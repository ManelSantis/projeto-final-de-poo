package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.model.vo.ResponsavelVO;

public class ResponsavelDAO extends PessoaDAO<ResponsavelVO> implements ResponsavelInterDAO{

	public ResultSet verEstoque(ResponsavelVO responsavel) {
		String sql = "select e.idproduto, e.quantidade, e.idlocal " + "from estoque as e, local as l "
				+ "where e.idlocal = l.idlocal and l.idresponsavel = ?";

		PreparedStatement st;
		ResultSet rs = null;
		// ArrayList<EstoqueVO> produtos = new ArrayList<EstoqueVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, responsavel.getId());
			rs = st.executeQuery(sql);
			/*
			 * while (rs.next()) { //nesse while está sendo primeiramente adicionado apenas
			 * os ids //de local e produto; EstoqueVO aux = new EstoqueVO(); //para salvar
			 * dentro da arraylist ProdutoVO aux2 = new ProdutoVO(); //para salvar primeiro
			 * a serie LocalVO aux3 = new LocalVO(); //para salvar primero o id do local //
			 * já que na tabela estoque estão apenas o numero de serie e o id do local
			 * aux2.setSerie(rs.getString("idProduto")); aux.setProduto(aux2);
			 * aux3.setId(rs.getInt("idLocal")); aux.setLocal(aux3);
			 * aux.setQuantidade(rs.getInt("quantidade")); produtos.add(aux); }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sql = "select * from local where compartimento = ?";
		// sql = "select * from produto where serie = ?";

		return rs;
	}

	public ResultSet historicoVendas(ResponsavelVO responsavel) {
		String sql = "select v.idvenda, v.data " + "from venda as v, pedido as p "
				+ "where p.idpedido = v.idpedido and p.idresponsavel = ?";

		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, responsavel.getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public void logar (ResponsavelVO responsavel) {
		if(buscarLogin(responsavel)) {
			String sql = "select * from responsavel where usuario = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			String aux = "";
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, responsavel.getUsuario());
				rs = ptst.executeQuery();
				if (rs.next()) {
					aux = rs.getString("senha");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if((!responsavel.getSenha().isEmpty()) &&(responsavel.getSenha().equals(aux))) {
				System.out.println("Login efetuado");
			} else {
				System.out.println("Senha incorreta");
			}
			
		} else {
			System.out.println("Usuario não existe");
		}
	}
	
	public boolean buscarLogin(ResponsavelVO responsavel) {
		// verifica se o login existe no banco de dados
		String sql = "select * from responsavel where usuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		boolean aux = false;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, responsavel.getUsuario());
			rs = ptst.executeQuery();
			if (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	public void cadastrar(ResponsavelVO responsavel) {
		if (buscarLogin(responsavel)) {
			System.out.println("Usuário já existe");
		} else {
			try {
				super.cadastrar(responsavel);
				String sql = "insert into Responsavel" 
						+ "(usuario, senha, idpessoa) " 
						+ "values (?, ?, ?);";
				PreparedStatement ptst;
				ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ptst.setString(1, responsavel.getUsuario());
				ptst.setString(2, responsavel.getSenha());
				ptst.setLong(3, responsavel.getIdPessoa());
				int linhas = ptst.executeUpdate();
				if (linhas == 0) {
					throw new SQLException("Nenhuma linha foi alterada.");
				}
				ResultSet rs = ptst.getGeneratedKeys();
				if (rs.next()) {
					responsavel.setId(rs.getLong(3));
				} else {
					throw new SQLException("Incersão falha.");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void editar(ResponsavelVO responsavel) {
		// editar o responsavel adicionado
		try {
			super.editar(responsavel);
			String sql = "update Responsavel set " 
				+ "usuario = ?, senha = ? " 
				+ "where idresponsavel = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, responsavel.getUsuario());
			ptst.setString(2, responsavel.getSenha());
			ptst.setLong(3, responsavel.getId());
			int linhas = ptst.executeUpdate();
			if (linhas == 0) {
				throw new SQLException("Atualização falho.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(ResponsavelVO responsavel) {
		// excluir um responsavel pelo id
		String sql = "delete from responsavel where idresponsavel = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, responsavel.getId());
			ptst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.excluir(responsavel); // deletar da tabela pessoa também
	}

	public ResultSet findById(ResponsavelVO responsavel) {
		// pesquisar a partir do id
		ResultSet rs = super.findById(responsavel);
		return rs;
	}

	public ResultSet listar() {
		// listar todos os responsaveis cadastrados
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco " + "from pessoa as p, responsavel as r "
				+ "where p.idpessoa = r.idpessoa";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet findByName(ResponsavelVO responsavel) {
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco " + "from pessoa as p, responsavel as r "
				+ "where p.idpessoa = r.idpessoa and nome like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		// ArrayList<ResponsavelVO> clientes = new ArrayList<ResponsavelVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%" + responsavel.getNome() + "%");
			rs = ptst.executeQuery();
			/*
			 * while (rs.next()) { ResponsavelVO aux = new ResponsavelVO();
			 * aux.setNome(rs.getString("nome")); aux.setCpf(rs.getString("cpf"));
			 * aux.setEndereco(rs.getString("endereco"));
			 * aux.setTelefone(rs.getString("telefone"));
			 * aux.setId(rs.getLong("idCliente")); clientes.add(aux); }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

}
