package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.model.vo.VendaVO;

public class PedidoDAO extends BaseDAO<VendaVO>{

	@Override
	public void cadastrar(VendaVO venda) {
		String sql = "insert into pedido (idCliente, idResponsavel) values (?, ?);";
		// primeiro ser� feito um insert na tabela pedido, aonde ser� salvado
		// o valor total da venda como default 0, que ser� incrementado
		// a cada item que � adicionado em itempedido com o mesmo id de venda
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, venda.getCliente().getId());
			ptst.setLong(2, venda.getResponsavel().getId());
			int linhas = ptst.executeUpdate();
			
			if (linhas == 0) {
				throw new SQLException ("Nada foi adicionado.");
			}
			ResultSet rs = ptst.getGeneratedKeys();
			if (rs.next()) {
				venda.setId(rs.getLong(1));
			} else {
				throw new SQLException ("Falhou");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editar(VendaVO venda) {
		// como o responsavel adicionado na venda � o que estiver logado
		// a unica coisa editavel seria o cliente
		
		String sql = "update pedido set idcliente = ?  where idpedido = ?;";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, venda.getCliente().getId());
			ptst.setLong(2, venda.getId());
			int linhas = ptst.executeUpdate();
			if (linhas == 0) {
				throw new SQLException ("Nada foi editado.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(VendaVO vo) {
		// em venda tudo j� � deletado
		
	}

	@Override
	public ResultSet findById(VendaVO vo) {
		//n�o � necessario encontrar o pedido pelo id, j� � encotnrada
		// a venda por id
		return null;
	}

	@Override
	public ResultSet listar() {
		// j� � listada a venda
		return null;
	}

	@Override
	public ResultSet findByName(VendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
