package projeto.model.vo;
	
public class ClienteVO {
	private String nome;
	private String cpf;
	private String endere�o;
	private String complemento;
	
	public String getNome(){ 
		return nome;

	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getCpf(){
		return cpf;
	}
	public void setCpf( String cpf){
		if (cpf != 12){
			System.out.println("CPF est� invalido.")
		}
		else this.cpf = cpf;
	}
	public String getEndere�o(){
		return enrede�o;
	}
	
	public void setEndere�o(String endere�o){
		
		
	}
	public String getComplemento(){
		return complemento;
	}
	public void setComplemento(String complemento){
		String nome = complemento;
		
	}
}  
