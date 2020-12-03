package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import projeto.model.vo.ClienteVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;

public class VendaDAO extends BaseDAO<VendaVO> {
	public void fazerPedido(VendaVO venda) {
		String sql = "insert into pedido (idCliente, idResponsavel, idVenda) values (?, ?, ?)";
		// primeiro será feito um insert na tabela pedido, aonde será salvado
		// o valor total da venda como default 0, que será incrementado
		// a cada item que é adicionado em itempedido com o mesmo id de venda
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, venda.getCliente().getCpf());
			ptst.setString(2, venda.getResponsavel().getCpf());
			ptst.setString(3, venda.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void adicionarCarrinho(VendaVO venda, ProdutoVO produto) {
		// esse método adicionar no carrinho
		PreparedStatement ptst;
		String sql = "insert into itempedido (idVenda, idProduto, quantidade) values (?, ?, ?)";
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, venda.getCodigo()); // salva o código da venda
			ptst.setString(2, produto.getSerie()); // salva o código do pedido
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
		String sql = "delete from itempedido where idvenda = ? and idproduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, venda.getCodigo()); // salva o código da venda
			ptst.setString(2, produto.getSerie());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cadastrar(VendaVO venda) {
		// nesse método a venda é confirmada
		String sql = "insert into venda (idvenda, data, hora) values (?, current_date, current_time)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, venda.getCodigo()); // salva o código da venda
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(VendaVO venda) {
		String sql = "delete cascade from venda where idvenda = ?";
		// irá deletar e todos as linhas que dependem dela
		// que estiverem em itempedido e em pedido
		// junto dela
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, venda.getCodigo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(VendaVO vo) {
		// TODO Auto-generated method stub
	}

	public ResultSet periodo(Calendar inicio, Calendar fim) {
		String sql = "select v.idVenda, v.data, p.idcliente, p.responsavel" + "from venda as v, pedido as p "
				+ "where v.idvenda = p.idvenda and v.data between ? and ?;";
		PreparedStatement ptst;
		ResultSet rs = null;
		// ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDate(1, null, inicio);
			ptst.setDate(2, null, fim);
			rs = ptst.executeQuery();
			/*
			 * while (rs.next()) { VendaVO aux = new VendaVO(); ClienteVO aux1 = new
			 * ClienteVO(); ResponsavelVO aux2 = new ResponsavelVO();
			 * aux.setCodigo(rs.getString("v.idVenda")); //aux.setData(rs.getDate(null,
			 * "v.data")); aux2.setId(rs.getLong("p.responsavel"));
			 * aux.setResponsavel(aux2); }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
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
