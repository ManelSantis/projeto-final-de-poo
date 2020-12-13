package projeto.model.vo;

import projeto.exception.ExceptionCampoInvalido;

public class EstoqueVO {
	private ProdutoVO produto;
	private LocalVO local;
	private int quantidade = 0;
	private long id;
	
	public ProdutoVO getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutoVO produto) throws ExceptionCampoInvalido {
		if (produto != null) {
			// Adicionar o produto se ele não for nulo
			this.produto = produto;
		} else {
			throw new ExceptionCampoInvalido("Produto não aceito");
		}

	}

	public LocalVO getLocal() {
		return local;
	}

	public void setLocal(LocalVO local) throws ExceptionCampoInvalido {
		if (local != null) {
			this.local = local;	
		} else {
			throw new ExceptionCampoInvalido("Local não aceito");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) throws ExceptionCampoInvalido {
		if (quantidade >= 0) {
			//Maior igual a zero, para caso acabe no estoque
			//ou só adicione para um responsavel guardar 
			//não aceitando "remover do estoque" ainda
			this.quantidade += quantidade;	
			produto.setQuantidade(quantidade);
		} else if ((this.quantidade > -quantidade) && (this.quantidade > 0)) {
			//só irá remover se a quantidade atual
			//for maior que o valor sendo removido
			this.quantidade += quantidade;
			produto.setQuantidade(quantidade);
		} else {
			throw new ExceptionCampoInvalido("Digitar quantidade maior que zero");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
