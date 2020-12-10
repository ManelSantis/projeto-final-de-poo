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
				// Limitar o tamanho do nome do cliente e se está vazio
				// para então ser salvo
			} else {
				System.out.print("Operação invalida");
			}
		} else {
			System.out.print("Operação invalida");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		// Ainda vendo como fazer uma validação melhor
		if (cpf != null) {
			if ((cpf.length() != 11) && (!cpf.isEmpty())) {
				System.out.println("CPF está invalido."); // se o tamnho está certo, e se está vazio
			} else {
				this.cpf = cpf;
			}
		} else {
			System.out.println("CPF está invalido."); // se o tamnho está certo, e se está vazio
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String estado, String cidade, String bairro, String rua, String numero) {
		// Irá verificar se todos os dados passados estão com
		// alguma coisa escrita para então ser aceito
		if ((estado != null) && (cidade != null) && (bairro != null) && (rua != null) && (numero != null)) {
			if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty()) && (!numero.isEmpty())) {
				this.endereco = bairro + ", " + rua + ", " + numero + ", " + cidade + ", " + estado; 
				// salvar tudo separado por , para ficar mais facil de verificar depois
			} else {
				System.out.println("Não foi possivel salvar o seu endereço!");
			}
		} else {
			System.out.println("Não foi possivel salvar o seu endereço!");
		}
	}

	public void setEndereco(String endereco) {
		// Construtor set usado como auxiliar para o bd
		if (endereco != null) {
			if (!endereco.isEmpty()) {
				this.endereco = endereco; 
				// salvar tudo separado por , para ficar mais facil de verificar depois
			} else {
				System.out.println("Não foi possivel salvar o seu endereço!");
			}
		} else {
			System.out.println("Não foi possivel salvar o seu endereço!");
		}
	}

	
	public String getTelefone() {
		return telefone;
	}

	
	public void setTelefone(String telefone) {
		// Ainda vendo como fazer uma validação melhor
		if (telefone != null) {
			if ((telefone.length() >= 10) && (!telefone.isEmpty())){
				this.telefone = telefone;
			} else {
				System.out.println("Não foi possivel salvar o telefone!");
			}
		} else {
			System.out.println("Não foi possivel salvar o telefone!");
		}

	}

	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

}
