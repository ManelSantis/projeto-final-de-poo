package projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
	private static Connection conn = null;
	private static final String url = "jdbc:postgresql://localhost:5432/ProjetoFinal";
	private static final String user = "postgres";
	private static final String senha = "99725005";
	
	public Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, senha);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		} else return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public abstract void cadastrar(VO vo);
	public abstract void editar(VO vo);
	public abstract void excluir(VO vo);
	public abstract VO findById(VO vo);
	public abstract ArrayList<VO> listar();
	public abstract ArrayList<VO> findByName(VO vo);
	
}
