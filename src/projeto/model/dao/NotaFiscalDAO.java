package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.vo.NotaFiscalVO;

public class NotaFiscalDAO extends BaseDAO<NotaFiscalVO>{

	@Override
	public void cadastrar(NotaFiscalVO nota) {
			String sql = "insert into Nota (idcliente, idresponsavel, carrinho,data,valor,codigo) values (?,?,?,?,?,?)";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, nota.getVenda().getCliente().getId());
				ptst.setLong(2, nota.getVenda().getResponsavel().getId());
				// Carrinho
				ptst.setCalendar(4, nota.getVenda().getData());
				ptst.setDouble(5, nota.getVenda().getValor());
				ptst.setString(6,nota.getVenda().getCodigo());
				int linhas = ptst.executeUpdate();
				if (linhas == 0) {
					throw new SQLException ("Nenhuma linha foi alterada.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	@Override
	public void editar(NotaFiscalVO nota) {
		String sql = "update Nota set idcliente = ?, idresponsavel =  ?, carrinho = ?, data = ?, valor = ?, codigo = ?";
		// editar o cliente a partir do cpf
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, nota.getVenda().getCliente().getId());
			ptst.setLong(2, nota.getVenda().getResponsavel().getId());
			// Carrinho
			ptst.setCalendar(4, nota.getVenda().getData());
			ptst.setDouble(5, nota.getVenda().getValor());
			ptst.setString(6,nota.getVenda().getCodigo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(NotaFiscalVO nota) {
		String sql = "delete from Nota where codigo = ?";
		// deletar a partir do cpf do cliente
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, nota.getVenda().getCodigo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public NotaFiscalVO findById(NotaFiscalVO nota) {
		// TODO Auto-generated method stub
				return null;
			}

	@Override
	public ArrayList<NotaFiscalVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NotaFiscalVO> findByName(NotaFiscalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
