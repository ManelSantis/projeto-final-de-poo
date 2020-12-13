package projeto.model.vo;

import projeto.exception.ExceptionCampoInvalido;
import projeto.exception.ExceptionLoginExistente;
import projeto.model.dao.ResponsavelDAO;

public class ResponsavelVO extends PessoaVO {
	private String usuario;
	private String senha;
	private long id;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuarioAux(String usuario) throws ExceptionLoginExistente {
		// usado para verificar se o usuario j� existe no banco de dados
		ResponsavelDAO aux = new ResponsavelDAO();
		ResponsavelVO x = new ResponsavelVO();
		try {
			x.setUsuario(usuario);
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (aux.buscarLogin(x)) {
			throw new ExceptionLoginExistente("Usu�rio j� existe");
		} else return;
	}

	public void setUsuario(String usuario) throws ExceptionCampoInvalido {
		if ((usuario != null) && (!usuario.isEmpty())) {
			this.usuario = usuario;
		} else {
			throw new ExceptionCampoInvalido("Usu�rio inv�lido");
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
				throw new ExceptionCampoInvalido("Senha precisa ter pelo menos 5 caracteres");
			}
		} else {
			throw new ExceptionCampoInvalido("Senha inv�lida");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
