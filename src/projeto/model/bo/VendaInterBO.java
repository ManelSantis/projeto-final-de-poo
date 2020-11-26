package projeto.model.bo;

import projeto.model.vo.VendaVO;

public interface VendaInterBO {
	
	public void confirmarVenda(VendaVO venda);
	public void alterarVenda (VendaVO venda);
	public void cancelarVenda(VendaVO venda);

}
