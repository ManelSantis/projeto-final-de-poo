package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.EstoqueVO;
import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;

public class ResponsavelDAO extends BaseDAO<ResponsavelVO>{
	
	public ArrayList<EstoqueVO> verEstoque(ResponsavelVO responsavel) {
		String sql = "select e.idproduto, e.quantidade, e.idlocal "
				+ "from estoque as e, local as l "
				+ "where e.idlocal = l.idlocal and l.idresponsavel = ?";
		
		PreparedStatement st;
		ResultSet rs;
		ArrayList<EstoqueVO> produtos = new ArrayList<EstoqueVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, responsavel.getId());
			rs = st.executeQuery(sql);
			while (rs.next()) {
				//nesse while est� sendo primeiramente adicionado apenas os ids
				//de local e produto;
				EstoqueVO aux = new EstoqueVO(); //para salvar dentro da arraylist
				ProdutoVO aux2 = new ProdutoVO(); //para salvar primeiro a serie 
				LocalVO aux3 = new LocalVO(); //para salvar primero o id do local
				// j� que na tabela estoque est�o apenas o numero de serie e o id do local
				aux2.setSerie(rs.getString("idProduto"));
				aux.setProduto(aux2);
				aux3.setId(rs.getInt("idLocal"));
				aux.setLocal(aux3);
				aux.setQuantidade(rs.getInt("quantidade"));
				produtos.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//sql = "select * from local where compartimento = ?";
		//sql = "select * from produto where serie = ?";
		
		return produtos;
	}

	@Override
	public void cadastrar(ResponsavelVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(ResponsavelVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(ResponsavelVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponsavelVO findById(ResponsavelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ResponsavelVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ResponsavelVO> findByName(ResponsavelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
