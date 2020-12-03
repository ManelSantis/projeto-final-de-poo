package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ResponsavelVO;

public class LocalDAO extends BaseDAO<LocalVO> {

	public void cadastrar(LocalVO local) {
		// esse método adiciona um novo local
		String sql = "insert into local (localizacao, idlocal, idresponsavel) values (?,?,?);";
		PreparedStatement ptst;
		try {
			// em local não será necessario uma implementação automatica no id
			// o número será digitado pelo proprio responsavel
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, local.getLocalizacao());
			ptst.setLong(2, local.getId());
			ptst.setLong(3, local.getResponsavel().getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void remover(LocalVO local) {
		String sql = "select compartimento, localizacao from local where idresponsavel = ?";
		// pesquisar todos os locals que possuem o o responsavel que está no select
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, local.getResponsavel().getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(LocalVO local) {
		String sql = "update local set localizacao = ? where compartimento = ?";
		// será auterada apenas a localização, já que o responsavel não mudará
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, local.getLocalizacao());
			ptst.setLong(2, local.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(LocalVO local) {
		//deletar o local e todos os itens dependentes desse local
		String sql = "delete on cascade from local where idLocal = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, local.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<LocalVO> listar(ResponsavelVO responsavel) {
		String sql = "select * from local where idResponsavel = ?";
		PreparedStatement ptst;
		ResultSet rs;
		ArrayList<LocalVO> locais = new ArrayList<LocalVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, responsavel.getId());
			rs = ptst.executeQuery();
			while (rs.next()) {
				LocalVO aux = new LocalVO();
				aux.setLocalizacao(rs.getString("localizacao"));
				aux.setId(rs.getLong("idlocal"));
				aux.setResponsavel(responsavel);
				locais.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return locais;
	}
	
	public LocalVO findById(LocalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LocalVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LocalVO> findByName(LocalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}