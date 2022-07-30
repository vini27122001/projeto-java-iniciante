package project.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.model.Pedido;
import project.model.Produto;
import project.util.HibernateUtil;


public class PedidoDao {

	public void saveProduct(Pedido produto) {
		
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

public List<Pedido> listAllPedidos() {
	
	Transaction transaction = null;
	List<Pedido> pedidos = new ArrayList<Pedido>();
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the pedidos
		
		pedidos = session.createQuery("SELECT a FROM Pedido a", Pedido.class).getResultList();
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	
	return pedidos;
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


@SuppressWarnings("unchecked")
public List<Pedido> getPedidoByDate(Date data, Date data2) {
	
	Transaction transaction = null;
	List<Pedido> pedidos = listAllPedidos();
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//start the transaction
		transaction = session.beginTransaction();
		//get the studendts 
		
		  pedidos = session.createQuery(
				    "SELECT a FROM Pedido a WHERE a.data BETWEEN :startDate AND :endDate")  
				  .setParameter("startDate", data)  
				  .setParameter("endDate", data2)  
				  .getResultList();
		//commit the transaction
		transaction.commit();
		
		
	} catch (Exception e) {
		if(transaction != null) {
			transaction.rollback();
		    System.out.println("abriu transaction mas falhou");
		}
	}
	
	return pedidos;
}
	
}
