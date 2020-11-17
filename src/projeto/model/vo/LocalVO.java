package projeto.model.vo;

public class LocalVO {
	private String localizacao;
	private String compartimento;

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String sala, String estante) {
		if ((sala != null) && (estante != null)) {
			if ((!sala.isEmpty()) && (!estante.isEmpty())) {
				this.localizacao = sala + "\n" + estante; // Cadastra informa��o caso realment esteja preenchida.
			}
		} else {
			System.out.println("Informa��o incorreta"); // Informado invalizes caso esteja vazio.
		}

	}

	public String getCompartimento() {
		return compartimento;
	}

	public void setCompartimento(String compartimento) {
		if (compartimento != null) {
			if (!compartimento.isEmpty()) {
				this.compartimento = compartimento;
			} else {
				System.out.println("Informa��o incorreta"); // cadastro n�o aceito
			}
		} else {
			System.out.println("Informa��o incorreta"); // Informado invalizes caso esteja vazio.
		}
		
	}

}