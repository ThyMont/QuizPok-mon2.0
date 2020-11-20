package control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.MTipo;

@Entity(name = "Tipos")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String tipo;
	@Column
	private Double def_normal;
	@Column
	private Double def_fire;
	@Column
	private Double def_water;
	@Column
	private Double def_grass;
	@Column
	private Double def_electric;
	@Column
	private Double def_ice;
	@Column
	private Double def_figting;
	@Column
	private Double def_poison;
	@Column
	private Double def_ground;
	@Column
	private Double def_flying;
	@Column
	private Double def_psyquic;
	@Column
	private Double def_bug;
	@Column
	private Double def_rock;
	@Column
	private Double def_ghost;
	@Column
	private Double def_dragon;
	@Column
	private Double def_dark;
	@Column
	private Double def_steel;
	@Column
	private Double def_fairy;
	@Column
	private Double def_noType;

	public Tipo() {

	}

	public Tipo(String tipo) {
		MTipo mt = new MTipo();
		this.tipo = tipo;
		this.id = mt.buscarTipo(tipo).getId();
	}

	public Tipo(Integer id) {
		this.id = id;
		MTipo mt = new MTipo();
		this.tipo = mt.buscarTipo(id).getTipo();
	}

	public Tipo(String tipo, Double def_normal, Double def_fire, Double def_water, Double def_grass,
			Double def_electric, Double def_ice, Double def_figting, Double def_poison, Double def_ground,
			Double def_flying, Double def_psyquic, Double def_bug, Double def_rock, Double def_ghost, Double def_dragon,
			Double def_dark, Double def_steel, Double def_fairy, Double def_noType) {
		super();
		this.tipo = tipo;
		this.def_normal = def_normal;
		this.def_fire = def_fire;
		this.def_water = def_water;
		this.def_grass = def_grass;
		this.def_electric = def_electric;
		this.def_ice = def_ice;
		this.def_figting = def_figting;
		this.def_poison = def_poison;
		this.def_ground = def_ground;
		this.def_flying = def_flying;
		this.def_psyquic = def_psyquic;
		this.def_bug = def_bug;
		this.def_rock = def_rock;
		this.def_ghost = def_ghost;
		this.def_dragon = def_dragon;
		this.def_dark = def_dark;
		this.def_steel = def_steel;
		this.def_fairy = def_fairy;
		this.def_noType = def_noType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return tipo.toLowerCase();
	}

}
