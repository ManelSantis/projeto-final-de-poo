package projeto.model.bo;

import projeto.model.vo.ProdutoVO;

public class ProdutoBO {
	public void cadastrar(String nome, String descricao, float peso,
			String serie, double preco, int quantidade,
			ResponsavelVO responsavel, LocalVO local, String img) {
		// Ir� receber os dados dos parametros
		// Repassando para um objeto produto e ent�o encaminhar para ser salvo
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
		// Ir� identificar o produto no banco de dados a partir de qual atributo
		// o usu�rio selecionou.
	}

	public void excluir(ProtudoVO proex) {
		// Ir� localizar no banco de dados o produto a partir do n�mero de s�rie
		// do mesmo para realizar a exclus�o.
		String ex = proex.getSerie();

	}

	public void editar (ProdutoVO proed) {
		
		// Ir� localizar o produto no banco de dados para realizar a edi��o.
		// Sendo  passado a altera��o para um objeto criado, para ent�o salvar a informa��o
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