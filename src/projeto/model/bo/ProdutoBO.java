package projeto.model.bo;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;

public class ProdutoBO {
	public void cadastrar(String nome, String descricao, float peso,
			String serie, double preco, int quantK, int quantT,
			ResponsavelVO responsavel, LocalVO local, String img) {
		// Ir� receber os dados dos parametros
		// Repassando para um objeto produto e ent�o encaminhar para ser salvo
		// no banco de dados.
		ProdutoVO pro = new ProdutoVO();
		pro.setNome(nome);
		pro.setDescricao(descricao);
		pro.setPeso(peso);
		pro.setSerie(serie);
		pro.setQuantidade(quantK, quantT);
		pro.setResponsavel(responsavel);
		pro.setLocal(local);
		pro.setImg(img);
	}

	public ProdutoVO[] pesquisar(String pesquisa) {
		// Ir� identificar o produto no banco de dados a partir de qual atributo
		// o usu�rio selecionou, ou a partir do qu�o parecido � a String, e ir�
		// adiciona-los em um vetor de ProdutoVO para ent�o ser mostrado
		int quantProd = 0;
		ProdutoVO produtos[] = new ProdutoVO[quantProd];
		return produtos;
	}

	public void excluir(String serie) {
		// Ir� localizar no banco de dados o produto a partir do n�mero de s�rie
		// do mesmo para realizar a exclus�o.
	}

	public void editar (String serie) {
		// Ir� localizar o produto no banco de dados a partir do
		// n�mero de serie para realizar a edi��o.
		// Sendo passado os dados encontrados para um objeto
		// e ent�o esses podendo ser alterados para
		// ser realizado o update no banco de dados
		ProdutoVO update = new ProdutoVO();

	}
	
}