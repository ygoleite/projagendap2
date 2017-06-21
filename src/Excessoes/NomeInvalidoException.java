package Excessoes;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NomeInvalidoException extends Exception {

			public NomeInvalidoException() {
			JOptionPane.showMessageDialog(null,"Nome Inválido");
			System.err.println("Erro causado por - Nome no formato inválido");
		};
	
};