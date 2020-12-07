package projeto.controller;

import javafx.event.ActionEvent;
import projeto.view.Telas;

public class ConLocal   extends ConMenu{
	public void listar (ActionEvent e) throws Exception{
		Telas.telaLocalListar();
		
	}
	public void cadastrar (ActionEvent e) throws Exception{
		Telas.telaLocalCadastro();
		
	}
	public void confirmarcad (ActionEvent e) throws Exception{
		Telas.telaLocalInicio();
	}
	public void cancelaracad (ActionEvent e) throws Exception{
		Telas.telaLocalInicio();
		
	}
	public void voltar (ActionEvent e) throws Exception{
		Telas.telaLocalInicio();
		
	}
	public void editar (ActionEvent e) throws Exception{
		Telas.telaLocalEditar();
		
	}
	public void confirmared (ActionEvent e) throws Exception{
		Telas.telaLocalListar();
		
	}
	public void cancelared (ActionEvent e) throws Exception{
		Telas.telaLocalListar();
		
	}
	public void excluir (ActionEvent e) throws Exception{
		Telas.telaLocalExcluir();
		
	}
	public void confirmarex (ActionEvent e) throws Exception{
		Telas.telaLocalListar();
		
	}
	public void cancelarex (ActionEvent e) throws Exception{
		Telas.telaLocalListar();
		
	}
}
