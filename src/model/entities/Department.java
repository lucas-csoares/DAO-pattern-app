package model.entities;

import java.io.Serializable;
import java.util.Objects;

// Implementar Serializable é importante para que os objetos Java sejam transformados em sequência de Bytes, de forma que o objeto possa ser gravado em arquivo ou trafegado em rede
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	// Construtor padrão
	public Department() {
	}

	
	// Construtor com argumentos
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	
	// Gerar getters e setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

	// Gerar hashCode e equals para que os objetos sejam comparados pelo conteúdo e não pela referência de ponteiro
	
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
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}


	
	// Imprimir valores do objeto com toString()
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	

	
	
	
	
	
	
}
