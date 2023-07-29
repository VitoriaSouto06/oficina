package com.example.oficina.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PedidoDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nomeAparelho;
	private String modeloAparelho;
	private BigDecimal pecaValor;
	private BigDecimal maoObra;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private  Cliente cliente;
	
	
	public PedidoDTO() {
		super();
	}


	public PedidoDTO(Long id, String nomeAparelho, String modeloAparelho, BigDecimal pecaValor, BigDecimal maoObra,
			LocalDate dataEntrada, LocalDate dataSaida, Cliente cliente) {
		super();
		this.id = id;
		this.nomeAparelho = nomeAparelho;
		this.modeloAparelho = modeloAparelho;
		this.pecaValor = pecaValor;
		this.maoObra = maoObra;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeAparelho() {
		return nomeAparelho;
	}


	public void setNomeAparelho(String nomeAparelho) {
		this.nomeAparelho = nomeAparelho;
	}


	public String getModeloAparelho() {
		return modeloAparelho;
	}


	public void setModeloAparelho(String modeloAparelho) {
		this.modeloAparelho = modeloAparelho;
	}


	public BigDecimal getPecaValor() {
		return pecaValor;
	}


	public void setPecaValor(BigDecimal pecaValor) {
		this.pecaValor = pecaValor;
	}


	public BigDecimal getMaoObra() {
		return maoObra;
	}


	public void setMaoObra(BigDecimal maoObra) {
		this.maoObra = maoObra;
	}


	public LocalDate getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Pedido toPedido(PedidoDTO pedidoDto) {
		Pedido pedido = new Pedido();
		pedido.setNomeAparelho(pedidoDto.getNomeAparelho());
		pedido.setModeloAparelho(pedidoDto.getModeloAparelho());
		pedido.setPecaValor(pedidoDto.getPecaValor());
		pedido.setMaoObra(pedidoDto.getMaoObra());
		pedido.setDataEntrada(pedido.getDataEntrada());
		pedido.setDataSaida(pedido.getDataSaida());
		pedido.setCliente(pedidoDto.getCliente());
		return pedido;
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
		PedidoDTO other = (PedidoDTO) obj;
		return Objects.equals(id, other.id);
	}

	

}
