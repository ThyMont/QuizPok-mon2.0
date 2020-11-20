package control;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.MTreinador;

@Entity
public class Treinador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20, nullable = false, unique = true)
	private String nome;
	@Column
	private Date data_nascimento;
	@Column
	private String avatar;
	@Column
	private String genero;
	@ManyToOne
	@JoinColumn(name = "mascote")
	private Pokemon mascote;
	@Column
	private String senha;

	public Treinador() {
	}

	public Treinador(Integer id) {
		this.id = id;
		MTreinador mt = new MTreinador();
		Treinador t = mt.buscar(id);
		this.avatar = t.getAvatar();
		this.data_nascimento = t.getData_nascimento();
		this.genero = t.getGenero();
		this.mascote = t.getMascote();
		this.senha = t.getSenha();
	}

	public Treinador(String nome, Date data_nascimento, String avatar, String genero, Pokemon mascote, String senha) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.avatar = avatar;
		this.genero = genero;
		this.mascote = mascote;
		this.senha = senha;
	}

	public Treinador(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public boolean autenticar() {
		MTreinador mt = new MTreinador();
		Treinador t = mt.autenticar(this);
		if (t != null) {
			this.id = t.getId();
			this.avatar = t.getAvatar();
			this.data_nascimento = t.getData_nascimento();
			this.genero = t.getGenero();
			this.mascote = t.getMascote();
			return true;
		} else {
			return false;
		}
	}

	public boolean cadastrar() {
		return new MTreinador().cadastrar(this);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pokemon getMascote() {
		return mascote;
	}

	public void setMascote(Pokemon mascote) {
		this.mascote = mascote;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean atualizar() {
		return new MTreinador().atualizar(this);
	}

	public boolean deletar() {
		return new MTreinador().deletar(this);

	}

}
