package Excessoes;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NomeInvalidoException extends Exception {

			public NomeInvalidoException() {
			JOptionPane.showMessageDialog(null,"Nome Inv�lido");
			System.err.println("Erro causado por - Nome no formato inv�lido");
		};
	
};