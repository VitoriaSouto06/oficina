package com.example.oficina.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficina.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{



}
