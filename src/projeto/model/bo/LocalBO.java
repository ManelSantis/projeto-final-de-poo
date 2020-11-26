package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.LocalVO;
import projeto.model.vo.ResponsavelVO;

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

	public ArrayList<LocalVO> listar(ResponsavelVO responsavel) {
		// Irá pesquisar no banco de dados uma lista de locai
		// a partir do responsavel parametrizado
		// com o auxilio de LocalDA
		// e então irá passar tudo para uma ArrayList 
		// para ser exibida
		ArrayList<LocalVO> locais = new ArrayList<LocalVO>();
		return locais;
	}
}
