package projeto.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import projeto.model.bo.ResponsavelBO;
import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;

public class ConLogin {
	
	@FXML
	private TextField usuario;
	
	@FXML
    private PasswordField senha;
	
	@FXML
    private Label aviso;
	
	@FXML
	public void logar (ActionEvent e) throws Exception {
		
		ResponsavelVO resp = new ResponsavelVO();
		resp.setUsuario(usuario.getText());
		resp.setSenha(senha.getText());
		
		ResponsavelBO respon = new ResponsavelBO();
		if ((respon != null )&& (respon.login(resp))) {
			Telas.setUsuario(resp);
			Telas.telaInicio();
			
		} else {
			aviso.setVisible(true);
		}
	}
}
