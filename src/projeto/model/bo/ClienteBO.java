package projeto.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.dao.ClienteDAO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;

public class ClienteBO implements ClienteInterBO {
	ClienteDAO cli = new ClienteDAO();
	public void cadastrar(ClienteVO cliente) {
		cli.cadastrar(cliente);
	}

	public void editar(ClienteVO cliente) {
		// Ser� pesquisado no bd o ClienteVO parametrizado
		// usando ClienteDAO, ent�o ir� abrir a pagina de edi��o
		// para depois ser dado um update no banco de dados
	}

	public void excluir(ClienteVO cliente) {
		// Ser� pesquisado no banco de dados o ClienteVO parametrizado
		// usando o ClienteDAO para ent�o poder ser excluido do banco de dados
	}

	
	public ArrayList<ClienteVO> listar() {
		ResultSet rs = cli.listar();
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		
		try {
			while (rs.next()) {
				ClienteVO aux = new ClienteVO();
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setTelefone(rs.getString("telefone"));
				aux.setId(rs.getLong("idcliente"));
				aux.setIdPessoa(rs.getLong("idpessoa"));
				clientes.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public ClienteVO findById(ClienteVO cliente) {
		ResultSet rs = cli.findById(cliente);
		try {
			while(rs.next()) {
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNome(rs.getString("nome"));
				System.out.print(cliente.getNome());
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setId(rs.getLong("idcliente"));
				cliente.setIdPessoa(rs.getLong("idpessoa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	
	public ClienteVO findByIdPessoa (ClienteVO cliente) {
		ResultSet rs = cli.findByIdPessoa(cliente);
		try {
			while(rs.next()) {
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setId(rs.getLong("idcliente"));
				cliente.setIdPessoa(rs.getLong("idpessoa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	
	public ArrayList<VendaVO> historicoDeCompras(ClienteVO cliente) {
		// Nesse metodo ter� que ser primeiro feita uma consulta 
		// no banco de dados em VendaDAO para saber as vendas que foram feitas
		// pelo cliente parametrizado ent�o elas ser�o guardadas em uma ArrayList 
		// para depois serem listadas
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}

}
