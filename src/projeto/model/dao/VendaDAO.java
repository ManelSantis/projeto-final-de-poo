package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.model.vo.VendaVO;

public class VendaDAO extends BaseDAO{
	public void confirmarVenda (VendaVO venda) {
		conn = getConnection();
		String sql = "insert into pedido (idCliente, idResponsavel, idVenda) values (?, ?, ?)";
		//primeiro ser� feito um insert na tabela pedido, aonde ser� salvado
		//o valor total da venda como default 0, que ser� incrementado
		//a cada item que � adicionado em itempedido com o mesmo id de venda
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, venda.getCliente().getCpf());
			ptst.setString(2, venda.getResponsavel().getCpf());
			ptst.setString(3, venda.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//salvar os itens que est�o sendo pedidos na venda dentro da tabela itemPedido
		sql = "insert into itempedido (idVenda, idProduto, quantidade) values (?, ?, ?)";
		try {
			ptst = conn.prepareStatement(sql);
			for (int i = 0; i < venda.getCarrinho().size(); i++) {
				ptst.setString(1, venda.getCodigo()); //salva o c�digo da venda
				ptst.setString(2, venda.getCarrinho().get(i).getSerie()); //salva o c�digo do pedido
				ptst.setInt(3, venda.getCarrinho().get(i).getQuantiPedido()); //salva a quantidade que est� sendo pedida
				ptst.execute();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//finalmente confirmar a venda
		sql = "insert into venda (idvenda, data, hora) values (?, current_date, current_time)";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, venda.getCodigo()); //salva o c�digo da venda
			ptst.execute();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancelarVenda (VendaVO venda) {
		conn = getConnection();
		String sql = "delete cascade from venda where idvenda = ?";
		//ir� deletar e todos os itens que dependem dela 
		//que estiverem em itempedido e em pedido
		//junto dela
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, venda.getCodigo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

