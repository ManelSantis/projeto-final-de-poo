package projeto.model.bo;

import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.model.vo.ProdutoVO;

public class ResponsavelBO {
	public ProdutoVO[] estoque(ResponsavelVO resp) {
		// Ir� procurar no banco de dados todos os produtos
		// que tiverem o responsavel igual ao do parametro
		// ser�o passados para um array para ent�o serem
		// mostrados
		int quantProd = 0;
		ProdutoVO produtos[] = new ProdutoVO[quantProd];
		return produtos;
	}

	public ProdutoVO[] pesquisar(String pesquisa, ResponsavelVO resp) {
		// Ir� chamar o m�dodo estoque para que seja pesquisado apenas os produtos
		// do responsavel que esteja logado
		ProdutoVO esto[] = estoque(resp);
		// e ent�o ser� feita uma busca para saber quais produtos tem algo
		// parecido com a String parametrizada, para serem postos em outro
		// vetor, que exibir� os dados
		int quantProd = 0;
		ProdutoVO produtos[] = new ProdutoVO[quantProd];
		return produtos;
	}

	public VendaVO[] HistoricoDeVendas(ResponsavelVO resp) {
		// Ir� exibir as vendas que foram feitas com o responsavel
		// indicado no parametro, para ent�o serem postas em um
		// vetor e ent�o serem exibidas
		int quantVen = 0;
		VendaVO vendas[] = new VendaVO[quantVen];
		return vendas;
	}

	public void Login(String usuario, String senha) {
		// Ser� receber o nome de login e a senha
		// e conferir se bate com o cadastrado.
		// Caso coincidir, ir� permitir o acesso.
	}

}
