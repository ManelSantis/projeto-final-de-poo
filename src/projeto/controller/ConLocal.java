package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import projeto.model.bo.LocalBO;
import projeto.model.vo.LocalVO;
import projeto.view.Telas;

public class ConLocal extends ConMenu implements Initializable{


    @FXML
    private TextField localizacao;
    @FXML
    private TextField compartimento;
    @FXML
    private TextField responsavel;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(responsavel != null) {
			responsavel.setText(Telas.getUsuario().getNome());
		}
	}
	
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
		LocalVO local = new LocalVO();
		LocalBO salvar = new LocalBO();
		local.setLocalizacao(localizacao.getText());
		local.setCompartimento(compartimento.getText());
		local.setResponsavel(Telas.getUsuario());
		salvar.cadastrar(local);
		Telas.telaLocal();
	}
	
	public void cancelar (ActionEvent e) throws Exception{
		Telas.telaLocal();
		
	}

	
}
