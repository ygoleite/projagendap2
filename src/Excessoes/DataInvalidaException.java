package Excessoes;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")

public class DataInvalidaException extends Exception {
	
	public DataInvalidaException() {
		
		JOptionPane.showMessageDialog(null,"Data não está no formato DD/MM/YYYY");
		
		System.err.println("Erro causado por - Data não está no formato DD/MM/YYYY");
		
	};
}
