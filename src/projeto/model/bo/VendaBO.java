package projeto.model.bo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import projeto.model.dao.ItemPedidoDAO;
import projeto.model.dao.PedidoDAO;
import projeto.model.dao.VendaDAO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;

public class VendaBO implements VendaInterBO{
	PedidoDAO pedido = new PedidoDAO();
	ItemPedidoDAO itens = new ItemPedidoDAO();
	VendaDAO vend = new VendaDAO();
	
	public void confirmarVenda(VendaVO venda) {
		// Irá receber a venda parametrizada e então adiconará ela no banco de dados 
		// caso não exista ainda a partir do VendaDAO para poder confirmar a venda
		// no final chamando o método imprimir de NotaFiscalBO para poder ser entregue ao cliente
		vend.cadastrar(venda);
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
	
	public ArrayList<VendaVO> listar() {
		ResultSet rs = vend.listar();
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		
		try {
			while (rs.next()) {
				VendaVO aux = new VendaVO();
				
				ResponsavelVO aux1 = new ResponsavelVO();
				ResponsavelBO aux2 = new ResponsavelBO();
				aux1.setId(rs.getLong("idresponsavel"));
				aux1 = aux2.findById(aux1);
				
				ClienteVO aux3 = new ClienteVO();
				ClienteBO aux4 = new ClienteBO();
				aux3.setId(rs.getLong("idcliente"));
				aux3 = aux4.findById(aux3);
				
				aux.setCliente(aux3);
				aux.setResponsavel(aux1);
				java.util.Date data = rs.getDate("data");
				Calendar aux5 = Calendar.getInstance();
				aux5.setTime(data);
				aux.setData(aux5);

				aux.setId(rs.getLong("idpedido"));
				aux.setValor(rs.getDouble("valor"));
		
				vendas.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return vendas;
	}
	
	public ArrayList<VendaVO> relatorio(Calendar inicio, Calendar fim) {
		// Irá pesquisar no banco de dados em VendasDAO as vendas que possuirem a data 
		// entre o periodo posto, para então adiciona-las em uma ArrayList 
		// e enviadas para esse método para serem exibidas
		ResultSet rs = vend.periodo(inicio, fim);
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		
		try {
			while (rs.next()) {
				VendaVO aux = new VendaVO();
				
				ResponsavelVO aux1 = new ResponsavelVO();
				ResponsavelBO aux2 = new ResponsavelBO();
				aux1.setId(rs.getLong("idresponsavel"));
				aux1 = aux2.findById(aux1);
				
				ClienteVO aux3 = new ClienteVO();
				ClienteBO aux4 = new ClienteBO();
				aux3.setId(rs.getLong("idcliente"));
				aux3 = aux4.findById(aux3);
				
				aux.setCliente(aux3);
				aux.setResponsavel(aux1);
				java.util.Date data = rs.getDate("data");
				System.out.println(data);
				Calendar aux5 = Calendar.getInstance();
				aux5.setTime(data);
				aux.setData(aux5);

				aux.setId(rs.getLong("idpedido"));
				aux.setValor(rs.getDouble("valor"));
		
				vendas.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return vendas;
	}
	
	public void alterarVenda (VendaVO venda) {
		// Irá receber uma venda parametrizada, e então procurará ela
		// no banco de dados, podendo então alterar os dados dessa,
		// para então poder ser confirmada novamente utilizando 
		// métodos de VendaDAO
	}
	
	public void cancelarVenda(VendaVO venda) {
		// Irá receber uma venda parametrizada, para poder
		// então cancelar ela, e removê-la do banco de dados
		// a partir de um metodo de VendaDAO
	}

}
