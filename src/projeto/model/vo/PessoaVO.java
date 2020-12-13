package projeto.model.vo;

import projeto.exception.ExceptionCampoInvalido;

public abstract class PessoaVO {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private long idPessoa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ExceptionCampoInvalido {
		if ((nome != null) && (!nome.isEmpty())) {
			this.nome = nome;
		} else {
			throw new ExceptionCampoInvalido("Nome inv�lido");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ExceptionCampoInvalido {
		// Validando
		if ((cpf != null) && (!cpf.isEmpty())) {
			if (cpf.length() == 11) {
				if(cpf.substring(0,10).matches("[0-9]*")) {
					if ((!cpf.equals("00000000000")) && (!cpf.equals("11111111111")) && (!cpf.equals("22222222222"))
						&& (!cpf.equals("33333333333")) && (!cpf.equals("44444444444")) && (!cpf.equals("55555555555"))
						&& (!cpf.equals("66666666666")) && (!cpf.equals("77777777777")) && (!cpf.equals("88888888888"))
						&& (!cpf.equals("99999999999"))) {
						this.cpf = cpf;
					} else {
						//Digitar n�meros repetidos
						throw new ExceptionCampoInvalido("CPF n�o ser apenas n�meros iguais");
					}
				} else {
					//Digitou uma letra
					throw new ExceptionCampoInvalido("CPF s� pode ter n�meros"); 
				}
			} else {
				//Tamanho inv�lido
				throw new ExceptionCampoInvalido("CPF tem que ter pelo menos 11 caracteres"); 
			}
		} else {
			// Se a variavel vier vazia
			throw new ExceptionCampoInvalido("CPF inv�lido"); 
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String estado, String cidade, String bairro, String rua, String numero)
			throws ExceptionCampoInvalido {
		// Ir� verificar se todos os dados passados est�o com
		// alguma coisa escrita para ent�o ser aceito
		if ((estado != null) && (cidade != null) && (bairro != null) && (rua != null) && (numero != null)) {
			if ((!estado.isEmpty()) && (!cidade.isEmpty()) && (!bairro.isEmpty()) && (!rua.isEmpty())
					&& (!numero.isEmpty())) {
				this.endereco = bairro + ", " + rua + ", " + numero + ", " + cidade + ", " + estado;
				// salvar tudo separado por , para ficar mais facil de verificar depois
			} else {
				throw new ExceptionCampoInvalido("Erro ao salvar o endere�o");
			}
		} else {
			throw new ExceptionCampoInvalido("Erro ao salvar o endere�o");
		}
	}

	public void setEndereco(String endereco) {
		// Construtor set usado como auxiliar para o bd
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws ExceptionCampoInvalido {
		// Ainda vendo como fazer uma valida��o melhor
		if ((telefone != null) && (!telefone.isEmpty())) {
			this.telefone = telefone;
		} else {
			throw new ExceptionCampoInvalido("Telefone inv�lido");
		}

	}

	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

}
