package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.model.Produto;
import project.util.HibernateUtil;


public class ProdutoDao {

	public void saveProduct(Produto produto) {
		
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save the studendt object
			session.save(produto);
			//commit the transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
	}
public void updateProduct(Produto produto) {
		
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save the studendt object
			session.saveOrUpdate(produto);
			//commit the transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
	}
public Produto getProdutctById(long id) {
	
	Transaction transaction = null;
	Produto produto = null;
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendt object
		produto = session.get(Produto.class, id);
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	return produto;
}

public List<Produto> listAllProducts() {
	
	Transaction transaction = null;
	List<Produto> produtos = new ArrayList<Produto>();
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendts 
		
		produtos = session.createQuery("SELECT a FROM Produto a", Produto.class).getResultList();
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	
	return produtos;
}

public void deleteProduct(long id) {
	
	Transaction transaction = null;
	Produto produto = null;
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//delete the studendt object
		produto = session.get(Produto.class, id);
		session.delete(produto);
		
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
}
	
}
