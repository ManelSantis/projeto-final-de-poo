package projeto.model.dao;

import projeto.model.vo.PessoaVO;

public interface PessoaInterDAO<VO extends PessoaVO> {
	public boolean cpf(VO vo);
}
