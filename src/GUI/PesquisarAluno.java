package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Alunos.Alunos;

public class PesquisarAluno extends JFrame implements ActionListener {
	JTextField nome,codigo;
	JButton pesquisarCodigo,pesquisarNome,limpar,sair,listarAlunos;
	JLabel textoTopo;
	
	public PesquisarAluno(){
		super("Pesquisar Aluno");
		
		Container a = new JPanel();
		Container b = new JPanel();
		Container c = new JPanel();
		Container d = getContentPane();
		
		
		a.setLayout(new BorderLayout());
		a.add(textoTopo=new JLabel("Insira o nome do Aluno ou o código do mesmo a ser procurado:"));
		textoTopo.setFont(new Font("serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
		
		b.setLayout(new GridLayout(2,2));
		b.add(new JLabel("Nome do Aluno:"));
		b.add(nome=new JTextField());
		nome.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		b.add(pesquisarNome=new JButton("Pesquisar"));
		b.add(new JLabel("Código do aluno:"));
		b.add(codigo=new JTextField());
		codigo.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		b.add(pesquisarCodigo=new JButton("Pesquisar"));
		
		c.setLayout(new GridLayout(1,3));
		c.add(limpar=new JButton("Limpar"));
		c.add(listarAlunos=new JButton("Listar todos os Alunos"));
		c.add(sair=new JButton("Sair"));
		
		
		
		d.add(BorderLayout.NORTH,textoTopo);
		d.add(BorderLayout.CENTER,b);		
		d.add(BorderLayout.SOUTH,c);
		
		
		
		
		sair.addActionListener(this);
		limpar.addActionListener(this);
		pesquisarNome.addActionListener(this);
		pesquisarCodigo.addActionListener(this);
		listarAlunos.addActionListener(this);
		
		
		
		setSize(510, 160);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==sair){
			setVisible(false);
		}
		
		if(arg0.getSource()==listarAlunos){
			Alunos.listarAlunos();
			nome.setText("");
			codigo.setText("");
		}
		
		if(arg0.getSource()==limpar){
			nome.setText("");
			codigo.setText("");
		}
		if(arg0.getSource()==pesquisarNome){
			Alunos.pesquisarAluno(nome.getText(),true,false);
			nome.setText("");
			codigo.setText("");
		}
		if(arg0.getSource()==pesquisarCodigo){
			Alunos.pesquisarAluno(codigo.getText(),false,true);
			nome.setText("");
			codigo.setText("");
		}
		
	}

}
