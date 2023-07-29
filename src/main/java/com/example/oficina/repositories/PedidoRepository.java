package com.example.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido,Long>{


}
