package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.ProdutoVO;

public class ProdutoBO implements ProdutoInterBO{
	public void cadastrar(ProdutoVO produto) {
		// Irá receber o produto parametrizado
		// Repassando para o banco de dados em ProdutoDAO
		// Verificando se já existe ou não o produto cadastrado
		// E só então vendo se adiciona ou não;
	}

	public ArrayList<ProdutoVO> pesquisar(String pesquisa) {
		// Irá identificar o produto no banco de dados em ProdutoDAO a partir de qual atributo
		// o usuário selecionou, ou a partir do quão parecido é a String, e irá
		// adiciona-los em uma ArrayList para então serem exibidas aqui
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		return produtos;
	}

	public void excluir(ProdutoVO produto) {
		// Irá localizar no banco de dados o ProdutoVO parametrizado
		// utilizando ProdutoDAO para então poder realizar a exclusão
	}

	public void editar (ProdutoVO produto) {
		// Irá localizar o ProdutoVO usando ProdutoDAO
		// mandando os dados para a pagina de edição
		// lá podendo serem editados antes de serem mandados
		// de volta para ProdutoDAO para o update
	}
	
}