package br.com.zupacademy.mariel.casadocodigo.livro;

import java.math.BigDecimal;

import br.com.zupacademy.mariel.casadocodigo.autor.AutorResponseDto;

public class DetalhesLivroResponseDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private String isbn;

	private Integer paginas;

	private BigDecimal preco;

	private AutorResponseDto autor;

	public DetalhesLivroResponseDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.isbn = livro.getIsbn();
		this.paginas = livro.getPaginas();
		this.preco = livro.getPreco();
		this.autor = new AutorResponseDto(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public AutorResponseDto getAutor() {
		return autor;
	}

}
