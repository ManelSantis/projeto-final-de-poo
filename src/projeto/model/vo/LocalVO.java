package projeto.model.vo;

public class LocalVO {
	private String localizacao;
	private String compartimento;
	private long id;
	private ResponsavelVO responsavel;

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		if (localizacao != null) {
			if (!localizacao.isEmpty()) {
				this.localizacao = localizacao; 
				// Cadastra informação caso realment esteja preenchida.
			}
		} else {
			System.out.println("Informação incorreta"); // Informado invalizes caso esteja vazio.
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
		} else {
			System.out.println("Não foi possivel adicionar responsavel");
		}
	}

	public String getCompartimento() {
		return compartimento;
	}

	public void setCompartimento(String compartimento) {
		if((compartimento != null) && (!compartimento.isEmpty())) {
			this.compartimento = compartimento;	
		}
	}

}