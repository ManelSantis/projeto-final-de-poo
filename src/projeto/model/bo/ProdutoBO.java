package projeto.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.exception.ExceptionCampoInvalido;
import projeto.model.dao.ProdutoDAO;
import projeto.model.vo.ProdutoVO;

public class ProdutoBO implements ProdutoInterBO{
	ProdutoDAO prod = new ProdutoDAO();
	public void cadastrar(ProdutoVO produto) {
		prod.cadastrar(produto);
	}
	
	public ArrayList<ProdutoVO> listar() {
		ResultSet rs = prod.listar();
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			while (rs.next()) {
				ProdutoVO aux = new ProdutoVO();
				aux.setNome(rs.getString("nome"));
				aux.setPreco(rs.getDouble("preco"));
				aux.setQuantidade(rs.getInt("quantidadeTotal"));
				aux.setDescricao(rs.getString("descricao"));
				aux.setId(rs.getLong("idproduto"));
				aux.setSerie(rs.getString("serie"));
				produtos.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionCampoInvalido e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return produtos;
	}
	
	public ProdutoVO findById(ProdutoVO produt) {
		ResultSet rs = prod.findById(produt);
		ProdutoVO produto = new ProdutoVO();
		try {
			while (rs.next()) {
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setId(rs.getLong("idproduto"));
				produto.setSerie(rs.getString("serie"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produto;
	}
	
	public ArrayList<ProdutoVO> findByNome(ProdutoVO pro){
		ResultSet rs = prod.findByName(pro);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			while (rs.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setId(rs.getLong("idproduto"));
				produto.setSerie(rs.getString("serie"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}

	public ArrayList<ProdutoVO> findBySerie(ProdutoVO pro){
		ResultSet rs = prod.findBySerie(pro);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			while (rs.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setId(rs.getLong("idproduto"));
				produto.setSerie(rs.getString("serie"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	
	public void excluir(ProdutoVO produto) {
		prod.excluir(produto);
	}

	public void editar (ProdutoVO produto) {
		prod.editar(produto);
	}
	
}