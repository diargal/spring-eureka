package com.formacionbdi.springboot.app.item.model;

import java.util.Date;

public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;

    public Producto(Long id, String nombre, Double precio, Date createAt, Integer port) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.createAt = createAt;
        this.port = port;
    }

    public Producto() {
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    private Integer port;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


}
