package projeto.model.bo;

import java.util.ArrayList;
import java.util.Calendar;

import projeto.model.vo.EstoqueVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;

public interface ResponsavelInterBO {
	public ArrayList<ProdutoVO> estoque();
	public ArrayList<ProdutoVO> estoque(ResponsavelVO resp);
	public ArrayList<ProdutoVO> estoqueNome(ResponsavelVO resp, ProdutoVO p);
	public ArrayList<ProdutoVO> estoquePreco(ResponsavelVO resp, ProdutoVO p);
	public ProdutoVO estoqueId(ResponsavelVO resp, ProdutoVO p);
	public ArrayList<ResponsavelVO> listar();
	public ArrayList<ResponsavelVO> nomes(ResponsavelVO resp);
	public ArrayList<ResponsavelVO> cpfs(String cpf);
	public void cadastrar(ResponsavelVO resp);
	public void editar(ResponsavelVO resp);
	public void excluir(ResponsavelVO resp);
	public ResponsavelVO findById(ResponsavelVO resp);
	public ResponsavelVO findByIdPessoa(ResponsavelVO resp);
	public boolean login(ResponsavelVO resp);
}
