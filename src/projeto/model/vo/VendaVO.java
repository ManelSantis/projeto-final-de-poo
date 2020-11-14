package projeto.model.vo;

import java.util.Calendar;
import java.util.Random;

public class VendaVO {
	private ClienteVO cliente;
	private ProdutoVO produto[];
	private ResponsavelVO responsavel;
	private int quantidade[];
	private Calendar data;
	private double valor;
	private String codigo;

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		if (cliente != null) {
			this.cliente = cliente; // Atribui os valores ao metodo da classe cliente.
		} else {
			System.out.println("Operação inválida");
		}
	}

	public ProdutoVO[] getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVO[] produto) {
		// Como o cliente pode acabar comprando mais de um produto
		// Então é bom que o metodo receba um vetor de ProdutoVO
		// Ao invés de apenas um produto
		this.produto = new ProdutoVO[produto.length];
		for (int i = 0; i < produto.length; i++) {
			if (produto[i] != null) {
				this.produto[i] = produto[i]; // Atribui os valores ao metodo da classe produto.
			} else {
				this.produto[i] = null; // pedido não irá aparecer na hora de fechar a venda
			}
		}

	}

	public int[] getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int[] quantidade) {
		this.quantidade = new int[quantidade.length];
		for (int i = 0; i < quantidade.length; i++) {
			if (quantidade[i] <= 0) {
				// Se a quantidade inseria for menor que 0, ou 0, então o
				// pedido será retirado da compra automaticamente
				this.quantidade[i] = 0;
			} else {
				// senão, então a quantidade será aceita
				this.quantidade[i] = quantidade[i];
			}
		}

	}

	public Calendar getData() {
		return data;
	}

	public void setData() {
		// Utilizando a classe calendar para gerar todas as
		// informações referente a data da compra.
		Calendar data = Calendar.getInstance();
		data.get(Calendar.YEAR);
		data.get(Calendar.MONTH);
		data.get(Calendar.DAY_OF_MONTH);
		data.get(Calendar.HOUR_OF_DAY);
		data.get(Calendar.MINUTE);
		data.get(Calendar.SECOND);
		this.data = data;
	}

	public ResponsavelVO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelVO responsavel) {
		if (responsavel != null) {
			this.responsavel = responsavel;
		} else {
			System.out.println("Operação inválida");
		}
	}

	public double getValor() {
		return valor;
	}

	public void setValor() {
		// irá salvar automaticamente o valor final,
		// apartir dos produtos e a quantidade de cada um
		for (int i = 0; i < produto.length; i++) {
			if (produto[i] != null) {
				valor = valor + (produto[i].getPreco() * quantidade[i]);
			}
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo() {
		// esse código está gerando automaticamente um código para a venda
		// só que antes de adicionar, tera que ser feita uma consulta no
		// banco de dados para saber se o código já foi usado ou não
		Random r = new Random();
		String aux = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String codigo = "";
		while (codigo.length() < 35) {
			// irá adicionar caractere por caractere a partir da string aux
			codigo = codigo + aux.charAt(r.nextInt(62));
		}
		this.codigo = codigo;
	}

}