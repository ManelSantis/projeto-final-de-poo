package projeto.controller;

import javafx.event.ActionEvent;
import projeto.view.Telas;

public class ConCadastrar extends ConMenu{
	
	
	public void cliente (ActionEvent e) throws Exception{
		Telas.telaClienteInicio();
	}
	
	public void responsavel (ActionEvent e) throws Exception{
		Telas.telaResponsavelInicio();
	}
	
	public void pesquisa (ActionEvent e) {
		
	}
	
	public void cadastroResponsavel(ActionEvent e) throws Exception {
		Telas.telaResponsavelCadastrar();
	}
	
	public void editarResponsavel(ActionEvent e) throws Exception {
		Telas.telaResponsavelEditar();
	}

	public void excluirResponsavel(ActionEvent e) throws Exception {
		Telas.telaResponsavelExcluir();
	}
	
	public void cadastroCliente(ActionEvent e) throws Exception {
		Telas.telaClienteCadastrar();
	}
	
	public void editarCliente(ActionEvent e) throws Exception {
		Telas.telaClienteEditar();
	}

	public void excluirCliente(ActionEvent e) throws Exception {
		Telas.telaClienteExcluir();
	}
}
