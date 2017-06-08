package Principal;
import java.io.IOException;
import GUI.PrimeiraJanela;
import Repositorio.Repositorio;


public class Principal {
	
	public static void main(String[]args) throws IOException{
	
		Repositorio.lerAlunos();

		 new PrimeiraJanela();

		
		
	}

}
