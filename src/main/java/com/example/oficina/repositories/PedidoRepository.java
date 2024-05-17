package com.example.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;





@Repository
public interface PedidoRepository  extends JpaRepository<Pedido,Long>{

	@Modifying
    @Query("DELETE Pedido p where p.cliente.id = :id")
	void excluirTodosPedidos(Long id);

	@Modifying
    @Query("DELETE Pedido p where p.id = :id")
	void excluirPedido(Long id);
}
