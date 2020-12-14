package projeto.model.bo;

import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;
import projeto.exception.ExceptionCampoInvalido;
import projeto.exception.ExceptionLoginExistente;
import projeto.model.dao.ResponsavelDAO;
import projeto.model.vo.ProdutoVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResponsavelBO implements ResponsavelInterBO {
	ResponsavelDAO responsavel = new ResponsavelDAO();
	
	public ArrayList<ProdutoVO> estoque() {
		// Pesquisa no banco de dados o estoque do responsável logado
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
			} catch (ExceptionCampoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}
	
	public ArrayList<ProdutoVO> estoque(ResponsavelVO resp) {
		// Pesquisa no BD o estoque de um responsavel parametrisado
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
			} catch (ExceptionCampoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}
	
	public ArrayList<ProdutoVO> estoqueNome(ResponsavelVO resp, ProdutoVO p) {
		// Irá pesquisar, no estoque de um responsavel, um produto pelo nome
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
			} catch (ExceptionCampoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}

	public ArrayList<ProdutoVO> estoquePreco(ResponsavelVO resp, ProdutoVO p) {
		// Irá pesquisar, no estoque de um responsavel, um produto pelo preço
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
			} catch (ExceptionCampoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}
	
	public ProdutoVO estoqueId(ResponsavelVO resp, ProdutoVO p) {
		// Irá pesquisar um produto no estoque do responsavel, a aprtir do id desse produto
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
				e.printStackTrace();
			} catch (ExceptionCampoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produto;
	}

	public ArrayList<ResponsavelVO> listar() {
		// Lista todos os responsaveis cadastrados
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
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responsaveis;
	}
	
	public ArrayList<ResponsavelVO> nomes(ResponsavelVO resp) {
		// Pesquisa os responsaveis cadastrados pelo nome
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
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responsaveis;
	}
	
	public ArrayList<ResponsavelVO> cpfs(String cpf) {
		// Pesquisa os responsaveis cadastrados pelo cpf
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
		} catch (ExceptionCampoInvalido e) {
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
		// Está pesquisando um responsavel por ID
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
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
	
	public ResponsavelVO findByIdPessoa(ResponsavelVO resp) {
		// Está pesquisando um responsavel pelo ID ligado a pessoa
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
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

	public boolean login(ResponsavelVO resp) {
		// Tenta logar
		System.out.println(resp.getUsuario());
		System.out.println(resp.getSenha());
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
			} catch (ExceptionCampoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

}
