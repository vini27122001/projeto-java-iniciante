package project.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelBase extends JPanel implements VisualWindow{

	private FrameBase frameB;
	private TelaCliente secondJP;
	private TelaProduto thirdJP;
	private TelaFornecedor fourJP;
	private TelaVendas fiveJP;
	private TelaConsulta sixJP;
	private TelaCadastro firstJP;
	
	public PanelBase(FrameBase frameB) {
		this.frameB = frameB;
		setLayouts();
		setComponents();
		setEvents();


	}

	public void setLayouts() {
		setLayout(new CardLayout());
		setBackground(Color.MAGENTA);
		setVisible(true);

	}

	public void setComponents() {
		firstJP = new TelaCadastro(frameB);
		secondJP = new TelaCliente(frameB);
		thirdJP = new TelaProduto(frameB);
		fourJP = new TelaFornecedor(frameB);
		fiveJP = new TelaVendas(frameB);
		sixJP = new TelaConsulta(frameB);
		// adicionando as telas nesta tela-base (cardLayout)
		add(firstJP, "first");
		add(secondJP, "second");
		add(thirdJP, "third");
		add(fourJP, "four");
		add(fiveJP, "five");
		add(sixJP, "six");
	}

	public void setEvents() {
		// TODO Auto-generated method stub

	}

}
