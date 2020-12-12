package projeto.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.dao.ItemPedidoDAO;
import projeto.model.dao.PedidoDAO;
import projeto.model.dao.VendaDAO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.VendaVO;

public class VendaBO implements VendaInterBO{
	PedidoDAO pedido = new PedidoDAO();
	ItemPedidoDAO itens = new ItemPedidoDAO();
	VendaDAO vend = new VendaDAO();
	
	public void confirmarVenda(VendaVO venda) {
		// Ir� receber a venda parametrizada e ent�o adiconar� ela no banco de dados 
		// caso n�o exista ainda a partir do VendaDAO para poder confirmar a venda
		// no final chamando o m�todo imprimir de NotaFiscalBO para poder ser entregue ao cliente
	}
	
	public void inicioVenda(VendaVO venda) {
		pedido.cadastrar(venda);
	}
	
	public void adicionarItens(VendaVO venda, ProdutoVO prod) {
		itens.adicionarCarrinho(venda, prod);
	}
	
	public void editarItens(VendaVO venda, ProdutoVO prod) {
		itens.editarCarrinho(venda, prod);
	}
	
	public void deletarItens(VendaVO venda, ProdutoVO prod) {
		itens.removerCarrinho(venda, prod);
	}
	
	public ArrayList<ProdutoVO> listarItens(VendaVO venda){
		ResultSet rs = itens.listarItens(venda);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		if(rs != null) {
			try {
				while (rs.next()) {
					ProdutoVO aux1 = new ProdutoVO();
					aux1.setNome(rs.getString("nome"));
					aux1.setPreco(rs.getDouble("preco"));
					aux1.setId(rs.getLong("idproduto"));
					aux1.setDescricao(""+rs.getLong("idlocal"));
					aux1.setQuantidade(rs.getInt("quantidade"));
					produtos.add(aux1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;

	}
	
	public void alterarVenda (VendaVO venda) {
		// Ir� receber uma venda parametrizada, e ent�o procurar� ela
		// no banco de dados, podendo ent�o alterar os dados dessa,
		// para ent�o poder ser confirmada novamente utilizando 
		// m�todos de VendaDAO
	}
	
	public void cancelarVenda(VendaVO venda) {
		// Ir� receber uma venda parametrizada, para poder
		// ent�o cancelar ela, e remov�-la do banco de dados
		// a partir de um metodo de VendaDAO
	}

}
