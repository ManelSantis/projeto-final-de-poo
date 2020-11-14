package projeto.model.bo;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ClienteVO;

public class VendaBO {
	public void ConfirmarVenda(ProdutoVO prove) {
		// Ao confirmar a venda, irá ser recolhido a quantidade do produto
		// Junto ao número de série para localiza-lo, e então diminuir a quandiade
		// no banco de dados.
		ProdutoVO pro = new ProdutoVO;
		pro = prove.getSerie();
		pro = prove.getQuantidade();
		
	}
	void CancelarVenda(ProdutoVO prove) {
		// Irá fazer o inverso da confirmaçãod a venda.
		// Irá receber a quantidade do produto
		// junto ao número de série para localiza-lo, e então aumentar de volta a quantidade
		// no banco de dados.
		ProdutoVO pro = new ProdutoVO;
		pro = prove.getSerie();
		pro = prove.getQuantidade();
	}

	void MostrarRelatorio() {
		// Irá exibir o relatório de vendas em determinado periodo.
	}

	public void Notafiscal(ProdutoVO prono, ClienteVO clieno) {
		// Irá ser retornado as informações primeiro do produto
		// para ser inserido na nota de venda.
		ProdutoVO prod = new ProdutoVO;
		prod = prove.getDescricao();
		prod = prove.getSerie();
		prod = prove.getQuantidade();
		prod = prove.getResponsavel();
		prod = prove.getPreco();
		// Apos isso deve ser diminuido no banco de dados a quantidade de produto em estoque.
				
				
		//Irá ser retornado as informações do cliente para ser inserido na nota de venda
		ClienteVO cli = new ClienteVO;
		cli = clieno.getCpf():
		cli = clien.getEndereço();
		cli = clieno.getNome();
		cli = clieno.Telefone();
	}
}
