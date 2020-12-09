package projeto.model.dao;

import java.sql.ResultSet;

import projeto.model.vo.ResponsavelVO;

public interface ResponsavelInterDAO {
	public boolean buscarLogin(ResponsavelVO responsavel);
	public ResultSet historicoVendas(ResponsavelVO responsavel);
	public ResultSet listar();
	public ResultSet verEstoque(ResponsavelVO responsavel);
	public boolean logar(ResponsavelVO responsavel);
	public ResultSet findByCpf(String cpf);
}
