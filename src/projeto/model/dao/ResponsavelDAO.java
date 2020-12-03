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
				//nesse while está sendo primeiramente adicionado apenas os ids
				//de local e produto;
				EstoqueVO aux = new EstoqueVO(); //para salvar dentro da arraylist
				ProdutoVO aux2 = new ProdutoVO(); //para salvar primeiro a serie 
				LocalVO aux3 = new LocalVO(); //para salvar primero o id do local
				// já que na tabela estoque estão apenas o numero de serie e o id do local
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
	public void cadastrar(ResponsavelVO Responsavel) {
		String sql =  "insert into Responsavel ( login,senha,nome,cpf,endereço,telefone, idresponsavel) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, Responsavel.getUsuario());
			ptst.setString(2, Responsavel.getSenha());
			ptst.setString(3, Responsavel.getNome());
			ptst.setString(4, Responsavel.getCpf());
			ptst.setString(5, Responsavel.getEndereco());
			ptst.setString(6, Responsavel.getTelefone());
			ptst.setLong(6, Responsavel.getId());
			ptst.execute();
			int linhas = ptst.executeUpdate();
			if (linhas == 0) {
				throw new SQLException ("Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editar(ResponsavelVO Responsavel) {
		String sql = "update Responsavel set nome = ?, endereco = ?, telefone = ?, cpf = ? where idresponsavel = ?";
		
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, Responsavel.getUsuario());
			ptst.setString(2, Responsavel.getSenha());
			ptst.setString(3, Responsavel.getNome());
			ptst.setString(4, Responsavel.getEndereco());
			ptst.setString(5, Responsavel.getTelefone());
			ptst.setString(6, Responsavel.getCpf());
			ptst.setLong(7, Responsavel.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	@Override
	public void excluir(ResponsavelVO Responsavel) {
		String sql = "delete from responsavel where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, Responsavel.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		


	@Override
	public ResponsavelVO findById(ResponsavelVO responsavel) {
		
	}
	@Override
	public ArrayList<ResponsavelVO> listar() {
		
	}
	@Override
	public ArrayList<ResponsavelVO> findByName(ResponsavelVO responsavel) {
		String sql = "select * from Cliente where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		ArrayList<ResponsavelVO> clientes = new ArrayList<ResponsavelVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%" + responsavel.getNome() + "%");
			rs = ptst.executeQuery();
			while (rs.next()) {
				ResponsavelVO aux = new ResponsavelVO();
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setEndereco(rs.getString("endereco"));
				aux.setTelefone(rs.getString("telefone"));
				aux.setId(rs.getLong("idCliente"));
				clientes.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
