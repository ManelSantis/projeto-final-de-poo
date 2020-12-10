package projeto.model.dao;

import java.util.ArrayList;

import projeto.model.vo.ClienteVO;
import projeto.model.vo.ResponsavelVO;

public class teste{
	public static void main (String args []){
		//ArrayList<ClienteVO> c = new ArrayList<ClienteVO>();
		ResponsavelDAO cd = new ResponsavelDAO();
		ResponsavelVO cv = new ResponsavelVO();
		cv.setNome("Kanalense dos Santos");
		cv.setCpf("15441491224");
		cv.setEndereco("RN", "Assu", "Pizza", "Rua do Poste", "1125");
		cv.setTelefone("84779725005");
		cv.setUsuario("Kanalense");
		cv.setSenha("123456789");
		cd.cadastrar(cv);
		
	}
}
