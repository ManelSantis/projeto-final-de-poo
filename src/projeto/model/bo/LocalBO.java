package projeto.model.bo;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;

public class LocalBO {
	
	public void cadastrar(String sala, String estante, String compartimento) {
		// Serão pegos os parâmetros dos metodos para que eles possão então ser utilizados com LocalVO
		LocalVO l = new LocalVO();
		l.setLocalizacao(sala, estante);
		l.setCompartimento(compartimento);
		// E então salvos no banco de dados
	}
	
	public void editar(String compartimento) {
		// Irá receber o compartimento do local e irá pesquisar no banco
		// de dados o local para poder editar os componentes
	}
	
	public void excluir(String compartimento) {
		// Irá pesquisar no banco de dados a partir do compartimento pára verificar
		// se existe e então irá deletar do banco de dados
	}

	
}
