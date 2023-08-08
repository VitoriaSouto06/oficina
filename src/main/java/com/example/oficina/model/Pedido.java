package com.example.oficina.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_pedidos")
public class Pedido implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nome_aparelho")
	@NotBlank
	private String nomeAparelho;
	
	@Column(name="modelo_aparelho")
	@NotBlank
	private String modeloAparelho;
	
	@Column(name="peca_valor")
	@NotNull
	private BigDecimal pecaValor;
	
	@Column(name="mao_obra")
	@NotNull
	private BigDecimal maoObra;
	
	@Column(name="data_entrada")
	@NotNull
	private LocalDate dataEntrada;
	
	@Column(name="data_saida")
	@NotNull
	private LocalDate dataSaida;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private  Cliente cliente;

	
	
	public Pedido() {
		super();
	}



	public Pedido(Long id, String nomeAparelho, String modeloAparelho, BigDecimal pecaValor, BigDecimal maoObra,
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
