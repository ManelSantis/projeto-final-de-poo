package projeto.model.dao;

import java.sql.ResultSet;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.VendaVO;

public interface ItemPedidoInterDAO {
	public void adicionarCarrinho(VendaVO venda, ProdutoVO produto);
	public void editarCarrinho(VendaVO venda, ProdutoVO produto);
	public void removerCarrinho(VendaVO venda, ProdutoVO produto);
	public ResultSet listarItens (VendaVO venda);
}
