package Excessoes;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")

public class DataInvalidaException extends Exception {
	
	public DataInvalidaException() {
		
		JOptionPane.showMessageDialog(null,"Data n�o est� no formato DD/MM/YYYY");
		
		System.err.println("Erro causado por - Data n�o est� no formato DD/MM/YYYY");
		
	};
}
