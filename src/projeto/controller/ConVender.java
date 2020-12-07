package projeto.controller;

import javafx.event.ActionEvent;
import projeto.view.Telas;

public class ConVender extends ConMenu{


	public void Avançar  (ActionEvent e) throws Exception{
		Telas.telaVendaConfirmar();
	}
	public void OK  (ActionEvent e) throws Exception{
		Telas.telaVendaCliente();
	}
	public void pesquisar  (ActionEvent e) throws Exception{
		Telas.telaVendaInicio();
	}
	public void telaVendaCliente  (ActionEvent e) throws Exception{
		Telas.telaVendaCliente();
	}
	
	public void confirmarcliente  (ActionEvent e) throws Exception{
		Telas.telaVendaConfirmar();
	}
	public void confirmarpedido  (ActionEvent e) throws Exception{
		Telas.telaVendaInicio();
	}
	public void cancelarpedido  (ActionEvent e) throws Exception{
		Telas.telaVendaCliente();
	}
} 

