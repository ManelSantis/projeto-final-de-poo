package projeto.model.bo;

import projeto.model.vo.VendaVO;

public class VendaBO implements VendaInterBO{
	public void confirmarVenda(VendaVO venda) {
		// Irá receber a venda parametrizada e então adiconará ela no banco de dados 
		// caso não exista ainda a partir do VendaDAO para poder confirmar a venda
		// no final chamando o método imprimir de NotaFiscalBO para poder ser entregue ao cliente
	}
	
	public void alterarVenda (VendaVO venda) {
		// Irá receber uma venda parametrizada, e então procurará ela
		// no banco de dados, podendo então alterar os dados dessa,
		// para então poder ser confirmada novamente utilizando 
		// métodos de VendaDAO
	}
	
	public void cancelarVenda(VendaVO venda) {
		// Irá receber uma venda parametrizada, para poder
		// então cancelar ela, e removê-la do banco de dados
		// a partir de um metodo de VendaDAO
	}

}
