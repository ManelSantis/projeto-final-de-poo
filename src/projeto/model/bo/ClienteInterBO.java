package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;

public interface ClienteInterBO {
	public void cadastrar(ClienteVO cliente);
	public void editar(ClienteVO cliente);
	public void excluir(ClienteVO cliente);	
	public ArrayList<ClienteVO> listar();
	public ArrayList<ClienteVO> nomes(ClienteVO cliente);
	public ArrayList<ClienteVO> cpfs(String cpf);
	public ClienteVO findById(ClienteVO cliente);
	public ClienteVO findByIdPessoa(ClienteVO cliente);

}