package startup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "PROFISSIONAL")
public class Profissional 
{
    
    private int       id;
    private String      cpf;
    private String    nivel;
    private String 	  descricao;
    private int      avaliacao;  
    private Usuario   usuario;

  //Determinar se necessita de anotação para sequência,ja que estaremos utilizando MySQL.
    @Id()
    @GeneratedValue
    @Column(name = "ID")
    public int getId()
    {
        return id;
    }
	public void setId(int pId)
    {
        id = pId;
    }
	
	@Column(name ="CPF")
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Column(name ="NIVEL")
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	@Column(name ="DESCRICAO")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name ="AVALIACAO")
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
}
