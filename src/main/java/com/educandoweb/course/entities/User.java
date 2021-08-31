package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*Entidade ou Tabela: É onde todas as informações inseridas em um banco de dados relacional são armazenadas. É uma estrutura formada por linhas e colunas onde cada linha consiste de, pelo menos, uma ou várias colunas.
Classe de Entidade: É uma classe do tipo Bean que faz referência a uma entidade do banco de dados, e cada instância desta entidade representa uma linha (registro ou tupla) na tabela (entidade).*/

@Entity  //avisa ao hibernate que é uma entidade
@Table(name = "tb_user") //é preciso mudar o nome porque pode ter alguma palavra que já é usada por padrão pelo codigo
public class User implements Serializable { //toda entidade tem que ser serializada

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String phone;
	
	
	@OneToMany(mappedBy = "client") //informa ao hibernate qual é o atributo que está sendo mapeado
	private List<Order> orders = new ArrayList<>(); //é uma array porque um usuário pode ter muitos pedidos

	public User(Long id, String name, String email, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	public List<Order> getOrders() {
		return orders;
	}

}
