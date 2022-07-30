package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;


import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import project.control.PedidoController;
import project.model.Pedido;
import project.model.Produto;



public class TelaConsulta extends JPanel implements VisualWindow{


		private FrameBase frameb;
		private JButton btPesquisa;
		private JTextField txFieldFinal,txFieldInicio;
		private JPanel header,dadosConsulta,vendas;
		private JLabel label;
		private DefaultTableModel modelo;
		private JTable tabel;
		private PedidoController pedidoController;

		public TelaConsulta(FrameBase frameb) {
			this.frameb = frameb;
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
			
			javax.swing.text.MaskFormatter data = null;
			try {
				data = new javax.swing.text.MaskFormatter("##/##/####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			pedidoController = new PedidoController();
			
			header = new JPanel();
			header.setLayout(null);
			header.setBounds(0, 0, 1440, 70);
			header.setVisible(true);
			header.setBackground(Color.decode("#007FFF"));
			add(header);

			label = new JLabel();
			label.setText("Histórico de Vendas");
			label.setFont(new Font("Times new Roman", Font.BOLD, 40));
			label.setForeground(Color.decode("#00000"));
			label.setVisible(true);
			label.setBounds(500, -17, 450, 100);
			header.add(label);
			
			dadosConsulta = new JPanel();
			dadosConsulta.setLayout(null);
			dadosConsulta.setBorder(BorderFactory.createTitledBorder("Consulta por Data"));
			dadosConsulta.setBounds(20, 90, 1330, 200);
			dadosConsulta.setVisible(true);
			dadosConsulta.setBackground(Color.decode("#f8f8ff"));
			add(dadosConsulta);
			
			label = new JLabel();
			label.setText("Data inicial:");
			label.setVisible(true);
			label.setBounds(200, 100, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 18));
			dadosConsulta.add(label);
			
			txFieldInicio = new javax.swing.JFormattedTextField(data);
			txFieldInicio.setBounds(320, 100, 200, 20);
			txFieldInicio.setFont(new Font("Verdana", Font.PLAIN, 18));
			txFieldInicio.setVisible(true);
			dadosConsulta.add(txFieldInicio);
			
			label = new JLabel();
			label.setText("Data Final:");
			label.setVisible(true);
			label.setBounds(600, 100, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 18));
			dadosConsulta.add(label);
			
			txFieldFinal = new javax.swing.JFormattedTextField(data);
			txFieldFinal.setBounds(700, 100, 200, 20);
			txFieldFinal.setVisible(true);
			txFieldFinal.setFont(new Font("Verdana", Font.PLAIN, 18));
			dadosConsulta.add(txFieldFinal);
			
			btPesquisa = new JButton("Pesquisar");
			btPesquisa.setBounds(920, 100, 150, 20);
			dadosConsulta.add(btPesquisa);
			
			vendas = new JPanel();
			vendas.setLayout(null);
			vendas.setBorder(BorderFactory.createTitledBorder("Vendas"));
			vendas.setBounds(20, 270, 1330, 400);
			vendas.setVisible(true);
			vendas.setBackground(Color.decode("#f8f8ff"));
			add(vendas);

			modelo = new DefaultTableModel();
			modelo.addColumn("Código");
			modelo.addColumn("Data da Venda");
			modelo.addColumn("Cliente");
			modelo.addColumn("Total da Venda");
			tabel = new JTable(modelo);
			tabel.setBackground(Color.decode("#f8f8ff"));
			tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tabel.setFocusable(false);
			vendas.setLayout(new BorderLayout());
			vendas.add(new JScrollPane(tabel), "Center");
		}

		
		public void setEvents() {
			btPesquisa.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					((DefaultTableModel) tabel.getModel()).setRowCount(0);
					

						String dataIni = txFieldInicio.getText();
						String dataFin = txFieldFinal.getText();
						DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
						java.sql.Date dataI = null;
						try {
							dataI = new java.sql.Date(fmt.parse(dataIni).getTime());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						java.sql.Date dataF = null;
						try {
							dataF = new java.sql.Date(fmt.parse(dataFin).getTime());
						} catch (ParseException e1) {
						
							e1.printStackTrace();
						}
						
						List<Pedido> pedidos  = pedidoController.getPedidoByDate(dataI, dataF);
						
						for (Iterator iterator = pedidos.iterator(); iterator.hasNext();) {
							Pedido pedido = (Pedido) iterator.next();
						
							modelo.addRow(new Object[] { pedido.getIdPedido(), pedido.getData(),
									 pedido.getCliente(), pedido.getTotalDaVenda()});
					}
					
					
					
				}
			});

		}



}
