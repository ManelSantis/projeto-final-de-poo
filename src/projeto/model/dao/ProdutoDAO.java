package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.model.vo.ProdutoVO;

public class ProdutoDAO extends BaseDao {
	public void cadastrar(ProdutoVO prod) {
		conn = getConnection();
		String sql = "insert into produto ( nome,descricao,peso,serie,preco,quantidade,quantipedido,img) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, prod.getNome());
			ptst.setString(2, prod.getDescricao());
			ptst.setDouble(3, prod.getPeso());
			ptst.setString(4, prod.getSerie());
			ptst.setDouble(5, prod.getPreco());
			ptst.setInt(6, prod.getQuantidade());
			ptst.setInt(7, prod.getQuantiPedido());
			ptst.setString(8, prod.getImg());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(ProdutoVO prod) {
		conn = getConnection();
		String sql = "delete from produto where cpf = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, prod.getSerie());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(ProdutoVO prod) {
		conn = getConnection();
		String sql =  "update from produto where serie = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, prod.getSerie());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
