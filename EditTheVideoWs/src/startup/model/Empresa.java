package startup.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "EMPRESA")
public class Empresa implements Serializable, Cloneable
{

    private static final long serialVersionUID = 4927454144429877814L;

    private int       id;
    private String    nome_curto;
    private String    razao_social;
    private String      cnpj;
    private Usuario usuario;

  //Determinar se necessita de anotação para sequência,ja que estaremos utilizando MySQL.
    @Id()
	@GeneratedValue
	@Column(name ="ID")
    public int getId()
    {
        return id;
    }

    public void setId(int pId)
    {
        id = pId;
    }

    @Column(name = "NOMECURTO")
    public String getNome_Curto()
    {
        return nome_curto;
    }
    

    public void setNome_Curto(String pNome_Curto)
    {
        nome_curto = pNome_Curto;
    }

    @Column(name = "RAZAOSOCIAL")
    public String getRazao_Social()
    {
        return razao_social;
    }

    public void setRazao_Social(String pRazao_Social)
    {
        razao_social = pRazao_Social;
    }


	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "CNPJ")
    public String getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(String pCnpj)
    {
        cnpj = pCnpj;
    }

 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

