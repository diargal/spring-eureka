package com.formacionbdi.springboot.app.item.controller;

import com.formacionbdi.springboot.app.item.model.entity.Item;
import com.formacionbdi.springboot.app.item.model.entity.Producto;
import com.formacionbdi.springboot.app.item.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private CircuitBreakerFactory breakerFactory;
    @Autowired
    @Qualifier("serviceRestTemplate")
    private ItemService itemServiceWithRestT;
    @Autowired
    //@Qualifier("serviceFeign") no es necesaria mientras la implementación Feign esté marcada como @Primary.
    private ItemService itemServiceWithFeign;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemServiceWithRestT.findAll();
    }

    //@HystrixCommand(fallbackMethod = "metodoAlternativo") Se quita porque no se utilizará para Resilience
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return breakerFactory
                .create("items")
                .run(() -> itemServiceWithFeign.findById(id, cantidad), e -> metodoAlternativo(id, cantidad));
    }

    public Item metodoAlternativo(Long id, Integer cantidad) {
        return Item.builder()
                .cantidad(20)
                .producto(Producto.builder()
                        .nombre("Producto de fallback")
                        .precio(8900D)
                        .build())
                .build();
    }
}
