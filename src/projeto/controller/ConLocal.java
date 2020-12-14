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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import projeto.exception.ExceptionCampoInvalido;
import projeto.exception.ExceptionCampoVazio;
import projeto.model.bo.LocalBO;
import projeto.model.vo.LocalVO;
import projeto.view.Telas;

public class ConLocal extends ConMenu implements Initializable {

	private static LocalVO editavel;
	private static boolean editar;
	private static boolean excluir;
	private List<String> categorias = new ArrayList<String>();
	private ObservableList<String> cb;
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
	@FXML
	private ComboBox<String> escolha;
	@FXML
	private Label mensagem;
	@FXML
	private TextField pesquisa;
	@FXML
	private Label resp;

	@FXML
	private Label loc;

	@FXML
	private Label comp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (responsavel != null) {

			responsavel.setText(Telas.getUsuario().getNome());
		}
		if (editar) {
			localizacao.setText(editavel.getLocalizacao());
			compartimento.setText(editavel.getCompartimento());

		}
		if (excluir) {
			resp.setText(Telas.getUsuario().getNome());
			loc.setText(editavel.getLocalizacao());
			comp.setText(editavel.getCompartimento());

		}
		preenxer();
		escolha();
	}

	public void escolha() {
		if (escolha != null) {
			categorias.add("Compartimento");
			categorias.add("Localização");
			cb = FXCollections.observableArrayList(categorias);
			escolha.setItems(cb);
		}
	}

	public void preenxer() {
		if (lista != null) {
			// irá mostrar todos os locais que o usuário logado tem
			LocalBO aux = new LocalBO();
			ObservableList<LocalVO> locaisUser = FXCollections.observableArrayList(aux.listar());
			id.setCellValueFactory(new PropertyValueFactory<LocalVO, Long>("id"));
			compar.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("compartimento"));
			loca.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("localizacao"));
			lista.setItems(locaisUser);
		}
	}

	public void adicionar(ActionEvent e) throws Exception {
		Telas.telaLocalCadastro();

	}

	public void editarLocal(ActionEvent e) throws Exception {
		LocalVO loca = lista.getSelectionModel().getSelectedItem();

		if (loca != null) {
			setEditavel(loca);
			setEditar(true);
			Telas.telaLocalEditar();
		}

	}

	public void editar(ActionEvent e) {
		// Irá receber o local com a informação alterada, salvar tudo e chamar o
		// metodo para editar no banco de dados.
		try {
			verificarCampo(compartimento);
			verificarCampo(localizacao);
			LocalVO loca = new LocalVO();
			LocalBO salvar = new LocalBO();
			loca.setId(editavel.getId());
			loca.setCompartimento(compartimento.getText());
			loca.setLocalizacao(localizacao.getText());
			loca.setResponsavel(Telas.getUsuario());
			salvar.editar(loca);
			setEditar(false);
			Telas.telaLocal();
		} catch (ExceptionCampoInvalido e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText(e1.getMessage());
			mensagem.setVisible(true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void excluirlocal(ActionEvent e) throws Exception {
		LocalVO loca = lista.getSelectionModel().getSelectedItem();

		if (loca != null) {
			setEditavel(loca);
			setExcluir(true);
			Telas.telaLocalExcluir();
		}

	}

	public void excluir(ActionEvent e) throws Exception {
		// Irá receber o local selecionado para exclui-lo do banco de dados
		LocalBO salvar = new LocalBO();
		salvar.excluir(editavel);
		setExcluir(false);
		Telas.telaLocal();
	}

	public void pesquisar(ActionEvent e) throws Exception {
		if ((pesquisa.getText() != null) && (!pesquisa.getText().isEmpty())) {

			if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Compartimento"))) {
				mensagem.setVisible(false);
				LocalVO local = new LocalVO();
				local.setCompartimento(pesquisa.getText());
				LocalBO aux = new LocalBO();
				ObservableList<LocalVO> locais = FXCollections.observableArrayList(aux.compartimento(local));
				id.setCellValueFactory(new PropertyValueFactory<LocalVO, Long>("id"));
				compar.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("compartimento"));
				loca.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("localizacao"));
				lista.setItems(locais);

			} else if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Localização"))) {
				mensagem.setVisible(false);
				LocalVO local = new LocalVO();
				local.setLocalizacao(pesquisa.getText());
				LocalBO aux = new LocalBO();
				ObservableList<LocalVO> locais = FXCollections.observableArrayList(aux.localizacao(local));
				id.setCellValueFactory(new PropertyValueFactory<LocalVO, Long>("id"));
				compar.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("compartimento"));
				loca.setCellValueFactory(new PropertyValueFactory<LocalVO, String>("localizacao"));
				lista.setItems(locais);
			} else {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText("Por favor, selecione um tipo de pesquisa");
				mensagem.setVisible(true);
			}
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, digite algo para pesquisar");
			mensagem.setVisible(true);
		}
	}
	
	private void verificarCampo(TextField tf) throws ExceptionCampoVazio {
		if (tf.getText().isEmpty()) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Preenxa todos os campos antes de salvar");
			mensagem.setVisible(true);
			throw new ExceptionCampoVazio("Complete todos os campos.");
		} else
			return;
	}
	
	public void confirmar(ActionEvent e) {
		try {
			verificarCampo(compartimento);
			verificarCampo(localizacao);
			LocalVO local = new LocalVO();
			LocalBO salvar = new LocalBO();
			local.setLocalizacao(localizacao.getText());
			local.setCompartimento(compartimento.getText());
			local.setResponsavel(Telas.getUsuario());
			salvar.cadastrar(local);
			Telas.telaLocal();
		} catch (ExceptionCampoInvalido e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText(e1.getMessage());
			mensagem.setVisible(true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

	public void cancelar(ActionEvent e) throws Exception {
		Telas.telaLocal();

	}

	public static void setEditavel(LocalVO local) {
		ConLocal.editavel = local;
	}

	public static LocalVO getEditavel() {
		return editavel;
	}

	public static boolean isEditar() {
		return editar;
	}

	public static void setEditar(boolean editar) {
		ConLocal.editar = editar;
	}

	public static boolean isExcluir() {
		return excluir;
	}

	public static void setExcluir(boolean deletar) {
		ConLocal.excluir = deletar;
	}

}
