package projeto.model.bo;

import projeto.model.vo.EstoqueVO;

public interface EstoqueInterBO {
	public void cadastrar(EstoqueVO estoque);
	public void editar(EstoqueVO estoque);
	public void excluir(EstoqueVO estoque);
}
