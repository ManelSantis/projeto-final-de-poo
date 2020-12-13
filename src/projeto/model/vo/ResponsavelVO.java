package projeto.model.vo;

import projeto.exception.ExceptionCampoInvalido;
import projeto.model.dao.ResponsavelDAO;

public class ResponsavelVO extends PessoaVO {
	private String usuario;
	private String senha;
	private long id;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuarioAux(String usuario) {
		// usado para verificar se o usuario já existe no banco de dados
		this.usuario = usuario;
	}

	public void setUsuario(String usuario) throws ExceptionCampoInvalido {
		if ((usuario != null) && (!usuario.isEmpty())) {
			this.usuario = usuario;
		} else {
			throw new ExceptionCampoInvalido("Usuário inválido");
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws ExceptionCampoInvalido {
		if ((senha != null) && (!senha.isEmpty())) {
			if (senha.length() >= 5) {
				this.senha = senha;
			} else {
				throw new ExceptionCampoInvalido("Senha inválida");
			}
		} else {
			throw new ExceptionCampoInvalido("Senha inválida");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
