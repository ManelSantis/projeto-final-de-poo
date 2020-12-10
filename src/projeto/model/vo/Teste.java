package projeto.model.vo;

public class Teste {
	public static void main(String args[]) {
		ProdutoVO p = new ProdutoVO();
		p.setNome("PenDrive");
		p.setDescricao("asasdas");
		p.setImg("AASDASDAD");
		p.setSerie("aloskdiempadr");
		p.setPeso(1.5);
		p.setPreco(58.5);
		EstoqueVO e = new EstoqueVO();
		e.setProduto(p);
		System.out.println(p.getQuantidade());
		e.setQuantidade(5);
		System.out.println(p.getQuantidade());
		e.setQuantidade(-2);
		System.out.println(p.getQuantidade());
		e.setQuantidade(5);
		System.out.println(p.getQuantidade());
		e.setQuantidade(-10);
		System.out.println(p.getQuantidade());
	}
}
