package projeto.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ResponsavelVO;
import projeto.view.Telas;
import projeto.model.dao.LocalDAO;
public class LocalBO implements LocalInterBO {
	LocalDAO loca = new LocalDAO();
	public void cadastrar(LocalVO local) {
		loca.cadastrar(local);
	}
	
	public void editar(LocalVO local) {
		loca.editar(local);
	}
	
	public void excluir(LocalVO local) {
		loca.excluir(local);
	}

	public ArrayList<LocalVO> listar() {
		ResponsavelVO responsavel = Telas.getUsuario();
		ResultSet rs = loca.listarPorResponsavel(responsavel);
		ArrayList<LocalVO> loc = new ArrayList<LocalVO>();
		try {
			while (rs.next()) {
				LocalVO aux = new LocalVO();
				aux.setLocalizacao(rs.getString("localizacao"));
				aux.setId(rs.getLong("idlocal"));
				aux.setResponsavel(responsavel);
				loc.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loc;
}

	@Override
	public ArrayList<LocalVO> listar(ResponsavelVO responsavel) {
		// TODO Auto-generated method stub
		return null;
	}
}
