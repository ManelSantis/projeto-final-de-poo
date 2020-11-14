package projeto.model.bo;

import projeto.model.vo.ProdutoVO;

public class ProdutoBO {
	public void cadastrar(String nome, String descricao, float peso,
			String serie, double preco, int quantidade,
			ResponsavelVO responsavel, LocalVO local, String img) {
		// Irá receber os dados dos parametros
		// Repassando para um objeto produto e então encaminhar para ser salvo
		// no banco de dados.
		ProdutoVO pro = new ProdutoVO();
		pro.setNome(nome);
		pro.setDescricao(descricao);
		pro.setPeso(peso);
		pro.setSerie(serie);
		pro.setQuantidade(quantidade);
		pro.setResponsavel(responsavel);
		pro.setLocal(local);
		pro.setImg(img);
	}

	public void pesquisar(ProdutoVO produto) {
		// Irá identificar o produto no banco de dados a partir de qual atributo
		// o usuário selecionou.
	}

	public void excluir(ProtudoVO proex) {
		// Irá localizar no banco de dados o produto a partir do número de série
		// do mesmo para realizar a exclusão.
		String ex = proex.getSerie();

	}

	public void editar (ProdutoVO proed) {
		
		// Irá localizar o produto no banco de dados para realizar a edição.
		// Sendo  passado a alteração para um objeto criado, para então salvar a informação
		// no local selecionado.
		ProdutoVO ed = new ProdutoVO;
		se.setNome("nome");
		se.setDescricao("descricao");
		se.setPeso("peso");
		se.setSerie("serie");
		se.setQuantidade("quantidade");
		se.setResponsavel("responsavel");
		se.setLocal("local");
		se.setImg("img");
	}
}