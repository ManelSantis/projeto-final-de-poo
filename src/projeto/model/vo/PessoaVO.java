package projeto.model.vo;

public abstract class PessoaVO {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private long idPessoa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			if ((nome.length() <= 100) && (!nome.isEmpty())) {
				this.nome = nome; 
				// Limitar o tamanho do nome do cliente e se est� vazio
				// para ent�o ser salvo
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
		// Ainda vendo como fazer uma valida��o melhor
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
		// Ir� verificar se todos os dados passados est�o com
		// alguma coisa escrita para ent�o ser aceito
		if ((estado != null) && (cidade != null) && (bairro != null) && (rua != null) && (numero != null)) {
			if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty()) && (!numero.isEmpty())) {
				this.endereco = bairro + ", " + rua + ", " + numero + ", " + cidade + ", " + estado; 
				// salvar tudo separado por , para ficar mais facil de verificar depois
			} else {
				System.out.println("N�o foi possivel salvar o seu endere�o!");
			}
		} else {
			System.out.println("N�o foi possivel salvar o seu endere�o!");
		}
	}

	public void setEndereco(String endereco) {
		// Construtor set usado como auxiliar para o bd
		if (endereco != null) {
			if (!endereco.isEmpty()) {
				this.endereco = endereco; 
				// salvar tudo separado por , para ficar mais facil de verificar depois
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
		// Ainda vendo como fazer uma valida��o melhor
		if (telefone != null) {
			if ((telefone.length() >= 10) && (!telefone.isEmpty())){
				this.telefone = telefone;
			} else {
				System.out.println("N�o foi possivel salvar o telefone!");
			}
		} else {
			System.out.println("N�o foi possivel salvar o telefone!");
		}

	}

	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

}
