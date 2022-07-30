package project.view;

	import java.awt.Color;
	import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import project.control.FornecedorController;
import project.model.Cliente;
import project.model.Fornecedor;
import project.model.SexoCLiente;
import project.model.Uf;

	

	public class TelaFornecedor extends JPanel implements VisualWindow{

		private FrameBase frameB;
		private JTextField  txField, txFieldNome, txFieldCnpj, txFieldEmail, txFieldCelular, txFieldEndereco, txFieldCep, txFieldCidade, txFieldDescricao, txFieldComplemento, txFieldNumero, txFieldBairro;
		private JButton btok,btNovo;
		private JLabel label;
		private BorderFactory border;
		private JComboBox<String> items;
		private JPanel panel,header;
		private JComboBox<Uf> uf;
		private JOptionPane pane;
		private FornecedorController fornecedorController;
		
		public TelaFornecedor(FrameBase frameB) {
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
			
			fornecedorController = new FornecedorController();
			
			
			header = new JPanel();
			header.setLayout(null);
			header.setBounds(0, 0, 1440, 70);
			header.setVisible(true);
			header.setBackground(Color.decode("#007FFF"));
			add(header);

			label = new JLabel();
			label.setText("Cadastro de Fornecedores");
			label.setFont(new Font("Times new Roman", Font.BOLD, 40));
			label.setForeground(Color.decode("#00000"));
			label.setVisible(true);
			label.setBounds(500, -17, 450, 100);
			header.add(label);
			
			label = new JLabel();
			label.setText("Nome:");
			label.setVisible(true);
			label.setBounds(150, 100, 100, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
		
			txFieldNome = new JTextField();
			txFieldNome.setBounds(210, 100, 300, 20);
			txFieldNome.setVisible(true);
			add(txFieldNome);
			
			label = new JLabel();
			label.setText("E-mail:");
			label.setVisible(true);
			label.setBounds(680, 100, 100, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			txFieldEmail = new JTextField();
			txFieldEmail.setBounds(740, 100, 400, 20);
			txFieldEmail.setVisible(true);
			add(txFieldEmail);
			
			label = new JLabel();
			label.setText("Celular:");
			label.setVisible(true);
			label.setBounds(200, 150, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			try {
				txFieldCelular =  new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txFieldCelular.setBounds(280, 150, 200, 20);
			txFieldCelular.setVisible(true);
			add(txFieldCelular);
			
			label = new JLabel();
			label.setText("CNPJ:");
			label.setVisible(true);
			label.setBounds(700, 150, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			try {
				txFieldCnpj =  new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txFieldCnpj.setBounds(750, 150, 300, 20);
			txFieldCnpj.setVisible(true);
			add(txFieldCnpj);
			
			label = new JLabel();
			label.setText("Endereço:");
			label.setVisible(true);
			label.setBounds(150, 200, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			txFieldEndereco = new JTextField();
			txFieldEndereco.setBounds(230, 200, 800, 20);
			txFieldEndereco.setVisible(true);
			add(txFieldEndereco);
			
			label = new JLabel();
			label.setText("N°:");
			label.setVisible(true);
			label.setBounds(1050, 200, 100, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			txFieldNumero = new JTextField();
			txFieldNumero.setBounds(1080, 200, 50, 20);
			txFieldNumero.setVisible(true);
			add(txFieldNumero);
			
			label = new JLabel();
			label.setText("Complemento:");
			label.setVisible(true);
			label.setBounds(150, 250, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);

			txFieldComplemento = new JTextField();
			txFieldComplemento.setBounds(270, 250, 400, 20);
			txFieldComplemento.setVisible(true);
			add(txFieldComplemento);
			
			label = new JLabel();
			label.setText("Bairro:");
			label.setVisible(true);
			label.setBounds(720, 250, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			txFieldBairro = new JTextField();
			txFieldBairro.setBounds(780, 250, 400, 20);
			txFieldBairro.setVisible(true);
			add(txFieldBairro);
			
			label = new JLabel();
			label.setText("CEP:");
			label.setVisible(true);
			label.setBounds(150, 300, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			try {
				txFieldCep =  new JFormattedTextField(new MaskFormatter("#####-###"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txFieldCep.setBounds(190, 300, 150, 20);
			txFieldCep.setVisible(true);
			add(txFieldCep);
			
			label = new JLabel();
			label.setText("Cidade:");
			label.setVisible(true);
			label.setBounds(400, 300, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			txFieldCidade = new JTextField();
			txFieldCidade.setBounds(470, 300, 300, 20);
			txFieldCidade.setVisible(true);
			add(txFieldCidade);
			
			label = new JLabel();
			label.setText("UF-Estado:");
			label.setVisible(true);
			label.setBounds(830, 300, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			uf = new JComboBox<Uf>(Uf.values());
			uf.setBounds(920, 300, 160, 20);
			uf.setVisible(true);
			add(uf);
			
			
			label = new JLabel();
			label.setText("Descrição:");
			label.setVisible(true);
			label.setBounds(450, 350, 200, 20);
			label.setFont(new Font("Verdana", Font.PLAIN, 15));
			add(label);
			
			txFieldDescricao = new JTextField();
			txFieldDescricao.setBounds(540, 350, 600, 20);
			txFieldDescricao.setVisible(true);
			add(txFieldDescricao);
			
			
			btNovo = new JButton("Novo");
			btNovo.setBounds(150, 400, 100, 32);
			add(btNovo);
			
			btok = new JButton("Salvar");
			btok.setBounds(270, 400, 100, 32);
			add(btok);
			
			
			btok = new JButton("Editar");
			btok.setBounds(390, 400, 100, 32);
			add(btok);
			
			
			btok = new JButton("Excluir");
			btok.setBounds(510, 400, 100, 32);
			add(btok);
			
			btok = new JButton("Cancelar");
			btok.setBounds(630, 400, 100, 32);
			add(btok);
			
			txField = new JTextField();
			txField.setBounds(750, 400, 220, 32);
			txField.setVisible(true);
			add(txField);
			
			btok = new JButton("Pesquisar");
			btok.setBounds(980, 400, 100, 32);
			add(btok);
			
			btok = new JButton("Sair");
			btok.setBounds(1090, 400, 100, 32);
			add(btok);
			
			panel = new JPanel();
			panel.setBounds(10, 450, 1345, 220);
			panel.setVisible(true);
			panel.setBorder(border.createEtchedBorder());
			add(panel);
			
		}

		public void setEvents() {
btNovo.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					int resposta = JOptionPane.showConfirmDialog(pane,"cadastrar", "cancelar", JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {
						try {
						int numero = Integer.parseInt(txFieldNumero.getText());
						String nome = txFieldNome.getText();
						String email = txFieldEmail.getText();
						String telefone = txFieldCelular.getText();
						String endereco = txFieldEndereco.getText();
						String cidade = txFieldCidade.getText();
						String cep = txFieldCep.getText();
						String bairro = txFieldBairro.getText();
						String ufEstado = String.valueOf(uf.getSelectedItem());
						String cnpj = txFieldCnpj.getText();
						String descricao = txFieldDescricao.getText();
						
						
						Fornecedor fornecedor = fornecedorController.getNewCliente();
						fornecedor.setBairro(bairro);
						fornecedor.setCep(cep);
						fornecedor.setTelefone(telefone);
						fornecedor.setCidade(cidade);
						fornecedor.setNome(nome);
						fornecedor.setEndereco(endereco);
						fornecedor.setEmail(email);
						fornecedor.setCnpj(cnpj);
						fornecedor.setDescricao(descricao);
				
						
						
						fornecedorController.saveFornecedor(fornecedor);
			
						JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
						}catch(NumberFormatException arg) {
							JOptionPane.showMessageDialog(null, "A campos vazios favor Preecher!!");
						}
						
				      }
				      else {
				         JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
				      }	
				}
			});
			
		}
	}


