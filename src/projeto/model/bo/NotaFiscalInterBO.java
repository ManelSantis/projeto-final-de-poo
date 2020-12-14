package projeto.model.bo;

import java.util.ArrayList;

import projeto.model.vo.NotaFiscalVO;
import projeto.model.vo.VendaVO;

public interface NotaFiscalInterBO {
	public void cadastrar (NotaFiscalVO nota);
	public ArrayList<VendaVO> listar();
}