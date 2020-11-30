package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.model.vo.ProdutoVO;

public class ProdutoDAO extends BaseDAO {
	public void cadastrar(ProdutoVO prod) {
		conn = getConnection();
		String sql = "insert into produto (nome, serie, peso, preco, descricao, imagem) values (?,?,?,?,?,?)";
		//a quantidade do produto só é alterada ao adicionar no estoque
		//então ela por default é setada como 0 no banco de dados
		//e  quantidade pedido só é utilizado na parte de java
		//como um auxilio na hora de usar a tabela ItemPedido
		//no banco de dados na hora de executar a venda
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, prod.getNome());
			ptst.setString(2, prod.getSerie());
			ptst.setDouble(3, prod.getPeso());
			ptst.setDouble(4, prod.getPreco());
			ptst.setString(5, prod.getDescricao());
			ptst.setString(6, prod.getImg());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(ProdutoVO prod) {
		conn = getConnection();
		String sql = "delete from produto where serie = ?";
		//deletar do banco de dados a partir da serie do produto
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
		String sql =  "update produto set nome = ?, peso = ?, preco = ?, descricao = ?, imagem = ? where serie = ?";
		//irá realizar o update de tudo menso do número de serie
		//a partir do número de serie que está na consulta
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, prod.getNome());
			ptst.setDouble(2, prod.getPeso());
			ptst.setDouble(3, prod.getPreco());
			ptst.setString(4, prod.getDescricao());
			ptst.setString(5, prod.getImg());
			ptst.setString(6, prod.getSerie());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
