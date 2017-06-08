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
import javax.swing.JPanel;

import Repositorio.Repositorio;


@SuppressWarnings("serial")
public class PrimeiraJanela extends JFrame implements ActionListener {

	JButton inserir,pesquisar,remover,sair; 
	JLabel textoTopo,textoBaixo;
	
	public PrimeiraJanela() throws IOException{
		super("CONDUÇAO DO SEU BIO");



		textoTopo=new JLabel("Selecione em um dos itens abaixo:");
		textoTopo.setFont(new Font("serif",Font.CENTER_BASELINE,15));
		textoBaixo=new JLabel("Projeto P2  All rights reserved");
		textoBaixo.setFont(new Font("serif",Font.LAYOUT_LEFT_TO_RIGHT,15));
		Container a = getContentPane();

		inserir = new JButton("Inserir Aluno");
		inserir.addActionListener(this);
		pesquisar = new JButton("Pesquisar Aluno");
		pesquisar.addActionListener(this);
		remover = new JButton("Remover Aluno");
		remover.addActionListener(this);
		sair= new JButton("Sair");
		sair.addActionListener(this);

		Container b = new JPanel();
		b.setLayout(new GridLayout(4,1));
		b.add(inserir);
		b.add(pesquisar);
		b.add(remover);
		b.add(sair);

		a.add(BorderLayout.NORTH,textoTopo);
		a.add(b);
		a.add(BorderLayout.SOUTH,textoBaixo);

		
		setSize(350, 350);
		setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0)   {

		if(arg0.getSource() == inserir){
			
			 new InserirAluno();
			
		}

		if(arg0.getSource() == pesquisar){
			new PesquisarAluno();
		}

		if(arg0.getSource() == remover){
			new RemoverAluno();
		}
		if(arg0.getSource() ==sair){
			System.exit(0);
			try {
				Repositorio.gravarAlunos();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}



	}

}
