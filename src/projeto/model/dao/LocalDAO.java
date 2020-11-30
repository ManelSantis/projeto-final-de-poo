package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.model.vo.LocalVO;

public class LocalDAO extends BaseDAO{
	public void  cadastrar (LocalVO local){
		conn = getConnection();
		//primeiro se conecta com o bd que est� em BaseDAO
		String sql =  "insert into local (localizacao, compartimento, idresponsavel) values (?,?,?)";
		//depois cria o insert na tabela Local
		PreparedStatement ptst;
		try {
			//aqui � onde ocorrer o insert dos dados
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, local.getLocalizacao());
			ptst.setInt(2, local.getCompartimento());
			ptst.setString(3, local.getResponsavel().getCpf());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void remover (LocalVO local){
		conn = getConnection();
		String sql =  "select compartimento, localizacao from local where idresponsavel = ?";
		//pesquisar todos os locals que possuem o o responsavel que est� no select
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, local.getResponsavel().getCpf());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(LocalVO local) {
		conn = getConnection();
		String sql =  "update local set localizacao = ? where compartimento = ?";
		//ser� auterada apenas a localiza��o, j� que o responsavel n�o mudar�
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, local.getLocalizacao());
			ptst.setInt(2, local.getCompartimento());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}