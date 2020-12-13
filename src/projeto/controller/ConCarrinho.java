package projeto.controller;

import java.net.URL;
import java.util.ArrayList;
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
import projeto.model.bo.EstoqueBO;
import projeto.model.bo.ResponsavelBO;
import projeto.model.bo.VendaBO;
import projeto.model.vo.EstoqueVO;
import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.view.Telas;

public class ConCarrinho extends ConMenu implements Initializable {
	private static boolean car; //verificar se está adicionando no carrinho
	private static boolean ok; //verificar se está confirmando a venda
	
	@FXML
	private TableView<ProdutoVO> lista;
	@FXML
	private TableColumn<ProdutoVO, Long> loc;
	@FXML
	private TableColumn<ProdutoVO, String> nome;
	@FXML
	private TableColumn<ProdutoVO, Integer> quant;
	@FXML
	private TableColumn<ProdutoVO, Double> preco;

	@FXML
	private TextField pesquisa;
	@FXML
	private Label mensagem;
	
	@FXML
	private Label valorFinal;
	@FXML
	private Label nomeCli;
	@FXML
	private Label cpfCli;
	@FXML
	private Label nomeResp;
	@FXML
	private Label cpfResp;
	
	@FXML
	private TableColumn<ProdutoVO, Long> id;
	@FXML
	private ComboBox<String> escolha;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preenxer();
		escolhas();
		if(ok) { //se for para a tela de confirmar a compra
			
			nomeCli.setText("Nome: " + ConVender.getCli().getNome());
			cpfCli.setText("CPF: " + ConVender.getCli().getCpf());

			nomeResp.setText("Nome: " + Telas.getUsuario().getNome());
			cpfResp.setText("CPF: " + Telas.getUsuario().getCpf());
			
			valorFinal.setText("Valor final: R$ " + ConVender.getVenda().getValor());
		}
	}

	public void escolhas() {
		if (escolha != null) {
			ArrayList<String> categorias = new ArrayList<String>();
			categorias.add("Nome");
			categorias.add("Preço");
			ObservableList<String> ob = FXCollections.observableArrayList(categorias);
			escolha.setItems(ob);
		}
	}

	public void preenxer() {
		if (lista != null) {
			if (car) { //para caso ir ver o carrinho
				VendaBO aux = new VendaBO();
				ObservableList<ProdutoVO> produtos = FXCollections
						.observableArrayList(aux.listarItens(ConVender.getVenda()));
				nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
			} else if (ok){ //para caso ir completar a venda
				VendaBO aux = new VendaBO();
				ObservableList<ProdutoVO> produtos = FXCollections
						.observableArrayList(aux.listarItens(ConVender.getVenda()));
				nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
			} else { //para caso ir para a tela de adicionar produtos no carrinho novamente
				ResponsavelBO aux = new ResponsavelBO();
				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(aux.estoque());
				nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
			}
		}
	}

	public void pesquisar(ActionEvent e) throws Exception {
		if ((pesquisa.getText() != null) && (!pesquisa.getText().isEmpty())) {
			if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Nome"))) {
				mensagem.setVisible(false);
				ResponsavelBO resp = new ResponsavelBO();
				ResponsavelVO re = Telas.getUsuario();
				ProdutoVO aux1 = new ProdutoVO();
				aux1.setNome(pesquisa.getText());
				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(resp.estoqueNome(re, aux1));
				nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
			} else if ((escolha.getSelectionModel().getSelectedItem() != null)
					&& (escolha.getSelectionModel().getSelectedItem().equals("Preço"))) {
				mensagem.setVisible(false);
				ResponsavelBO resp = new ResponsavelBO();
				ResponsavelVO re = Telas.getUsuario();
				ProdutoVO aux1 = new ProdutoVO();
				aux1.setPreco(Double.parseDouble(pesquisa.getText()));
				System.out.println(aux1.getPreco());
				ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList(resp.estoquePreco(re, aux1));
				nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
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

	public void voltar(ActionEvent e) throws Exception {
		setCar(false); //saindo do carrinho
		setOk(false); //saindo da tela de confirmar venda
		ConVender.getVenda().zerarValor(); //resetar o valor final da venda
		Telas.telaVendaCarrinho();
	}

	public void adicionarCarrinho(ActionEvent e) throws Exception {
		VendaVO ven = ConVender.getVenda();
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			System.out.println(aux.getDescricao());
			VendaBO salvar = new VendaBO();
			ResponsavelBO aux1 = new ResponsavelBO();
			aux = aux1.estoqueId(Telas.getUsuario(), aux);
			aux.setQuantiPedido(1);
			salvar.adicionarItens(ven, aux);
			ConVender.getVenda().setCarrinho(aux);
			mensagem.setTextFill(Color.web("green"));
			mensagem.setText("Item adicionado no carrinho");
			mensagem.setVisible(true);
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um item para adicionar ao carrinho");
			mensagem.setVisible(true);
		}
	}

	public void confirmarVenda(ActionEvent e) throws Exception {
		VendaBO completar = new VendaBO();
		ConVender.getVenda().setCodigo();
		ConVender.getVenda().setData();
		completar.confirmarVenda(ConVender.getVenda());
		for (int i = 0; i < ConVender.getVenda().getCarrinho().size(); i++) {
			//pegando o local do produto
			LocalVO l = new LocalVO();
			l.setId(Long.parseLong(ConVender.getVenda().getCarrinho().get(i).getDescricao()));
			ResponsavelBO re = new ResponsavelBO();
			EstoqueVO es = new EstoqueVO();
			//adiconando o local
			es.setLocal(l);
			System.out.println(es.getLocal().getId());
			//adicionando o produto
			es.setProduto(re.estoqueId(Telas.getUsuario(), ConVender.getVenda().getCarrinho().get(i)));
			es.setQuantidade(es.getProduto().getQuantidade() 
					- ConVender.getVenda().getCarrinho().get(i).getQuantiPedido());
			EstoqueBO salvar = new EstoqueBO();
			//por fim edita o estoque no final
			salvar.editar(es);
		}
		setCar(false); //saindo do carrinho
		setOk(false); //saindo da tela de confirmar venda
		Telas.telaVenda();
	}
	
	public void confirmar(ActionEvent e) throws Exception {
		setOk(true);
		ConVender.getVenda().setValor();
		Telas.telaVendaConfirmar();
	}

	public void verCarrinho(ActionEvent e) throws Exception {
		setCar(true);
		Telas.telaCarrinho();
	}

	public void aumentar(ActionEvent e) throws Exception {
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			try {
				VendaBO salvar = new VendaBO();
				ResponsavelBO aux1 = new ResponsavelBO();
				int x = aux.getQuantidade();
				aux = aux1.estoqueId(Telas.getUsuario(), aux);
				aux.setQuantiPedido(x + 1);
				salvar.editarItens(ConVender.getVenda(), aux);
				for (int i = 0; i < ConVender.getVenda().getCarrinho().size(); i++) {
					if(ConVender.getVenda().getCarrinho().get(i).getId() == aux.getId()) {
						ConVender.getVenda().getCarrinho().get(i)
						.setQuantiPedido(aux.getQuantiPedido());
						System.out.println(ConVender.getVenda().getCarrinho().get(i)
						.getQuantiPedido());
					}
				}
				VendaBO aux2 = new VendaBO();
				ObservableList<ProdutoVO> produtos = FXCollections
						.observableArrayList(aux2.listarItens(ConVender.getVenda()));
				nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
				quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
				preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
				id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
				loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
				lista.setItems(produtos);
				Telas.telaCarrinho();
			} catch (ExceptionCampoInvalido e1) {
				mensagem.setTextFill(Color.web("red"));
				mensagem.setText(e1.getMessage());
				mensagem.setVisible(true);
			}
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para aumentar a quantidade no carrinho");
			mensagem.setVisible(true);
		}
	}

	public void diminuir(ActionEvent e) throws Exception {
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			VendaBO salvar = new VendaBO();
			ResponsavelBO aux1 = new ResponsavelBO();
			int x = aux.getQuantidade();
			aux = aux1.estoqueId(Telas.getUsuario(), aux);
			aux.setQuantiPedido(x - 1);
			if (aux.getQuantiPedido() == 0) {
				salvar.deletarItens(ConVender.getVenda(), aux);
				for (int i = 0; i < ConVender.getVenda().getCarrinho().size(); i++) {
					if(ConVender.getVenda().getCarrinho().get(i).getId() == aux.getId()) {
						ConVender.getVenda().getCarrinho().remove(i);
					}
				}
			} else {
				salvar.editarItens(ConVender.getVenda(), aux);
				for (int i = 0; i < ConVender.getVenda().getCarrinho().size(); i++) {
					if(ConVender.getVenda().getCarrinho().get(i).getId() == aux.getId()) {
						ConVender.getVenda().getCarrinho().get(i)
						.setQuantiPedido(aux.getQuantiPedido());
					}
				}
			}
			VendaBO aux2 = new VendaBO();
			ObservableList<ProdutoVO> produtos = FXCollections
					.observableArrayList(aux2.listarItens(ConVender.getVenda()));
			nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
			quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
			preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
			id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
			loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
			lista.setItems(produtos);
			Telas.telaCarrinho();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para diminuir a quantidade no carrinho");
			mensagem.setVisible(true);
		}
	}

	public void deletar(ActionEvent e) throws Exception {
		ProdutoVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			VendaBO salvar = new VendaBO();
			ResponsavelBO aux1 = new ResponsavelBO();
			aux = aux1.estoqueId(Telas.getUsuario(), aux);
			salvar.deletarItens(ConVender.getVenda(), aux);
			VendaBO aux2 = new VendaBO();
			for (int i = 0; i < ConVender.getVenda().getCarrinho().size(); i++) {
				if(ConVender.getVenda().getCarrinho().get(i).getId() == aux.getId()) {
					ConVender.getVenda().getCarrinho().remove(i);
				}
			}
			ObservableList<ProdutoVO> produtos = FXCollections
					.observableArrayList(aux2.listarItens(ConVender.getVenda()));
			nome.setCellValueFactory(new PropertyValueFactory<ProdutoVO, String>("nome"));
			quant.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Integer>("quantidade"));
			preco.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Double>("preco"));
			id.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("id"));
			loc.setCellValueFactory(new PropertyValueFactory<ProdutoVO, Long>("descricao"));
			lista.setItems(produtos);
			Telas.telaCarrinho();
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione um produto para deletar do carrinho");
			mensagem.setVisible(true);
		}
	}

	public void cancelarVenda(ActionEvent e) throws Exception {
		setCar(false);
		setOk(false);
		Telas.telaVenda();
	}

	public static boolean isCar() {
		return car;
	}

	public static void setCar(boolean car) {
		ConCarrinho.car = car;
	}

	public static boolean isOk() {
		return ok;
	}

	public static void setOk(boolean ok) {
		ConCarrinho.ok = ok;
	}

}
