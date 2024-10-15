package com.seruhioCode30.quickbites.QuickBites_Back_End.repository;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
