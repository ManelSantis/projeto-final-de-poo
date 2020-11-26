package projeto.model.bo;

import projeto.model.vo.EstoqueVO;

public class EstoqueBO {
	
	public void cadastrar(EstoqueVO estoque) {
		// Será pego o EstoqueVO parametrizado
		// verificará se ele já existe no EstoqueDAO
		// E então salvos no banco de dados em EstoqueDAO
	}
	
	public void editar(EstoqueVO estoque) {
		// Irá receber um EstoqueVO parametrizado
		// pesquisará ele com o auxilio de EstoqueDAO
		// e então mandara eles para a pagina de edição
		// lá os dados podendo ser alterados
		// seja aumentar a quantidade do produto
		// ou transferir para outro responsavel
		// e então será mandado novamente para o banco de dados
		// atrásves de um update
	}
	
	public void excluir(EstoqueVO estoque) {
		// Irá pesquisar no banco de dados o estoque parametrizado
		// com o auxilio de EstoqueDAO,
		// se existir irá deletar do banco de dados
	}

}
