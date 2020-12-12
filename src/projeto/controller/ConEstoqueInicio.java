package projeto.controller;

import javafx.event.ActionEvent;
import projeto.view.Telas;

public class ConEstoqueInicio extends ConMenu{
	public void produtos(ActionEvent e) throws Exception {
		Telas.telaProdutos();
	}

	public void estocados(ActionEvent e) throws Exception {
		Telas.telaEstoque();
	}

}
