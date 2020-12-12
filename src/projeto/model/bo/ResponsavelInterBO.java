package projeto.model.bo;

import java.util.ArrayList;
import java.util.Calendar;

import projeto.model.vo.EstoqueVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;

public interface ResponsavelInterBO {
	public ArrayList<ProdutoVO> estoque();
	public ArrayList<VendaVO> historicoDeVendas(ResponsavelVO resp);
	public ArrayList<VendaVO> relatorio(Calendar inicio, Calendar fim);
	public boolean login(ResponsavelVO resp);
}
