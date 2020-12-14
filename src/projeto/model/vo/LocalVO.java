package projeto.model.vo;

import projeto.exception.ExceptionCampoInvalido;

public class LocalVO {
	private String localizacao;
	private String compartimento;
	private long id;
	private ResponsavelVO responsavel;

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) throws ExceptionCampoInvalido {
		if (localizacao != null) {
			if (!localizacao.isEmpty()) {
				this.localizacao = localizacao; 
				// Cadastra informação caso realment esteja preenchida.
			}
		} else {
			throw new ExceptionCampoInvalido("Localização inválida"); //Informado invalizes caso esteja vazio.
		}

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;		
	}

	public ResponsavelVO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelVO responsavel) {
		if (responsavel != null) {
			this.responsavel = responsavel;	
		}
	}

	public String getCompartimento() {
		return compartimento;
	}

	public void setCompartimento(String compartimento) throws ExceptionCampoInvalido {
		if((compartimento != null) && (!compartimento.isEmpty())) {
			this.compartimento = compartimento;	
		} else {
			throw new ExceptionCampoInvalido("Conpartimento inválido");
		}
	}

}