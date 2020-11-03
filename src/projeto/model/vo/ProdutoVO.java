package projeto.model.vo;

public class ProdutoVO {
	private String nome;
	private String descricao;
	private double preco; 
	private String serie; //número de serie geralmente tem 13 caracteres
	private int quantidade; //quantKanalence + quantToinho
	private String img; //um endereço string
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() <= 100) {
			this.nome = nome; //limitar o tamanho do nome do produto
		} else {
			System.out.print("Ultrapassou o limite de caracteres!");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao.length() <= 500) {
			this.descricao = descricao; //limitar o tamanho da descrição do produto
		} else {
			System.out.print("Ultrapassou o limite de caracteres!");
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco; //verificar se o preço está sendo um valor positivo e maior que zero
		} else {
			System.out.print("Quantidade inválida!");
		}
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		if (serie.length() == 13) {
		this.serie = serie; //verificar se o tamanho do numero de serie está correto
		} else {
			System.out.println("Digite novamente!");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantKanalence, int quantToinho) {
		if(quantKanalence < 0) {
			System.out.println("Quantidade inválida!");
		}
		if(quantToinho < 0) {
			System.out.println("Quantidade inválida!");
		}
		if((quantKanalence + quantToinho) > 0) {
			this.quantidade = quantKanalence + quantToinho;
		} else {
			System.out.println("Quantidade total inválida!");
		}
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img; //não acho que precise de um ecessão, além do link ter que ser valido
	}
}
