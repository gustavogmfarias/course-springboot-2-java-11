package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable { // é obrigado fazer esse implemente nas config

	/*Entidade ou Tabela: É onde todas as informações inseridas em um banco de dados relacional são armazenadas. É uma estrutura formada por linhas e colunas onde cada linha consiste de, pelo menos, uma ou várias colunas.
	Classe de Entidade: É uma classe do tipo Bean que faz referência a uma entidade do banco de dados, e cada instância desta entidade representa uma linha (registro ou tupla) na tabela (entidade).*/

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // usar para
																											// colocar o
																											// padrão
																											// data e
																											// hora que
																											// será
																											// usado
	private Instant moment; // tipo de tempo

	private Integer orderStatus; // coloco integer para explicitar que é um numero

	@JsonIgnore // protege para que não entre em loop infinito order chamando user e user
				// chamando order. Não precisa ficar do lado do "um", apenas ao lado do "muitos"
	@ManyToOne // siginifca que é muitos para um
	@JoinColumn(name = "client_id") // informa qual é a coluna do user que vamos faz a conexão e damos o nome para a
									// coluna
	private User client;

	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client; // referencia ao cliente
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus); // como agora o orderStatus é um inteiro lá em cima, a gente deve
													// converte-lo
		// para orderStatus com o value of, para retornar o orderstatus certinho
	}

	public void setOrderStatus(OrderStatus orderStatus) { // no set ele vai receber o orderstatus e vai retornar como
															// interiro.
		
		if(orderStatus != null) { //para evitar que coloque vlaor nulo;
		this.orderStatus = orderStatus.getCode(); } //usa-se o get code para pegar o codigo
	}

	public void setClient(User client) {
		this.client = client;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
