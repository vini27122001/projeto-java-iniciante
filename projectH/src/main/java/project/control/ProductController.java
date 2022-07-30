package project.control;

import java.util.List;

import project.dao.ProdutoDao;
import project.model.Produto;

public class ProductController {

	private ProdutoDao produtoDao;
	
	public ProductController() {
		produtoDao = new ProdutoDao();
	}
	
	public Produto getNewProduct() {
		return new Produto();
	}
	
	public void saveProduct(Produto produto) {
		produtoDao.saveProduct(produto);
	}
	
	public List<Produto> listAllProducts(){
		return produtoDao.listAllProducts();
	}
	
	public void deleteProduct(long id) {
		produtoDao.deleteProduct(id);
	}
	
	public void updateProduct(Produto produto) {
		produtoDao.updateProduct(produto);
	}
	
	public Produto getProdutctById(long id) {
		return produtoDao.getProdutctById(id);
	}
	
}
