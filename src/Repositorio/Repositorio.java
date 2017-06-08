package Repositorio;
import Alunos.Alunos;
import Repositorio.Repositorio;
import Repositorio.Repositorio;

import java.io.*;
import java.util.*;

public class Repositorio {
	private static   int contador=0;
	private static   String registro="0";



	public static String getRegistro() {
		return registro;
	}



	public static void setRegistro(String registro) {
		Repositorio.registro = registro;
	}



	public static int getContador() {
		return contador;
	}



	public static void setContador(int contador) {
		Repositorio.contador = contador;
	}



	public static void lerAlunos() throws FileNotFoundException{
		File lAlunos = new File("alunos.txt");
		
		@SuppressWarnings("resource")
		Scanner leituraAlunos = new Scanner(lAlunos);
        String numeroCadastro;
		String nome;
		String sexo;
		String idade;
		String pais;
		String colegio;
		String telefone;
		String endereco;
		String valorPagamento;
		String dataPagamento;


		while(leituraAlunos.hasNextLine()){
			numeroCadastro=leituraAlunos.nextLine();
			nome=leituraAlunos.nextLine();
			sexo=leituraAlunos.nextLine();
			idade=leituraAlunos.nextLine();
			pais=leituraAlunos.nextLine();
			colegio=leituraAlunos.nextLine();		
			telefone=leituraAlunos.nextLine();
			endereco=leituraAlunos.nextLine();
			valorPagamento=leituraAlunos.nextLine();
			dataPagamento=leituraAlunos.nextLine();
            registro=leituraAlunos.nextLine();


			Alunos.setNovoAluno(numeroCadastro,nome, sexo, idade, pais,colegio, telefone, endereco,valorPagamento, dataPagamento,  contador);
			contador=contador + 1;

		}
	}

	public static void gravarAlunos() throws IOException{

		FileWriter gAlunos = new FileWriter("alunos.txt");                     
		BufferedWriter gravarAlunos = new BufferedWriter(gAlunos);

		for (int i = 0; i < contador; i++) {

			if (   Alunos.getNumeroCadastro(i) == null
					&& Alunos.getNome(i) == null 
					&& Alunos.getSexo(i) == null
					&& Alunos.getIdade(i) == null
					&& Alunos.getPais(i) == null   
				    && Alunos.getColegio(i) == null
					&& Alunos.getTelefone(i) == null
					&& Alunos.getEndereco(i) == null
					&& Alunos.getValorPagamento(i) == null
				    && Alunos.getDataPagamento(i) == null){

			} else {

				gravarAlunos.write(Alunos.getNumeroCadastro(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getNome(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getSexo(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getIdade(i));                              
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getPais(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getColegio(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getTelefone(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getEndereco(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getValorPagamento(i));
				gravarAlunos.newLine();
				gravarAlunos.write(Alunos.getDataPagamento(i));
				gravarAlunos.newLine();
				gravarAlunos.write(registro);
				gravarAlunos.newLine();

			}


		}
		gravarAlunos.close();
	}
}
