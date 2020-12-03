package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.vo.ProdutoVO;
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

	public void carrinho(VendaVO venda, ProdutoVO produto, boolean aux) {
		// esse método adiciona ou remove do carrinho
		// com o auxilio de uma variavel boolean

		if (aux) {
			String sql = "insert into itempedido (idVenda, idProduto, quantidade) values (?, ?, ?)";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, venda.getCodigo()); // salva o código da venda
				ptst.setString(2, produto.getSerie()); // salva o código do pedido
				ptst.setInt(3, produto.getQuantiPedido()); 
				// salva a quantidade que está sendo pedida
				ptst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
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

	@Override
	public void editar(VendaVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VendaVO findById(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VendaVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VendaVO> findByName(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
