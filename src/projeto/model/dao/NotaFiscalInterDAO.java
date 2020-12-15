package projeto.model.dao;

import java.sql.ResultSet;
import java.util.Calendar;

public interface NotaFiscalInterDAO {
	public ResultSet periodo(Calendar inicio, Calendar fim);
}
