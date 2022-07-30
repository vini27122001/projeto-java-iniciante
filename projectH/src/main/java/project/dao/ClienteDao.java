package project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.model.Cliente;
import project.util.HibernateUtil;


public class ClienteDao {

	public void saveCliente(Cliente cliente) {
		
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save the cliente object
			session.save(cliente);
			//commit the transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
	}
public void updateCliente(Cliente cliente) {
		
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save the studendt object
			session.saveOrUpdate(cliente);
			//commit the transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			    System.out.println("abriu transaction mas falhou");
			}
		}
	}
public Cliente getClienteById(long id) {
	
	Transaction transaction = null;
	Cliente cliente = null;
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendt object
		cliente = session.get(Cliente.class, id);
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	return cliente;
}

public List<Cliente> listAllClientes() {
	
	Transaction transaction = null;
	List<Cliente> clientes = null;
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendts 
		
		clientes = session.createQuery("SELECT a FROM Cliente a", Cliente.class).getResultList();
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	
	return clientes;
}

public void deleteCliente(long id) {
	
	Transaction transaction = null;
	Cliente cliente = null;
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//delete the studendt object
		cliente = session.get(Cliente.class, id);
		session.delete(cliente);
		
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
