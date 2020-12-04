package projeto.model.dao;

import java.sql.ResultSet;

import projeto.model.vo.ResponsavelVO;

public interface LocalInterDAO {
	public ResultSet listarPorResponsavel(ResponsavelVO responsavel);
}
