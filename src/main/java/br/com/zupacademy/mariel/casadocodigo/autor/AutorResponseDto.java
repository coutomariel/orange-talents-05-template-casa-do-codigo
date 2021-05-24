package br.com.zupacademy.mariel.casadocodigo.autor;

public class AutorResponseDto {

	private String nome;
	private String descricao;

	public AutorResponseDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
