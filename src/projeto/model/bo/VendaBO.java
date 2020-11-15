package projeto.model.bo;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import projeto.model.vo.ClienteVO;
import java.util.Calendar;

public class VendaBO {
	public void ConfirmarVenda(ProdutoVO prod[], int quant[], ResponsavelVO resp, ClienteVO cli) {
		// Ir� receber as informa��es da venda por parametros, com um vetor que ter� todos os produtos 
		// que o cliente estar� comprando, e um vetor com a quantidade de cada produto, para ent�o tudo
		// ser adicionado na venda
		VendaVO venda = new VendaVO();
		venda.setResponsavel(resp);
		venda.setCliente(cli);
		venda.setProduto(prod);
		venda.setQuantidade(quant);
		venda.setValor();
		venda.setCodigo();
		venda.setData();
		//ent�o ser� feito um la�o para poder verficar o valor final da venda, usando os vetores de produtoVO e quantidade
		//e ap�s verificar se tudo est� okay, ent�o ir� chamar o metodo NotaFiscal 
		//para confirmar a compra
		Notafiscal(venda);
	}
	
	public void CancelarVenda(String codigo) {
		// Ir� fazer o inverso da confirma��o da venda.
		// Ir� receber o c�digo da venda por parametro
		// pesquisar� no banco de dados, e reverter� tudo que ocorreu em confirmar venda
		// restaurando a quantidade de produtos no estoque, e deixando a venda como
		// cancelada no relatorio
	}

	public VendaVO[] MostrarRelatorio(Calendar inicio, Calendar fim) {
		//Ir� pesquisar no banco de dados as vendas que possuirem a data entre o periodo
		//posto, para ent�o adicionar a quantidade no vetor vendas, e ele ser exebido posteriormente
		int quantVendas = 0;
		VendaVO vendas[] = new VendaVO[quantVendas];
		return vendas;
	}

	private void Notafiscal(VendaVO ven) {
		// Ir� receber por parametros todas as informa��es de vendas, para ent�o gerar uma
		//nota fiscal com todas as informa��es da venda, adicionando ela no banco de dados,
		//e ent�o retornando um pdf com a nota fiscal
	}
	
}
