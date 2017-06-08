package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Alunos.Alunos;
import Repositorio.Repositorio;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InserirAluno extends JFrame implements ActionListener{
	JTextField nome,sexo,idade,nomePai,colegio,telefone,endereco,valorPagamento,dataPagamento;
	JButton inserir,sair,limpar;
	int contador=0;

	public InserirAluno(){
		super ("InserirAluno");
		Container b = new JPanel();
		Container c = new JPanel();
		Container d = new JPanel();
		Container e = getContentPane();
		


		


		c.setLayout(new GridLayout(9,9));
		c.add(new JLabel("Nome:"));
		c.add(nome=new JTextField());
		nome.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Sexo:"));
		c.add(sexo=new JTextField());
		sexo.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Idade:"));
		c.add(idade=new JTextField());
		idade.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Nome do/dos pai/pais:"));
		c.add(nomePai=new JTextField());
		nomePai.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Colegio:"));
		c.add(colegio=new JTextField());
		colegio.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Telefone:"));
		c.add(telefone=new JTextField());
		telefone.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Endereço:"));
		c.add(endereco=new JTextField());
		endereco.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Valor do pagamento:"));
		c.add(valorPagamento=new JTextField());
		valorPagamento.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		c.add(new JLabel("Data do pagamento:"));
		c.add(dataPagamento=new JTextField());
		dataPagamento.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
		
		

		d.setLayout(new GridLayout (1,3));
		d.add(inserir=new JButton("Inserir"));
		d.add(limpar=new JButton("Limpar"));
		d.add(sair=new JButton("Sair"));
		sair.addActionListener(this);
		limpar.addActionListener(this);
		inserir.addActionListener(this);
		
		e.setLayout(new BorderLayout());
		e.add(BorderLayout.NORTH,c);
		e.add(BorderLayout.SOUTH,d);



		setSize(750,350);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==sair){
			setVisible(false);

		}
		if(arg0.getSource()==inserir){
			

			Alunos.inserirAluno(nome.getText(), sexo.getText(), idade.getText(), nomePai.getText(), colegio.getText(), telefone.getText(), endereco.getText(), valorPagamento.getText(), dataPagamento.getText());


			try {
				Repositorio.gravarAlunos();
			} catch (IOException e) {

				e.printStackTrace();
			}


			nome.setText("");
			sexo.setText("");
			idade.setText("");
			nomePai.setText("");
			colegio.setText("");
			telefone.setText("");
			endereco.setText("");
			valorPagamento.setText("");
			dataPagamento.setText("");


		}

		if(arg0.getSource()==limpar){
			nome.setText("");
			sexo.setText("");
			idade.setText("");
			nomePai.setText("");
			colegio.setText("");
			telefone.setText("");
			endereco.setText("");
			valorPagamento.setText("");
			dataPagamento.setText("");

		}

	}

}
