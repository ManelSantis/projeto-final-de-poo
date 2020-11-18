package projeto.model.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class VendaVO {
	private ClienteVO cliente;
	private ResponsavelVO responsavel;
	private ArrayList <ProdutoVO> carrinho = new ArrayList<ProdutoVO>();
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
	
	public ArrayList <ProdutoVO> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(ProdutoVO produto, int quantidade) {
		if (produto != null) { // Primeiro Verifica se o produto está vindo corretamente
			if (quantidade > 0) { // Depois verifica se a quantidade pedida é maior que zero
				if (produto.setQuantiPedido(quantidade)) { // Então chama o metodo setQuantiPedido que tem em produtoVO
					// lá ele retorna um valor true se a quantidade for aceita (existir em estoque), senão
					// retorna false
					this.carrinho.add(produto); // Se sim, adiciona na arraylist
					System.out.println("Produto adicionado");
				} else {
					System.out.println("Não possuimos a quantidade pedida em estoque.");
				}
			} else {
				System.out.println("Quantidade adicionana precisa ser maior que zero.");
			}
		} else {
			System.out.println("Produto não foi adicionado.");
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

	public double getValor() {
		return valor;
	}

	public void setValor() {
		// Irá salvar automaticamente o valor final da venda
		// a partir dos dados presentes no carrinho
		for (int i = 0; i < carrinho.size(); i++) {
				valor = valor + (carrinho.get(i).getPreco() * carrinho.get(i).getQuantiPedido());
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo() {
		// esse código está gerando automaticamente um código para a venda
		// só que antes de adicionar, tera que ser feita uma consulta no
		// banco de dados para saber se o código já foi usado ou não
		// já que estamos falando de valores aleatorios
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