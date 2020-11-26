package projeto.model.vo;

public class EstoqueVO {
	private ProdutoVO produto;
	private LocalVO local;
	private int quantidade = 0;
	
	public ProdutoVO getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutoVO produto) {
		if (produto != null) {
			// Adicionar o produto se ele n�o for nulo
			this.produto = produto;
		} else {
			System.out.println("N�o foi possivel adicionar o produto");
		}

	}

	public LocalVO getLocal() {
		return local;
	}

	public void setLocal(LocalVO local) {
		if (local != null) {
			this.local = local;	
		} else {
			System.out.println("N�o foi possivel adicionar o local");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (quantidade >= 0) {
			//Maior igual a zero, para caso acabe no estoque
			//ou s� adicione para um responsavel guardar 
			//n�o aceitando "remover do estoque" ainda
			this.quantidade += quantidade;	
			produto.setQuantidade(quantidade);
		} else if ((this.quantidade > -quantidade) && (this.quantidade > 0)) {
			//s� ir� remover se a quantidade atual
			//for maior que o valor sendo removido
			this.quantidade += quantidade;
			produto.setQuantidade(quantidade);
		} else {
			System.out.println("Quantidade n�o aceita!");
		}
	}
	
	
}
