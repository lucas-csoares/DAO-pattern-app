package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;


/**
 * Transforma os dados do banco de dados relacional em objetos Java associados
 * @author polon
 *
 */
public class SellerDaoJDBC implements SellerDao{
	
	private final Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", //Placeholders
				Statement.RETURN_GENERATED_KEYS); // Retorna o id
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			
			int rowsAffected = st.executeUpdate(); // Linhas afetadas
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id); // Objeto populado com id
				}
				
				DB.closeResultSet(rs);
				
			} else
				throw new DbException("Unexpected error! No rows Affected!");
		
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Seller obj) {
		PreparedStatement st = null;
//		if(findById(obj.getId()) != null) {
//			
//		}
		try {
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET Name = ?, "
					+ "Email = ?, "
					+ "BirthDate = ?, "
					+ "BaseSalary = ?, "
					+ "DepartmentId = ? "
					+ "WHERE Id = ?"); 
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			st.setInt(6, obj.getId());
			
			st.executeUpdate(); 
			
			
		
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 *
	 * @param id
	 * @return
	 */
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
			if(rs.next())
				return instantiateSeller(rs, instantiateDepartment(rs));

			return null;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	private Seller instantiateSeller (ResultSet rs, Department dep) throws SQLException {
		Seller sell = new Seller();
		sell.setId(rs.getInt("Id"));
		sell.setEmail(rs.getString("Email"));
		sell.setName(rs.getString("Name"));
		sell.setBaseSalary(rs.getDouble("BaseSalary"));
		sell.setBirthDate(rs.getDate("BirthDate"));
		sell.setDepartment(dep);
		return sell;
	}

	/**
	 * Método que instancia um departamento
	 * @param rs
	 * @return
	 * @throws SQLException (propapação)
	 */
	private Department instantiateDepartment (ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId")); //Passa o nome da coluna do banco
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
			
			rs = st.executeQuery(); // Execução da query
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			//Um while pois podemos ter zero ou mais valores (departamento com mais de uma pessoa)
			while(rs.next()) {
				
				int key = rs.getInt("DepartmentId");
				Department dep = map.get(key); // Se não existir no mapa, retorna nulo
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(key, dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
			}
			
			return list;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
			st.setInt(1, department.getId());
			
			rs = st.executeQuery(); // Execução da query
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			//Um while pois podemos ter zero ou mais valores (departamento com mais de uma pessoa)
			while(rs.next()) {
				
				int key = rs.getInt("DepartmentId");
				Department dep = map.get(key); // Se não existir no mapa, retorna nulo
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(key, dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
			}
			
			return list;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	

}
