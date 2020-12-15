package projeto.controller;

import javafx.scene.input.MouseEvent;//como os botões do menu são labels, tem que usar o MouseEvent
import projeto.model.dao.BaseDAO;
import projeto.view.Telas;

public class ConMenu {
	public void inicio (MouseEvent e) throws Exception{
		Telas.telaInicio();
	}
	public void estoque (MouseEvent e) throws Exception{
		Telas.telaEstoqueInicio();
	}
	
	public void local (MouseEvent e) throws Exception{
		Telas.telaLocal();
	}
	
	public void vender (MouseEvent e) throws Exception{
		Telas.telaVenda();
	}
	public void relatorio (MouseEvent e) throws Exception{
		Telas.telaRelatorio();
	}
	
	public void pessoa (MouseEvent e) throws Exception{
		Telas.telaPessoaInicio();
	}
	public void sair (MouseEvent e) throws Exception{
		BaseDAO.closeConnection();
		Telas.telaLogin();
	}
	
	public static void sairExcluir () throws Exception{
		//usado apenas se um usuário logado deletar a propria conta
		BaseDAO.closeConnection();
		Telas.telaLogin();
	}
}
