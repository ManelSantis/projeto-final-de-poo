package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.model.vo.LocalVO;
import projeto.model.vo.PessoaVO;
import projeto.model.vo.VendaVO;

public class LocalDAO extends BaseDao{
	public void  cadastrar (LocalVO loca){
		conn = getConnection();
		String sql =  "insert into pessoa (localizacao,compartimento,responsavel) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, loca.getLocalizacao());
			ptst.setString(2, loca.getCompartimento());
			((Responsavel) ptst).setResponsavel(3, loca.getResponsavel());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void remover (LocalVO loca){
		conn = getConnection();
		String sql =  "select from local where localizacao = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, loca.getLocalizacao());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(LocalVO loca) {
		conn = getConnection();
		String sql =  "update from local where localizacao = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, loca.getLocalizacao());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}