package projeto.model.dao;

import java.sql.ResultSet;
import projeto.model.vo.ClienteVO;

public interface ClienteInterDAO {
	public ResultSet historicoCompras(ClienteVO cliente);
	public ResultSet listar();
	public ResultSet findByIdPessoa(ClienteVO cliente);
	public ResultSet findByCpf(String cpf);
}
