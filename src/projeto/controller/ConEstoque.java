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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import projeto.model.bo.EstoqueBO;
import projeto.model.bo.LocalBO;
import projeto.model.bo.ProdutoBO;
import projeto.model.bo.ResponsavelBO;
import projeto.model.vo.EstoqueVO;
import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;

public class ConEstoque extends ConMenu implements Initializable {

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
	private TableColumn<ProdutoVO, Long> loc;

	@FXML
	private Label mensagem;
	@FXML
	private ComboBox<String> escolha;
	@FXML
	private TextField pesquisa;

	@FXML
	private Button aumentar;
	@FXML
	private Button diminuir;
	@FXML
	private Button deletar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		escolhas();
		preenxer();
	}

	public void escolhas() {
		if (escolha != null) {
			ResponsavelBO aux = new ResponsavelBO();
			ArrayList<ResponsavelVO> aux2 = aux.listar();
			ArrayList<String> nomes = new ArrayList<String>();
			for (int i = 0; i < aux2.size(); i++) {
				nomes.add(aux2.get(i).getId() + "/" + aux2.get(i).getUsuario());
			}
			ObservableList<String> cb = FXCollections.observableArrayList(nomes);
			escolha.setItems(cb);
		}
	}

	public void preenxer() {
		ResponsavelBO aux = new ResponsavelBO();
		ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(aux.estoque());
		nomeProd.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
		numSerie.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("serie"));
		quantTotal.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
		valor.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
		id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
		loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
		lista.setItems(produtos);
	}

	/// ESTOQUE///
	public void aumentar(ActionEvent e) throws Exception {
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			LocalVO l = new LocalVO();
			l.setId(Long.parseLong(aux.getDescricao()));
			EstoqueVO es = new EstoqueVO();
			es.setLocal(l);
			es.setProduto(aux);
			es.setQuantidade(1 + aux.getQuantidade());
			EstoqueBO salvar = new EstoqueBO();
			salvar.editar(es);
			Telas.telaEstoque();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para aumentar a quantidade");
			mensagem.setVisible(true);
		}
	}

	public void diminuir(ActionEvent e) throws Exception {
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			LocalVO l = new LocalVO();
			l.setId(Long.parseLong(aux.getDescricao()));
			EstoqueVO es = new EstoqueVO();
			es.setLocal(l);
			es.setProduto(aux);
			es.setQuantidade(aux.getQuantidade() - 1);
			EstoqueBO salvar = new EstoqueBO();
			salvar.editar(es);
			Telas.telaEstoque();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para diminuir a quantidade");
			mensagem.setVisible(true);
		}
	}

	public void deletar(ActionEvent e) throws Exception {
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			LocalVO l = new LocalVO();
			l.setId(Long.parseLong(aux.getDescricao()));
			EstoqueVO es = new EstoqueVO();
			es.setLocal(l);
			es.setProduto(aux);
			es.setQuantidade(aux.getQuantidade());
			EstoqueBO salvar = new EstoqueBO();
			salvar.excluir(es);
			Telas.telaEstoque();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para remover do seu estoque");
			mensagem.setVisible(true);
		}
	}

	public void pesquisar(ActionEvent e) throws Exception {
		if ((pesquisa.getText() != null) && (!pesquisa.getText().isEmpty())) {
			if (escolha.getSelectionModel().getSelectedItem() != null) {
				mensagem.setVisible(false);
				String[] respon = escolha.getSelectionModel().getSelectedItem().split("/");

				// Achar os dados do responsavel que está pesquisando;
				ResponsavelBO resp = new ResponsavelBO();
				ResponsavelVO re = new ResponsavelVO();
				re.setId(Long.parseLong(respon[0]));
				re = resp.findById(re);
				if (re.getId() == Telas.getUsuario().getId()) {
					aumentar.setVisible(true);
					diminuir.setVisible(true);
					deletar.setVisible(true);
				} else {
					aumentar.setVisible(false);
					diminuir.setVisible(false);
					deletar.setVisible(false);
				}

				// os dados do produto a ser pesquisado
				ProdutoVO aux1 = new ProdutoVO();
				aux1.setNome(pesquisa.getText());

				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(resp.estoqueNome(re, aux1));
				nomeProd.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				numSerie.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("serie"));
				quantTotal.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				valor.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
			} else {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText("Por favor, selecione um tipo de pesquisa");
				mensagem.setVisible(true);
			}
		} else {
			if (escolha.getSelectionModel().getSelectedItem() != null) {
				mensagem.setVisible(false);
				String[] respon = escolha.getSelectionModel().getSelectedItem().split("/");

				// Achar os dados do responsavel que está pesquisando;
				ResponsavelBO resp = new ResponsavelBO();
				ResponsavelVO re = new ResponsavelVO();
				re.setId(Long.parseLong(respon[0]));
				re = resp.findById(re);
				if (re.getId() == Telas.getUsuario().getId()) {
					aumentar.setVisible(true);
					diminuir.setVisible(true);
					deletar.setVisible(true);
				} else {
					aumentar.setVisible(false);
					diminuir.setVisible(false);
					deletar.setVisible(false);
				}

				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(resp.estoque(re));
				nomeProd.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				numSerie.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("serie"));
				quantTotal.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				valor.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
			} else {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText("Por favor, selecione um responsável para ver o estoque");
				mensagem.setVisible(true);
			}

		}
	}

	public void voltar(ActionEvent e) throws Exception {
		Telas.telaEstoqueInicio();
	}

}
