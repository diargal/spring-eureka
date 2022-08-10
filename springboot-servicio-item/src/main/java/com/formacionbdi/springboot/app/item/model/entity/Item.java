package com.formacionbdi.springboot.app.item.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private Producto producto;
    private Integer cantidad;

    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }
}
