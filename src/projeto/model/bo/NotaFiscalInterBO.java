package projeto.model.bo;

import java.util.ArrayList;
import java.util.Calendar;

import projeto.model.vo.NotaFiscalVO;
import projeto.model.vo.VendaVO;

public interface NotaFiscalInterBO {
	public void cadastrar (NotaFiscalVO nota);
	public ArrayList<VendaVO> listar();
	public ArrayList<VendaVO> relatorio(Calendar comeco, Calendar fim);
}