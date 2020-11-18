package projeto.model.vo;

public class NotaFiscalVO {
	private VendaVO venda;

	public VendaVO getVenda() {
		return venda;
	}

	public void setVenda(VendaVO venda) {
		if (venda != null) {
			// Se estiver tudo okay com a venda, então ela será aceita
			this.venda = venda;
		} else {
			System.out.println("Venda não concluida");
		}
		
	}
	
}
