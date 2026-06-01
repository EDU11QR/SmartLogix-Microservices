package com.edudev.inventario_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventarioController {

    @Value("${server.port}")
    private String puerto;

    @GetMapping("/stock")
    public String consultarStock(@RequestParam String producto) {

        int stockDisponible = 15;

        return "Producto: "
                + producto
                + " | Stock disponible: "
                + stockDisponible
                + " | Puerto: "
                + puerto;
    }
}