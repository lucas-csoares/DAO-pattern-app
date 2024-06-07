package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Representa um vendedor.
 */
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private Double baseSalary;
    private Department department;

    /**
     * Construtor padrão.
     */
    public Seller() {
    }

    /**
     * Construtor com argumentos para inicializar todos os atributos.
     *
     * @param id         o ID do vendedor
     * @param name       o nome do vendedor
     * @param email      o email do vendedor
     * @param birthDate  a data de nascimento do vendedor
     * @param baseSalary o salário base do vendedor
     * @param department o departamento ao qual o vendedor está associado
     */
    public Seller(Integer id, String name, String email, Date birthDate, 
    		Double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    /**
     * Obtém o ID do vendedor.
     *
     * @return o ID do vendedor
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do vendedor.
     *
     * @param id o ID do vendedor
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do vendedor.
     *
     * @return o nome do vendedor
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do vendedor.
     *
     * @param name o nome do vendedor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o email do vendedor.
     *
     * @return o email do vendedor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do vendedor.
     *
     * @param email o email do vendedor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a data de nascimento do vendedor.
     *
     * @return a data de nascimento do vendedor
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Define a data de nascimento do vendedor.
     *
     * @param birthDate a data de nascimento do vendedor
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtém o salário base do vendedor.
     *
     * @return o salário base do vendedor
     */
    public Double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Define o salário base do vendedor.
     *
     * @param baseSalary o salário base do vendedor
     */
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * Obtém o departamento ao qual o vendedor está associado.
     *
     * @return o departamento ao qual o vendedor está associado
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Define o departamento ao qual o vendedor está associado.
     *
     * @param department o departamento ao qual o vendedor está associado
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Gera o código de hash para o vendedor com base no ID.
     *
     * @return o código de hash gerado
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Compara se dois objetos são iguais com base no ID.
     *
     * @param obj o objeto a ser comparado
     * @return true se os objetos são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Seller other = (Seller) obj;
        return Objects.equals(id, other.id);
    }

    /**
     * Retorna uma representação string do vendedor, incluindo todos os atributos.
     *
     * @return uma string representando o vendedor
     */
    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }
}
