package projeto.model.bo;

import projeto.model.vo.ClienteVO;
import projeto.model.vo.VendaVO;

public class ClienteBO {
	public void cadastrar(String nome, String cpf, String telefone, String estado, String cidade, String bairro, String rua, String numero) {
		//esse metodo ir� receber todos os dados que s�o salvos em um clienteVO a aprtir de parametros
		//ent�o ser� criado um objeto clientevo, para poder salvar os dados
		//dentro do banco de dados
		ClienteVO c = new ClienteVO();
		c.setCpf(cpf);
		c.setEndereco(estado, cidade, bairro, rua, numero);
		c.setNome(nome);
		c.setTelefone(telefone);
		//ent�o ser� salvado no banco de dados
	}

	public void editar(String id) {
		//ser� pesquisado no bd o cliente que tenha o id indicado para editar
		//o que est� sendo salvo est� assim apenas como demonstra��o, 
		//depois ser� alterado
		ClienteVO c = new ClienteVO();
		c.setCpf("cpf");
		c.setEndereco("estado", "cidade", "bairro", "rua", "numero");
		c.setNome("nome");
		c.setTelefone("telefone");
		//e ent�o salvo no banco de dados
	}

	public void excluir(ClienteVO c) {
		String id = c.getCpf();
		//ser� pesquisado e ent�o deletado no bd a partir do id do cliente apontado
	}

	public VendaVO[] historicoDeCompras(String id) {
		//nesse metodo ter� que ser primeiro feita uma consulta no banco de dados para saber
		//quantas vendas foram feitas com o id (no caso o cpf) do cliente
		int quantVendas =  0;
		//ent�o elas ser�o guardadas em um array para depois serem listadas
		VendaVO vendas[] = new VendaVO[quantVendas];
		return vendas;
	}

}
