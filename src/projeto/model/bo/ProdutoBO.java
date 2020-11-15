package projeto.model.bo;

import projeto.model.vo.LocalVO;
import projeto.model.vo.ProdutoVO;
import projeto.model.vo.ResponsavelVO;

public class ProdutoBO {
	public void cadastrar(String nome, String descricao, float peso,
			String serie, double preco, int quantK, int quantT,
			ResponsavelVO responsavel, LocalVO local, String img) {
		// Irá receber os dados dos parametros
		// Repassando para um objeto produto e então encaminhar para ser salvo
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
		// Irá identificar o produto no banco de dados a partir de qual atributo
		// o usuário selecionou, ou a partir do quão parecido é a String, e irá
		// adiciona-los em um vetor de ProdutoVO para então ser mostrado
		int quantProd = 0;
		ProdutoVO produtos[] = new ProdutoVO[quantProd];
		return produtos;
	}

	public void excluir(String serie) {
		// Irá localizar no banco de dados o produto a partir do número de série
		// do mesmo para realizar a exclusão.
	}

	public void editar (String serie) {
		// Irá localizar o produto no banco de dados a partir do
		// número de serie para realizar a edição.
		// Sendo passado os dados encontrados para um objeto
		// e então esses podendo ser alterados para
		// ser realizado o update no banco de dados
		ProdutoVO update = new ProdutoVO();

	}
	
}