package projeto.model.bo;

import java.util.ArrayList;

import projeto.model.vo.ProdutoVO;

public interface ProdutoInterBO {
	public void cadastrar(ProdutoVO produto);
	public ArrayList<ProdutoVO> pesquisar(String pesquisa);
	public void excluir(ProdutoVO produto);
	public void editar (ProdutoVO produto);
}
