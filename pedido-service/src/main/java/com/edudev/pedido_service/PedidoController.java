package com.edudev.pedido_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @Value("${server.port}")
    private String puerto;

    @GetMapping("/pedido")
    public String registrarPedido(@RequestParam String cliente,
                                  @RequestParam String producto,
                                  @RequestParam int cantidad) {

        return "Pedido registrado correctamente | Cliente: "
                + cliente
                + " | Producto: "
                + producto
                + " | Cantidad: "
                + cantidad
                + " | Puerto: "
                + puerto;
    }
}