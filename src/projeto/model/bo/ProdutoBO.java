package projeto.model.bo;

import java.util.ArrayList;

import projeto.model.dao.ProdutoDAO;
import projeto.model.vo.ProdutoVO;

public class ProdutoBO implements ProdutoInterBO{
	ProdutoDAO prod = new ProdutoDAO();
	public void cadastrar(ProdutoVO produto) {
		prod.cadastrar(produto);
	}

	public ArrayList<ProdutoVO> pesquisar(String pesquisa) {
		// Ir� identificar o produto no banco de dados em ProdutoDAO a partir de qual atributo
		// o usu�rio selecionou, ou a partir do qu�o parecido � a String, e ir�
		// adiciona-los em uma ArrayList para ent�o serem exibidas aqui
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		return produtos;
	}

	public void excluir(ProdutoVO produto) {
		prod.excluir(produto);
	}

	public void editar (ProdutoVO produto) {
		prod.editar(produto);
	}
	
}