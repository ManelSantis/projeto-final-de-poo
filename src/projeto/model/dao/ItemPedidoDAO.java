package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.VendaVO;

public class ItemPedidoDAO extends BaseDAO<VendaVO> implements ItemPedidoInterDAO{

	public void adicionarCarrinho(VendaVO venda, ProdutoVO produto) {
		// esse método adicionar no carrinho, a chava primeira
		//sendo idpedido + idproduto
		PreparedStatement ptst;
		String sql = "insert into itempedido (idPedido, idProduto, quantidade) "
				+ "values (?, ?, ?);";
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId()); // salva o código da venda
			ptst.setLong(2, produto.getId()); // salva o código do pedido
			ptst.setInt(3, produto.getQuantiPedido());
			// salva a quantidade que está sendo pedida
			int linhas = ptst.executeUpdate();
			if (linhas == 0) {
				throw new SQLException("Nenhuma linha adicionada");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editarCarrinho(VendaVO venda, ProdutoVO produto) {
		// verificar se o item já existe dentro do pedido
		boolean aux = false;
		String sql = "select * from itempedito where idpedido = ? and idproduto = ?";
		PreparedStatement ptst;
		ResultSet rs;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId());
			ptst.setLong(2, produto.getId());
			rs = ptst.executeQuery();
			while (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (aux) {
			// se já existir, irá fazer um update
			sql = "update itempedido set quantidade = ? where idpedido = ? and idproduto = ?";
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setInt(1, produto.getQuantiPedido());
				ptst.setLong(2, venda.getId());
				ptst.setLong(3, produto.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void removerCarrinho(VendaVO venda, ProdutoVO produto) {
		// remover do carrinho
		String sql = "delete from itempedido where idpedido = ? and idproduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId()); // salva o código da venda
			ptst.setLong(2, produto.getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet listarItens (VendaVO venda) {
		String sql = "select * from itempedido where idpedido = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId()); // salva o código da venda
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public void cadastrar(VendaVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(VendaVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(VendaVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet findById(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findByName(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
