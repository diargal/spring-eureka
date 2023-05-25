package com.formacionbdi.springboot.app.item.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;
    private Integer port;

    public Producto() {
    }
}
