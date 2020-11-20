package control;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.MPokemon;
import model.MTipo;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 5, nullable = false)
	private String dex_number;
	@Column(length = 20, nullable = false)
	private String nome;
	@Column(length = 30)
	private String categoria;
	@Column(length = 500)
	private String descricao;
	@Column(length = 50, precision = 1)
	private Double altura;
	@Column(length = 1000, precision = 1)
	private Double peso;
	@Column(length = 10)
	private Integer geracao;

	@ManyToOne
	@JoinColumn(name = "tipo1_id")
	private Tipo tipo1;
	@ManyToOne
	@JoinColumn(name = "tipo2_id")
	private Tipo tipo2;

	public Pokemon() {
	}

	public Pokemon(String nome) {
		MPokemon mp = new MPokemon();
		List<Pokemon> list = mp.buscar(nome);
		if (!list.isEmpty()) {
			this.id = list.get(0).getId();
			this.nome = list.get(0).getNome();
			this.dex_number = list.get(0).getDex_number();
			this.nome = list.get(0).getNome();
			this.categoria = list.get(0).getCategoria();
			this.descricao = list.get(0).getDescricao();
			this.altura = list.get(0).getAltura();
			this.peso = list.get(0).getPeso();
			this.geracao = list.get(0).getGeracao();
			this.tipo1 = list.get(0).getTipo1();
			this.tipo2 = list.get(0).getTipo2();
		}
	}

	public Pokemon(Integer id) {
		this.id = id;
		MPokemon mp = new MPokemon();
		Pokemon p = mp.buscar(id);
		this.dex_number = p.getDex_number();
		this.nome = p.getNome();
		this.categoria = p.getCategoria();
		this.descricao = p.getDescricao();
		this.altura = p.getAltura();
		this.peso = p.getPeso();
		this.geracao = p.getGeracao();
		this.tipo1 = p.getTipo1();
		this.tipo2 = p.getTipo2();
	}

	public Pokemon(String dex_number, String nome, String categoria, String descricao, Double altura, Double peso,
			Integer geracao, Tipo tipo1, Tipo tipo2) {
		super();
		this.dex_number = dex_number;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.altura = altura;
		this.peso = peso;
		this.geracao = geracao;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}

	public boolean cadastrar() {
		return new MPokemon().cadastrar(this);
	}

	public List<Pokemon> buscar(String nome) {
		MPokemon mp = new MPokemon();
		return mp.buscar(nome);
	}

	public List<Pokemon> buscar(Tipo tipo) {
		MPokemon mp = new MPokemon();
		return mp.buscar(tipo);
	}

	public List<Tipo> fraquezas() {
		MTipo mt = new MTipo();
		return mt.buscarFraquezas(tipo1, tipo2);
	}

	public List<Tipo> resistencias() {
		MTipo mt = new MTipo();
		return mt.buscarResistencias(tipo1, tipo2);
	}

	public List<Tipo> imunidades() {
		MTipo mt = new MTipo();
		return mt.buscarImunidades(tipo1, tipo2);
	}

	@Override
	public String toString() {
		return nome;
	}

	// -------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDex_number() {
		return dex_number;
	}

	public void setDex_number(String dex_number) {
		this.dex_number = dex_number;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getGeracao() {
		return geracao;
	}

	public void setGeracao(Integer geracao) {
		this.geracao = geracao;
	}

	public Tipo getTipo1() {
		return tipo1;
	}

	public void setTipo1(Tipo tipo1) {
		this.tipo1 = tipo1;
	}

	public Tipo getTipo2() {
		return tipo2;
	}

	public void setTipo2(Tipo tipo2) {
		this.tipo2 = tipo2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
