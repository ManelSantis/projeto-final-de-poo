package projeto.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projeto.model.vo.ResponsavelVO;

public class Telas extends Application {
	private static Stage primaryStage;
	private static ResponsavelVO usuario;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static ResponsavelVO getUsuario() {
		return usuario;
	}

	public static void setUsuario(ResponsavelVO usuario) {
		Telas.usuario = usuario;
	}
	
	public static void main(String ... args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setResizable(false); //para impedir que o usuário maximize ou diminua a tela
		primaryStage.setTitle("Projeto Final");
		primaryStage.show();
		telaLogin();
	}
	//TELA DE LOGIN//
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	////////////////////////////////////////////////////////////////////////////
	
	//TELA INICIAL DO MENU
	public static void telaInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}	
	////////////////////////////////////////////////////////////////////////////
	
	
	//TELA DE ESTOQUE//
	public static void telaEstoque() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaEstoque.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	////////////////////////////////////////////////////////////////////////////
	
	//TELAS DE PRODUTO//
	public static void adicionarProduto() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/adicionarProduto.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void editarProduto() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/editarProduto.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void excluirProduto() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/excluirProduto.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	////////////////////////////////////////////////////////////////////////////
	//TELAS DE VENDA//
	public static void telaVenda() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaVenda.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	
	public static void telaVendaCarrinho() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaVendaCarrinho.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	
	public static void telaCarrinho() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCarrinho.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaVendaConfirmar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaVendaConfirmar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	///////////////////////////////////////////////////////////////////////////
	//TELA INICIAL DE CADASTRO//
	public static void telaPessoaInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPessoaInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	////////////////////////////////////////////////////////////////////////////
	//TELAS DE CLIENTE//
	public static void telaClienteInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClienteInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	
	public static void telaClienteCadastrar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClienteCadastrar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaClienteEditar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClienteEditar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaClienteExcluir() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/excluirCliente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	////////////////////////////////////////////////////////////////////////////
	
	//TELAS DE RESPONSAVEL//
	public static void telaResponsavelInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaResponsavelInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	
	public static void telaResponsavelCadastrar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaResponsavelCadastrar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaResponsavelEditar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaResponsavelEditar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaResponsavelExcluir() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/excluirResponsavel.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	////////////////////////////////////////////////////////////////////////////
	//TELA DE RELATORIO//	
	public static void telaRelatorio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaRelatorio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.centerOnScreen();
	}
	////////////////////////////////////////////////////////////////////////////
	//TELAS DE LOCAL//
	public static void telaLocal() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLocal.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaLocalCadastro() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLocalCadastro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaLocalEditar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLocalEditar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaLocalExcluir() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLocalExcluir.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	////////////////////////////////////////////////////////////////////////////

}
