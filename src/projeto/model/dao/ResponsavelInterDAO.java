package projeto.model.dao;

import java.sql.ResultSet;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;

public interface ResponsavelInterDAO {
	public boolean buscarLogin(ResponsavelVO responsavel);
	public ResultSet listar();
	public ResultSet verEstoque(ResponsavelVO responsavel);
	public ResultSet nomeEstoque(ResponsavelVO responsavel, ProdutoVO produto);
	public ResultSet precoEstoque(ResponsavelVO responsavel, ProdutoVO produto);
	public ResultSet idEstoque(ResponsavelVO responsavel, ProdutoVO produto);
	public boolean logar(ResponsavelVO responsavel);
	public ResultSet findByName(ResponsavelVO responsavel);
	public ResultSet findByCpf(String cpf);
}
