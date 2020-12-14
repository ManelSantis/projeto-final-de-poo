package projeto.model.bo;

import java.util.ArrayList;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ResponsavelVO;

public interface LocalInterBO {
	public void cadastrar(LocalVO local);
	public void editar(LocalVO local);
	public void excluir(LocalVO local);
	public ArrayList<LocalVO> listar();
	public ArrayList<LocalVO> compartimento(LocalVO local);
	public ArrayList<LocalVO> localizacao(LocalVO local);
}
