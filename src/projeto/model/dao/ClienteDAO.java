package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.ClienteVO;

public class ClienteDAO extends PessoaDAO<ClienteVO> implements ClienteInterDAO{

	public void cadastrar(ClienteVO cliente) {
		try {
			super.cadastrar(cliente);
			String sql = "insert into Cliente (idPessoa) values (?);";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, cliente.getIdPessoa());
			int linhas = ptst.executeUpdate();
			if (linhas == 0) {
				throw new SQLException("Nenhuma linha foi alterada.");
			}
			
			ResultSet rs = ptst.getGeneratedKeys();
			
			if(rs.next()) {
				cliente.setId(rs.getLong(1));
			} else {
				throw new SQLException("Incersão falhou.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(ClienteVO cliente) {
		//excluir um cliente por id
		String sql = "delete from cliente where idresponsavel = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getId());
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.excluir(cliente);//deletar da tabela pessoas também
	}

	public void editar(ClienteVO cliente) {
		//editar um cliente
		super.editar(cliente);
	}

	public ResultSet findById(ClienteVO cliente) {
		// procurar por id um cliente
		ResultSet rs = super.findById(cliente);
		return rs;
	}

	public ResultSet findByName(ClienteVO cliente) {
		String sql = "select p.nome, p.cpf, p.telefone, p.endereco "
				+ "from pessoa as p, cliente as c "
				+ "where p.idpessoa = c.idpessoa and nome like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%" + cliente.getNome() + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet listar() {
		String sql = "select p.nome, p.cpf, p.endereco, p.telefone "
				+ "from Pessoa as p, cliente as c "
				+ "where p.idpessoa = c.idcliente";
		Statement st;
		ResultSet rs = null;
		// ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			/*
			 * while (rs.next()) { ClienteVO aux = new ClienteVO();
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

	public ResultSet historicoCompras(ClienteVO cliente) {
		// pesquisar todas as vendas que o cliente participou
		// a partir de seu id
		String sql = "select v.idvenda, v.data " + "from venda as v, pedido as p "
				+ "where p.idpedido = v.idpedido and p.idcliente = ?";

		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

}
