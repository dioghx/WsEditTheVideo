package startup.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import startup.model.Empresa;

@XmlRootElement(name = "EmpresaDTO")
public class EmpresaDTO extends AbstractDTO<Empresa>
{
    /* Construtores da classe */
    public EmpresaDTO()
    {
        super();
    }

    public EmpresaDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public EmpresaDTO(boolean pOk, String pMensagem, Empresa pEmpresa)
    {
        super(pOk, pMensagem, pEmpresa);
    }

    public EmpresaDTO(boolean pOk, String pMensagem, List<Empresa> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Empresa getEmpresa()
    {
        return getObjeto();
    }

    public void setEmpresa(Empresa pEmpresa)
    {
        setObjeto(pEmpresa);
    }
}
