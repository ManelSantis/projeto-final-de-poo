package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.VendaVO;

public class ItemPedidoDAO extends BaseDAO<VendaVO> implements ItemPedidoInterDAO {

	public void adicionarCarrinho(VendaVO venda, ProdutoVO produto) {
		// esse m�todo adicionar no carrinho, a chava primeira
		// sendo idpedido + idproduto
		boolean aux = false;
		String sql = "select * from itempedido where idpedido = ? and idproduto = ? and idlocal = ?";
		PreparedStatement ptst;
		ResultSet rs;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId());
			ptst.setLong(2, produto.getId());
			ptst.setLong(3, Long.parseLong(produto.getDescricao()));
			rs = ptst.executeQuery();
			while (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (aux) {
			super.closeConnection();
		} else {

			sql = "insert into itempedido (idPedido, idProduto, idlocal, quantidade) " 
			+ "values (?, ?, ?, ?);";
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, venda.getId()); // salva o c�digo da venda
				ptst.setLong(2, produto.getId()); // salva o c�digo do pedido
				ptst.setLong(3, Long.parseLong(produto.getDescricao()));
				ptst.setInt(4, produto.getQuantiPedido());
				// salva a quantidade que est� sendo pedida
				int linhas = ptst.executeUpdate();
				if (linhas == 0) {
					throw new SQLException("Nenhuma linha adicionada");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.closeConnection();
		}
	}

	public void editarCarrinho(VendaVO venda, ProdutoVO produto) {
		// verificar se o item j� existe dentro do pedido
		boolean aux = false;
		String sql = "select * from itempedido where idpedido = ? and idproduto = ? and idlocal = ?";
		PreparedStatement ptst;
		ResultSet rs;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId());
			ptst.setLong(2, produto.getId());
			ptst.setLong(3, Long.parseLong(produto.getDescricao()));
			rs = ptst.executeQuery();
			while (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (aux) {
			// se j� existir, ir� fazer um update
			sql = "update itempedido set quantidade = ? where idpedido = ? and idproduto = ? and idlocal = ?";
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setInt(1, produto.getQuantiPedido());
				ptst.setLong(2, venda.getId());
				ptst.setLong(3, produto.getId());
				ptst.setLong(4, Long.parseLong(produto.getDescricao()));
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.closeConnection();
	}

	public void removerCarrinho(VendaVO venda, ProdutoVO produto) {
		// remover do carrinho
		String sql = "delete from itempedido where idpedido = ? and idproduto = ? and idlocal = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId()); // salva o c�digo da venda
			ptst.setLong(2, produto.getId());
			ptst.setLong(3, Long.parseLong(produto.getDescricao()));
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.closeConnection();
	}

	public ResultSet listarItens(VendaVO venda) {
		String sql = "select p.nome, p.idproduto, p.preco, "
				+ "i.idlocal, i.quantidade "
				+ "from itempedido as i, produto as p, local as l "
				+ "where i.idproduto = p.idproduto and i.idlocal = l.idlocal and i.idpedido = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId()); // salva o c�digo da venda
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.closeConnection();
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
