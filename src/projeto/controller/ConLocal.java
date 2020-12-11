package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.model.bo.LocalBO;
import projeto.model.vo.LocalVO;
import projeto.view.Telas;

public class ConLocal extends ConMenu implements Initializable{
	
	@FXML
    private TableView<LocalVO> lista;
    @FXML
    private TableColumn<LocalVO, Long> id;
    @FXML
    private TableColumn<LocalVO, String> compar;
    @FXML
    private TableColumn<LocalVO, String> loca;

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
		System.out.print(".....");
		preenxer();
	}
    
    public void preenxer() {
    	if (lista != null) {
    		//irá mostrar todos os locais que o usuário logado tem
    		LocalBO aux = new LocalBO();
    		ObservableList<LocalVO> locaisUser = FXCollections.observableArrayList(aux.listar());
    		id.setCellValueFactory(new PropertyValueFactory<LocalVO, Long>("id"));
    		compar.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("compartimento"));
    		loca.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("localizacao"));
    		lista.setItems(locaisUser);
    	}
    }
	
	public void adicionar (ActionEvent e) throws Exception{
		Telas.telaLocalCadastro();
		
	}
	public void excluirlocal (ActionEvent e) throws Exception{
		Telas.telaLocalExcluir();
		
	}
	
	public void editarLocal(ActionEvent e) throws Exception{
		Telas.telaLocalEditar();
	}
	
	public void editar (ActionEvent e) throws Exception{
		LocalBO salvar = new LocalBO();
		LocalVO aux = new LocalVO();
		aux.setResponsavel(Telas.getUsuario());
		aux.setCompartimento(compartimento.getText());
		aux.setLocalizacao(localizacao.getText());
		salvar.editar(aux);
		Telas.telaLocal();
	}
	
	public void excluir (ActionEvent e) throws Exception{
		LocalBO salvar = new LocalBO();
		LocalVO aux = new LocalVO();
		aux.setResponsavel(Telas.getUsuario());
		aux.setCompartimento(compartimento.getText());
		aux.setLocalizacao(localizacao.getText());
		salvar.excluir(aux);
		Telas.telaLocal();
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
