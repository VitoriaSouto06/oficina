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
	private LocalDate dataSaida;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private  Cliente cliente;
	
	@Column(name="total_pedido")
	private BigDecimal totalPedido = BigDecimal.ZERO;
	
	@Column(name="observacao",length=900)
	private String observacao;
	@Column(name="peca",length=1500)
	private String peca;
	@Column(name="defeito",length=1500)
	private String defeito;
	
	@Column(name="lucro")
	private BigDecimal lucro = BigDecimal.ZERO;
	
	@Column(name="status_pedido")
	private String statusPedido;
	
	public Pedido() {
		super();
	}



	public Pedido(Long id, String nomeAparelho, String modeloAparelho, BigDecimal pecaValor, BigDecimal maoObra,
			LocalDate dataEntrada,String observacao,String peca,String defeito, Cliente cliente) {
		super();
		this.id = id;
		this.nomeAparelho = nomeAparelho;
		this.modeloAparelho = modeloAparelho;
		this.pecaValor = pecaValor;
		this.maoObra = maoObra;
		this.dataEntrada = dataEntrada;
		this.cliente = cliente;
		this.observacao = observacao;
		this.defeito = defeito;
		this.peca = peca;
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

	

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}



	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	

	public BigDecimal getLucro() {
		return lucro;
	}



	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}



	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public String getPeca() {
		return peca;
	}


	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getDefeito() {
		return defeito;
	}


	public String getStatusPedido() {
		return statusPedido;
	}



	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}



	public void totalLucro() {
		lucro = lucro.add(maoObra);
	}
	
	public void atulizarLucro() {
		lucro = BigDecimal.ZERO;
		lucro = lucro.add(maoObra);
	}
	public void totalPedido() {
		totalPedido = totalPedido.add(maoObra);
		totalPedido = totalPedido.add(pecaValor);
		
	}
	
	public void atualizarTotalPedido() {
		totalPedido = BigDecimal.ZERO;
		totalPedido = totalPedido.add(maoObra);
		totalPedido = totalPedido.add(pecaValor);
		
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