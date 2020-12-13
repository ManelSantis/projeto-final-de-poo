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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import projeto.exception.ExceptionCampoInvalido;
import projeto.exception.ExceptionCampoVazio;
import projeto.model.bo.EstoqueBO;
import projeto.model.bo.LocalBO;
import projeto.model.bo.ProdutoBO;
import projeto.model.vo.EstoqueVO;
import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;
import projeto.view.Telas;

public class ConProdutos extends ConMenu implements Initializable {
	private List<String> categorias = new ArrayList<String>();
	private ObservableList<String> cb;
	private static ProdutoVO editavel;
	private static boolean estocar;
	private static boolean editar;
	private static boolean deletar;

	@FXML
	private TableView<ProdutoVO> lista;
	@FXML
	private TableColumn<ProdutoVO, String> numSerie;
	@FXML
	private TableColumn<ProdutoVO, String> nomeProd;
	@FXML
	private TableColumn<ProdutoVO, Integer> quantTotal;
	@FXML
	private TableColumn<ProdutoVO, Double> valor;
	@FXML
	private TableColumn<ProdutoVO, Long> id;

	@FXML
	private Label tipo;
	@FXML
	private TextField serie;
	@FXML
	private TextField nome;
	@FXML
	private TextArea descricao;
	@FXML
	private TextField preco;
	@FXML
	private TextField peso;
	@FXML
	private TextField ID;
	@FXML
	private TextField quant;
	@FXML
	private TextField pesquisa;

	@FXML
	private ComboBox<String> escolha;
	@FXML
	private ComboBox<String> locais;
	@FXML
	private Label mensagem;
	@FXML
	private Label nomeProduto;
	@FXML
	private Label serieProduto;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (descricao != null) {
			descricao.setWrapText(true);
		}
		if (editar) {
			nome.setText(editavel.getNome());
			serie.setText(editavel.getSerie());
			preco.setText("" + editavel.getPreco());
			peso.setText("" + editavel.getPeso());
			descricao.setText(editavel.getDescricao());
		}
		if (deletar) {
			nomeProduto.setText(editavel.getNome());
			serieProduto.setText(editavel.getSerie());
		}
		if (estocar) {
			nome.setText(editavel.getNome());
			serie.setText(editavel.getSerie());
			preco.setText("" + editavel.getPreco());
			peso.setText("" + editavel.getPeso());
			ID.setText("" + editavel.getId());
		}
		locais();
		escolhas();
		preenxer();
	}

	public void escolhas() {
		if (escolha != null) {
			categorias.add("Nome");
			categorias.add("Serie");
			cb = FXCollections.observableArrayList(categorias);
			escolha.setItems(cb);
		}
	}

	public void locais() {
		if (locais != null) {
			LocalBO aux = new LocalBO();
			ArrayList<LocalVO> aux2 = aux.listar();
			ArrayList<String> aux3 = new ArrayList<String>();

			for (int i = 0; i < aux2.size(); i++) {
				aux3.add(aux2.get(i).getId() + "/" + aux2.get(i).getCompartimento() + "/"
						+ aux2.get(i).getLocalizacao());
			}

			ObservableList<String> locaisUser = FXCollections.observableArrayList(aux3);
			locais.setItems(locaisUser);
		}
	}

	public void preenxer() {
		if (lista != null) {
			ProdutoBO aux = new ProdutoBO();
			ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(aux.listar());
			nomeProd.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
			numSerie.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("serie"));
			quantTotal.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
			valor.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
			id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
			lista.setItems(produtos);
		}
	}

	public void telaAdicionar(ActionEvent e) throws Exception {
		Telas.adicionarProduto();
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

	private void verificarArea(TextArea tf) throws ExceptionCampoVazio {
		if (tf.getText().isEmpty()) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Preenxa todos os campos antes de salvar");
			mensagem.setVisible(true);
			throw new ExceptionCampoVazio("Complete todos os campos.");
		} else
			return;
	}

	public void adicionar(ActionEvent e) {
		try {
			verificarCampo(nome);
			verificarCampo(serie);
			verificarCampo(preco);
			verificarCampo(peso);
			verificarArea(descricao);
			ProdutoVO prod = new ProdutoVO();
			ProdutoBO salvar = new ProdutoBO();
			prod.setNome(nome.getText());
			prod.setSerie(serie.getText());
			prod.setPreco(Double.parseDouble(preco.getText()));
			prod.setPeso(Double.parseDouble(peso.getText()));
			prod.setDescricao(descricao.getText());
			salvar.cadastrar(prod);
			Telas.telaProdutos();
		} catch (NumberFormatException e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Digitar apenas números em preço e peso");
			mensagem.setVisible(true);
		} catch (ExceptionCampoVazio e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText(e1.getMessage());
			mensagem.setVisible(true);
		} catch (ExceptionCampoInvalido e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText(e1.getMessage());
			mensagem.setVisible(true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void telaEditar(ActionEvent e) throws Exception {
		ProdutoVO prod = lista.getSelectionModel().getSelectedItem();
		if (prod != null) {
			ProdutoBO aux = new ProdutoBO();
			prod = aux.findById(prod);
			setEditavel(prod);
			setEditar(true);
			Telas.editarProduto();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para editar");
			mensagem.setVisible(true);
		}
	}

	public void editar(ActionEvent e) {
		try {
			verificarCampo(nome);
			verificarCampo(serie);
			verificarCampo(preco);
			verificarCampo(peso);
			verificarArea(descricao);
			ProdutoVO prod = new ProdutoVO();
			ProdutoBO salvar = new ProdutoBO();
			prod.setNome(nome.getText());
			prod.setSerie(serie.getText());
			prod.setPreco(Double.parseDouble(preco.getText()));
			prod.setPeso(Double.parseDouble(peso.getText()));
			prod.setDescricao(descricao.getText());
			prod.setId(editavel.getId());
			salvar.editar(prod);
			setEditar(false);
			Telas.telaProdutos();
		} catch (NumberFormatException e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Digitar apenas números em preço e peso");
			mensagem.setVisible(true);
		} catch (ExceptionCampoVazio e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText(e1.getMessage());
			mensagem.setVisible(true);
		} catch (ExceptionCampoInvalido e1) {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText(e1.getMessage());
			mensagem.setVisible(true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void telaExcluir(ActionEvent e) throws Exception {
		ProdutoVO prod = lista.getSelectionModel().getSelectedItem();
		if (prod != null) {
			ProdutoBO aux = new ProdutoBO();
			prod = aux.findById(prod);
			setEditavel(prod);
			setDeletar(true);
			Telas.excluirProduto();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para deletar");
			mensagem.setVisible(true);
		}
	}

	public void excluir(ActionEvent e) throws Exception {
		ProdutoBO salvar = new ProdutoBO();
		salvar.excluir(editavel);
		setDeletar(false);
		Telas.telaProdutos();
	}

	public void estocar(ActionEvent e) throws Exception {
		ProdutoVO prod = lista.getSelectionModel().getSelectedItem();
		if (prod != null) {
			ProdutoBO aux = new ProdutoBO();
			prod = aux.findById(prod);
			setEditavel(prod);
			setEstocar(true);
			Telas.estocar();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para estocar");
			mensagem.setVisible(true);
		}
	}

	public void estoq(ActionEvent e) {
		if (locais.getSelectionModel().getSelectedItem() != null) {
			try {
				verificarCampo(quant);
				ProdutoBO aux1 = new ProdutoBO();
				ProdutoVO aux = new ProdutoVO();
				aux.setId(Long.parseLong(ID.getText()));
				aux = aux1.findById(aux);
				LocalVO local = new LocalVO();
				String[] localCompleto = locais.getSelectionModel().getSelectedItem().split("/");
				local.setId(Long.parseLong(localCompleto[0]));
				local.setCompartimento(localCompleto[1]);
				local.setLocalizacao(localCompleto[2]);
				local.setResponsavel(Telas.getUsuario());
				EstoqueVO esto = new EstoqueVO();
				esto.setLocal(local);
				esto.setProduto(getEditavel());
				esto.setQuantidade(Integer.parseInt(quant.getText()));
				EstoqueBO salvar = new EstoqueBO();
				setEstocar(false);
				salvar.cadastrar(esto);
				Telas.telaProdutos();
			} catch (NumberFormatException e1) {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText("Digitar apenas números na quantidade");
				mensagem.setVisible(true);
			} catch (ExceptionCampoVazio e1) {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText(e1.getMessage());
				mensagem.setVisible(true);
			} catch (ExceptionCampoInvalido e1) {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText(e1.getMessage());
				mensagem.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Selecione um local aonde irá guardar o produto");
			mensagem.setVisible(true);
		}
	}

	public void pesquisar(ActionEvent e) throws Exception {
		if ((pesquisa.getText() != null) && (!pesquisa.getText().isEmpty())) {
			if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Nome"))) {
				mensagem.setVisible(false);
				ProdutoBO aux = new ProdutoBO();
				ProdutoVO aux1 = new ProdutoVO();
				aux1.setNome(pesquisa.getText());
				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(aux.findByNome(aux1));
				nomeProd.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				numSerie.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("serie"));
				quantTotal.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				valor.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				lista.setItems(produtos);
			} else if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Serie"))) {
				mensagem.setVisible(false);
				ProdutoBO aux = new ProdutoBO();
				ProdutoVO aux1 = new ProdutoVO();
				aux1.setSerie(pesquisa.getText());
				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(aux.findBySerie(aux1));
				nomeProd.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				numSerie.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("serie"));
				quantTotal.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				valor.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				lista.setItems(produtos);
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

	public void cancelar(ActionEvent e) throws Exception {
		setEditar(false);
		setDeletar(false);
		setEstocar(false);
		Telas.telaProdutos();
	}

	public void voltar(ActionEvent e) throws Exception {
		Telas.telaEstoqueInicio();
	}

	// GETTERS E SETTERS//

	public static ProdutoVO getEditavel() {
		return editavel;
	}

	public static void setEditavel(ProdutoVO editavel) {
		ConProdutos.editavel = editavel;
	}

	public static boolean isEditar() {
		return editar;
	}

	public static void setEditar(boolean editar) {
		ConProdutos.editar = editar;
	}

	public static boolean isDeletar() {
		return deletar;
	}

	public static void setDeletar(boolean deletar) {
		ConProdutos.deletar = deletar;
	}

	public static boolean isEstocar() {
		return estocar;
	}

	public static void setEstocar(boolean estocar) {
		ConProdutos.estocar = estocar;
	}
}
