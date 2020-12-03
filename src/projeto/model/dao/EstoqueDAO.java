package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.EstoqueVO;

public class EstoqueDAO extends BaseDAO<EstoqueVO>{
	public void cadastrar(EstoqueVO estoque) {
		String sql = "insert into estoque (idlocal, idproduto, quantidade) values (?,?,?)";
		//ir� inserir o estoque usando o idlocal, o produto que est� guardado no local, e a quantidade
		//que est� guardada, e como o idlocal tem um responsavel, j� da para saber quanto
		//esse responsavel tem em estoque produto
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, estoque.getLocal().getId());
			ptst.setLong(2, estoque.getProduto().getId());
			ptst.setInt(3, estoque.getQuantidade());
			int linhas = ptst.executeUpdate();
			if (linhas == 0) {
				throw new SQLException ("Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(EstoqueVO estoque) {
		String sql = "delete from estoque where idproduto = ? and idlocal = ?";
		//deletar do banco de dados a partir da serie do produto e do local
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, estoque.getProduto().getId());
			ptst.setLong(2, estoque.getLocal().getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(EstoqueVO estoque) {
		String sql =  "update estoque set quantidade = ? "
				+ "where idproduto = ? and idlocal = ?";
		//aqui ir� realizar um update na quantidade que existe do produto em estoque
		//como aqui no java j� diminui ou aumenta a quantidade, ser� mandada apenas a nova quantidade para o
		//banco de dados, aonde ocorrer� um gatilho para ser alterada na quantidade
		//total do produto
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, estoque.getQuantidade());
			ptst.setLong(2, estoque.getProduto().getId());
			ptst.setLong(3, estoque.getLocal().getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EstoqueVO findById(EstoqueVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EstoqueVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EstoqueVO> findByName(EstoqueVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
