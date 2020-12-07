package projeto.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
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
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}	
	
	public static void telaEstoque() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaEstoque.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
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
	
	public static void telaVendaInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaVendaInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaVendaCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaVendaCliente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaClienteEditar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClienteEditar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaClienteCadastrar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClienteCadastrar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaResponsavelCadastrar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaResponsavelCadastrar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaResponsavelInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaResponsavelInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaClienteInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClienteInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaCadastroInicio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastroInicio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaVendaConfirmar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaVendaConfirmar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaRelatorio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaRelatorio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
}
