package Alunos;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import GUI.ScrollProcurarAluno;
import Repositorio.Repositorio;
public class Alunos {
	private String numeroCadastro;
	private String nome;
	private String sexo;
	private String idade;
	private String pais;
	private String telefone;
	private String endereco;
	private String valorPagamento;
	private String dataPagamento;
	private String colegio;


	private static Alunos[] novoAluno=new Alunos[1000];

	public static void setNovoAluno(String numeroCadastro,String nome,String sexo,String idade,String pais,String colegio,String telefone,String endereco,String valorPagamento,String dataPagamento,int posicao){
		novoAluno[posicao]=new Alunos(numeroCadastro,nome,sexo,idade,pais,colegio,telefone,endereco,valorPagamento,dataPagamento);
	}

	public static String getNumeroCadastro(int contador) {
		return novoAluno[contador].numeroCadastro;
	}

	public static String getNome(int contador) {
		return novoAluno[contador].nome;
	}

	public static String getSexo(int contador) {
		return novoAluno[contador].sexo;
	}

	public static String getIdade(int contador) {
		return novoAluno[contador].idade;
	}

	public static String getPais(int contador) {
		return novoAluno[contador].pais;
	}

	public static String getColegio(int contador) {
		return novoAluno[contador].colegio;
	}

	public static String getTelefone(int contador) {
		return novoAluno[contador].telefone;
	}

	public static String getEndereco(int contador) {
		return novoAluno[contador].endereco;
	}

	public static String getValorPagamento(int contador) {
		return novoAluno[contador].valorPagamento;
	}

	public static String getDataPagamento(int contador) {
		return novoAluno[contador].dataPagamento;
	}




	public Alunos(String numeroCadastro,String nome,String sexo,String idade,String pais,String colegio,String telefone,String endereco,String valorPagamento,String dataPagamento){
		this.numeroCadastro=numeroCadastro;
		this.nome=nome;
		this.sexo=sexo;
		this.idade=idade;
		this.pais=pais;
		this.colegio=colegio;
		this.telefone=telefone;
		this.endereco=endereco;
		this.valorPagamento=valorPagamento;
		this.dataPagamento=dataPagamento;

	}


	public static void inserirAluno(String nome,String sexo,String idade,String nomePai,String colegio,String telefone, String endereco, String valorPagamento, String dataPagamento){
		boolean sair=false;
		String numeroCadastro;
		int registro;


		if(Repositorio.getContador()==0){
			numeroCadastro="1";
			Repositorio.setRegistro("1");
		}

		else{			
			registro=Integer.parseInt(Repositorio.getRegistro());
			registro=registro +1;
			numeroCadastro=String.valueOf(registro);
			Repositorio.setRegistro(numeroCadastro);


		}

		Alunos.setNovoAluno(numeroCadastro,nome, sexo, idade, nomePai,colegio, telefone, endereco, valorPagamento, dataPagamento, Repositorio.getContador());

		Repositorio.setContador(Repositorio.getContador() +1);
		JOptionPane.showMessageDialog(null, "Inserido!\n\n "+ "Código de cadastro: "+numeroCadastro+"\n Nome do aluno: "+nome+"\n Sexo do aluno: "+sexo+"\n Idade do aluno: "+idade+"\n Nome do/dos pai/pais do aluno: "+nomePai+"\n Colégio: "+colegio +"\n Telefone do aluno: "+telefone+"\n Endereço do aluno: "+endereco+"\n Valor do pagamento do aluno: "+valorPagamento+"\n Data de vencimento do pagamento do aluno: "+dataPagamento+"\n");

	}

	public static  void pesquisarAluno(String nomeOuCodigo,boolean pesquisaNome,boolean pesquisaCodigo){
		String lista,listaN=" ";
		boolean alunoEncontrado=false;
		int contador=0;
		String  listaFinal;

		if(pesquisaNome==true){
			for(int i=0;i<Repositorio.getContador();i++){

				if(nomeOuCodigo.equals(novoAluno[i].nome)){
					contador=contador + 1;
					lista="Código de cadastro: "+novoAluno[i].numeroCadastro+"\n Nome do aluno: "+novoAluno[i].nome+"\n Sexo do aluno: "+novoAluno[i].sexo+"\n Idade do aluno: "+novoAluno[i].idade+"\n Nome do/dos pai/pais do aluno: "+novoAluno[i].pais+"\n Telefone do aluno: "+novoAluno[i].telefone+"\n Endereço do aluno: "+novoAluno[i].endereco+"\n Valor do pagamento do aluno: "+novoAluno[i].valorPagamento+"\n Data de vencimento do pagamento do aluno: "+novoAluno[i].dataPagamento+"\n\n";
					listaN=listaN + lista ;
					alunoEncontrado=true;

				}

			}
		}

		if(pesquisaCodigo==true){
			for(int i=0;i<Repositorio.getContador();i++){

				if(nomeOuCodigo.equals(novoAluno[i].numeroCadastro)){
					contador=contador + 1;
					lista="Código de cadastro: "+novoAluno[i].numeroCadastro+"\n Nome do aluno: "+novoAluno[i].nome+"\n Sexo do aluno: "+novoAluno[i].sexo+"\n Idade do aluno: "+novoAluno[i].idade+"\n Nome do/dos pai/pais do aluno: "+novoAluno[i].pais+"\n Telefone do aluno: "+novoAluno[i].telefone+"\n Endereço do aluno: "+novoAluno[i].endereco+"\n Valor do pagamento do aluno: "+novoAluno[i].valorPagamento+"\n Data de vencimento do pagamento do aluno: "+novoAluno[i].dataPagamento+"\n\n";
					listaN=listaN + lista ;
					alunoEncontrado=true;

				}

			}
		}


		if(alunoEncontrado==false){
			JOptionPane.showMessageDialog(null,"ALUNO NAO ENCONTRADO!");


		}

		if(alunoEncontrado==true){
			listaFinal="Número de alunos achados:"+String.valueOf(contador)+"\n\n"+listaN;
			new ScrollProcurarAluno(listaFinal);
		}
		alunoEncontrado=false;

	}

	public static void removerAluno(int codigo) throws IOException{

		int numeroC=0;
		boolean alunoExcluido=false;



		for(int i=0;i<Repositorio.getContador();i++){

			if(novoAluno[i].numeroCadastro!=null){
				numeroC=Integer.parseInt(novoAluno[i].numeroCadastro);
			}



			if(codigo==numeroC&&alunoExcluido==false){
				JOptionPane.showMessageDialog(null,"Nome do aluno: "+novoAluno[i].nome+"\n Numero do cadastro: "+ novoAluno[i].numeroCadastro + "\n\n ALUNO REMOVIDO!");
				novoAluno[i].numeroCadastro=null;
				novoAluno[i].nome=null;
				novoAluno[i].sexo=null;
				novoAluno[i].idade=null;
				novoAluno[i].pais=null;
				novoAluno[i].colegio=null;
				novoAluno[i].telefone=null;
				novoAluno[i].endereco=null;
				novoAluno[i].valorPagamento=null;
				novoAluno[i].dataPagamento=null;
				alunoExcluido=true;

			}
		}

		if(alunoExcluido==false){
			JOptionPane.showMessageDialog(null, "ALUNO NAO ENCONTRADO!");
		}
		Repositorio.gravarAlunos();
	}

	public static void removerTodos() throws IOException{


		
			for(int i=0;i<Repositorio.getContador();i++){

				novoAluno[i].numeroCadastro=null;
				novoAluno[i].nome=null;
				novoAluno[i].sexo=null;
				novoAluno[i].idade=null;
				novoAluno[i].pais=null;
				novoAluno[i].colegio=null;
				novoAluno[i].telefone=null;
				novoAluno[i].endereco=null;
				novoAluno[i].valorPagamento=null;
				novoAluno[i].dataPagamento=null;


			}

			JOptionPane.showMessageDialog(null,"TODOS OS ALUNOS REMOVIDOS!");
			Repositorio.setContador(0);		
		
			Repositorio.gravarAlunos();
		
	}

	public static void listarAlunos(){
		String lista,listaN=" ";
		int contador=0;
		String  listaFinal;

		for(int i=0;i<Repositorio.getContador();i++){
			if(Alunos.getNumeroCadastro(i) != null
					&& Alunos.getNome(i) != null 
					&& Alunos.getSexo(i) != null
					&& Alunos.getIdade(i) != null
					&& Alunos.getPais(i) != null   
					&& Alunos.getColegio(i) != null
					&& Alunos.getTelefone(i) != null
					&& Alunos.getEndereco(i) != null
					&& Alunos.getValorPagamento(i) != null
					&& Alunos.getDataPagamento(i) != null){


				lista="Código de cadastro: "+novoAluno[i].numeroCadastro+"\n Nome do aluno: "+novoAluno[i].nome+"\n Sexo do aluno: "+novoAluno[i].sexo+"\n Idade do aluno: "+novoAluno[i].idade+"\n Nome do/dos pai/pais do aluno: "+novoAluno[i].pais+"\n Telefone do aluno: "+novoAluno[i].telefone+"\n Endereço do aluno: "+novoAluno[i].endereco+"\n Valor do pagamento do aluno: "+novoAluno[i].valorPagamento+"\n Data de vencimento do pagamento do aluno: "+novoAluno[i].dataPagamento+"\n\n";
				listaN=listaN + lista ;	
				contador=contador+1;
			}

		}

		if(contador==0){
			JOptionPane.showMessageDialog(null,"NENHUM ALUNO CADASTRADO!");
		}
		else{
			listaFinal="NÚMERO DE ALUNOS ACHADOS:"+contador+"\n\n"+listaN;
			new ScrollProcurarAluno(listaFinal);
		}

	}


}
