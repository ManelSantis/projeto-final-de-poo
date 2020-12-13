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
	private long id;

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

	public void setCarrinho(ProdutoVO produto) {
		if (produto != null) {
			this.carrinho.add(produto);//adicionando produto no carrinho
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
	
	public void setData(Calendar data) {
		//para auxiliar no dao
		this.data = data;
	}
	
	public String getCli() {
		//para passar o calendar como string
		String cli = cliente.getNome();
		return cli;
	}
	
	public String getResp() {
		//para passar o calendar como string
		String resp = responsavel.getNome();
		return resp;
	}
	
	public String getString() {
		//para passar o calendar como string
		String dataFinal = data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH) + "-" +data.get(Calendar.DAY_OF_MONTH);
		return dataFinal;
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
	
	public void zerarValor() {
		// Usado para zerar o valor caso retornar para alterações na compra
		valor = 0;
	}
	
	public void setValor(double valor) {
		// ajduar na hora de pegar uma venda do bd
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		//metodo usado para ajudar no dao
		if (codigo != null) {
			if (!codigo.isBlank()) {
				this.codigo = codigo;
			} else {
				System.out.println("Código invalido");
			}
		} else {
			System.out.println("Codigo invalido");
		}
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}