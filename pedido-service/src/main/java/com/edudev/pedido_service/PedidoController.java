package com.edudev.pedido_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PedidoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String puerto;

    @GetMapping("/pedido")
    public String registrarPedido(@RequestParam String cliente,
                                  @RequestParam String producto,
                                  @RequestParam int cantidad,
                                  @RequestParam double precio) {

        String stock = restTemplate.getForObject(
                "http://inventario-service/stock?producto=" + producto,
                String.class
        );

        String operacion = restTemplate.getForObject(
                "http://operaciones-service/calcular?precio="
                        + precio
                        + "&cantidad="
                        + cantidad,
                String.class
        );

        return "PEDIDO PROCESADO\n\n"
                + "Cliente: " + cliente
                + "\nProducto: " + producto
                + "\nCantidad: " + cantidad
                + "\n\n=== INVENTARIO ===\n"
                + stock
                + "\n\n=== OPERACIONES ===\n"
                + operacion
                + "\n\nPuerto Pedido Service: "
                + puerto;
    }
}