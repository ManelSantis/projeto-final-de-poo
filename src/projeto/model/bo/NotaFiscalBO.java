package projeto.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import projeto.exception.ExceptionCampoInvalido;
import projeto.model.dao.NotaFiscalDAO;
import projeto.model.vo.ClienteVO;
import projeto.model.vo.NotaFiscalVO;
import projeto.model.vo.ResponsavelVO;
import projeto.model.vo.VendaVO;
import java.util.Date;

public class NotaFiscalBO implements NotaFiscalInterBO {
	NotaFiscalDAO note = new NotaFiscalDAO();

	public void cadastrar(NotaFiscalVO nota) {
		// Esse metodo irá imprimir a nota fiscal da
		// Venda que está sendo posta como atributo
		// em NotaFiscalVO
		note.cadastrar(nota.getVenda());
	}

	public ArrayList<VendaVO> listar() {
		ResultSet rs = note.listar();
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();

		try {
			while (rs.next()) {
				VendaVO aux = new VendaVO();

				ResponsavelVO aux1 = new ResponsavelVO();
				aux1.setNome(rs.getString("nomeResp"));
				aux1.setCpf(rs.getString("cpfResp"));

				ClienteVO aux3 = new ClienteVO();
				aux3.setNome(rs.getString("nomeCli"));
				aux3.setCpf(rs.getString("cpfCli"));

				aux.setCliente(aux3);
				aux.setResponsavel(aux1);
				Date data = (rs.getDate("data"));
				
				Calendar aux5 = Calendar.getInstance();
				aux5.setTime(data);
				aux.setData(aux5);
				
				aux.setCodigo(rs.getString("codigo"));

				aux.setValor(rs.getDouble("valor"));

				vendas.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vendas;
	}
	
	public ArrayList<VendaVO> relatorio(Calendar comeco, Calendar fim){
		ResultSet rs = note.periodo(comeco, fim);
		ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();

		try {
			while (rs.next()) {
				VendaVO aux = new VendaVO();

				ResponsavelVO aux1 = new ResponsavelVO();
				aux1.setNome(rs.getString("nomeResp"));
				aux1.setCpf(rs.getString("cpfResp"));

				ClienteVO aux3 = new ClienteVO();
				aux3.setNome(rs.getString("nomeCli"));
				aux3.setCpf(rs.getString("cpfCli"));

				aux.setCliente(aux3);
				aux.setResponsavel(aux1);
				Date data = (rs.getDate("data"));
				
				Calendar aux5 = Calendar.getInstance();
				aux5.setTime(data);
				aux.setData(aux5);
				
				aux.setCodigo(rs.getString("codigo"));

				aux.setValor(rs.getDouble("valor"));

				vendas.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionCampoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vendas;
	}

}
