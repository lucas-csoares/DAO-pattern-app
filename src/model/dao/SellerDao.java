package model.dao;

import java.util.List;
import model.entities.Department;
import model.entities.Seller;

/**
 * Interface que define as operações de acesso a dados para a entidade Seller.
 * Fornece métodos para inserir, atualizar, deletar, buscar por ID, buscar todos 
 * e buscar vendedores por departamento.
 */
public interface SellerDao {

    /**
     * Insere um novo vendedor no banco de dados.
     *
     * @param obj o vendedor a ser inserido
     */
    void insert(Seller obj);

    /**
     * Atualiza um vendedor existente no banco de dados.
     *
     * @param obj o vendedor a ser atualizado
     */
    void update(Seller obj);

    /**
     * Deleta um vendedor do banco de dados com base no ID.
     *
     * @param id o ID do vendedor a ser deletado
     */
    void deleteById(Integer id);

    /**
     * Busca um vendedor no banco de dados com base no ID.
     *
     * @param id o ID do vendedor a ser buscado
     * @return o vendedor com o ID especificado, ou null se não encontrado
     */
    Seller findById(Integer id);

    /**
     * Busca todos os vendedores no banco de dados.
     *
     * @return uma lista de todos os vendedores
     */
    List<Seller> findAll();

    /**
     * Busca todos os vendedores de um determinado departamento.
     *
     * @param department o departamento cujos vendedores serão buscados
     * @return uma lista de vendedores do departamento especificado
     */
    List<Seller> findByDepartment(Department department);
}
