package projeto.model.bo;

import projeto.model.vo.LocalVO;

public class LocalBO {
	
	public void cadastrar(LocalVO local) {
		// Será pego o LocalVO parametrizado
		// verificará se ele já existe no LocalDAO
		// E então salvos no banco de dados em LocalDAO
	}
	
	public void editar(LocalVO local) {
		// Irá receber um LocalVO parametrizado
		// pesquisará ele com o auxilio de LocalDAO
		// e então mandara eles para a pagina de edição
		// lá os dados podendo ser alterados
		// e então mandados novamente para o banco de dados
		// atrásves de um update
	}
	
	public void excluir(LocalVO local) {
		// Irá pesquisar no banco de dados o local parametrizado
		// com o auxilio de LocalDAO,
		// se existir irá deletar do banco de dados
	}

	
}
