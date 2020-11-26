package projeto.model.bo;

import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.model.vo.ProdutoVO;
import java.util.ArrayList;
import java.util.Calendar;

public class ResponsavelBO {
	public ArrayList<ProdutoVO> estoque(ResponsavelVO resp) {
		// Irá procurar no banco de dados (em EstoqueDAO) todos os produtos
		// que estiverem guardados no local que tenha como responsavel
		// igual ao que está sendo apresentado lá será posto em um ArrayList, 
		// para então ser passado todos os valores para 
		// a ArrayList desse método e mandados para a exebição
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		return produtos;
	}

	public ArrayList<VendaVO> historicoDeVendas(ResponsavelVO resp) {
		// Irá procurar no banco de dados (em VendaDAO) todas as vendas
		// que tiverem o responsavel igual ao que está sendo apresentado
		// lá será posto em um ArrayList, para então ser passado todos os valores para 
		// a ArrayList desse método e mandados para a exebição
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}
	
	public ArrayList<VendaVO> relatorio(Calendar inicio, Calendar fim) {
		// Irá pesquisar no banco de dados em VendasDAO as vendas que possuirem a data 
		// entre o periodo posto, para então adiciona-las em uma ArrayList 
		// e enviadas para esse método para serem exibidas
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}

	public void login(String usuario, String senha) {
		// Será receber o nome de login e a senha
		// e conferir se bate com o cadastrado.
		// Caso coincidir, irá permitir o acesso.
	}

}
