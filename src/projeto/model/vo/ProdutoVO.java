package projeto.model.vo;

public class ProdutoVO {
	private String nome;
	private String descricao;
	private double peso;
	private String serie; // n�mero de serie geralmente tem 13 caracteres
	private double preco;
	private int quantidade = 0; // quantKanalence + quantToinho
	private int quantiPedido = 0;
	private String img; // um endere�o string
	private long id;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			if ((nome.length() <= 100) && (!nome.isEmpty())) {
				this.nome = nome; 
				// limitar o tamanho do nome do produto e se n�o est� vazio
			} else {
				System.out.print("Opera��o invalida");
			}
		} else {
			System.out.print("Opera��o invalida");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao != null) {
			if ((descricao.length() <= 500) && (!descricao.isEmpty())) {
				this.descricao = descricao; 
				// limitar o tamanho da descri��o do produto e se n�o est� vazia
			} else {
				System.out.print("Opera��o inv�lida!");
			}
		} else {
			System.out.print("Opera��o inv�lida!");
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco; 
			// verificar se o pre�o est� sendo um valor positivo e maior que zero
		} else {
			System.out.print("Quantidade inv�lida!");
		}
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		if (serie != null) {
			if (serie.length() == 13) {
				this.serie = serie; 
				// verificar se o tamanho do numero de serie est� correto
			} else {
				System.out.println("Digite novamente!");
			}
		} else {
			System.out.println("Digite novamente!");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) { 
		// esse m�todo � usado em estoqueVO para aumentar
		// ou diminuir a quantidade, e l� mesmo
		// verifica se a quantidade � valida ou n�o
		this.quantidade += quantidade;
	}
	
	public int getQuantiPedido() {
		return quantiPedido;
	}

	public boolean setQuantiPedido(int quantiPedido) {
		// m�dodo usado em vendaVO para vericar se a quantidade
		// pedida � aceita
		if (quantiPedido > 0) {
			if (quantiPedido <= quantidade) {
				this.quantiPedido = quantiPedido;
				return true;
			}
		}
		return false;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		if (img != null) {
			if (!img.isEmpty()) {
				this.img = img; 
				// se n�o estiver vazia, salva
			} else {
				System.out.println("Adicione uma imagem!");
			}
		} else {
			System.out.println("Adicione uma imagem!");
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso > 0) {
			this.peso = peso; 
			// verificar se o pre�o est� sendo um valor positivo e maior que zero
		} else {
			System.out.print("Quantidade inv�lida!");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
