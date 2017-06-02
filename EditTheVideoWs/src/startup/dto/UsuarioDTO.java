package startup.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import startup.model.Usuario;

@XmlRootElement(name = "UsuarioDTO")
public class UsuarioDTO extends AbstractDTO<Usuario>
{
    /* Construtores da classe */
    public UsuarioDTO()
    {
        super();
    }

    public UsuarioDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public UsuarioDTO(boolean pOk, String pMensagem, Usuario pUsuario)
    {
        super(pOk, pMensagem, pUsuario);
    }

    public UsuarioDTO(boolean pOk, String pMensagem, List<Usuario> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Usuario getUsuario()
    {
        return getObjeto();
    }

    public void setUsuario(Usuario pUsuario)
    {
        setObjeto(pUsuario);
    }
}
