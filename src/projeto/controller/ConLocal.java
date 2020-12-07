package projeto.controller;

import javafx.event.ActionEvent;
import projeto.view.Telas;

public class ConLocal   extends ConMenu{

	public void adicionar (ActionEvent e) throws Exception{
		Telas.telaLocalCadastro();
		
	}

	public void editar (ActionEvent e) throws Exception{
		Telas.telaLocalEditar();
		
	}
	
	public void excluir (ActionEvent e) throws Exception{
		Telas.telaLocalExcluir();
		
	}
	
	public void pesquisar (ActionEvent e) throws Exception{
		Telas.telaLocal();
		
	}
	
	public void confirmar (ActionEvent e) throws Exception{
		Telas.telaLocal();
		
	}
	
	public void cancelar (ActionEvent e) throws Exception{
		Telas.telaLocal();
		
	}
}
