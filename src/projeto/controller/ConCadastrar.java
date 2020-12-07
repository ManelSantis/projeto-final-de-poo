package projeto.controller;

import javafx.scene.input.MouseEvent;//como os botões do menu são labels, tem que usar o MouseEvent
import projeto.view.Telas;

public class ConCadastrar extends ConMenu{
	public void inicio (MouseEvent e) throws Exception{
		Telas.telaInicio();
	}
	public void cliente (MouseEvent e) throws Exception{
		Telas.telaClienteInicio();
	}
	public void responsavel (MouseEvent e) throws Exception{
		Telas.telaResponsavelInicio();
	}
	
	public void sair (MouseEvent e) throws Exception{
		Telas.telaLogin();
	}
}
