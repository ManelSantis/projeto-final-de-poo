package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.model.vo.ProdutoVO;

public class ProdutoDAO extends BaseDAO<ProdutoVO> {
	public void cadastrar(ProdutoVO prod) {
		String sql = "insert into produto (nome, serie, peso, preco, descricao, imagem) values (?,?,?,?,?,?)";
		//a quantidade do produto só é alterada ao adicionar no estoque
		//então ela por default é setada como 0 no banco de dados
		//e  quantidade pedido só é utilizado na parte de java
		//como um auxilio na hora de usar a tabela ItemPedido
		//no banco de dados na hora de executar a venda
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
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
		String sql = "delete from produto where serie = ?";
		//deletar do banco de dados a partir da serie do produto
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prod.getSerie());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(ProdutoVO prod) {
		String sql =  "update produto set nome = ?, peso = ?, preco = ?, descricao = ?, imagem = ? where serie = ?";
		//irá realizar o update de tudo menso do número de serie
		//a partir do número de serie que está na consulta
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
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

	public ResultSet findById(ProdutoVO prod) {
		String sql = "select * from produto where idpedido = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		//ProdutoVO produto = new ProdutoVO();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, prod.getId());
			rs = ptst.executeQuery();
			/*while (rs.next()) {
				produto.setId(rs.getLong("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setImg(rs.getString("img"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setQuantiPedido(0);
				produto.setPeso(rs.getDouble("peso"));
				produto.setSerie(rs.getString("serie"));
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet listar() {
		//esse método irá listar todos os produtos em estoque
		//não importando o responsavel
		String sql = "select * from produto";
		PreparedStatement ptst;
		ResultSet rs = null;
		//ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
			/*while (rs.next()) {
				ProdutoVO aux = new ProdutoVO();
				aux.setId(rs.getLong("idProduto"));
				aux.setNome(rs.getString("nome"));
				aux.setDescricao(rs.getString("descricao"));
				aux.setImg(rs.getString("img"));
				aux.setQuantidade(rs.getInt("quantidade"));
				aux.setQuantiPedido(0);
				aux.setPeso(rs.getDouble("peso"));
				aux.setSerie(rs.getString("serie"));
				produtos.add(aux);
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public ResultSet findByName(ProdutoVO prod) {
		String sql = "select * from produto where nome = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,"%"+ prod.getNome() + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

}
