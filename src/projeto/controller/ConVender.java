package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import projeto.model.bo.ClienteBO;
import projeto.model.bo.VendaBO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;
import projeto.view.Telas;

public class ConVender extends ConMenu implements Initializable {
	private static ClienteVO cli;
	private static VendaVO venda;
	
	@FXML
	private TableView<ClienteVO> lista;
	@FXML
	private TableColumn<ClienteVO, String> nome;
	@FXML
	private TableColumn<ClienteVO, String> cpf;
	@FXML
	private TableColumn<ClienteVO, Long> id;
	
	@FXML
	private TextField pesquisa;
	@FXML
	private Label mensagem;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preenxer();
	}
	
	public void preenxer() {
		if(lista != null) {
			ClienteBO aux = new ClienteBO();
			ObservableList<ClienteVO> clientes = FXCollections.observableArrayList(aux.listar());
			nome.setCellValueFactory(new PropertyValueFactory<ClienteVO, String>("nome"));
			cpf.setCellValueFactory(new PropertyValueFactory<ClienteVO, String>("cpf"));
			id.setCellValueFactory(new PropertyValueFactory<ClienteVO, Long>("id"));
			lista.setItems(clientes);
		}
	}
	
	public void pesquisar(ActionEvent e) throws Exception {
		if((pesquisa.getText() != null) && (!pesquisa.getText().isEmpty())) {
			ClienteBO aux = new ClienteBO();
			ObservableList<ClienteVO> clientes = FXCollections.observableArrayList(aux.cpfs(pesquisa.getText()));
			nome.setCellValueFactory(new PropertyValueFactory<ClienteVO, String>("nome"));
			cpf.setCellValueFactory(new PropertyValueFactory<ClienteVO, String>("cpf"));
			id.setCellValueFactory(new PropertyValueFactory<ClienteVO, Long>("id"));
			lista.setItems(clientes);
		}
	}

	public void avancar(ActionEvent e) throws Exception {
		ClienteVO aux = lista.getSelectionModel().getSelectedItem();
		if(aux != null) {
			ClienteBO aux1 = new ClienteBO();
			VendaBO aux2 = new VendaBO();
			VendaVO aux3 = new VendaVO();
			setCli(aux1.findById(aux));
			aux3.setCliente(getCli());
			aux3.setResponsavel(Telas.getUsuario());
			setVenda(aux3);
			aux2.inicioVenda(getVenda());
			Telas.telaVendaCarrinho();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecionar uma linha da tabela");
			mensagem.setVisible(true);
		}
	}

	public static ClienteVO getCli() {
		return cli;
	}

	public static void setCli(ClienteVO cli) {
		ConVender.cli = cli;
	}

	public static VendaVO getVenda() {
		return venda;
	}

	public static void setVenda(VendaVO venda) {
		ConVender.venda = venda;
	}

}
