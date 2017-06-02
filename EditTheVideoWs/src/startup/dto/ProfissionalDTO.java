package startup.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import startup.model.Profissional;

@XmlRootElement(name = "ProfissionalDTO")
public class ProfissionalDTO extends AbstractDTO<Profissional>
{
    /* Construtores da classe */
    public ProfissionalDTO()
    {
        super();
    }

    public ProfissionalDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProfissionalDTO(boolean pOk, String pMensagem, Profissional pProfissional)
    {
        super(pOk, pMensagem, pProfissional);
    }

    public ProfissionalDTO(boolean pOk, String pMensagem, List<Profissional> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Profissional getProfissional()
    {
        return getObjeto();
    }

    public void setProfissional(Profissional pProfissional)
    {
        setObjeto(pProfissional);
    }
}
