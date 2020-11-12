package projeto.model.bo;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;

public class LocalBO {
	public void cadastrar(String sala, String estante, String compartimento) {
		//serão pegos os parâmetros dos metodos para que eles possão então ser utilizados com LocalVO
		LocalVO l = new LocalVO();
		l.setLocalizacao(sala, estante);
		l.setNumCompartimento(compartimento);
		//e então salvos no banco de dados
	}

	public void adicionar(LocalVO l) {
		//esse método ligará o produto com um local, se o local existir
		ProdutoVO p = new ProdutoVO();
		p.setLocal(l);
		//para assim poder salvar que tal produto esta em tal local
	}

	public void excluir(LocalVO l) {
		//irá pesquisar no banco de dados a partir do id para verificar se existe
		String c = l.getNumCompartimento();
		//salvará em uma variavel auxiliar para então poder deletar do banco de dados
	}

	public void editar(LocalVO l) {
		l.setLocalizacao("nova sala", "nova estante");
	}
}
