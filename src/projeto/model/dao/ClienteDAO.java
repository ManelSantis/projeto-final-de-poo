package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.ClienteVO;

public class ClienteDAO extends BaseDAO<ClienteVO> {

	public void cadastrar(ClienteVO cliente) {
		String sql = "select * from Cliente where idCliente = ?";
		boolean aux = false;
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getId());
			rs = ptst.executeQuery();
			while (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (aux) {
			System.out.println("Cliente já existe.");
		} else {
			sql = "insert into Cliente (nome, cpf, telefone, endereco) values (?, ?, ?, ?);";
			try {
				ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ptst.setString(1, cliente.getNome());
				ptst.setString(2, cliente.getCpf());
				ptst.setString(3, cliente.getTelefone());
				ptst.setString(4, cliente.getEndereco());
				int linhas = ptst.executeUpdate();
				
				if (linhas == 0) {
					throw new SQLException ("Nenhuma linha foi alterada.");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void excluir(ClienteVO cliente) {
		String sql = "delete from Cliente where idCliente = ?";
		// deletar a partir do cpf do cliente
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(ClienteVO cliente) {
		String sql = "update Cliente set nome = ?, endereco = ?, telefone = ?, cpf = ? where idCliente = ?";
		// editar o cliente a partir do cpf
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getNome());
			ptst.setString(2, cliente.getEndereco());
			ptst.setString(3, cliente.getTelefone());
			ptst.setString(4, cliente.getCpf());
			ptst.setLong(5, cliente.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ClienteVO findById(ClienteVO cliente) {
		ClienteVO aux = new ClienteVO();
		String sql = "select * from Cliente where idCliente = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getId());
			rs = ptst.executeQuery();
			while (rs.next()) {
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setEndereco(rs.getString("endereco"));
				aux.setTelefone(rs.getString("telefone"));
				aux.setId(rs.getLong("idCliente"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	
	public ArrayList<ClienteVO> findByName(ClienteVO cliente) {
		// esse método retornba uma arraylist com os clientes
		// que tiverem o nome parecido com o que foi digitado
		String sql = "select * from Cliente where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%" + cliente.getNome() + "%");
			rs = ptst.executeQuery();
			while (rs.next()) {
				ClienteVO aux = new ClienteVO();
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
		return clientes;
	}

	public ArrayList<ClienteVO> listar() {
		String sql = "select * from Cliente";
		Statement st;
		ResultSet rs;
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ClienteVO aux = new ClienteVO();
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

		return clientes;
	}

}
