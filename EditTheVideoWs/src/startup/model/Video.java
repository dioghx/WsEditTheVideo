package startup.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity(name="VIDEO")
@Table(name ="VIDEO")

public class Video {
	private int id;
	private Profissional profissional;
	private Empresa empresa;
	private String titulo;
	private int avaliacao;
	private List<Genero>generos;
	private String link;
	
	//Determinar se necessita de anotação para sequência,ja que estaremos utilizando MySQL.
	@Id()
	@GeneratedValue
	@Column(name ="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_PROFISSIONAL", referencedColumnName = "ID")
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_EMPRESA", referencedColumnName = "ID")
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	@Column(name="TITULO")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name="AVALIACAO")
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	@Column(name="LINK")
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="VIDEO_GENERO",
			joinColumns=@JoinColumn(name = "ID_VIDEO", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name = "ID_GENERO", referencedColumnName = "ID"))
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	
	

}
