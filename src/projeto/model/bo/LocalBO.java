package projeto.model.bo;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;

public class LocalBO {
	
	public void cadastrar(String sala, String estante, String compartimento) {
		// Ser�o pegos os par�metros dos metodos para que eles poss�o ent�o ser utilizados com LocalVO
		LocalVO l = new LocalVO();
		l.setLocalizacao(sala, estante);
		l.setCompartimento(compartimento);
		// E ent�o salvos no banco de dados
	}
	
	public void editar(String compartimento) {
		// Ir� receber o compartimento do local e ir� pesquisar no banco
		// de dados o local para poder editar os componentes
	}
	
	public void excluir(String compartimento) {
		// Ir� pesquisar no banco de dados a partir do compartimento p�ra verificar
		// se existe e ent�o ir� deletar do banco de dados
	}

	
}
