package projeto.model.bo;

import java.util.ArrayList;
import java.util.Calendar;

import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;

public interface ResponsavelInterBO {
	public ArrayList<ProdutoVO> estoque(ResponsavelVO resp);
	public ArrayList<VendaVO> historicoDeVendas(ResponsavelVO resp);
	public ArrayList<VendaVO> relatorio(Calendar inicio, Calendar fim);
	public void login(String usuario, String senha);
}
