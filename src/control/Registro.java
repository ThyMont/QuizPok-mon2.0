package control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import enums.StatusRegistro;
import model.MRegistro;

@Entity
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "treinador_id")
	private Treinador treinador;
	@ManyToOne
	@JoinColumn(name = "pokemon_id")
	private Pokemon pokemon;
	@Column
	private StatusRegistro status;

	public Registro() {
	}

	public Registro(Treinador treinador, Pokemon pokemon) {
		this.treinador = treinador;
		this.pokemon = pokemon;
		this.status = StatusRegistro.CAPTURADO;
	}

	public boolean cadastrar() {
		MRegistro mr = new MRegistro();
		return mr.registrar(this) ? true : false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusRegistro getStatus() {
		return status;
	}

	public void setStatus(StatusRegistro status) {
		this.status = status;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public boolean deletar(Treinador t) {
		MRegistro mr = new MRegistro();
		return mr.deletar(t) ? true : false;
	}

}
