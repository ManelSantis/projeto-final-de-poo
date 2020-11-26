package projeto.model.bo;

import projeto.model.vo.VendaVO;

public class VendaBO implements VendaInterBO{
	public void confirmarVenda(VendaVO venda) {
		// Ir� receber a venda parametrizada e ent�o adiconar� ela no banco de dados 
		// caso n�o exista ainda a partir do VendaDAO para poder confirmar a venda
		// no final chamando o m�todo imprimir de NotaFiscalBO para poder ser entregue ao cliente
	}
	
	public void alterarVenda (VendaVO venda) {
		// Ir� receber uma venda parametrizada, e ent�o procurar� ela
		// no banco de dados, podendo ent�o alterar os dados dessa,
		// para ent�o poder ser confirmada novamente utilizando 
		// m�todos de VendaDAO
	}
	
	public void cancelarVenda(VendaVO venda) {
		// Ir� receber uma venda parametrizada, para poder
		// ent�o cancelar ela, e remov�-la do banco de dados
		// a partir de um metodo de VendaDAO
	}

}
