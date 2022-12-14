package com.formacionbdi.springboot.app.productos.controller;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    //Se puede obtener el puerto mediante Environment o por @Value
    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return iProductoService.findAll().stream().map(
                        producto -> {
                            producto.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
                            //  producto.setPort(port);
                            return producto;
                        }
                )
                .collect(Collectors.toList());
    }


    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = iProductoService.findById(id);
        producto.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        //producto.setPort(port);

        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return producto;
    }
}
