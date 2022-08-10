package com.formacionbdi.springboot.app.items.model.service;

import com.formacionbdi.springboot.app.items.model.entity.Item;
import com.formacionbdi.springboot.app.items.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(
                Objects.requireNonNull(clienteRest.getForObject(
                        "http://localhost:8001/listar",
                        Producto[].class)
                ));

        return productos.stream()
                .map(producto -> new Item(producto, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://localhost:8001/listar/{id}", Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
