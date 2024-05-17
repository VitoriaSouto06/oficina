package com.example.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public void deletebyId(Long id) {
		clienteRepository.deleteById(id);
	}

	@Transactional
	public void excluirCliente(Long id) {
		clienteRepository.excluirCliente(id);
	}
	public void update(Cliente cliente, Long id) {
		Optional<Cliente> cliente2 = clienteRepository.findById(id);
		Cliente cliente3 = cliente2.get();
		if(!cliente.getNomeCliente().isBlank() && !cliente.getNomeCliente().isEmpty()) {
			cliente3.setNomeCliente(cliente.getNomeCliente());
		} 
		if(!cliente.getTelefoneCliente().isBlank() && !cliente.getTelefoneCliente().isEmpty()) {
			cliente3.setTelefoneCliente(cliente.getTelefoneCliente());
			
		}
		clienteRepository.save(cliente3);
	}
	
	public List<Cliente> findByNome(String nome) {
		return clienteRepository.findByNomeCliente(nome);
		
	}
	
}