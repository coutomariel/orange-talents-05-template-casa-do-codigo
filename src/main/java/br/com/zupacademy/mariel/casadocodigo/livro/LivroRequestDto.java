package br.com.zupacademy.mariel.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mariel.casadocodigo.autor.Autor;
import br.com.zupacademy.mariel.casadocodigo.autor.AutoresRepository;
import br.com.zupacademy.mariel.casadocodigo.categoria.Categoria;
import br.com.zupacademy.mariel.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.mariel.casadocodigo.common.validators.ExistsByAttribute;
import br.com.zupacademy.mariel.casadocodigo.common.validators.Unique;

public class LivroRequestDto {

	@NotBlank
	@Unique(entity = Livro.class, attribute = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@DecimalMin(value = "20.0")
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	private Integer paginas;

	@NotBlank
	@Unique(entity = Livro.class, attribute = "isbn")
	private String isbn;

	@Future
	@NotNull
	private LocalDate dataPublicacao;

	@NotNull
	@ExistsByAttribute(entity = Autor.class, attribute = "id")
	private Long autorId;

	@NotNull
	@ExistsByAttribute(entity = Categoria.class, attribute = "id")
	private Long categoriaId;

	public Livro toEntity(AutoresRepository autoresRepository, CategoriaRepository categoriasRepository) {

		Autor autor = autoresRepository.findById(autorId).get();
		Categoria categoria = categoriasRepository.findById(categoriaId).get();
		
		return new Livro(this.titulo, this.resumo, this.sumario, new BigDecimal(this.preco.toString()), this.paginas,
				this.isbn, this.dataPublicacao, autor, categoria);
		
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

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

}
