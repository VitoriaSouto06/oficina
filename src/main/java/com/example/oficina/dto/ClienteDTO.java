package com.example.oficina.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.oficina.model.Cliente;
import com.example.oficina.services.ClienteService;

public class ClienteDTO implements Serializable{
	
	@Autowired 
	ClienteService clienteService;

	private static final long serialVersionUID = 1L;

	private String id;

	private String nomeCliente;

	private String telefoneCliente;

	
	
	
	public ClienteDTO() {
		super();
	}


	public ClienteDTO(String id, String nomeCliente, String telefoneCliente) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		id = id;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getTelefoneCliente() {
		return telefoneCliente;
	}


	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(id, other.id);
	}

	public  Cliente toCliente(ClienteDTO clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(clienteDto.getNomeCliente());
		cliente.setTelefoneCliente(clienteDto.getTelefoneCliente());
		return cliente;
	}
	public  Cliente alterarCliente(ClienteDTO clienteDto) {
		Cliente cliente = new Cliente();
		if(clienteDto.getNomeCliente() != null && !clienteDto.getNomeCliente().isEmpty()) {
		cliente.setNomeCliente(clienteDto.getNomeCliente());
		}
		if(clienteDto.getTelefoneCliente() != null && !clienteDto.getTelefoneCliente().isEmpty()) {
		cliente.setTelefoneCliente(clienteDto.getTelefoneCliente());
		}
		return cliente;
	}
	
		
}
