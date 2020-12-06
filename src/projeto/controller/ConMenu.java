package projeto.controller;

import javafx.scene.input.MouseEvent;//como os botões do menu são labels, tem que usar o MouseEvent
import projeto.view.Telas;

public class ConMenu {
	public void inicio (MouseEvent e) throws Exception{
		Telas.telaInicio();
	}
	public void estoque (MouseEvent e) throws Exception{
		Telas.telaEstoque();
	}
	
	public void local (MouseEvent e) throws Exception{
		Telas.telaLocal();
	}
	
	public void vender (MouseEvent e) throws Exception{
		Telas.telaVender();
	}
	public void relatorio (MouseEvent e) throws Exception{
		Telas.telaRelatorio();
	}
	public void cadastro (MouseEvent e) throws Exception{
		Telas.telaCadastro();
	}
	public void sair (MouseEvent e) throws Exception{
		Telas.telaLogin();
	}
}
