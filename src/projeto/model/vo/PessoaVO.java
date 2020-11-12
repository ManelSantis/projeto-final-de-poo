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
				this.nome = nome; // limitar o tamanho do nome do cliente e se está vazio
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
		if ((estado != null) && (cidade != null) && (bairro != null) && (rua != null) && (numero != null)) {
			if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty()) && (!numero.isEmpty())) {
				this.endereco = estado + "\n" + cidade + "\n" + bairro + "\n" + rua + "\n" + numero; // salvar tudo separado por \n para ficar mais facil de verificar depois
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
		if (telefone != null) {
			if ((telefone.length() == 11) && (!telefone.isEmpty())){
				this.telefone = telefone;
			} else {
				System.out.println("Não foi possivel salvar o telefone!");
			}
		} else {
			System.out.println("Não foi possivel salvar o telefone!");
		}

	}

}
