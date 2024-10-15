package com.seruhioCode30.quickbites.QuickBites_Back_End.service;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Pedido;
import com.seruhioCode30.quickbites.QuickBites_Back_End.repository.PedidoRepository;
import com.seruhioCode30.quickbites.QuickBites_Back_End.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired; // Asegúrate de tener esta importación
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }


    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        Pedido pedido = obtenerPedidoPorId(id);
        pedido.setProductos(pedidoActualizado.getProductos());
        pedido.setTotal(pedidoActualizado.getTotal());
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
