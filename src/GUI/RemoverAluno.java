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
import javax.swing.JTextField;

import Repositorio.Repositorio;
import Alunos.Alunos;

public class RemoverAluno extends JFrame implements ActionListener {
	JLabel textoTopo;
	JTextField codigo;
	JButton remover,removerTodos,listarTodos,sair;

	public RemoverAluno(){

		super("REMOVER ALUNO");

		Container a = new JPanel();
		Container b = new JPanel();
		Container c = new JPanel();
		Container d = getContentPane();

		a.add(textoTopo=new JLabel("Digite o código do aluno a ser removido:"));
		textoTopo.setFont(new Font("serif",Font.LAYOUT_LEFT_TO_RIGHT,18));

		b.setLayout(new GridLayout(1,2));
		b.add(new JLabel("Código de cadastro do aluno:"));
		b.add(codigo=new JTextField());

		codigo.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		b.add(remover=new JButton("Remover"));

		c.setLayout(new GridLayout(1,3));
		c.add(listarTodos=new JButton("Listar Todos"));
		c.add(removerTodos=new JButton("Remover Todos"));
		c.add(sair=new JButton("Sair"));

		d.add(BorderLayout.NORTH,a);
		d.add(BorderLayout.CENTER,b);
		d.add(BorderLayout.SOUTH,c);

		remover.addActionListener(this);
		sair.addActionListener(this);
		listarTodos.addActionListener(this);
		removerTodos.addActionListener(this);


		
		setSize(530, 130);
		setVisible(true);

	}


	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource()==sair){
			setVisible(false);
		}

		if(arg0.getSource()==remover){

			try {
				Alunos.removerAluno(Integer.parseInt(codigo.getText()));
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			codigo.setText("");

		}

		if(arg0.getSource()==listarTodos){
			Alunos.listarAlunos();
		}

		if(arg0.getSource()==removerTodos){
			int dialogButton = JOptionPane.YES_NO_OPTION;

			if(Repositorio.getContador()>0){
				JOptionPane.showConfirmDialog(null,"VOCÊ ESTÁ CERTO DISSO?","", dialogButton);

				if(dialogButton == JOptionPane.YES_OPTION){
					
					try {
						Alunos.removerTodos();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
				if(dialogButton == JOptionPane.NO_OPTION){
					remove(dialogButton);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"NENHUM ALUNO CADASTRADO!");
			}

		}
	}

}
