package db;

/**
 * Classe de exceção personalizada para erros de integridade do banco de dados.
 * Estende RuntimeException, permitindo que seja usada como uma exceção não verificada.
 */
public class DbIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que aceita uma mensagem de erro.
     *
     * @param message a mensagem de erro detalhando a causa da exceção
     */
    public DbIntegrityException(String message) {
        super(message);
    }
}
