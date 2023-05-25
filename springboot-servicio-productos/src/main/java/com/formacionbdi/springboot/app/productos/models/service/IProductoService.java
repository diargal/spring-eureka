package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

import java.util.List;
import java.util.UUID;

public interface IProductoService {
    List<Producto> findAll();

    Producto findById(Long id);
}
