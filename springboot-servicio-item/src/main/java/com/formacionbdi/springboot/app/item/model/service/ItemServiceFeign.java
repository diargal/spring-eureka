package com.formacionbdi.springboot.app.item.model.service;

import com.formacionbdi.springboot.app.item.cliente.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.model.entity.Item;
import com.formacionbdi.springboot.app.item.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign") //Nombre de la implementación para poder llamar. Forma 1
@Primary //Indica que es la implementación a cargar por defecto. Forma 2
public class ItemServiceFeign implements ItemService {
    @Autowired
    private ProductoClienteRest productoClienteRest;

    @Override
    public List<Item> findAll() {
        return productoClienteRest.listar().stream()
                .map(producto -> new Item(producto, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Producto producto = productoClienteRest.detalle(id);

        return new Item(producto, cantidad);
    }
}
