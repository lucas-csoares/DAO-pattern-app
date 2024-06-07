package db;

/**
 * Classe de exceção personalizada para erros relacionados ao banco de dados.
 * Estende RuntimeException, permitindo que seja usada como uma exceção não verificada.
 */
public class DbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que aceita uma mensagem de erro.
     *
     * @param msg a mensagem de erro detalhando a causa da exceção
     */
    public DbException(String msg) {
        super(msg);
    }
}
