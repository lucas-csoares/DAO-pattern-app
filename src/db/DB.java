package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Classe utilitária para gerenciar a conexão com o banco de dados.
 * Fornece métodos para carregar propriedades, obter e fechar conexões, 
 * além de fechar Statements e ResultSets.
 */
public class DB {
    private static Connection conn = null;

    /**
     * Carrega as propriedades do arquivo db.properties.
     *
     * @return um objeto Properties contendo as propriedades do banco de dados
     * @throws DbException se ocorrer um erro de E/S ao carregar as propriedades
     */
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return uma conexão com o banco de dados
     * @throws DbException se ocorrer um erro ao estabelecer a conexão
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @throws DbException se ocorrer um erro ao fechar a conexão
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Fecha um Statement.
     *
     * @param st o Statement a ser fechado
     * @throws DbException se ocorrer um erro ao fechar o Statement
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Fecha um ResultSet.
     *
     * @param rs o ResultSet a ser fechado
     * @throws DbException se ocorrer um erro ao fechar o ResultSet
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
