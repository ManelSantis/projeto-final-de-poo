package projeto.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import projeto.view.Telas;

public class ConEstoque extends ConMenu implements Initializable{
	private List<String> categorias = new ArrayList<String>();
	private ObservableList<String> cb;
	
	@FXML
	private ComboBox<String> escolha;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		escolhas();
	}
	
	public void escolhas() {
		if(escolha != null) {
		categorias.add("Nome");
		categorias.add("Preço");
		categorias.add("Serie");
		cb = FXCollections.observableArrayList(categorias);
		escolha.setItems(cb);
		}
	}
	
	public void adicionar(ActionEvent e) throws Exception {
		Telas.adicionarProduto();
	}
	
	public void editar (ActionEvent e) throws Exception {
		//irá selecionar um dos produtos que estiverem na tabela, 
		//para então o botão ser ativado e receber as informações
		//que estiverem na linha
		Telas.editarProduto();
	}
	
	public void excluir (ActionEvent e) throws Exception {
		//irá selecionar um dos produtos que estiverem na tabela, 
		//para então o botão ser ativado e receber as informações
		//que estiverem na linha
		Telas.excluirProduto();
	}
	
	public void pesquisar (ActionEvent e) throws Exception{
		Telas.telaEstoque();
	}
	
	
}
