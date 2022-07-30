package project.control;

import java.sql.Date;
import java.util.List;

import project.dao.PedidoDao;
import project.model.Pedido;
import project.model.Produto;

public class PedidoController {

	private PedidoDao pedidoDao;
	
	public PedidoController() {
		pedidoDao = new PedidoDao();
	}
	
	public Pedido getNewProduct() {
		return new Pedido();
	}
	
	public void saveProduct(Pedido pedido) {
		pedidoDao.saveProduct(pedido);
	}
	
	public List<Pedido> listAllProducts(){
		return pedidoDao.listAllPedidos();
	}
	
	public void deleteProduct(long id) {
		pedidoDao.deleteProduct(id);
	}
	
	public void updateProduct(Produto produto) {
		pedidoDao.updateProduct(produto);
	}
	
	public Produto getProdutctById(long id) {
		return pedidoDao.getProdutctById(id);
	}
	
	public List<Pedido> getPedidoByDate(Date data, Date data2) {
		return pedidoDao.getPedidoByDate(data, data2);
	}
	
}
