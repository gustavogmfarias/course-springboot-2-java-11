package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Entidade ou Tabela: É onde todas as informações inseridas em um banco de dados relacional são armazenadas. É uma estrutura formada por linhas e colunas onde cada linha consiste de, pelo menos, uma ou várias colunas.
Classe de Entidade: É uma classe do tipo Bean que faz referência a uma entidade do banco de dados, e cada instância desta entidade representa uma linha (registro ou tupla) na tabela (entidade).*/

@Entity // porque é uma entidade
@Table(name = "tb_category") // nome da columna
public class Category implements Serializable { // é obrigado fazer esse implemente nas config

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id // informa que é um id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para gerar a id automaticamente
	private Long id;
	private String name;
	// @Transient //impede que o java tente interpretar, coloquei temporariamente
	// para poder compilar
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categories" ) //coloco o nome da coleção que está lá na classe product
	private Set<Product> products = new HashSet<>();

	public Category() {

	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	public Set<Product> getProducts() {
		return products;
	}

}
