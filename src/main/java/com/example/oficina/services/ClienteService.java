package com.example.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficina.model.Cliente;
import com.example.oficina.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
}
