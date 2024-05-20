package model.dao;

import model.dao.impl.SellerDaoJDBC;
import db.DB;
public class DaoFactory {
	
	// Retorna o tipo da interface mas internamente instancia uma implementação
	// A estratégia é não expor a implementação
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
