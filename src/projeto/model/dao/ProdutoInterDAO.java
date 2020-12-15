package projeto.model.dao;

import java.sql.ResultSet;

import projeto.model.vo.ProdutoVO;

public interface ProdutoInterDAO {
	public ResultSet findBySerie(ProdutoVO prod);
	public boolean serie (ProdutoVO prod);
}
