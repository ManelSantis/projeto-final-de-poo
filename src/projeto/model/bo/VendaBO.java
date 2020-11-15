package projeto.model.bo;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.model.vo.ClienteVO;
import java.util.Calendar;

public class VendaBO {
	public void ConfirmarVenda(ProdutoVO prod[], int quant[], ResponsavelVO resp, ClienteVO cli) {
		// Irá receber as informações da venda por parametros, com um vetor que terá todos os produtos 
		// que o cliente estará comprando, e um vetor com a quantidade de cada produto, para então tudo
		// ser adicionado na venda
		VendaVO venda = new VendaVO();
		venda.setResponsavel(resp);
		venda.setCliente(cli);
		venda.setProduto(prod);
		venda.setQuantidade(quant);
		venda.setValor();
		venda.setCodigo();
		venda.setData();
		//então será feito um laço para poder verficar o valor final da venda, usando os vetores de produtoVO e quantidade
		//e após verificar se tudo está okay, então irá chamar o metodo NotaFiscal 
		//para confirmar a compra
		Notafiscal(venda);
	}
	
	public void CancelarVenda(String codigo) {
		// Irá fazer o inverso da confirmação da venda.
		// Irá receber o código da venda por parametro
		// pesquisará no banco de dados, e reverterá tudo que ocorreu em confirmar venda
		// restaurando a quantidade de produtos no estoque, e deixando a venda como
		// cancelada no relatorio
	}

	public VendaVO[] MostrarRelatorio(Calendar inicio, Calendar fim) {
		//Irá pesquisar no banco de dados as vendas que possuirem a data entre o periodo
		//posto, para então adicionar a quantidade no vetor vendas, e ele ser exebido posteriormente
		int quantVendas = 0;
		VendaVO vendas[] = new VendaVO[quantVendas];
		return vendas;
	}

	private void Notafiscal(VendaVO ven) {
		// Irá receber por parametros todas as informações de vendas, para então gerar uma
		//nota fiscal com todas as informações da venda, adicionando ela no banco de dados,
		//e então retornando um pdf com a nota fiscal
	}
	
}
