package projeto.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import projeto.model.vo.VendaVO;

public class NotaFiscalDAO extends BaseDAO<VendaVO> implements NotaFiscalInterDAO{

	@Override
	public void cadastrar(VendaVO venda) {
		String sql = "insert into nota (codigo, nomecli, cpfcli, nomeresp, cpfresp, data, valor) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, venda.getCodigo()); // salva o código da venda,
			ptst.setString(2, venda.getCliente().getNome()); //nome do cliente
			ptst.setString(3, venda.getCliente().getCpf()); //cpf do cliente
			ptst.setString(4, venda.getResponsavel().getNome()); //nome do responsavel
			ptst.setString(5, venda.getResponsavel().getCpf()); //cpf do responsavel
			ptst.setDate(6, new Date(venda.getData().getTimeInMillis()));
			ptst.setDouble(7, venda.getValor());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.closeConnection();
	}
	
	@Override
	public ResultSet listar() {
		String sql = "select * from nota";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.closeConnection();
		return rs;
	}
	
	public ResultSet periodo(Calendar inicio, Calendar fim) {
		String sql = "select * from nota where data between ? and ?;";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDate(1, new Date (inicio.getTimeInMillis()));
			ptst.setDate(2, new Date (fim.getTimeInMillis()));
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.closeConnection();
		return rs;
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
	public ResultSet findByName(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
