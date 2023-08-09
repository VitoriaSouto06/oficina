package com.example.oficina.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.oficina.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

	void save(Optional<Cliente> cliente);

	@Query(value="select * from tb_cliente where nome_cliente LIKE %:nome%", nativeQuery=true)
	List<Cliente> findByNomeCliente(String nome);

}
