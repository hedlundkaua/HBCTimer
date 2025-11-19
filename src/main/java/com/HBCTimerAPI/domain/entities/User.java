package com.HBCTimerAPI.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


// core de estudantes
@Entity //informar que é uma entidade de persistência para o JPA
@Table(name = "tb_user") //especifica o nome da tabela no BD qua qual a classe está mapeada
public class User implements Serializable{
//implentamos Serializable para podermos serializar nossos objetos da classe

	private static final long serialVersionUID = 1L;

	@Id //designamos abaixo nossa primary key da entidade no BD
	//definimos como valor da PK e o méthodo de gerar esse valor
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name; // atributos do nosso objeto
	private String email;
	private String password;
	
	@JsonIgnore //ignora este campo ao gerar o JSON de resposta
	@OneToMany(mappedBy = "student")
	private List<Matter> matters = new ArrayList<>();
	
	public User() {
	}

	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public List<Matter> getMatters() {
		return matters;
	}
	
	public void setName(String name) {
		this.name = name;
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
}
