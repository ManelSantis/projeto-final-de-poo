package projeto.model.bo;

import java.util.ArrayList;
import projeto.model.vo.ProdutoVO;

public class ProdutoBO implements ProdutoInterBO{
	public void cadastrar(ProdutoVO produto) {
		// Ir� receber o produto parametrizado
		// Repassando para o banco de dados em ProdutoDAO
		// Verificando se j� existe ou n�o o produto cadastrado
		// E s� ent�o vendo se adiciona ou n�o;
	}

	public ArrayList<ProdutoVO> pesquisar(String pesquisa) {
		// Ir� identificar o produto no banco de dados em ProdutoDAO a partir de qual atributo
		// o usu�rio selecionou, ou a partir do qu�o parecido � a String, e ir�
		// adiciona-los em uma ArrayList para ent�o serem exibidas aqui
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		return produtos;
	}

	public void excluir(ProdutoVO produto) {
		// Ir� localizar no banco de dados o ProdutoVO parametrizado
		// utilizando ProdutoDAO para ent�o poder realizar a exclus�o
	}

	public void editar (ProdutoVO produto) {
		// Ir� localizar o ProdutoVO usando ProdutoDAO
		// mandando os dados para a pagina de edi��o
		// l� podendo serem editados antes de serem mandados
		// de volta para ProdutoDAO para o update
	}
	
}