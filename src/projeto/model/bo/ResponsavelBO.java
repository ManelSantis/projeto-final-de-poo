package projeto.model.bo;

import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.view.Telas;
import projeto.model.dao.ResponsavelDAO;
import projeto.model.vo.EstoqueVO;
import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class ResponsavelBO implements ResponsavelInterBO {
	ResponsavelDAO responsavel = new ResponsavelDAO();
	
	public ArrayList<ProdutoVO> estoque() {
		// Irá procurar no banco de dados (em EstoqueDAO) todos os produtos
		// que estiverem guardados no local que tenha como responsavel
		// igual ao que está sendo apresentado lá será posto em um ArrayList, 
		// para então ser passado todos os valores para 
		// a ArrayList desse método e mandados para a exebição
		ResultSet rs = responsavel.verEstoque(Telas.getUsuario());
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		if(rs != null) {
			try {
				while (rs.next()) {
					ProdutoVO aux1 = new ProdutoVO();
					aux1.setNome(rs.getString("nome"));
					aux1.setPreco(rs.getDouble("preco"));
					aux1.setId(rs.getLong("idproduto"));
					aux1.setSerie(rs.getString("serie"));
					aux1.setDescricao(""+rs.getLong("idlocal"));
					aux1.setQuantidade(rs.getInt("quantidade"));
					produtos.add(aux1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}
	
	public ArrayList<ProdutoVO> estoque(ResponsavelVO resp) {
		// Irá procurar no banco de dados (em EstoqueDAO) todos os produtos
		// que estiverem guardados no local que tenha como responsavel
		// igual ao que está sendo apresentado lá será posto em um ArrayList, 
		// para então ser passado todos os valores para 
		// a ArrayList desse método e mandados para a exebição
		ResultSet rs = responsavel.verEstoque(resp);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		if(rs != null) {
			try {
				while (rs.next()) {
					ProdutoVO aux1 = new ProdutoVO();
					aux1.setNome(rs.getString("nome"));
					aux1.setPreco(rs.getDouble("preco"));
					aux1.setId(rs.getLong("idproduto"));
					aux1.setSerie(rs.getString("serie"));
					aux1.setDescricao(""+rs.getLong("idlocal"));
					aux1.setQuantidade(rs.getInt("quantidade"));
					produtos.add(aux1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}
	
	public ArrayList<ProdutoVO> estoqueNome(ResponsavelVO resp, ProdutoVO p) {
		// Irá pesquisar, no estoque de um responsavel, um produto pelo noome
		ResultSet rs = responsavel.nomeEstoque(resp, p);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		if(rs != null) {
			try {
				while (rs.next()) {
					ProdutoVO aux1 = new ProdutoVO();
					aux1.setNome(rs.getString("nome"));
					aux1.setPreco(rs.getDouble("preco"));
					aux1.setId(rs.getLong("idproduto"));
					aux1.setSerie(rs.getString("serie"));
					aux1.setDescricao(""+rs.getLong("idlocal"));
					aux1.setQuantidade(rs.getInt("quantidade"));
					produtos.add(aux1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}

	public ArrayList<ProdutoVO> estoquePreco(ResponsavelVO resp, ProdutoVO p) {
		// Irá pesquisar, no estoque de um responsavel, um produto pelo noome
		ResultSet rs = responsavel.precoEstoque(resp, p);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		if(rs != null) {
			try {
				while (rs.next()) {
					ProdutoVO aux1 = new ProdutoVO();
					aux1.setNome(rs.getString("nome"));
					aux1.setPreco(rs.getDouble("preco"));
					aux1.setId(rs.getLong("idproduto"));
					aux1.setSerie(rs.getString("serie"));
					aux1.setDescricao(""+rs.getLong("idlocal"));
					aux1.setQuantidade(rs.getInt("quantidade"));
					produtos.add(aux1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}
	
	public ProdutoVO estoqueId(ResponsavelVO resp, ProdutoVO p) {
		// Irá pesquisar, no estoque de um responsavel, um produto pelo noome
		ResultSet rs = responsavel.idEstoque(resp, p);
		ProdutoVO produto = new ProdutoVO();
		if(rs != null) {
			try {
				while (rs.next()) {
					produto.setNome(rs.getString("nome"));
					produto.setPreco(rs.getDouble("preco"));
					produto.setId(rs.getLong("idproduto"));
					produto.setSerie(rs.getString("serie"));
					produto.setDescricao(""+rs.getLong("idlocal"));
					produto.setQuantidade(rs.getInt("quantidade"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produto;
	}

	public ArrayList<VendaVO> historicoDeVendas(ResponsavelVO resp) {
		ResultSet rs = responsavel.historicoVendas(resp);
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		
		try {
			while(rs.next()) {
				VendaVO aux = new VendaVO();
				aux.setId(rs.getLong("idVenda"));
				aux.setCodigo(rs.getString("codigo"));
				//aux.setData(new Calendar(rs.getDate("data"));
				aux.setResponsavel(resp);
				
				vendas.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendas;
	}

	
	public ArrayList<ResponsavelVO> listar() {
		//lista todos os funcionarios disponiveis
		ResultSet rs = responsavel.listar();
		ArrayList<ResponsavelVO> responsaveis = new ArrayList<ResponsavelVO>();
		
		try {
			while (rs.next()) {
				ResponsavelVO aux = new ResponsavelVO();
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setTelefone(rs.getString("telefone"));
				aux.setUsuario(rs.getString("usuario"));
				aux.setId(rs.getLong("idresponsavel"));
				aux.setIdPessoa(rs.getLong("idpessoa"));
				responsaveis.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responsaveis;
	}
	
	public ArrayList<ResponsavelVO> nomes(ResponsavelVO resp) {
		//lista todos os funcionarios disponiveis
		ResultSet rs = responsavel.findByName(resp);
		ArrayList<ResponsavelVO> responsaveis = new ArrayList<ResponsavelVO>();
		
		try {
			while (rs.next()) {
				ResponsavelVO aux = new ResponsavelVO();
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setTelefone(rs.getString("telefone"));
				aux.setId(rs.getLong("idresponsavel"));
				aux.setIdPessoa(rs.getLong("idpessoa"));
				responsaveis.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responsaveis;
	}
	
	public ArrayList<ResponsavelVO> cpfs(String cpf) {
		//lista todos os funcionarios disponiveis
		ResultSet rs = responsavel.findByCpf(cpf);
		ArrayList<ResponsavelVO> responsaveis = new ArrayList<ResponsavelVO>();
		
		try {
			while (rs.next()) {
				ResponsavelVO aux = new ResponsavelVO();
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setTelefone(rs.getString("telefone"));
				aux.setId(rs.getLong("idresponsavel"));
				aux.setIdPessoa(rs.getLong("idpessoa"));
				responsaveis.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responsaveis;
	}
	
	public void cadastrar(ResponsavelVO resp) {
		responsavel.cadastrar(resp);
	}
	
	public void editar (ResponsavelVO resp) {
		responsavel.editar(resp);
	}
	
	public void excluir (ResponsavelVO resp) {
		responsavel.excluir(resp);
	}
	
	public ResponsavelVO findById(ResponsavelVO resp) {
		//está pesquisando pelo id do responavel cadastrado
		ResultSet rs = responsavel.findById(resp);
		try {
			while(rs.next()) {
				resp.setCpf(rs.getString("cpf"));
				resp.setEndereco(rs.getString("endereco"));
				resp.setNome(rs.getString("nome"));
				resp.setTelefone(rs.getString("telefone"));
				resp.setUsuario(rs.getString("usuario"));
				resp.setSenha(rs.getString("senha"));
				resp.setId(rs.getLong("idresponsavel"));
				resp.setIdPessoa(rs.getLong("idpessoa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
	
	
	
	public ResponsavelVO findByIdPessoa(ResponsavelVO resp) {
		//está pesquisando pelo id pessoa do responsavel cadastrado
		ResultSet rs = responsavel.findByIdPessoa(resp);
		try {
			while(rs.next()) {
				resp.setCpf(rs.getString("cpf"));
				resp.setEndereco(rs.getString("endereco"));
				resp.setNome(rs.getString("nome"));
				resp.setUsuario(rs.getString("usuario"));
				resp.setSenha(rs.getString("senha"));
				resp.setTelefone(rs.getString("telefone"));
				resp.setId(rs.getLong("idresponsavel"));
				resp.setIdPessoa(rs.getLong("idpessoa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

	public boolean login(ResponsavelVO resp) {
		//primeiro vai para o banco de dados saber se é possivel o login, antes de iniciar
		if(responsavel.logar(resp)) {
			ResultSet rs = responsavel.findById(resp);
			try {
				while(rs.next()) {
					resp.setCpf(rs.getString("cpf"));
					resp.setEndereco(rs.getString("endereco"));
					resp.setNome(rs.getString("nome"));
					resp.setTelefone(rs.getString("telefone"));
					resp.setId(rs.getLong("idresponsavel"));
					resp.setIdPessoa(rs.getLong("idpessoa"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

}
