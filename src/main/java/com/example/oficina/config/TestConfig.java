package com.example.oficina.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;
import com.example.oficina.repositories.ClienteRepository;
import com.example.oficina.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public void run(String... args) throws Exception {
		
		
	}
}

