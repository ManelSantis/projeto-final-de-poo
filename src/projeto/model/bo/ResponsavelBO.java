package projeto.model.bo;

import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.model.vo.ProdutoVO;
import java.util.ArrayList;
import java.util.Calendar;

public class ResponsavelBO {
	public ArrayList<ProdutoVO> estoque(ResponsavelVO resp) {
		// Ir� procurar no banco de dados (em EstoqueDAO) todos os produtos
		// que estiverem guardados no local que tenha como responsavel
		// igual ao que est� sendo apresentado l� ser� posto em um ArrayList, 
		// para ent�o ser passado todos os valores para 
		// a ArrayList desse m�todo e mandados para a exebi��o
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		return produtos;
	}

	public ArrayList<VendaVO> historicoDeVendas(ResponsavelVO resp) {
		// Ir� procurar no banco de dados (em VendaDAO) todas as vendas
		// que tiverem o responsavel igual ao que est� sendo apresentado
		// l� ser� posto em um ArrayList, para ent�o ser passado todos os valores para 
		// a ArrayList desse m�todo e mandados para a exebi��o
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}
	
	public ArrayList<VendaVO> relatorio(Calendar inicio, Calendar fim) {
		// Ir� pesquisar no banco de dados em VendasDAO as vendas que possuirem a data 
		// entre o periodo posto, para ent�o adiciona-las em uma ArrayList 
		// e enviadas para esse m�todo para serem exibidas
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
		return vendas;
	}

	public void login(String usuario, String senha) {
		// Ser� receber o nome de login e a senha
		// e conferir se bate com o cadastrado.
		// Caso coincidir, ir� permitir o acesso.
	}

}
