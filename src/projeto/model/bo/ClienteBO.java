package projeto.model.bo;

import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;

public class ClienteBO {
	public void cadastrar(String nome, String cpf, String telefone, String estado, String cidade, String bairro, String rua, String numero) {
		// Esse metodo irá receber todos os dados que são salvos em um clienteVO
		// a aprtir de parametros
		// então será criado um objeto clientevo, para poder salvar os dados
		// dentro do banco de dados
		ClienteVO c = new ClienteVO();
		c.setCpf(cpf);
		c.setEndereco(estado, cidade, bairro, rua, numero);
		c.setNome(nome);
		c.setTelefone(telefone);
		//então será salvado no banco de dados
	}

	public void editar(String id) {
		// Será pesquisado no bd o cliente que tenha o id indicado para editar
		// o que está sendo salvo está assim apenas como demonstração, 
		// depois será alterado
		ClienteVO c = new ClienteVO();
		c.setCpf("cpf");
		c.setEndereco("estado", "cidade", "bairro", "rua", "numero");
		c.setNome("nome");
		c.setTelefone("telefone");
		// e então salvo no banco de dados
	}

	public void excluir(String id) {
		// Será pesquisado no banco de dados o cpf do cliente
		// para então deleta-lo
	}

	public VendaVO[] historicoDeCompras(ClienteVO cli) {
		// Nesse metodo terá que ser primeiro feita uma consulta 
		// no banco de dados para saber
		// quantas vendas foram feitas com o id (no caso o cpf) do cliente
		int quantVendas =  0;
		// então elas serão guardadas em um array para depois serem listadas
		VendaVO vendas[] = new VendaVO[quantVendas];
		return vendas;
	}

}
