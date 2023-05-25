package com.formacionbdi.springboot.app.item.controller;

import com.formacionbdi.springboot.app.item.model.entity.Item;
import com.formacionbdi.springboot.app.item.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

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

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemServiceWithFeign.findById(id, cantidad);
    }
}
