package model.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa um departamento.
 * Implementa a interface Serializable para permitir que objetos da classe sejam serializados.
 * Contém informações sobre o id e o nome do departamento.
 * Inclui métodos para obter e definir os atributos, além de métodos para comparação e representação em forma de string.
 */
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    /**
     * Construtor padrão sem parâmetros.
     * Cria uma nova instância da classe Department.
     */
    public Department() {
    }

    /**
     * Construtor com parâmetros.
     * Cria uma nova instância da classe Department com os atributos especificados.
     *
     * @param id o id do departamento
     * @param name o nome do departamento
     */
    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Obtém o id do departamento.
     *
     * @return o id do departamento
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o id do departamento.
     *
     * @param id o id a ser definido para o departamento
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do departamento.
     *
     * @return o nome do departamento
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do departamento.
     *
     * @param name o nome a ser definido para o departamento
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Calcula o código hash para o objeto Department com base no id.
     *
     * @return o código hash do objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Compara este objeto com o objeto especificado para igualdade.
     * Dois objetos Department são considerados iguais se tiverem o mesmo id.
     *
     * @param obj o objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
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

    /**
     * Retorna uma representação em forma de string do objeto Department.
     * A representação inclui o id e o nome do departamento.
     *
     * @return a representação em forma de string do objeto
     */
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

}

