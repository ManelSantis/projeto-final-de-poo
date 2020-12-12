package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Date;

import projeto.model.vo.VendaVO;

public class VendaDAO extends BaseDAO<VendaVO> {
	
	public void cadastrar(VendaVO venda) {
		// nesse método a venda é confirmada
		String sql = "insert into venda (idvenda, idpedido, data) values (?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, venda.getCodigo()); // salva o código da venda,
			ptst.setLong(2, venda.getId()); //id da compra
			ptst.setDate(3, (java.sql.Date) new Date(venda.getData().getTimeInMillis()));
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(VendaVO venda) {
		String sql = "delete on cascade from venda where idpedido = ?";
		// irá deletar e todos as linhas que dependem dela
		// que estiverem em itempedido e em pedido
		// junto dela
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId());
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
			ptst.setDate(1, new Date (inicio.getTimeInMillis()));
			ptst.setDate(2, new Date (fim.getTimeInMillis()));
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
	public ResultSet findById(VendaVO venda) {
		//procurar uma venda pelo id
		String sql = "select * from produto where idpedido = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	
	}

	@Override
	public ResultSet listar() {
		//listar todas as vendas já feitas
		String sql = "select * from venda";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet findByName(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
