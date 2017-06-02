package startup.dto;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import startup.dto.AbstractDTO;
import startup.model.Genero;

@XmlRootElement(name = "GeneroDTO")
public class GeneroDTO extends AbstractDTO<Genero> {

	  /* Construtores da classe */
    public GeneroDTO()
    {
        super();
    }

    public GeneroDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public GeneroDTO(boolean pOk, String pMensagem, Genero pGenero)
    {
        super(pOk, pMensagem, pGenero);
    }

    public GeneroDTO(boolean pOk, String pMensagem, List<Genero> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Genero getGenero()
    {
        return getObjeto();
    }

    public void setGenero(Genero pGenero)
    {
        setObjeto(pGenero);
    }
}
