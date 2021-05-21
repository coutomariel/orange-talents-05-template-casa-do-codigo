package br.com.zupacademy.mariel.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mariel.casadocodigo.autor.Autor;
import br.com.zupacademy.mariel.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String titulo;

	@NotBlank
	@Size(max = 500)
	@Column(nullable = false, length = 500)
	private String resumo;

	@NotBlank
	@Column(nullable = false)
	private String sumario;

	@NotNull
	@DecimalMin(value = "20.0")
	@Column(nullable = false)
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	@Column(nullable = false)
	private Integer paginas;

	@NotBlank
	@Column(nullable = false)
	private String isbn;

	@Future
	@NotNull
	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@NotNull
	@ManyToOne
	private Autor autor;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @DecimalMin("20.0") BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

}
