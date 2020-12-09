package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.model.bo.ClienteBO;
import projeto.model.bo.ResponsavelBO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.PessoaVO;
import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;

public class ConPessoa extends ConMenu implements Initializable{

	@FXML
	private TableView<PessoaVO> lista; //tabela
	@FXML
	private TableColumn<PessoaVO, String> nome; //coluna
	@FXML
	private TableColumn<PessoaVO, String> cpf; //coluna
	@FXML
	private TableColumn<PessoaVO, Long> id; //coluna
	@FXML
	private TableColumn<PessoaVO, String> telefone; //coluna
	@FXML
	private Label tipo; //responsavel ou cliente
	@FXML
	private Button editar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preenxer();
		/*if (editar != null) {
			if(lista.) {
				
			}
			editar.setDisable(true);
		}*/
	}

	public void cliente(ActionEvent e) throws Exception {
		Telas.telaClienteInicio();
	}

	public void responsavel(ActionEvent e) throws Exception {
		Telas.telaResponsavelInicio();
	}

	public void preenxer() {
		if (lista != null) {
			if (tipo.getText().equals("Responsavel")) {
				ResponsavelBO aux = new ResponsavelBO();
				ObservableList<PessoaVO> responsaveis = FXCollections.observableArrayList(aux.listar());
				nome.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("nome"));
				cpf.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("cpf"));
				telefone.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("telefone"));
				id.setCellValueFactory(new PropertyValueFactory<PessoaVO, Long>("id"));
				lista.setItems(responsaveis);
			} else {
				ClienteBO aux = new ClienteBO();
				ObservableList<PessoaVO> clientes = FXCollections.observableArrayList(aux.listar());
				nome.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("nome"));
				cpf.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("cpf"));
				telefone.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("telefone"));
				id.setCellValueFactory(new PropertyValueFactory<PessoaVO, Long>("id"));
				lista.setItems(clientes);
			}
		}
	}

	public void pesquisa(ActionEvent e) {

	}

	public void cadastro(ActionEvent e) throws Exception {
		if(tipo.getText().equals("Responsavel")) {
			Telas.telaResponsavelCadastrar();
		} else {
			Telas.telaClienteCadastrar();	
		}
	}

	public void editar(ActionEvent e) throws Exception {
		
		if(tipo.getText().equals("Responsavel")) {
			PessoaVO aux = lista.getSelectionModel().getSelectedItem(); //pega a linha selecionada da tabela
			ResponsavelBO aux2 = new ResponsavelBO();
			ResponsavelVO resp = new ResponsavelVO();
			resp.setIdPessoa(aux.getIdPessoa()); //salva o valor de idpessoa
			resp = aux2.findByIdPessoa(resp); //encontra os dados do responsavel que está na linha e os adiciona
			ConCadastrar.setRespEditavel(resp); //guarda eles no ojeto que ajudará na edição
			ConCadastrar.setEditarResp(true); //diz que é para editar um resposval
			Telas.telaResponsavelEditar(); //abre a tela de editar responsavel
		} else {
			// mesma coisa antenrior mas com cliente
			PessoaVO aux = lista.getSelectionModel().getSelectedItem(); 
			ClienteBO aux2 = new ClienteBO();
			ClienteVO cli = new ClienteVO();
			cli.setIdPessoa(aux.getIdPessoa());
			cli = aux2.findByIdPessoa(cli);
			ConCadastrar.setCliEditavel(cli);
			ConCadastrar.setEditarCli(true);
			Telas.telaClienteEditar();	
		}
	}

	public void excluir(ActionEvent e) throws Exception {
		if(tipo.getText().equals("Responsavel")) {
			Telas.telaResponsavelExcluir();	
		} else {
			Telas.telaClienteExcluir();	
		}
	}

}
