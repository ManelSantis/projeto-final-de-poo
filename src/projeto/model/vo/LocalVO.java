package projeto.model.vo;

public class LocalVO {
	private String localizacao;
	private int compartimento;
	private ResponsavelVO responsavel;

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String sala, String estante) {
		if ((sala != null) && (estante != null)) {
			if ((!sala.isEmpty()) && (!estante.isEmpty())) {
				this.localizacao = sala + "\n" + estante; // Cadastra informação caso realment esteja preenchida.
			}
		} else {
			System.out.println("Informação incorreta"); // Informado invalizes caso esteja vazio.
		}

	}

	public int getCompartimento() {
		return compartimento;
	}

	public void setCompartimento(int compartimento) {
		this.compartimento = compartimento;		
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

}