package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println (">>> TESTE 1: seller findById <<<");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		System.out.println ("\n>>> TESTE 2: seller findByDepartment <<<");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.forEach(System.out::println);
		
		
		System.out.println ("\n>>> TESTE 3: seller findAll <<<");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println ("\n>>> TESTE 4: seller INSERT <<<");
		Seller newSeller = new Seller(null, "Lucas Soares", "lucas-cabral-soares@gmail.com", new Date(),
				4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		
		System.out.println ("\n>>> TESTE 5: seller UPDATE <<<");
		seller = sellerDao.findById(4);
		seller.setName("Silvano Silveira Soares");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		
		System.out.println ("\n>>> TESTE 6: seller DELETE <<<");
		sellerDao.deleteById(25);
		System.out.println("Delete completed!");
		
		
	}

}
