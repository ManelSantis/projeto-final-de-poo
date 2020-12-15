package projeto.model.bo;

import java.util.ArrayList;

import projeto.model.vo.ProdutoVO;

public interface ProdutoInterBO {
	public void cadastrar(ProdutoVO produto);
	public void excluir(ProdutoVO produto);
	public void editar (ProdutoVO produto);
	public ArrayList<ProdutoVO> listar();
	public ProdutoVO findById(ProdutoVO produto);
	public ArrayList<ProdutoVO> findByNome(ProdutoVO produto);
	public ArrayList<ProdutoVO> findBySerie(ProdutoVO produto);
}
