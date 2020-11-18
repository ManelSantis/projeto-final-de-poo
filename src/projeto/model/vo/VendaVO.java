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
			System.out.println("Opera��o inv�lida");
		}
	}
	
	public ResponsavelVO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelVO responsavel) {
		if (responsavel != null) {
			this.responsavel = responsavel;
		} else {
			System.out.println("Opera��o inv�lida");
		}
	}
	
	public ArrayList <ProdutoVO> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(ProdutoVO produto, int quantidade) {
		if (produto != null) { // Primeiro Verifica se o produto est� vindo corretamente
			if (quantidade > 0) { // Depois verifica se a quantidade pedida � maior que zero
				if (produto.setQuantiPedido(quantidade)) { // Ent�o chama o metodo setQuantiPedido que tem em produtoVO
					// l� ele retorna um valor true se a quantidade for aceita (existir em estoque), sen�o
					// retorna false
					this.carrinho.add(produto); // Se sim, adiciona na arraylist
					System.out.println("Produto adicionado");
				} else {
					System.out.println("N�o possuimos a quantidade pedida em estoque.");
				}
			} else {
				System.out.println("Quantidade adicionana precisa ser maior que zero.");
			}
		} else {
			System.out.println("Produto n�o foi adicionado.");
		}
	}

	public Calendar getData() {
		return data;
	}

	public void setData() {
		// Utilizando a classe calendar para gerar todas as
		// informa��es referente a data da compra.
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
		// Ir� salvar automaticamente o valor final da venda
		// a partir dos dados presentes no carrinho
		for (int i = 0; i < carrinho.size(); i++) {
				valor = valor + (carrinho.get(i).getPreco() * carrinho.get(i).getQuantiPedido());
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo() {
		// esse c�digo est� gerando automaticamente um c�digo para a venda
		// s� que antes de adicionar, tera que ser feita uma consulta no
		// banco de dados para saber se o c�digo j� foi usado ou n�o
		// j� que estamos falando de valores aleatorios
		Random r = new Random();
		String aux = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String codigo = "";
		while (codigo.length() < 35) {
			// ir� adicionar caractere por caractere a partir da string aux
			codigo = codigo + aux.charAt(r.nextInt(62));
		}
		this.codigo = codigo;
	}

}