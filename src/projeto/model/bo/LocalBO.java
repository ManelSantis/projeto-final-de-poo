package projeto.model.bo;

import projeto.model.vo.LocalVO;

public class LocalBO {
	
	public void cadastrar(LocalVO local) {
		// Ser� pego o LocalVO parametrizado
		// verificar� se ele j� existe no LocalDAO
		// E ent�o salvos no banco de dados em LocalDAO
	}
	
	public void editar(LocalVO local) {
		// Ir� receber um LocalVO parametrizado
		// pesquisar� ele com o auxilio de LocalDAO
		// e ent�o mandara eles para a pagina de edi��o
		// l� os dados podendo ser alterados
		// e ent�o mandados novamente para o banco de dados
		// atr�sves de um update
	}
	
	public void excluir(LocalVO local) {
		// Ir� pesquisar no banco de dados o local parametrizado
		// com o auxilio de LocalDAO,
		// se existir ir� deletar do banco de dados
	}

	
}
