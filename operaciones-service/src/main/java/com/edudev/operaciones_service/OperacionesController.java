package com.edudev.operaciones_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacionesController {

    @Value("${server.port}")
    private String puerto;

    @GetMapping("/calcular")
    public String calcularTotal(@RequestParam double precio,
                                @RequestParam int cantidad) {

        double subtotal = precio * cantidad;
        double igv = subtotal * 0.18;
        double total = subtotal + igv;

        return "Subtotal: " + subtotal
                + " | IGV: " + igv
                + " | Total Final: " + total
                + " | Puerto: " + puerto;
    }
}