package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.lang.Integer.*;

import projeto.model.vo.ClienteVO;

public class ClienteDAO extends BaseDAO{
	
	public void cadastrar (ClienteVO cliente) {
		conn = getConnection();
		String sql = "insert into Cliente (nome, cpf, telefone, endereco) values (?, ?, ?, ?)";
		
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString (1, cliente.getNome());
			ptst.setString(2, cliente.getCpf());
			ptst.setString(3, cliente.getTelefone());
			ptst.setString(4, cliente.getEndereco());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deletar(ClienteVO cliente) {
		conn = getConnection();
		String sql = "delete from Cliente where cpf = ?";
		//deletar a partir do cpf do cliente
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, cliente.getCpf());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar (ClienteVO cliente) {
		conn = getConnection();
		String sql = "update Cliente set nome = ?, endereco = ?, telefone = ? where cpf = ?";
		//editar o cliente a partir do cpf
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, cliente.getNome());
			ptst.setString(2, cliente.getEndereco());
			ptst.setString(3, cliente.getTelefone());
			ptst.setString(4, cliente.getCpf());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ClienteVO> listar() {
		conn = getConnection();
		String sql = "select * from Cliente";
		
		Statement st;
		ResultSet rs;
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ClienteVO aux = new ClienteVO();
				aux.setNome(rs.getString("nome"));
				aux.setCpf(""+rs.getString("cpf"));
				aux.setEndereco(rs.getString("endereco"));
				aux.setTelefone(rs.getString("telefone"));
				clientes.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
}
