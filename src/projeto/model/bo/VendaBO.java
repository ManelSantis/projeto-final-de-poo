package projeto.model.bo;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ClienteVO;

public class VendaBO {
	public void ConfirmarVenda(ProdutoVO prove) {
		// Ao confirmar a venda, ir� ser recolhido a quantidade do produto
		// Junto ao n�mero de s�rie para localiza-lo, e ent�o diminuir a quandiade
		// no banco de dados.
		ProdutoVO pro = new ProdutoVO;
		pro = prove.getSerie();
		pro = prove.getQuantidade();
		
	}
	void CancelarVenda(ProdutoVO prove) {
		// Ir� fazer o inverso da confirma��od a venda.
		// Ir� receber a quantidade do produto
		// junto ao n�mero de s�rie para localiza-lo, e ent�o aumentar de volta a quantidade
		// no banco de dados.
		ProdutoVO pro = new ProdutoVO;
		pro = prove.getSerie();
		pro = prove.getQuantidade();
	}

	void MostrarRelatorio() {
		// Ir� exibir o relat�rio de vendas em determinado periodo.
	}

	public void Notafiscal(ProdutoVO prono, ClienteVO clieno) {
		// Ir� ser retornado as informa��es primeiro do produto
		// para ser inserido na nota de venda.
		ProdutoVO prod = new ProdutoVO;
		prod = prove.getDescricao();
		prod = prove.getSerie();
		prod = prove.getQuantidade();
		prod = prove.getResponsavel();
		prod = prove.getPreco();
		// Apos isso deve ser diminuido no banco de dados a quantidade de produto em estoque.
				
				
		//Ir� ser retornado as informa��es do cliente para ser inserido na nota de venda
		ClienteVO cli = new ClienteVO;
		cli = clieno.getCpf():
		cli = clien.getEndere�o();
		cli = clieno.getNome();
		cli = clieno.Telefone();
	}
}
