package model.dao;

import java.util.List;
import model.entities.Department;

/**
 * Interface que define as operações de acesso a dados para a entidade Department.
 * Fornece métodos para inserir, atualizar, deletar, buscar por ID e buscar todos os departamentos.
 */
public interface DepartmentDao {
    
    /**
     * Insere um novo departamento no banco de dados.
     *
     * @param obj o departamento a ser inserido
     */
    void insert(Department obj);

    /**
     * Atualiza um departamento existente no banco de dados.
     *
     * @param obj o departamento a ser atualizado
     */
    void update(Department obj);

    /**
     * Deleta um departamento do banco de dados com base no ID.
     *
     * @param id o ID do departamento a ser deletado
     */
    void deleteById(Integer id);

    /**
     * Busca um departamento no banco de dados com base no ID.
     *
     * @param id o ID do departamento a ser buscado
     * @return o departamento com o ID especificado, ou null se não encontrado
     */
    Department findById(Integer id);

    /**
     * Busca todos os departamentos no banco de dados.
     *
     * @return uma lista de todos os departamentos
     */
    List<Department> findAll();
}
