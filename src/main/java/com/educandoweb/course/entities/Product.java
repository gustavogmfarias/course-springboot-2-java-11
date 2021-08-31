package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_products") // cria o nome da tabela
public class Product implements Serializable { // toda entidade tem que ser serializada

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double price;
	private String imgUrl;

	// @Transient //impede que o java tente interpretar, coloquei temporariamente
	// para poder compilar

	@ManyToMany // informa que o atributo é de muitos para muitos, ou seja, um produto pode ter
				// // muitas categorias, e uma categoria pode ter muitos produtos
	@JoinTable(name = "tb_product_categoy", joinColumns = @JoinColumn(name = "product_id"), 
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	
	
	
	// cria uma tabela
																							// relacional no bd //o join
																							// collum é pra colocar qual
																							// o a chave estrangeira da
																							// coluna referente ao
																							// produto
	// ja a inverse join column, cria a coluna da outr achave estrangeira do bd
	// relacional, no caso, o inverso de product é category;
	//na clase category, vou informar o mapeamento que fizemos aqui

	private Set<Category> categories = new HashSet<>(); // set em vez de list porque o produto não pode ter a mesma
														// categoria mais de uma vez; // o set é uma interface e não
														// pode ser instanciado, por isso se usa o hashset

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String description, double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
