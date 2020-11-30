package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;

public interface ClienteInterBO {
	public void cadastrar(ClienteVO cliente);
	public void editar(ClienteVO cliente);
	public void excluir(ClienteVO cliente);
	public ArrayList<VendaVO> historicoDeCompras(ClienteVO cliente);	
}