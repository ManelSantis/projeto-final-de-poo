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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import projeto.model.bo.ClienteBO;
import projeto.model.bo.ResponsavelBO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.PessoaVO;
import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;

public class ConPessoa extends ConMenu implements Initializable {
	private List<String> categorias = new ArrayList<String>();
	private ObservableList<String> cb;

	@FXML
	private TableView<PessoaVO> lista; // tabela
	@FXML
	private TableColumn<PessoaVO, String> nome; // coluna
	@FXML
	private TableColumn<PessoaVO, String> cpf; // coluna
	@FXML
	private TableColumn<PessoaVO, Long> id; // coluna
	@FXML
	private TableColumn<PessoaVO, String> telefone; // coluna
	@FXML
	private Label tipo; // responsavel ou cliente
	@FXML
	private Label mensagem; // para mensagens de erro ou acerto
	@FXML
	private Button editar;
	@FXML
	private TextField pesquisa;
	@FXML
	private ComboBox<String> escolha;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preenxer();
		escolhas();
		/*
		 * if(lista != null) { if(lista.getSelectionModel().getSelectedItem() != null) {
		 * editar.setDisable(false); } else { editar.setDisable(true); } }
		 */

	}

	public void voltar(ActionEvent e) throws Exception {
		Telas.telaPessoaInicio();
	}

	public void cliente(ActionEvent e) throws Exception {
		Telas.telaClienteInicio();
	}

	public void responsavel(ActionEvent e) throws Exception {
		Telas.telaResponsavelInicio();
	}

	public void escolhas() {
		if (escolha != null) {
			categorias.add("Nome");
			categorias.add("CPF");
			cb = FXCollections.observableArrayList(categorias);
			escolha.setItems(cb);
		}
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
		// primeiro verifica o tipo de pesquisa que está sendo feita (cliente ou
		// respoonsavel)
		// depois verifica se algo foi selecionado na combo box
		// depois verifica se algo foi digitado na area de pesquisa
		if (tipo.getText().equals("Responsavel")) {
			if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Nome"))) {
				if (!pesquisa.getText().isEmpty()) {
					mensagem.setVisible(false);
					ResponsavelVO resp = new ResponsavelVO();
					resp.setNome(pesquisa.getText());
					ResponsavelBO aux = new ResponsavelBO();
					ObservableList<PessoaVO> responsaveis = FXCollections.observableArrayList(aux.nomes(resp));
					nome.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("nome"));
					cpf.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("cpf"));
					telefone.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("telefone"));
					id.setCellValueFactory(new PropertyValueFactory<PessoaVO, Long>("id"));
					lista.setItems(responsaveis);
				} else {
					mensagem.setTextFill(Color.web("red"));
					mensagem.setText("Por favor, digite algo para pesquisar");
					mensagem.setVisible(true);
				}
			} else if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("CPF"))) {
				if (!pesquisa.getText().isEmpty()) {
					mensagem.setVisible(false);
					ResponsavelBO aux = new ResponsavelBO();
					ObservableList<PessoaVO> responsaveis = FXCollections.observableArrayList(aux.cpfs(pesquisa.getText()));
					nome.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("nome"));
					cpf.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("cpf"));
					telefone.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("telefone"));
					id.setCellValueFactory(new PropertyValueFactory<PessoaVO, Long>("id"));
					lista.setItems(responsaveis);
				} else {
					mensagem.setTextFill(Color.web("red"));
					mensagem.setText("Por favor, digite algo para pesquisar");
					mensagem.setVisible(true);
				}
			} else {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText("Por favor, selecionar um tipo de pesquisa");
				mensagem.setVisible(true);
			}
		} else {
			if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Nome"))) {
				if (!pesquisa.getText().isEmpty()) {
					mensagem.setVisible(false);
					ClienteVO cli = new ClienteVO();
					cli.setNome(pesquisa.getText());
					ClienteBO aux = new ClienteBO();
					ObservableList<PessoaVO> clientes = FXCollections.observableArrayList(aux.nomes(cli));
					nome.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("nome"));
					cpf.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("cpf"));
					telefone.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("telefone"));
					id.setCellValueFactory(new PropertyValueFactory<PessoaVO, Long>("id"));
					lista.setItems(clientes);
				} else {
					mensagem.setTextFill(Color.web("red"));
					mensagem.setText("Por favor, digite algo para pesquisar");
					mensagem.setVisible(true);
				}
			} else if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("CPF"))) {
				if (!pesquisa.getText().isEmpty()) {
					mensagem.setVisible(false);
					ClienteBO aux = new ClienteBO();
					ObservableList<PessoaVO> clientes = FXCollections.observableArrayList(aux.cpfs(pesquisa.getText()));
					nome.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("nome"));
					cpf.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("cpf"));
					telefone.setCellValueFactory(new PropertyValueFactory<PessoaVO, String>("telefone"));
					id.setCellValueFactory(new PropertyValueFactory<PessoaVO, Long>("id"));
					lista.setItems(clientes);
				} else {
					mensagem.setTextFill(Color.web("red"));
					mensagem.setText("Por favor, digite algo para pesquisar");
					mensagem.setVisible(true);
				}
			} else {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText("Por favor, selecionar um tipo de pesquisa");
				mensagem.setVisible(true);
			}
		}
	}

	public void cadastro(ActionEvent e) throws Exception {
		if (tipo.getText().equals("Responsavel")) {
			Telas.telaResponsavelCadastrar();
		} else {
			Telas.telaClienteCadastrar();
		}
	}

	public void editar(ActionEvent e) throws Exception {

		if (tipo.getText().equals("Responsavel")) {
			PessoaVO aux = lista.getSelectionModel().getSelectedItem(); // pega a linha selecionada da tabela
			ResponsavelBO aux2 = new ResponsavelBO();
			ResponsavelVO resp = new ResponsavelVO();
			resp.setIdPessoa(aux.getIdPessoa()); // salva o valor de idpessoa
			resp = aux2.findByIdPessoa(resp); // encontra os dados do responsavel que está na linha e os adiciona
			ConCadastrar.setRespEditavel(resp); // guarda eles no ojeto que ajudará na edição
			ConCadastrar.setEditarResp(true); // diz que é para editar um resposval
			Telas.telaResponsavelEditar(); // abre a tela de editar responsavel
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
		if (tipo.getText().equals("Responsavel")) {
			PessoaVO aux = lista.getSelectionModel().getSelectedItem(); // pega a linha selecionada da tabela
			ResponsavelBO aux2 = new ResponsavelBO();
			ResponsavelVO resp = new ResponsavelVO();
			resp.setIdPessoa(aux.getIdPessoa()); // salva o valor de idpessoa
			resp = aux2.findByIdPessoa(resp); // encontra os dados do responsavel que está na linha e os adiciona
			ConCadastrar.setRespEditavel(resp);
			ConCadastrar.setDeletarResp(true);
			Telas.telaResponsavelExcluir();
		} else {
			PessoaVO aux = lista.getSelectionModel().getSelectedItem();
			ClienteBO aux2 = new ClienteBO();
			ClienteVO cli = new ClienteVO();
			cli.setIdPessoa(aux.getIdPessoa());
			cli = aux2.findByIdPessoa(cli);
			ConCadastrar.setCliEditavel(cli);
			ConCadastrar.setDeletarCli(true);
			Telas.telaClienteExcluir();
		}
	}

}
