package projeto.model.vo;

public class ClienteVO {
	private String nome;
	private String cpf;
	private String endereco;
	private String complemento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if ((nome.length() <= 100) && (!nome.isEmpty())) {
			this.nome = nome; // limitar o tamanho do nome do cliente e se está vazio
		} else {
			System.out.print("Operação invalida");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf){
		if ((cpf.length() != 11) && (!cpf.isEmpty())){
			System.out.println("CPF está invalido."); //se o tamnho está certo, e se está vazio
		} else {
			this.cpf = cpf;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereço(String estado, String cidade, String bairro, String rua, String numero) {
		if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty()) && (!numero.isEmpty())) {
			this.endereco = estado + "\n" + cidade + "\n" + bairro + "\n" + rua + "\n" + numero; //salvar tudo separado por \n para ficar mais facil de verificar depois
		} else {
			System.out.println("Não foi possivel salvar o seu endereço!");
		}
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		if ((complemento.length() <= 100) && (!complemento.isEmpty())){
			this.complemento = complemento; // limitar o tamanho do complemento e verificar se não está vazio
		} else {
			System.out.print("Operação inválida");
		}
	}
}
