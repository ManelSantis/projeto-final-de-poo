package projeto.controller;

import javafx.event.ActionEvent;
import projeto.view.Telas;

public class ConVender extends ConMenu{


	public void avancar  (ActionEvent e) throws Exception{
		Telas.telaVendaCarrinho();
	}
	
	public void voltar  (ActionEvent e) throws Exception{
		Telas.telaVendaCarrinho();
	}
	
	public void pesquisar  (ActionEvent e) throws Exception{
		Telas.telaVenda();
	}
	
	public void confirmar  (ActionEvent e) throws Exception{
		Telas.telaVendaConfirmar();
		
	}
	
	public void confirmarVenda  (ActionEvent e) throws Exception{
		Telas.telaVenda();
		
	}
	
	public void verCarrinho  (ActionEvent e) throws Exception{
		Telas.telaCarrinho();
	}
	
	public void adicionarCarrinho (ActionEvent e) throws Exception{
		
	}
	
	public void removerCarrinho  (ActionEvent e) throws Exception{
		Telas.telaVendaCarrinho();
	}
	
	public void cancelarVenda  (ActionEvent e) throws Exception{
		Telas.telaVenda();
	}
	
} 

