package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;


/**
 * Transforma os dados do banco de dados relacional e transformar em objetos associados
 * @author polon
 *
 */
public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			//Se a consulta não conter registro, next retorna falso
			if(rs.next()) {
				Department dep = new Department();
				//Passa o nome da coluna do banco
				dep.setId(rs.getInt("DepartmentId")); 
				dep.setName(rs.getString("DepName"));
				
				Seller sell = new Seller();
				sell.setId(rs.getInt("Id"));
				sell.setEmail(rs.getString("Email"));
				sell.setName(rs.getString("Name"));
				sell.setBaseSalary(rs.getDouble("BaseSalary"));
				sell.setBirthDate(rs.getDate("BirthDate"));
				sell.setDepartment(dep);
				return sell;
			}
			return null;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}