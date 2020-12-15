package projeto.model.bo;

import java.util.ArrayList;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.VendaVO;

public interface VendaInterBO {
	
	public void confirmarVenda(VendaVO venda);
	public void inicioVenda(VendaVO venda);
	public void adicionarItens(VendaVO venda, ProdutoVO prod);
	public void editarItens(VendaVO venda, ProdutoVO prod);
	public void deletarItens(VendaVO venda, ProdutoVO prod);
	public ArrayList<ProdutoVO> listarItens(VendaVO venda);
	public ArrayList<VendaVO> listar();
	public void cancelarVenda(VendaVO venda);

}
