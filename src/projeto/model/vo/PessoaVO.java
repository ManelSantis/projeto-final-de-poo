package projeto.model.vo;

public class PessoaVO {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			if ((nome.length() <= 100) && (!nome.isEmpty())) {
				this.nome = nome; // limitar o tamanho do nome do cliente e se est� vazio
			} else {
				System.out.print("Opera��o invalida");
			}
		} else {
			System.out.print("Opera��o invalida");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf != null) {
			if ((cpf.length() != 11) && (!cpf.isEmpty())) {
				System.out.println("CPF est� invalido."); // se o tamnho est� certo, e se est� vazio
			} else {
				this.cpf = cpf;
			}
		} else {
			System.out.println("CPF est� invalido."); // se o tamnho est� certo, e se est� vazio
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String estado, String cidade, String bairro, String rua, String numero) {
		if ((estado != null) && (cidade != null) && (bairro != null) && (rua != null) && (numero != null)) {
			if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty()) && (!numero.isEmpty())) {
				this.endereco = estado + "\n" + cidade + "\n" + bairro + "\n" + rua + "\n" + numero; // salvar tudo separado por \n para ficar mais facil de verificar depois
			} else {
				System.out.println("N�o foi possivel salvar o seu endere�o!");
			}
		} else {
			System.out.println("N�o foi possivel salvar o seu endere�o!");
		}
	}

	public String getTelefone() {
		return telefone;
	}

	
	public void setTelefone(String telefone) {
		if (telefone != null) {
			if ((telefone.length() == 11) && (!telefone.isEmpty())){
				this.telefone = telefone;
			} else {
				System.out.println("N�o foi possivel salvar o telefone!");
			}
		} else {
			System.out.println("N�o foi possivel salvar o telefone!");
		}

	}

}
