package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Alunos.Alunos;

public class ScrollProcurarAluno extends JFrame implements ActionListener{
	JTextField codigo;
	JButton sair,remover;

	public ScrollProcurarAluno(String lista){

		super("LISTA DE ALUNOS");

		Container a = new JPanel();
		Container b = getContentPane();

		JTextArea texto = new JTextArea(lista);  
		texto.setFont(new Font("serif",Font.TRUETYPE_FONT,20) );

		a.setLayout(new GridLayout(1,2));
		a.add(new JLabel("Digite o código do aluno a ser removido:"));
		a.add(codigo=new JTextField());
		codigo.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		a.add(remover=new JButton("Remover"));
		a.add(sair=new JButton("Sair"));

		b.add(new JScrollPane(texto));
		b.add(BorderLayout.SOUTH,a);

		remover.addActionListener(this);
		sair.addActionListener(this);




	
		setSize(1000,700);
		setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {


		if(arg0.getSource()==remover){
			String e;


			e=codigo.getText();

			if(e.equals("")||e==null){
				JOptionPane.showMessageDialog(null, "ALUNO NAO ENCONTRADO!");
			}

			else{
				int a=Integer.parseInt(e);

				try {
					Alunos.removerAluno(a);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Alunos.listarAlunos();
				setVisible(false);
			}

		}

		if(arg0.getSource()==sair){
			setVisible(false);

		}

	}

}
