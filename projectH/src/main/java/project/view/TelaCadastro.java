package project.view;

	import java.awt.Color;
	import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.control.ClienteController;
import project.model.Cliente;
import project.model.Produto;
import project.model.SexoCLiente;
import project.model.Uf;



	

	public class TelaCadastro extends JPanel implements VisualWindow{

		private FrameBase frameB;
		private JTextField txField, txFieldNome, txFieldIdade, txFieldEmail, txFieldCelular, txFieldEndereco, txFieldCep, txFieldCidade, txFieldCpf, txFieldComplemento, txFieldNumero, txFieldBairro;
		private JButton btok, btNovo;
		private JLabel label, labelCliente,labelEmail,labelNome,labelIdade,labelCelular;
		private BorderFactory border;
		private JComboBox<Uf> uf;
		private JComboBox<String> tipoCadastro;
		private JPanel panel, header;
		private JOptionPane pane;
		private TelaCliente tc;
		private JComboBox<SexoCLiente> sexo;
		
		
		public TelaCadastro(FrameBase frameB) {
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
			
			header = new JPanel();
			header.setLayout(null);
			header.setBounds(0, 0, 1440, 70);
			header.setVisible(true);
			header.setBackground(Color.decode("#007FFF"));
			add(header);

			label = new JLabel();
			label.setText("Sistema De Controle de Estoque");
			label.setFont(new Font("Times new Roman", Font.BOLD, 40));
			label.setForeground(Color.decode("#00000"));
			label.setVisible(true);
			label.setBounds(400, -17, 700, 100);
			header.add(label);
	
			
			panel = new JPanel();
			panel.setBounds(10, 450, 1345, 220);
			panel.setVisible(true);
			panel.setBorder(border.createEtchedBorder());
			add(panel);
			
			
			
		}

		public void setEvents() {
			
	}
	}


