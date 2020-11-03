package projeto.model.vo;

public class ProdutoVO {
	private String nome;
	private String descricao;
	private double preco; 
	private String serie; //n�mero de serie geralmente tem 13 caracteres
	private int quantidade; //quantKanalence + quantToinho
	private String img; //um endere�o string
	
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
			this.descricao = descricao; //limitar o tamanho da descri��o do produto
		} else {
			System.out.print("Ultrapassou o limite de caracteres!");
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco; //verificar se o pre�o est� sendo um valor positivo e maior que zero
		} else {
			System.out.print("Quantidade inv�lida!");
		}
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		if (serie.length() == 13) {
		this.serie = serie; //verificar se o tamanho do numero de serie est� correto
		} else {
			System.out.println("Digite novamente!");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantKanalence, int quantToinho) {
		if(quantKanalence < 0) {
			System.out.println("Quantidade inv�lida!");
		}
		if(quantToinho < 0) {
			System.out.println("Quantidade inv�lida!");
		}
		if((quantKanalence + quantToinho) > 0) {
			this.quantidade = quantKanalence + quantToinho;
		} else {
			System.out.println("Quantidade total inv�lida!");
		}
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img; //n�o acho que precise de um ecess�o, al�m do link ter que ser valido
	}
}
