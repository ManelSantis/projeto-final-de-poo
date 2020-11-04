package projeto.model.vo;
	
public class ClienteVO {
	private String nome;
	private String cpf;
	private String endereço;
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
			System.out.println("CPF está invalido.")
		}
		else this.cpf = cpf;
	}
	public String getEndereço(){
		return enredeço;
	}
	
	public void setEndereço(String endereço){
		
		
	}
	public String getComplemento(){
		return complemento;
	}
	public void setComplemento(String complemento){
		String nome = complemento;
		
	}
}  
