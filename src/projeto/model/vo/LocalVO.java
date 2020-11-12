package projeto.model.vo;

public class LocalVO {
	private String localizacao;

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
}