package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RootPaneContainer;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import project.control.ClienteController;

import project.control.PagamentoECancelamentoController;
import project.control.PedidoController;
import project.control.ProductController;
import project.model.Cancelamento;
import project.model.Cliente;
import project.model.Pagamento;

import project.model.Pedido;
import project.model.Produto;

public class TelaVendas extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private JTextField txField, txFieldCpf, txFieldNome, txFieldProduto, txFieldCod, txFieldpreco, txFieldQtd,
			txFieldVenda,txFieldData;
	private JButton btok, btoCliente, btProduto, btAdd, btRemove, btPagamento,btCancelar;
	private JLabel label;
	private BorderFactory border;
	private JComboBox<String> items;
	private JPanel dadosCliente, header, dadosDoProduto, carrinhoDeCompras, totalDaVenda;
	private JTable tabel;
	private ClienteController clienteController;
	private ProductController productController;
	private PedidoController pedidoController;
	private DefaultTableModel modelo;
	private double subTotal, totalVenda, subtraiVenda;
	private long id;
	private Date date;
	private PagamentoECancelamentoController PagaECanceController;

	public TelaVendas(FrameBase frameB) {
		this.frameB = frameB;
		setLayouts();
		setComponents();
		setEvents();
	}

	public void setLayouts() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.decode("#f8f8ff"));
	}

	public void setComponents() {

		clienteController = new ClienteController();
		productController = new ProductController();
		pedidoController = new PedidoController();
		PagaECanceController = new PagamentoECancelamentoController();
		date = new Date();

		dadosCliente = new JPanel();
		dadosCliente.setLayout(null);
		dadosCliente.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));
		dadosCliente.setBounds(20, 90, 600, 180);
		dadosCliente.setVisible(true);
		dadosCliente.setBackground(Color.decode("#f8f8ff"));
		add(dadosCliente);

		header = new JPanel();
		header.setLayout(null);
		header.setBounds(0, 0, 1440, 70);
		header.setVisible(true);
		header.setBackground(Color.decode("#007FFF"));
		add(header);

		label = new JLabel();
		label.setText("Ponto De Vendas");
		label.setFont(new Font("Times new Roman", Font.BOLD, 40));
		label.setForeground(Color.decode("#00000"));
		label.setVisible(true);
		label.setBounds(500, -17, 450, 100);
		header.add(label);

		label = new JLabel();
		label.setText("CPF:");
		label.setVisible(true);
		label.setBounds(30, 30, 100, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosCliente.add(label);

		try {
			txFieldCpf =  new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txFieldCpf.setBounds(90, 30, 200, 20);
		txFieldCpf.setVisible(true);
		dadosCliente.add(txFieldCpf);

		label = new JLabel();
		label.setText("Data:");
		label.setVisible(true);
		label.setBounds(300, 30, 100, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosCliente.add(label);

		txFieldData = new JTextField();
		txFieldData.setBounds(350, 30, 200, 20);
		txFieldData.setVisible(true);
		txFieldData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		dadosCliente.add(txFieldData);

		label = new JLabel();
		label.setText("Nome:");
		label.setVisible(true);
		label.setBounds(30, 100, 80, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosCliente.add(label);

		txFieldNome = new JTextField();
		txFieldNome.setBounds(90, 100, 250, 20);
		txFieldNome.setVisible(true);
		dadosCliente.add(txFieldNome);

		btoCliente = new JButton("Pesquisar");
		btoCliente.setBounds(360, 100, 100, 20);
		btoCliente.setVisible(true);
		dadosCliente.add(btoCliente);

		dadosDoProduto = new JPanel();
		dadosDoProduto = new JPanel();
		dadosDoProduto.setLayout(null);
		dadosDoProduto.setBorder(BorderFactory.createTitledBorder("Dados do Produto"));
		dadosDoProduto.setBounds(20, 290, 600, 300);
		dadosDoProduto.setVisible(true);
		dadosDoProduto.setBackground(Color.decode("#f8f8ff"));
		add(dadosDoProduto);

		label = new JLabel();
		label.setText("Código:");
		label.setVisible(true);
		label.setBounds(30, 30, 100, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosDoProduto.add(label);

		txFieldCod = new JTextField();
		txFieldCod.setBounds(100, 30, 200, 20);
		txFieldCod.setVisible(true);
		dadosDoProduto.add(txFieldCod);

		btProduto = new JButton("Pesquisar");
		btProduto.setVisible(true);
		btProduto.setBounds(315, 30, 100, 20);
		dadosDoProduto.add(btProduto);

		label = new JLabel();
		label.setText("Produto:");
		label.setVisible(true);
		label.setBounds(30, 100, 80, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosDoProduto.add(label);

		txFieldProduto = new JTextField();
		txFieldProduto.setBounds(100, 100, 350, 20);
		txFieldProduto.setVisible(true);
		dadosDoProduto.add(txFieldProduto);

		label = new JLabel();
		label.setText("Preço:");
		label.setVisible(true);
		label.setBounds(40, 170, 80, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosDoProduto.add(label);

		txFieldpreco = new JTextField();
		txFieldpreco.setBounds(100, 170, 150, 20);
		txFieldpreco.setVisible(true);
		dadosDoProduto.add(txFieldpreco);

		label = new JLabel();
		label.setText("Qtd:");
		label.setVisible(true);
		label.setBounds(320, 170, 80, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		dadosDoProduto.add(label);

		txFieldQtd = new JTextField();
		txFieldQtd.setBounds(360, 170, 150, 20);
		txFieldQtd.setVisible(true);
		dadosDoProduto.add(txFieldQtd);

		btAdd = new JButton("Adicionar Item");
		btAdd.setVisible(true);
		btAdd.setBounds(50, 250, 200, 30);
		dadosDoProduto.add(btAdd);

		btRemove = new JButton("Remover item");
		btRemove.setVisible(true);
		btRemove.setBounds(300, 250, 200, 30);
		dadosDoProduto.add(btRemove);

		carrinhoDeCompras = new JPanel();
		carrinhoDeCompras.setLayout(null);
		carrinhoDeCompras.setBorder(BorderFactory.createTitledBorder("Carrinho De Compras"));
		carrinhoDeCompras.setBounds(630, 90, 720, 250);
		carrinhoDeCompras.setVisible(true);
		carrinhoDeCompras.setBackground(Color.decode("#f8f8ff"));
		add(carrinhoDeCompras);

		modelo = new DefaultTableModel();
		modelo.addColumn("Cod");
		modelo.addColumn("Produto");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço");
		modelo.addColumn("Sub total");
		tabel = new JTable(modelo);
		tabel.setBackground(Color.decode("#f8f8ff"));
		tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabel.setFocusable(false);
		carrinhoDeCompras.setLayout(new BorderLayout());
		carrinhoDeCompras.add(new JScrollPane(tabel), "Center");

		totalDaVenda = new JPanel();
		totalDaVenda.setLayout(null);
		totalDaVenda.setBorder(BorderFactory.createTitledBorder("Total Da Venda"));
		totalDaVenda.setBounds(630, 350, 720, 170);
		totalDaVenda.setVisible(true);
		totalDaVenda.setBackground(Color.decode("#f8f8ff"));
		add(totalDaVenda);

		label = new JLabel("TOTAL DA VENDA :");
		label.setVisible(true);
		label.setBounds(50, 70, 200, 30);
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		totalDaVenda.add(label);

		txFieldVenda = new JTextField();
		txFieldVenda.setBounds(280, 70, 150, 30);
		txFieldVenda.setVisible(true);
		totalDaVenda.add(txFieldVenda);

		btPagamento = new JButton("PAGAMENTO");
		btPagamento.setBounds(680, 560, 200, 50);
		add(btPagamento);

		btCancelar = new JButton("CANCELAR VENDA");
		btCancelar.setBounds(1000, 560, 200, 50);
		add(btCancelar);

	}

	public void setEvents() {
		btoCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String cpf = txFieldCpf.getText();
				List<Cliente> clientes = clienteController.listAllClientes();

				for (Iterator iterator = clientes.iterator(); iterator.hasNext();) {
					Cliente cliente = (Cliente) iterator.next();
					if (cpf.equals(cliente.getCpf())) {
						txFieldNome.setText(cliente.getNome());

					}

				}

			}
		});

		btProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String pesquisa = txFieldCod.getText();

				List<Produto> allProducts = productController.listAllProducts();
				for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
					Produto produto = (Produto) iterator.next();
					String cod = Long.toString(produto.getCod());
					if (pesquisa.equals(cod)) {

						txFieldProduto.setText(produto.getNome());
						txFieldpreco.setText(String.valueOf(produto.getPreco()));

					}
				}

			}
		});

		btAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txFieldProduto.getText().equals("") || txFieldCod.getText().equals("") || txFieldCpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
				} else {

					try {
						String pesquisa = txFieldCod.getText();

						List<Produto> allProducts = productController.listAllProducts();
						for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
							Produto produto = (Produto) iterator.next();

							String cod = Long.toString(produto.getCod());

							if (pesquisa.equals(cod)) {
								if (Long.valueOf(txFieldQtd.getText()) <= produto.getQtd()) {

									long qtd = Long.valueOf(txFieldQtd.getText());

									subTotal = produto.getSubTotal(qtd, produto.getPreco());

									Double.toString(subTotal);

									modelo.addRow(new Object[] { txFieldCod.getText(), txFieldProduto.getText(),
											txFieldQtd.getText(), txFieldpreco.getText(), subTotal });

									produto.setQtd(produto.getQtd() - qtd);

									id = produto.getId();

									productController.updateProduct(produto);

								} else {
									JOptionPane.showMessageDialog(null, "Quatidade do estoque é:" + produto.getQtd());
								}

							}
						}
						for (int linha = 0; linha < modelo.getRowCount(); linha++) {
							String valorColuna = Double.toString((Double) tabel.getModel().getValueAt(linha, 4));

							totalVenda += Double.parseDouble(valorColuna);
						}
						txFieldVenda.setText(Double.toString(totalVenda));
						
						subtraiVenda = totalVenda;

						totalVenda = 0;

					} catch (NumberFormatException arg) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
					}
				}
			}
		});

		btRemove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) tabel.getModel();
				if (tabel.getSelectedRow() >= 0) {
					Produto produto = productController.getProdutctById(id);
					long qtd = Long.parseLong((String) tabel.getModel().getValueAt(tabel.getSelectedRow(), 2));

					produto.setQtd(produto.getQtd() + qtd);

					productController.updateProduct(produto);

					String valorColuna = Double
							.toString((Double) tabel.getModel().getValueAt(tabel.getSelectedRow(), 4));
					subtraiVenda -= Double.parseDouble(valorColuna);
					txFieldVenda.setText(Double.toString(subtraiVenda));

					dtm.removeRow(tabel.getSelectedRow());
					tabel.setModel(dtm);

				} else {
					JOptionPane.showMessageDialog(null, "Favor selecionar um item do carrinho!!");
				}

			}
		});

		btPagamento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Pedido pedido = pedidoController.getNewProduct();
				
				pedido.setCliente(txFieldNome.getText());
				long timeInMilliSeconds = date.getTime();
				java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
				pedido.setData(date1);
				double venda = Double.parseDouble(txFieldVenda.getText());
				pedido.setTotalDaVenda(venda);
				pedido.setProduto(txFieldProduto.getText());
				
				pedidoController.saveProduct(pedido);
				
				Pagamento loading = PagaECanceController.getNewPagamento();
				loading.start();
				
		        
				((DefaultTableModel) tabel.getModel()).setRowCount(0);
				txFieldVenda.setText("");
		        
		        
			}
		});
		
		btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cancelamento loading = PagaECanceController.getNewCancelamento();
				loading.start();
				((DefaultTableModel) tabel.getModel()).setRowCount(0);
				txFieldVenda.setText("");
				txFieldCpf.setText("");
				txFieldCod.setText("");
				txFieldpreco.setText("");
				txFieldCod.setText("");
				txFieldProduto.setText("");
				txFieldNome.setText("");
				txFieldQtd.setText("");
			}
		});

	}

}
