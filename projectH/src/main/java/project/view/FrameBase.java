package project.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FrameBase extends JFrame implements VisualWindow {

	private JMenuBar menubar;
	private JMenu menu,menuVendas;
	private JMenuItem item,item1, item2, item3, item4, item5;
	public CardLayout cl;

	private PanelBase baseJP;

	public FrameBase() {
		setLayouts();
		setComponents();
		setEvents();
		validate();
	}

	public void setLayouts() {
		setSize(1440, 1024);
		setVisible(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	public void setComponents() {
		menubar = new JMenuBar();
		menu = new JMenu("Cadastros");
		item = new JMenuItem("Cadastro");
		item2 = new JMenuItem("Cadastro de Clientes");
		item1 = new JMenuItem("Cadastro de Fornecedores");
		item3 = new JMenuItem("Cadastro De Produtos");
		
		menu.add(item);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		
		menubar.add(menu);
		
		menu = new JMenu("Controle de Vendas");
		item4 = new JMenuItem("Nova Venda");
		
		menu.add(item4);
		
		menuVendas = new JMenu("Historico de Vendas");
		item5 = new JMenuItem("Consultar");
		
		menuVendas.add(item5);
		
		menubar.add(menuVendas);
		menubar.add(menu);
		
	
		baseJP = new PanelBase(this);
		cl = new CardLayout();
		cl = (CardLayout) baseJP.getLayout();

		add(menubar, BorderLayout.NORTH);
		add(baseJP, BorderLayout.CENTER);
		
	}

	public void setEvents() {
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(baseJP, "first");
				
			}
		});
		
		item1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				cl.show(baseJP, "four");

			}
		});
		item2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				cl.show(baseJP, "second");
			}
		});
		item3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cl.show(baseJP, "third");
			}
		});
		item4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cl.show(baseJP, "five");
			}
		});
		item5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cl.show(baseJP,"six");
				
			}
		});
		
	}
}
