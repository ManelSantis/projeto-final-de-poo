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
import projeto.model.bo.ProdutoBO;
import projeto.model.vo.ProdutoVO;
import projeto.view.Telas;

public class ConEstoque extends ConMenu implements Initializable{
	private List<String> categorias = new ArrayList<String>();
	private ObservableList<String> cb;
	private static ProdutoVO editavel;
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
	private TableColumn<ProdutoVO, Integer> quantRespAtual;
	@FXML
	private TableColumn<ProdutoVO, Double> valor;
	@FXML
	private TableColumn<ProdutoVO, Long> id;
	
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
	private ComboBox<String> escolha;
	
	@FXML
	private Label nomeProduto;
	@FXML
	private Label serieProduto;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(descricao != null) {
			descricao.setWrapText(true);
		}
		if (lista != null) {
			quantRespAtual.setText(Telas.getUsuario().getUsuario());
		}
		if(editar) {
			nome.setText(editavel.getNome());
			serie.setText(editavel.getSerie());
			preco.setText(""+editavel.getPreco());
			peso.setText(""+editavel.getPeso());
			descricao.setText(editavel.getDescricao());
		}
		if(deletar) {
			nomeProduto.setText(editavel.getNome());
			serieProduto.setText(editavel.getSerie());
		}
		
		escolhas();
		preenxer();
	}
	
	public void escolhas() {
		if(escolha != null) {
		categorias.add("Nome");
		categorias.add("Responsável");
		categorias.add("Serie");
		cb = FXCollections.observableArrayList(categorias);
		escolha.setItems(cb);
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
	
	public void adicionar(ActionEvent e) throws Exception {
		ProdutoVO prod = new ProdutoVO();
		ProdutoBO salvar = new ProdutoBO();
		prod.setNome(nome.getText());
		prod.setSerie(serie.getText());
		prod.setPreco(Double.parseDouble(preco.getText()));
		prod.setPeso(Double.parseDouble(peso.getText()));
		prod.setDescricao(descricao.getText());
		salvar.cadastrar(prod);
		Telas.telaEstoque();
	}
	
	public void telaEditar(ActionEvent e) throws Exception{
		ProdutoVO prod = lista.getSelectionModel().getSelectedItem();
		if(prod != null) {
			ProdutoBO aux = new ProdutoBO();
			prod = aux.findById(prod);
			setEditavel(prod);
			setEditar(true);
			Telas.editarProduto();
		}
	}
	
	public void editar (ActionEvent e) throws Exception {
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
		Telas.telaEstoque();
	}
	
	public void telaExcluir(ActionEvent e) throws Exception{
		ProdutoVO prod = lista.getSelectionModel().getSelectedItem();
		if(prod != null) {
			ProdutoBO aux = new ProdutoBO();
			prod = aux.findById(prod);
			setEditavel(prod);
			setDeletar(true);
			Telas.excluirProduto();
		}
	}
	
	public void excluir (ActionEvent e) throws Exception {
		ProdutoBO salvar = new ProdutoBO();
		salvar.excluir(editavel);
		setDeletar(false);
		Telas.telaEstoque();
	}
	
	public void pesquisar (ActionEvent e) throws Exception{
		Telas.telaEstoque();
	}
	
	public void cancelar (ActionEvent e) throws Exception{
		setDeletar(false);
		setEditar(false);
		Telas.telaEstoque();
	}

	public static ProdutoVO getEditavel() {
		return editavel;
	}

	public static void setEditavel(ProdutoVO editavel) {
		ConEstoque.editavel = editavel;
	}

	public static boolean isEditar() {
		return editar;
	}

	public static void setEditar(boolean editar) {
		ConEstoque.editar = editar;
	}

	public static boolean isDeletar() {
		return deletar;
	}

	public static void setDeletar(boolean deletar) {
		ConEstoque.deletar = deletar;
	}
	
}
