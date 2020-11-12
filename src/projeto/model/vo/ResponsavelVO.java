package projeto.model.vo;

public class ResponsavelVO extends PessoaVO {
	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if (usuario != null) {
			if (!usuario.isEmpty()) {
				this.usuario = usuario;
			} else {
				System.out.println("Inválido");
			}
		} else {
			System.out.println("Inválido");
		}

	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			if (!senha.isEmpty()) {
				this.senha = senha;
			} else {
				System.out.println("Inválido");
			}
		} else {
			System.out.println("Inválido");
		}
	}

}
