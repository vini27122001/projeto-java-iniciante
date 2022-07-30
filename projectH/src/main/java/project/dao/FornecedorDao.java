package project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.model.Fornecedor;
import project.util.HibernateUtil;


public class FornecedorDao {

	public void saveFornecedor(Fornecedor fornecedor) {
		
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save the cliente object
			session.save(fornecedor);
			//commit the transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
	}
public void updateFornecedor(Fornecedor fornecedor) {
		
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save the studendt object
			session.saveOrUpdate(fornecedor);
			//commit the transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
	}
public Fornecedor getFornecedorById(long id) {
	
	Transaction transaction = null;
	Fornecedor fornecedor = null;
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendt object
		fornecedor = session.get(Fornecedor.class, id);
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	return fornecedor;
}

public List<Fornecedor> listAllFornecedores() {
	
	Transaction transaction = null;
	List<Fornecedor> fornecedor = null;
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendts 
		
		fornecedor = session.createQuery("SELECT a FROM Fornecedor a", Fornecedor.class).getResultList();
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	
	return fornecedor;
}

public void deleteFornecedor(long id) {
	
	Transaction transaction = null;
	Fornecedor fornecedor = null;
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//delete the studendt object
		fornecedor = session.get(Fornecedor.class, id);
		session.delete(fornecedor);
		
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
