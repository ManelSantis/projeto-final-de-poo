package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.model.vo.PessoaVO;

public class PessoaDAO<VO extends PessoaVO> extends BaseDAO<VO> {

	@Override
	public void cadastrar(VO vo) {
		// adicionar uma pessoa
		String sql = "insert into Pessoa (nome, cpf, telefone, endereco) " 
		+ "values (?, ?, ?, ?);";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCpf());
			ptst.setString(4, vo.getEndereco());
			ptst.setString(3, vo.getTelefone());
			int linhas = ptst.executeUpdate();

			if (linhas == 0) {
				throw new SQLException("Nenhuma linha foi alterada.");
			}
			
			ResultSet rs = ptst.getGeneratedKeys();
			if (rs.next()) {
				vo.setIdPessoa(rs.getLong(1));
			} else {
				throw new SQLException("Incersão falha.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editar(VO vo) {
		String sql = "update pessoa set " 
				+ "nome = ?, endereco = ?, telefone = ?, cpf = ? " 
				+ "where idpessoa= ?";
		// editar a pessoa a partir do id
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getTelefone());
			ptst.setString(4, vo.getCpf());
			ptst.setLong(5, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(VO vo) {
		String sql = "delete from pessoa where idpessoa = ?";
		// deletar a partir do id da pessoa
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet findById(VO vo) {
		String sql = "select * from pessoa where idpessoa = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdPessoa());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean cpf(String cpf) {
		String sql = "select * from pessoa where cpf = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cpf);
			rs = ptst.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public ResultSet findByName(VO vo) {
		return null;
	}

	@Override
	public ResultSet listar() {
		return null;
	}

}
