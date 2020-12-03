package projeto.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface BaseInterDAO<VO> {
	public Connection getConnection();
	public abstract void cadastrar(VO entity);
	public abstract void editar(VO entity);
	public abstract void excluir(VO entity);
	public abstract VO findById(VO entity);
	public abstract ArrayList<VO> listar();
	public abstract ArrayList<VO> findByName(VO entity);
	
}
