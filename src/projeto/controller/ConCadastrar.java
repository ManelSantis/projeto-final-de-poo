package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import projeto.model.bo.ClienteBO;
import projeto.model.bo.ResponsavelBO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;

public class ConCadastrar extends ConMenu implements Initializable {
	private static ResponsavelVO respEditavel; //objeto responsavel que será usado para editar
	private static boolean editarResp; //se for true, irá editar responsavel
	private static boolean deletarResp;
	private static ClienteVO cliEditavel; //objeto cliente que será usado para editar
	private static boolean editarCli; //se for true, irá editar cliente
	private static boolean deletarCli;
	
	@FXML
	private TextField senha;
	@FXML
	private TextField cidade;
	@FXML
	private TextField telefone;
	@FXML
	private TextField estado;
	@FXML
	private Button cancelar;
	@FXML
	private Button confirmar;
	@FXML
	private TextField numero;
	@FXML
	private TextField bairro;
	@FXML
	private TextField cpf;
	@FXML
	private TextField nome;
	@FXML
	private TextField usuario;
	@FXML
	private TextField rua;
	@FXML
	private Label NOME;
	@FXML
	private Label CPF;
	

	public void cliente(ActionEvent e) throws Exception {
		Telas.telaClienteInicio();
	}

	public void responsavel(ActionEvent e) throws Exception {
		Telas.telaResponsavelInicio();
	}

	public void cadastrarResp() throws Exception {
		ResponsavelVO respon = new ResponsavelVO();
		ResponsavelBO salvar = new ResponsavelBO();
		respon.setNome(nome.getText());
		respon.setCpf(cpf.getText());
		respon.setUsuario(usuario.getText());
		respon.setSenha(senha.getText());
		respon.setEndereco(estado.getText(), cidade.getText(), bairro.getText(), rua.getText(), numero.getText());
		respon.setTelefone(telefone.getText());
		salvar.cadastrar(respon);
		Telas.telaResponsavelInicio();
	}
	
	public void cadastrarCli() throws Exception {
		ClienteVO cli = new ClienteVO();
		ClienteBO salvar = new ClienteBO();
		cli.setNome(nome.getText());
		cli.setCpf(cpf.getText());
		cli.setEndereco(estado.getText(), cidade.getText(), bairro.getText(), rua.getText(), numero.getText());
		cli.setTelefone(telefone.getText());
		salvar.cadastrar(cli);
		Telas.telaClienteInicio();
	}
	
	public void editarResp(){
		//adiciona todos os campos com os dados de responsavel que serão editados
		nome.setText(respEditavel.getNome());
		cpf.setText(respEditavel.getCpf());
		telefone.setText(respEditavel.getTelefone());
		String[] enderecoCompleto = respEditavel.getEndereco().split(",");
		bairro.setText(enderecoCompleto[0]);
		rua.setText(enderecoCompleto[1]);
		numero.setText(enderecoCompleto[2]);
		cidade.setText(enderecoCompleto[3]);
		estado.setText(enderecoCompleto[4]);
		usuario.setText(respEditavel.getUsuario());
		senha.setText(respEditavel.getSenha());
	}
	
	public void editarCli(){
		//adiciona todos os campos com os dados de cliente que vão ser editados
		System.out.print(cliEditavel.getNome());
		nome.setText(cliEditavel.getNome());
		cpf.setText(cliEditavel.getCpf());
		telefone.setText(cliEditavel.getTelefone());
		String[] enderecoCompleto = cliEditavel.getEndereco().split(",");
		bairro.setText(enderecoCompleto[0]);
		rua.setText(enderecoCompleto[1]);
		numero.setText(enderecoCompleto[2]);
		cidade.setText(enderecoCompleto[3]);
		estado.setText(enderecoCompleto[4]);
	}
	
	public void editar() {
		if (usuario != null) {
			ResponsavelBO aux = new ResponsavelBO();
			respEditavel.setNome(nome.getText());
			respEditavel.setCpf(cpf.getText());
			respEditavel.setEndereco(estado.getText(), cidade.getText(), bairro.getText(), rua.getText(), numero.getText());
			respEditavel.setTelefone(telefone.getText());
			respEditavel.setUsuario(usuario.getText());
			respEditavel.setSenha(senha.getText());
			aux.editar(respEditavel);
			
			setEditarCli(false);
			setEditarResp(false);
			
			try {
				Telas.telaResponsavelInicio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ClienteBO aux = new ClienteBO();
			cliEditavel.setNome(nome.getText());
			cliEditavel.setCpf(cpf.getText());
			cliEditavel.setEndereco(estado.getText(), cidade.getText(), bairro.getText(), rua.getText(), numero.getText());
			cliEditavel.setTelefone(telefone.getText());
			aux.editar(cliEditavel);
			
			setEditarCli(false);
			setEditarResp(false);
			
			try {
				Telas.telaClienteInicio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deletarResp() {
		NOME.setText(respEditavel.getNome());
		CPF.setText(respEditavel.getCpf());
	}
	
	public void deletarCli() {
		NOME.setText(cliEditavel.getNome());
		CPF.setText(cliEditavel.getCpf());
	}
	
	public void excluir() {
		if (deletarResp) {
			ResponsavelBO aux = new ResponsavelBO();
			aux.excluir(respEditavel);
			setDeletarResp(false);
			setDeletarCli(false);
			
			try {
				Telas.telaResponsavelInicio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(deletarCli) {
			ClienteBO aux = new ClienteBO();
			aux.excluir(cliEditavel);
			setDeletarResp(false);
			setDeletarCli(false);
			
			try {
				Telas.telaClienteInicio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//ao iniciar o controllador, verifica se o que está ocorrendo é uma edição ou deleção de cliente ou responsavel
		if (editarResp) {
			editarResp();
		}
		if(editarCli) {
			editarCli();
		}
		
		if(deletarResp) {
			deletarResp();
		}
		
		if(deletarCli) {
			deletarCli();
		}
	}

	
	//gets e sets das variaveis estaticas 
	public static ResponsavelVO getRespEditavel() {
		return respEditavel;
	}

	public static void setRespEditavel(ResponsavelVO editavel) throws Exception {
		ConCadastrar.respEditavel = editavel;
	}

	public static boolean isEditarResp() {
		return editarResp;
	}

	public static void setEditarResp(boolean editar) {
		ConCadastrar.editarResp = editar;
	}

	public static ClienteVO getCliEditavel() {
		return cliEditavel;
	}

	public static void setCliEditavel(ClienteVO cliEditavel) {
		ConCadastrar.cliEditavel = cliEditavel;
	}

	public static boolean isEditarCli() {
		return editarCli;
	}

	public static void setEditarCli(boolean editarCli) {
		ConCadastrar.editarCli = editarCli;
	}

	public static boolean isDeletarResp() {
		return deletarResp;
	}

	public static void setDeletarResp(boolean deletarResp) {
		ConCadastrar.deletarResp = deletarResp;
	}

	public static boolean isDeletarCli() {
		return deletarCli;
	}

	public static void setDeletarCli(boolean deletarCli) {
		ConCadastrar.deletarCli = deletarCli;
	}
}
