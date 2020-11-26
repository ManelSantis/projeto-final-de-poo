package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;

public class ClienteBO implements ClienteInterBO {
	public void cadastrar(ClienteVO cliente) {
		// Esse metodo ir� receber um clienteVO
		// vai verificar se ele j� existe no Banco de dados
		// em ClienteDAO, caso n�o exista, ir� salvar 
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

	public ArrayList<VendaVO> historicoDeCompras(ClienteVO cliente) {
		// Nesse metodo ter� que ser primeiro feita uma consulta 
		// no banco de dados em VendaDAO para saber as vendas que foram feitas
		// pelo cliente parametrizado ent�o elas ser�o guardadas em uma ArrayList 
		// para depois serem listadas
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}

}
