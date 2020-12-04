package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ResponsavelVO;

public class LocalDAO extends BaseDAO<LocalVO> implements LocalInterDAO{

	public void cadastrar(LocalVO local) {
		// esse m�todo adiciona um novo local
		String sql = "insert into local (localizacao, idlocal, idresponsavel) values (?,?,?);";
		PreparedStatement ptst;
		try {
			// em local n�o ser� necessario uma implementa��o automatica no id
			// o n�mero ser� digitado pelo proprio responsavel
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, local.getLocalizacao());
			ptst.setLong(2, local.getId());
			ptst.setLong(3, local.getResponsavel().getId());
			int linhas = ptst.executeUpdate();
			
			if (linhas == 0) {
				throw new SQLException ("Nada foi adicionado");
			}
			
			ResultSet rs = ptst.getGeneratedKeys();
			if (rs.next()) {
				local.setId(rs.getLong(1));
			} else {
				throw new SQLException ("Falhou");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editar(LocalVO local) {
		String sql = "update local set localizacao = ? where idlocal = ?";
		// ser� auterada apenas a localiza��o, j� que o responsavel n�o mudar�
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, local.getLocalizacao());
			ptst.setLong(2, local.getId());
			int linhas = ptst.executeUpdate();
			
			if (linhas == 0) {
				throw new SQLException ("Nada foi adicionado");
			}
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
			int linhas = ptst.executeUpdate();
			
			if (linhas == 0) {
				throw new SQLException ("Nada foi adicionado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet listarPorResponsavel(ResponsavelVO responsavel) {
		//listar os locais a partir do responsavel
		String sql = "select * from local where idResponsavel = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		//ArrayList<LocalVO> locais = new ArrayList<LocalVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, responsavel.getId());
			rs = ptst.executeQuery();
			/*while (rs.next()) {
				LocalVO aux = new LocalVO();
				aux.setLocalizacao(rs.getString("localizacao"));
				aux.setId(rs.getLong("idlocal"));
				aux.setResponsavel(responsavel);
				locais.add(aux);
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
	public ResultSet findById(LocalVO local) {
		LocalVO aux = new LocalVO();
		String sql = "select * from local where idlocal  = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, local.getId());
			rs = ptst.executeQuery();
			while (rs.next()) {
				aux.setLocalizacao(rs.getString("localizacao"));
				aux.setId(rs.getLong("idlocal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet findByName(LocalVO local) {
		
		return null;
	}

	@Override
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}

}