package projeto.model.vo;

public class ProdutoVO {
	private String nome;
	private String descricao;
	private double preco;
	private String serie; // n�mero de serie geralmente tem 13 caracteres
	private int quantidade; // quantKanalence + quantToinho
	private String img; // um endere�o string

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.equals(null)) {
			System.out.print("Opera��o invalida");
		} else if ((nome.length() <= 100) && (!nome.isEmpty())) {
			this.nome = nome; // limitar o tamanho do nome do produto e se n�o est� vazio
		} else {
			System.out.print("Opera��o inv�lida!");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao.equals(null)) {
			System.out.print("Opera��o invalida");
		} else if ((descricao.length() <= 500) && (!descricao.isEmpty())) {
			this.descricao = descricao; // limitar o tamanho da descri��o do produto e se n�o est� vazia
		} else {
			System.out.print("Opera��o inv�lida!");
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco; // verificar se o pre�o est� sendo um valor positivo e maior que zero
		} else {
			System.out.print("Quantidade inv�lida!");
		}
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		if (serie.equals(null)) {
			System.out.print("Opera��o invalida");
		} else if (serie.length() == 13) {
			this.serie = serie; // verificar se o tamanho do numero de serie est� correto
		} else {
			System.out.println("Digite novamente!");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantKanalence, int quantToinho) { // pegar as duas quantidades e depois soma-las
		if (quantKanalence < 0) {
			System.out.println("Quantidade inv�lida!");
		}
		if (quantToinho < 0) {
			System.out.println("Quantidade inv�lida!");
		}
		if ((quantKanalence + quantToinho) > 0) {
			this.quantidade = quantKanalence + quantToinho;
		} else {
			System.out.println("Quantidade total inv�lida!");
		}
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		if (img.equals(null)) {
			System.out.print("Opera��o invalida");
		} else if (!img.isEmpty()) {
			this.img = img; // se n�o estiver vazia, salva
		} else {
			System.out.println("Adicione uma imagem!");
		}
	}
}
