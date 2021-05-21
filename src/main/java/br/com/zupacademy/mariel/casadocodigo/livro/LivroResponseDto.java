package br.com.zupacademy.mariel.casadocodigo.livro;

public class LivroResponseDto {

	private Long id;
	private String nome;
	
	public LivroResponseDto(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
