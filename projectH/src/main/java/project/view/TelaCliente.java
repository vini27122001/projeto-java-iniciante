package project.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import project.control.ClienteController;
import project.model.Cliente;
import project.model.Produto;
import project.model.SexoCLiente;
import project.model.Uf;

public class TelaCliente extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private JTextField txField, txFieldNome, txFieldIdade, txFieldEmail, txFieldEndereco, txFieldCep,
			txFieldCidade, txFieldCpf, txFieldComplemento, txFieldNumero, txFieldBairro;
	private JButton btok, btNovo;
	private JLabel labelCliente;
	private BorderFactory border;
	private JComboBox<Uf> uf;
	private JComboBox<SexoCLiente> sexo;
	private JPanel panel, header;
	private JOptionPane pane;
	private JFormattedTextField txFieldCelular;

	private ClienteController clienteController;

	public TelaCliente(FrameBase frameB) {
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

		labelCliente = new JLabel();
		labelCliente.setText("Cadastro de Clientes");
		labelCliente.setFont(new Font("Times new Roman", Font.BOLD, 40));
		labelCliente.setForeground(Color.decode("#00000"));
		labelCliente.setVisible(true);
		labelCliente.setBounds(500, -17, 450, 100);
		header.add(labelCliente);

		labelCliente = new JLabel();
		labelCliente.setText("Nome:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(150, 100, 100, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldNome = new JTextField();
		txFieldNome.setBounds(210, 100, 300, 20);
		txFieldNome.setVisible(true);
		add(txFieldNome);

		labelCliente = new JLabel();
		labelCliente.setText("Idade:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(520, 100, 100, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldIdade = new JTextField();
		txFieldIdade.setBounds(570, 100, 50, 20);
		txFieldIdade.setVisible(true);
		add(txFieldIdade);

		labelCliente = new JLabel();
		labelCliente.setText("E-mail:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(680, 100, 100, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldEmail = new JTextField();
		txFieldEmail.setBounds(740, 100, 400, 20);
		txFieldEmail.setVisible(true);
		add(txFieldEmail);

		labelCliente = new JLabel();
		labelCliente.setText("Celular:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(200, 150, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		try {
			txFieldCelular =  new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txFieldCelular.setBounds(280, 150, 200, 20);
		txFieldCelular.setVisible(true);
		add(txFieldCelular);

		labelCliente = new JLabel();
		labelCliente.setText("Sexo:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(500, 150, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		sexo = new JComboBox<SexoCLiente>(SexoCLiente.values());
		sexo.setBounds(550, 150, 160, 20);
		sexo.setVisible(true);
		add(sexo);

		labelCliente = new JLabel();
		labelCliente.setText("Endereço:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(150, 200, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldEndereco = new JTextField();
		txFieldEndereco.setBounds(230, 200, 800, 20);
		txFieldEndereco.setVisible(true);
		add(txFieldEndereco);

		labelCliente = new JLabel();
		labelCliente.setText("N°:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(1050, 200, 100, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldNumero = new JTextField();
		txFieldNumero.setBounds(1080, 200, 50, 20);
		txFieldNumero.setVisible(true);
		add(txFieldNumero);

		labelCliente = new JLabel();
		labelCliente.setText("Complemento:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(150, 250, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldComplemento = new JTextField();
		txFieldComplemento.setBounds(270, 250, 400, 20);
		txFieldComplemento.setVisible(true);
		add(txFieldComplemento);

		labelCliente = new JLabel();
		labelCliente.setText("Bairro:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(720, 250, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldBairro = new JTextField();
		txFieldBairro.setBounds(780, 250, 400, 20);
		txFieldBairro.setVisible(true);
		add(txFieldBairro);

		labelCliente = new JLabel();
		labelCliente.setText("CEP:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(150, 300, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		try {
			txFieldCep =  new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txFieldCep.setBounds(190, 300, 150, 20);
		txFieldCep.setVisible(true);
		add(txFieldCep);

		labelCliente = new JLabel();
		labelCliente.setText("Cidade:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(400, 300, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		txFieldCidade = new JTextField();
		txFieldCidade.setBounds(470, 300, 300, 20);
		txFieldCidade.setVisible(true);
		add(txFieldCidade);

		labelCliente = new JLabel();
		labelCliente.setText("UF-Estado:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(830, 300, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		uf = new JComboBox<Uf>(Uf.values());
		uf.setBounds(920, 300, 160, 20);
		uf.setVisible(true);
		add(uf);

		labelCliente = new JLabel();
		labelCliente.setText("CPF:");
		labelCliente.setVisible(true);
		labelCliente.setBounds(150, 350, 200, 20);
		labelCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(labelCliente);

		try {
			txFieldCpf =  new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txFieldCpf.setBounds(190, 350, 150, 20);
		txFieldCpf.setVisible(true);
		add(txFieldCpf);

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

		clienteController = new ClienteController();

	}

	public void setEvents() {
		btNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(pane, "cadastrar", "cancelar", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					try {
						int idade = Integer.parseInt(txFieldIdade.getText());
						int numero = Integer.parseInt(txFieldNumero.getText());
						String nome = txFieldNome.getText();
						String email = txFieldEmail.getText();
						String telefone = txFieldCelular.getText();
						String endereco = txFieldEndereco.getText();
						String cidade = txFieldCidade.getText();
						String cep = txFieldCep.getText();
						String cpf = txFieldCpf.getText();
						String bairro = txFieldBairro.getText();
						String sexoCliente = String.valueOf(sexo.getSelectedItem());
						String ufEstado = String.valueOf(uf.getSelectedItem());

						Cliente cliente = clienteController.getNewCliente();
						cliente.setBairro(bairro);
						cliente.setCep(cep);
						cliente.setTelefone(telefone);
						cliente.setCidade(cidade);
						cliente.setNome(nome);
						cliente.setEndereco(endereco);
						cliente.setEmail(email);
						cliente.setCpf(cpf);
						cliente.setIdade(idade);
						cliente.setNumero(numero);
						cliente.setSexo(sexoCliente);

						clienteController.saveCliente(cliente);

						JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
					} catch (NumberFormatException arg) {
						JOptionPane.showMessageDialog(null, "A campos vazios favor Preecher!!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
				}
			}
		});
	}
}
