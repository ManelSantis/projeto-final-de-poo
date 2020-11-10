package projeto.model.vo;

import java.util.Calendar;

public class VendaVO {
	private ClienteVO cliente;
	private ProdutoVO produto;
	private ResponsavelVO responsavel;
	private int quantidade;
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

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVO produto) {
		if (produto != null) {
			this.produto = produto; // Atribui os valores ao metodo da classe produto.
		} else {
			System.out.println("Operação inválida");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (quantidade <= 0) { // Se a quantidade inseria for menor que 0 ele vai informar que está invalido,
								// se não irá armazenar o valor.
			System.out.print("Quantidade de produtos invalida");
		} else {
			this.quantidade = quantidade;
		}
	}

	public Calendar getData() {
		return data;
	}

	public void setData() {
		// Utilizando a classe calendar para gerar todas as informações referente a data
		// da compra.
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

	public void setValor(double valor) {
		if (valor > 0) {
			this.valor = valor;
		} else {
			System.out.println("Operação inválida");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo != null) {
			if ((codigo.length() == 15) && (!codigo.isEmpty())) {
				this.codigo = codigo;
			}
		} else {
			System.out.println("Operação inválida");
		}

	}

}