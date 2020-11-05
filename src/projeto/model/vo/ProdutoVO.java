package projeto.model.vo;

public class ProdutoVO {
	private String nome;
	private String descricao;
	private double preco;
	private String serie; // número de serie geralmente tem 13 caracteres
	private int quantidade; // quantKanalence + quantToinho
	private String img; // um endereço string

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.equals(null)) {
			System.out.print("Operação invalida");
		} else if ((nome.length() <= 100) && (!nome.isEmpty())) {
			this.nome = nome; // limitar o tamanho do nome do produto e se não está vazio
		} else {
			System.out.print("Operação inválida!");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao.equals(null)) {
			System.out.print("Operação invalida");
		} else if ((descricao.length() <= 500) && (!descricao.isEmpty())) {
			this.descricao = descricao; // limitar o tamanho da descrição do produto e se não está vazia
		} else {
			System.out.print("Operação inválida!");
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco; // verificar se o preço está sendo um valor positivo e maior que zero
		} else {
			System.out.print("Quantidade inválida!");
		}
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		if (serie.equals(null)) {
			System.out.print("Operação invalida");
		} else if (serie.length() == 13) {
			this.serie = serie; // verificar se o tamanho do numero de serie está correto
		} else {
			System.out.println("Digite novamente!");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantKanalence, int quantToinho) { // pegar as duas quantidades e depois soma-las
		if (quantKanalence < 0) {
			System.out.println("Quantidade inválida!");
		}
		if (quantToinho < 0) {
			System.out.println("Quantidade inválida!");
		}
		if ((quantKanalence + quantToinho) > 0) {
			this.quantidade = quantKanalence + quantToinho;
		} else {
			System.out.println("Quantidade total inválida!");
		}
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		if (img.equals(null)) {
			System.out.print("Operação invalida");
		} else if (!img.isEmpty()) {
			this.img = img; // se não estiver vazia, salva
		} else {
			System.out.println("Adicione uma imagem!");
		}
	}
}
