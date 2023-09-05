package com.example.oficina.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
	private String pecaValor;
	private String maoObra;
	private String dataEntrada;
	private String observacao;
	private Cliente cliente;
	
	
	public PedidoDTO() {
		super();
	}


	public PedidoDTO(Long id, String nomeAparelho, String modeloAparelho, String pecaValor, String maoObra,
			String dataEntrada, String observacao, Cliente cliente) {
		super();
		this.id = id;
		this.nomeAparelho = nomeAparelho;
		this.modeloAparelho = modeloAparelho;
		this.pecaValor = pecaValor;
		this.maoObra = maoObra;
		this.dataEntrada = dataEntrada;
		this.observacao = observacao;
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


	public String getPecaValor() {
		return pecaValor;
	}


	public void setPecaValor(String pecaValor) {
		this.pecaValor = pecaValor;
	}


	public String getMaoObra() {
		return maoObra;
	}


	public void setMaoObra(String maoObra) {
		this.maoObra = maoObra;
	}


	public String getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}



	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Pedido novoPedido(PedidoDTO pedidoDto,Cliente cliente) {
		Pedido pedido = new Pedido();
		pedido.setNomeAparelho(pedidoDto.getNomeAparelho());
		pedido.setModeloAparelho(pedidoDto.getModeloAparelho());
		String pecaValorStr = pedidoDto.getPecaValor().replace(",", ".");
		BigDecimal pecaValor = new BigDecimal(pecaValorStr);
		pedido.setPecaValor(pecaValor);
		String maoObraStr = pedidoDto.getMaoObra().replace(",", ".");
		BigDecimal maoObra = new BigDecimal(maoObraStr);
		pedido.setMaoObra(maoObra);
		String dataEntradaStr = pedidoDto.getDataEntrada();
		LocalDate dataEntrada = LocalDate.parse(dataEntradaStr); 
		pedido.setDataEntrada(dataEntrada);
		pedido.setObservacao(pedidoDto.getObservacao());
		pedido.setCliente(cliente);
		pedido.totalPedido();
		pedido.totalLucro();
		return pedido;
	}
	
	public Pedido toPedido(PedidoDTO pedidoDto,Cliente cliente) {
		Pedido pedido = new Pedido();
				pedido.setNomeAparelho(pedidoDto.getNomeAparelho());
				pedido.setModeloAparelho(pedidoDto.getModeloAparelho());
				pedido.setObservacao(pedidoDto.getObservacao());
		 if(pedidoDto.getPecaValor()!= null && !pedidoDto.getPecaValor().isEmpty()) {
				String pecaValorStr = pedidoDto.getPecaValor().replace(",", ".");
				BigDecimal pecaValor = new BigDecimal(pecaValorStr);
				pedido.setPecaValor(pecaValor);
			
		 }
		 if(pedidoDto.getMaoObra() != null && !pedidoDto.getMaoObra().isEmpty()) {
			String maoObraStr = pedidoDto.getMaoObra().replace(",", ".");
				BigDecimal maoObra = new BigDecimal(maoObraStr);
				pedido.setMaoObra(maoObra);
			
			
		
		}
		 if(pedidoDto.getDataEntrada()!= null && !pedidoDto.getDataEntrada().isEmpty()) {
				String dataEntradaStr = pedidoDto.getDataEntrada();
				LocalDate dataEntrada = LocalDate.parse(dataEntradaStr); 
				pedido.setDataEntrada(dataEntrada);
			
			}
		
		 
		
		pedido.setCliente(cliente);
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