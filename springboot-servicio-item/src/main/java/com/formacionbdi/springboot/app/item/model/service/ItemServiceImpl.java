package com.formacionbdi.springboot.app.item.model.service;

import com.formacionbdi.springboot.app.item.model.entity.Item;
import com.formacionbdi.springboot.app.item.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(Objects.requireNonNull(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class)));

        return productos.stream()
                .map(producto -> new Item(producto, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
