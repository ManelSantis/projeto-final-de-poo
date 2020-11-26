package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;

public class ClienteBO implements ClienteInterBO {
	public void cadastrar(ClienteVO cliente) {
		// Esse metodo irá receber um clienteVO
		// vai verificar se ele já existe no Banco de dados
		// em ClienteDAO, caso não exista, irá salvar 
	}

	public void editar(ClienteVO cliente) {
		// Será pesquisado no bd o ClienteVO parametrizado
		// usando ClienteDAO, então irá abrir a pagina de edição
		// para depois ser dado um update no banco de dados
	}

	public void excluir(ClienteVO cliente) {
		// Será pesquisado no banco de dados o ClienteVO parametrizado
		// usando o ClienteDAO para então poder ser excluido do banco de dados
	}

	public ArrayList<VendaVO> historicoDeCompras(ClienteVO cliente) {
		// Nesse metodo terá que ser primeiro feita uma consulta 
		// no banco de dados em VendaDAO para saber as vendas que foram feitas
		// pelo cliente parametrizado então elas serão guardadas em uma ArrayList 
		// para depois serem listadas
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}

}
