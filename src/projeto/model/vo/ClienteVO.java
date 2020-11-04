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
			this.nome = nome; // limitar o tamanho do nome do cliente e se est� vazio
		} else {
			System.out.print("Opera��o invalida");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf){
		if ((cpf.length() != 11) && (!cpf.isEmpty())){
			System.out.println("CPF est� invalido."); //se o tamnho est� certo, e se est� vazio
		} else {
			this.cpf = cpf;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndere�o(String estado, String cidade, String bairro, String rua, String numero) {
		if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty()) && (!numero.isEmpty())) {
			this.endereco = estado + "\n" + cidade + "\n" + bairro + "\n" + rua + "\n" + numero; //salvar tudo separado por \n para ficar mais facil de verificar depois
		} else {
			System.out.println("N�o foi possivel salvar o seu endere�o!");
		}
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		if ((complemento.length() <= 100) && (!complemento.isEmpty())){
			this.complemento = complemento; // limitar o tamanho do complemento e verificar se n�o est� vazio
		} else {
			System.out.print("Opera��o inv�lida");
		}
	}
}
