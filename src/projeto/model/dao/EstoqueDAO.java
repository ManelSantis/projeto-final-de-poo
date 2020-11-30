package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.model.vo.EstoqueVO;

public class EstoqueDAO extends BaseDAO{
	public void cadastrar(EstoqueVO estoque) {
		conn = getConnection();
		String sql = "insert into estoque (idlocal, idproduto, quantidade) values (?,?,?)";
		//irá inserir o estoque usando o idlocal, o produto que está guardado no local, e a quantidade
		//que está guardada, e como o idlocal tem um responsavel, já da para saber quanto
		//esse responsavel tem em estoque produto
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, estoque.getLocal().getCompartimento());
			ptst.setString(2, estoque.getProduto().getSerie());
			ptst.setInt(3, estoque.getQuantidade());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(EstoqueVO estoque) {
		conn = getConnection();
		String sql = "delete from estoque where idproduto = ? and idlocal = ?";
		//deletar do banco de dados a partir da serie do produto e do local
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, estoque.getProduto().getSerie());
			ptst.setInt(2, estoque.getLocal().getCompartimento());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(EstoqueVO estoque) {
		conn = getConnection();
		String sql =  "update estoque set quantidade = ? where idproduto = ? and idlocal = ?";
		//aqui irá realizar um update na quantidade que existe do produto em estoque
		//como aqui no java já diminui ou aumenta a quantidade, será mandada apenas a nova quantidade para o
		//banco de dados, aonde ocorrerá um gatilho para ser alterada na quantidade
		//total do produto
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, estoque.getQuantidade());
			ptst.setString(2, estoque.getProduto().getSerie());
			ptst.setInt(3, estoque.getLocal().getCompartimento());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
