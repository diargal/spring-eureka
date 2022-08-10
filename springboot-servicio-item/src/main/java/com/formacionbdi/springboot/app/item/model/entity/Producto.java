package com.formacionbdi.springboot.app.item.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;
}
