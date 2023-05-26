package com.formacionbdi.springboot.app.item.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private Producto producto;
    private Integer cantidad;

    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }

    public Double getSubTotal() {
        return producto.getPrecio() * cantidad.doubleValue() - (producto.getPrecio() * 0.8);
    }

}
