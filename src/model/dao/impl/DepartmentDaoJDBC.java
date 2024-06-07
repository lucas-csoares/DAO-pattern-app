package model.dao.impl;

import java.sql.Connection;
import java.util.List;
import model.dao.DepartmentDao;
import model.entities.Department;

/**
 * Implementação JDBC da interface DepartmentDao para operações de acesso a 
 * dados relacionadas aos departamentos.
 */
public class DepartmentDaoJDBC implements DepartmentDao {

    private final Connection conn;

    /**
     * Construtor que recebe uma conexão com o banco de dados.
     *
     * @param conn a conexão com o banco de dados
     */
    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    /**
     * Insere um novo departamento no banco de dados.
     *
     * @param obj o departamento a ser inserido
     */
    @Override
    public void insert(Department obj) {
        // Implementação pendente
    }

    /**
     * Atualiza um departamento existente no banco de dados.
     *
     * @param obj o departamento a ser atualizado
     */
    @Override
    public void update(Department obj) {
        // Implementação pendente
    }

    /**
     * Deleta um departamento do banco de dados com base no ID.
     *
     * @param id o ID do departamento a ser deletado
     */
    @Override
    public void deleteById(Integer id) {
        // Implementação pendente
    }

    /**
     * Busca um departamento no banco de dados com base no ID.
     *
     * @param id o ID do departamento a ser buscado
     * @return o departamento com o ID especificado, ou null se não encontrado
     */
    @Override
    public Department findById(Integer id) {
        // Implementação pendente
        return null;
    }

    /**
     * Busca todos os departamentos no banco de dados.
     *
     * @return uma lista de todos os departamentos
     */
    @Override
    public List<Department> findAll() {
        // Implementação pendente
        return null;
    }
}
