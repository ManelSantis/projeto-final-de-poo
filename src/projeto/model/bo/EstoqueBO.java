package projeto.model.bo;

import projeto.model.vo.EstoqueVO;

public class EstoqueBO {
	
	public void cadastrar(EstoqueVO estoque) {
		// Ser� pego o EstoqueVO parametrizado
		// verificar� se ele j� existe no EstoqueDAO
		// E ent�o salvos no banco de dados em EstoqueDAO
	}
	
	public void editar(EstoqueVO estoque) {
		// Ir� receber um EstoqueVO parametrizado
		// pesquisar� ele com o auxilio de EstoqueDAO
		// e ent�o mandara eles para a pagina de edi��o
		// l� os dados podendo ser alterados
		// seja aumentar a quantidade do produto
		// ou transferir para outro responsavel
		// e ent�o ser� mandado novamente para o banco de dados
		// atr�sves de um update
	}
	
	public void excluir(EstoqueVO estoque) {
		// Ir� pesquisar no banco de dados o estoque parametrizado
		// com o auxilio de EstoqueDAO,
		// se existir ir� deletar do banco de dados
	}

}
