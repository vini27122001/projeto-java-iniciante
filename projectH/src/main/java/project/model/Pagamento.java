package project.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Pagamento extends Thread {

	private JProgressBar pr;

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public void run() {

		frame.setBackground(Color.gray);
		frame.setVisible(true);
		frame.setSize(300, 300);

		panel.add(label);
		frame.add(panel);

		pr = new JProgressBar();
		pr.setStringPainted(true);
		pr.setValue(0);
		pr.setBounds(680, 530, 200, 20);
		pr.setSize(new Dimension(200, 23));
		panel.add(pr);

		label = new JLabel();
		label.setText("confirmando pagamento!!");
		label.setFont(new Font("Times new Roman", Font.BOLD, 15));
		label.setForeground(Color.decode("#00000"));
		label.setVisible(true);
		label.setBounds(500, -17, 450, 100);
		panel.add(label);

		
			try {
				final SwingWorker w = new SwingWorker() {

					@Override
					protected Object doInBackground() throws Exception {
						for (int i = 1; i <= 100; i++) {
							try {
								pr.setValue(i);
								pr.setString(i + "%");
								Thread.sleep(110);
							} catch (InterruptedException ex) {
								ex.printStackTrace();
							}
						}
						label.setText("Pagamento confirmado!!");
						pr.setValue(0);
						pr.setString(0 + "%");
						return 0;
					}
				};
				w.execute();
				sleep(13000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
		frame.dispose();
	}

}
