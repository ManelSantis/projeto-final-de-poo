package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.exception.ExceptionCampoInvalido;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;

public class ResponsavelDAO extends PessoaDAO<ResponsavelVO> implements ResponsavelInterDAO {

	public ResultSet verEstoque(ResponsavelVO responsavel) {
		// Ver estoque de um responsavel
		String sql = "select e.idlocal, e.idproduto, e.quantidade, p.nome, p.serie, p.preco "
				+ "from estoque as e, local as l, produto as p "
				+ "where e.idlocal = l.idlocal and p.idproduto = e.idproduto and l.idresponsavel = ?";

		PreparedStatement st;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, responsavel.getId());
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet nomeEstoque(ResponsavelVO responsavel, ProdutoVO produto) {
		// Pesquisar no estoque de um responsavel a partir do nome do produto
		String sql = "select e.idlocal, e.idproduto, e.quantidade, p.nome, p.serie, p.preco "
				+ "from estoque as e, local as l, produto as p "
				+ "where e.idlocal = l.idlocal and p.idproduto = e.idproduto and l.idresponsavel = ? and p.nome ilike ?";

		PreparedStatement st;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, responsavel.getId());
			st.setString(2, "%" + produto.getNome() + "%");
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet precoEstoque(ResponsavelVO responsavel, ProdutoVO produto) {
		// Pesquisar no estoque de um Responsavel pelo preco <=
		String sql = "select e.idlocal, e.idproduto, e.quantidade, p.nome, p.serie, p.preco "
				+ "from estoque as e, local as l, produto as p "
				+ "where e.idlocal = l.idlocal and p.idproduto = e.idproduto and l.idresponsavel = ? and p.preco <= ?";

		PreparedStatement st;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, responsavel.getId());
			st.setDouble(2, produto.getPreco());
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet idEstoque(ResponsavelVO responsavel, ProdutoVO produto) {
		// Pesquisar no esstoque do responsavel pelo id do produto
		String sql = "select e.idlocal, e.idproduto, e.quantidade, p.nome, p.serie, p.preco "
				+ "from estoque as e, local as l, produto as p "
				+ "where e.idlocal = l.idlocal and p.idproduto = e.idproduto and l.idresponsavel = ? and p.idproduto = ? and e.idlocal = ?";

		PreparedStatement st;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, responsavel.getId());
			st.setLong(2, produto.getId());
			st.setLong(3, Long.parseLong(produto.getDescricao()));
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public boolean logar(ResponsavelVO responsavel) {
		// Logar
		if (buscarLogin(responsavel)) {
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
					responsavel.setId(rs.getLong("idResponsavel"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((!responsavel.getSenha().isEmpty()) && (responsavel.getSenha().equals(aux))) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public boolean buscarLogin(ResponsavelVO responsavel) {
		// Verifica se o login existe no banco de dados
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
			return;
		} else {
			try {
				super.cadastrar(responsavel);
				String sql = "insert into Responsavel" + "(usuario, senha, idpessoa) " + "values (?, ?, ?);";
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
		if (buscarLogin(responsavel)) {
			return;
		} else {
			try {
				super.editar(responsavel);
				String sql = "update Responsavel set " + "usuario = ?, senha = ? " + "where idresponsavel = ?";
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
	}

	public void excluir(ResponsavelVO responsavel) {
		// Excluir um responsavel pelo id
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
		//Encontrar um responsavel pelo ID
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco, p.idpessoa, r.idresponsavel, r.usuario, r.senha "
				+ "from pessoa as p, responsavel as r " + "where p.idpessoa = r.idpessoa and r.idresponsavel = ?";
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

	public ResultSet findByIdPessoa(ResponsavelVO responsavel) {
		//Encontrar um responsavel pelo IdPessoa
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco, p.idpessoa, r.idresponsavel, r.usuario, r.senha "
				+ "from pessoa as p, responsavel as r " + "where p.idpessoa = r.idpessoa and p.idpessoa = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, responsavel.getIdPessoa());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet listar() {
		// listar todos os responsaveis cadastrados
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco, p.idpessoa, r.idresponsavel, r.usuario, r.senha "
				+ "from pessoa as p, responsavel as r " + "where p.idpessoa = r.idpessoa";
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
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco, p.idpessoa, r.idresponsavel, r.usuario, r.senha "
				+ "from pessoa as p, responsavel as r " + "where p.idpessoa = r.idpessoa and p.nome ilike ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%" + responsavel.getNome() + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet findByCpf(String cpf) {
		//Buscar por cpf
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco, p.idpessoa, r.idresponsavel, r.usuario, r.senha "
				+ "from pessoa as p, responsavel as r " + "where p.idpessoa = r.idpessoa and p.cpf like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cpf + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

}
