package projeto.model.vo;

import java.util.Calendar;

public class VendaVO {
	private ClienteVO cliente;
	private ProdutoVO produto;
	private int quantidade;
	private Calendar data;
	
	public ClienteVO getCliente(){
		return cliente;
	}
	public void  setCliente(ClienteVO cliente){
		this.cliente = cliente; // Atribui os valores ao metodo da classe cliente.
		
	}
	public ProdutoVO getProduto(){
		return produto;
	}
	public void  setProduto(ProdutoVO produto){
		this.produto = produto; // Atribui os valores ao metodo da classe produto.
	}
	public int getQuantidade(){
		return quantidade;
	}
	public void setQuantidade(int quantidade){
		if (quantidade <= 0){ // Se a quantidade inseria for menor que 0 ele vai informar que está invalido, se não irá armazenar o valor.
			System.out.print("Quantidade de produtos invalida")
		}
		else this.quantidade =  quantidade;
	}
	public Calendar getData(){
		return data;
	}
	public void setData(Calendar data){
		// Utilizando a classe calendar para gerar todas as informações referente a data da compra.
		data = Calendar.getInstance(); 
		int ano = data.get(Calendar.YEAR);
		int mes = data.get(Calendar.MONTH);
		int dia = data.get(Calendar.DAY_OF_MONTH);
		int hora = data.get(Calendar.HOUR_OF_DAY);
		int minutos = data.get(Calendar.MINUTE);
		int segundos = data.get(Calendar.SECOND);
		
	}
}