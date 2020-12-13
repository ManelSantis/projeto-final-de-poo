package projeto.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import projeto.exception.ExceptionCampoInvalido;
import projeto.model.bo.ResponsavelBO;
import projeto.model.dao.BaseDAO;
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
	public void logar (ActionEvent e) {
		ResponsavelVO resp = new ResponsavelVO();
		try {
			resp.setUsuario(usuario.getText());
			resp.setSenha(senha.getText());
		} catch (ExceptionCampoInvalido e2) {
			aviso.setVisible(true);
		}
		
		ResponsavelBO respon = new ResponsavelBO();
		if ((respon != null )&& (respon.login(resp))) {
			Telas.setUsuario(resp);
			try {
				Telas.telaInicio();
			} catch (Exception e1) {
				aviso.setText("Não foi possivel abrir a tela");
				aviso.setVisible(true);
			}
		} else {
			aviso.setVisible(true);
		}
	}
}
