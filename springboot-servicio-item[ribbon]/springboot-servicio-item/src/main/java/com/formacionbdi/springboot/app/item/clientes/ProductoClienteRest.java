package com.formacionbdi.springboot.app.item.clientes;

import com.formacionbdi.springboot.app.item.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//@FeignClient(name = "servicio-productos", url = "localhost:8001") sin usar ribbon
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

}
