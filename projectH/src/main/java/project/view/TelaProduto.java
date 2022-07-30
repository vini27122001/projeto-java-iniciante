package project.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import project.control.ProductController;
import project.model.Produto;




public class TelaProduto extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private JTextField txField, txFieldNome, txFieldCod, txFieldQtd, txFieldPreco, txFieldPesquisa;
	private JButton btok, btNovo, btPesquisa, btLista,btExcluir,btCancelar;
	private JLabel label;
	private BorderFactory border;
	private JComboBox<String> marcas;
	private JPanel panel, header,vendas;
	private JOptionPane pane;
	private JTable tabel;
	private DefaultTableModel modelo;
	
	private ProductController productController;

	public TelaProduto(FrameBase frameB) {
		this.frameB = frameB;
		setLayouts();
		setComponents();
		setEvents();
	}

	public void setLayouts() {
		setVisible(true);
		setBackground(Color.decode("#D3D3D3"));
	}

	public void setComponents() {

		setLayout(null);
		setBackground(Color.decode("#f8f8ff"));
		
		productController = new ProductController();

		header = new JPanel();
		header.setLayout(null);
		header.setBounds(0, 0, 1440, 70);
		header.setVisible(true);
		header.setBackground(Color.decode("#007FFF"));
		add(header);

		label = new JLabel();
		label.setText("Cadastro de Produtos");
		label.setFont(new Font("Times new Roman", Font.BOLD, 40));
		label.setForeground(Color.decode("#00000"));
		label.setVisible(true);
		label.setBounds(500, -17, 450, 100);
		header.add(label);

		label = new JLabel();
		label.setText("Cod:");
		label.setVisible(true);
		label.setBounds(150, 100, 40, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(label);

		txFieldCod = new JTextField();
		txFieldCod.setBounds(195, 100, 160, 20);
		txFieldCod.setVisible(true);
		add(txFieldCod);

		label = new JLabel();
		label.setText("Produto:");
		label.setVisible(true);
		label.setBounds(380, 100, 100, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(label);

		txFieldNome = new JTextField();
		txFieldNome.setBounds(450, 100, 400, 20);
		txFieldNome.setVisible(true);
		add(txFieldNome);

		label = new JLabel();
		label.setText("Quantidade:");
		label.setVisible(true);
		label.setBounds(870, 100, 100, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(label);

		txFieldQtd = new JTextField();
		txFieldQtd.setBounds(970, 100, 200, 20);
		txFieldQtd.setVisible(true);
		add(txFieldQtd);

		label = new JLabel();
		label.setText("Preço:");
		label.setVisible(true);
		label.setBounds(150, 200, 200, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(label);

		txFieldPreco = new JTextField();
		txFieldPreco.setBounds(200, 200, 160, 20);
		txFieldPreco.setVisible(true);
		add(txFieldPreco);

		label = new JLabel();
		label.setText("Marca:");
		label.setVisible(true);
		label.setBounds(450, 200, 200, 20);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(label);

		marcas = new JComboBox<String>();
		marcas.setBounds(550, 200, 160, 20);
		marcas.setVisible(true);
		marcas.addItem("Scania");
		marcas.addItem("Volvo");
		marcas.addItem("Mercedes");
		marcas.addItem("Iveco");
		marcas.addItem("Daf");
		marcas.addItem("Volkswagem");
		add(marcas);
		
		vendas = new JPanel();
		vendas.setLayout(null);
		vendas.setBorder(BorderFactory.createTitledBorder("Vendas"));
		vendas.setBounds(20, 350, 1330, 350);
		vendas.setVisible(true);
		vendas.setBackground(Color.decode("#f8f8ff"));
		add(vendas);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod");
		modelo.addColumn("Produto");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço");
		modelo.addColumn("Marca");
		tabel = new JTable(modelo);
		tabel.setBackground(Color.decode("#f8f8ff"));
		tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabel.setFocusable(false);
		vendas.setLayout(new BorderLayout());
		vendas.add(new JScrollPane(tabel), "Center");

		btok = new JButton("+");
		btok.setBounds(730, 200, 50, 20);
		add(btok);

		btNovo = new JButton("+ Novo");
		btNovo.setBounds(150, 300, 100, 32);
		add(btNovo);

		btLista = new JButton("Listar");
		btLista.setBounds(270, 300, 100, 32);
		add(btLista);

		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(390, 300, 100, 32);
		add(btExcluir);

		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(510, 300, 100, 32);
		add(btCancelar);

		txFieldPesquisa = new JTextField();
		txFieldPesquisa.setBounds(620, 300, 220, 32);
		txFieldPesquisa.setVisible(true);
		add(txFieldPesquisa);

		btPesquisa = new JButton("Pesquisar");
		btPesquisa.setBounds(850, 300, 100, 32);
		add(btPesquisa);


	}

	public void setEvents() {
		btNovo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String pesquisa = txFieldCod.getText();
				String comparar = pesquisa;
				List<Produto> allProducts = productController.listAllProducts();
				for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
					Produto teste = (Produto) iterator.next();
					String codigo = Long.toString(teste.getCod());
					if (pesquisa.equals(codigo)) {
						JOptionPane.showMessageDialog(null, "Já Existe um Produto com esse COD!!");
						comparar = null;
					}
				}
						if(comparar != null) {
							int resposta = JOptionPane.showConfirmDialog(pane,"cadastrar", "cancelar", JOptionPane.YES_NO_OPTION);
							if (resposta == JOptionPane.YES_OPTION) {
								String nome = txFieldNome.getText();
								long cod = Integer.parseInt(txFieldCod.getText());
								long quantidade = Integer.parseInt(txFieldQtd.getText());
								txFieldPreco.getText().replaceAll( "," , "." );
								double preco = Double.parseDouble(txFieldPreco.getText());
								String marca = (String) marcas.getSelectedItem();
								
								Produto produto = productController.getNewProduct();
								produto.setNome(nome);
								produto.setCod(cod);
								produto.setQtd(quantidade);
								produto.setPreco(preco);
								produto.setMarca(marca);
								
								productController.saveProduct(produto);
					
								JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
						      }
						      else {
						         JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
						      }
						}else {
							JOptionPane.showMessageDialog(null, "Preencha um codigo válido!!");
						}
						
					
				
			}
		});
		
		btLista.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tabel.getModel()).setRowCount(0);
				List<Produto> allProducts = productController.listAllProducts();
				for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
					Produto produto = (Produto) iterator.next();
					modelo.addRow(new Object[] { produto.getCod(),produto.getNome(),produto.getQtd(),produto.getPreco(),produto.getMarca()});
				}
			
				
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {
							
			public void actionPerformed(ActionEvent e) {
					String pesquisa = txFieldPesquisa.getText().toLowerCase();
					((DefaultTableModel) tabel.getModel()).setRowCount(0);
				List<Produto> allProducts = productController.listAllProducts();
				for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
					Produto produto = (Produto) iterator.next();
					
					if(produto.getNome().toLowerCase().contains(pesquisa)) {
						modelo.addRow(new Object[] { produto.getCod(),produto.getNome(),produto.getQtd(),produto.getPreco(),produto.getMarca()});
					}
				}	
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) tabel.getModel();
				if (tabel.getSelectedRow() >= 0) {
					Long cod = (Long) tabel.getModel().getValueAt(tabel.getSelectedRow(), 0);
					List<Produto> allProducts = productController.listAllProducts();
					for (Iterator iterator = allProducts.iterator(); iterator.hasNext();) {
						Produto produto = (Produto) iterator.next();
						if(produto.getCod() == cod) {
							productController.deleteProduct(produto.getId());
							JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!!");
							dtm.removeRow(tabel.getSelectedRow());
							tabel.setModel(dtm);
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Favor selecionar um Produto!!");
				}
				
			}
		});
		
		btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	        
	}

}
