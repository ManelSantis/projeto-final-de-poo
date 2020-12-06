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
	
	public static void telaVender() throws Exception{
		
	}
	
	public static void telaRelatorio() throws Exception{
		
	}
	
	public static void telaCadastro() throws Exception{
		
	}
	
	public static void telaLocal() throws Exception{
		
	}
}
