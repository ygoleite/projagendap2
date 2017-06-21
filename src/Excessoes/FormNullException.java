package Excessoes;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class FormNullException extends Exception {
	public FormNullException() {
		JOptionPane.showMessageDialog(null,"Campos obrigatórios faltantes");
		System.err.println("Erro causado por - Ausencia de Valores Obrigatórios");
	}
}
