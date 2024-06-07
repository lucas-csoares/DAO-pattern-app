package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;


/**
 * Classe que segue o padrão Factory Method e tem o propósito de criar 
 * instâncias de Data Access Objects (DAOs) específicos
 * @author polon
 *
 */
public class DaoFactory {
	
	/**
	 * Instancia um objeto do tipo SellerDaoJDBC, implementação de SellerDao
	 * @return a instância do tipo implementação de sellerDao
	 */
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	/**
	 * Instancia um objeto do tipo DeparmentDaoJDBC, implementação de DeparmentDao 
	 * @return a instância do tipo implementação de DepartmentDao
	 */
	public static DepartmentDao createDeparmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
	
}
