package com.seruhioCode30.quickbites.QuickBites_Back_End.controller;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Pedido;
import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Producto;
import com.seruhioCode30.quickbites.QuickBites_Back_End.service.PedidoService;
import com.seruhioCode30.quickbites.QuickBites_Back_End.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")//ruta base para este controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        // Creamos una nueva lista de productos para el pedido
        List<Producto> productosPersistidos = new ArrayList<>();

        // Iteramos sobre los productos del pedido
        for (Producto producto : pedido.getProductos()) {
            // Buscamos cada producto en la base de datos
            Producto productoPersistido = productoService.obtenerProductoPorId(producto.getId());
            // Si el producto existe, lo agregamos a la lista de productos del pedido
            productosPersistidos.add(productoPersistido);
        }

        // Asignamos los productos persistidos al pedido
        pedido.setProductos(productosPersistidos);
        Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
    }


    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.actualizarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }
}
