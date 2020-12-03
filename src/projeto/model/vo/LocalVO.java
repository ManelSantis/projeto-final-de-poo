package projeto.model.vo;

public class LocalVO {
	private String localizacao;
	private long id;
	private ResponsavelVO responsavel;

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		if (localizacao != null) {
			if (!localizacao.isEmpty()) {
				this.localizacao = localizacao; 
				// Cadastra informa��o caso realment esteja preenchida.
			}
		} else {
			System.out.println("Informa��o incorreta"); // Informado invalizes caso esteja vazio.
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
			System.out.println("N�o foi possivel adicionar responsavel");
		}
	}

}