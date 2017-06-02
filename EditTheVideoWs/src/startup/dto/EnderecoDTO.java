package startup.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import startup.model.Endereco;


@XmlRootElement(name = "EnderecoDTO")
public class EnderecoDTO extends AbstractDTO<Endereco> {
	
	  /* Construtores da classe */
    public EnderecoDTO()
    {
        super();
    }

    public EnderecoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public EnderecoDTO(boolean pOk, String pMensagem, Endereco pEndereco)
    {
        super(pOk, pMensagem, pEndereco);
    }

    public EnderecoDTO(boolean pOk, String pMensagem, List<Endereco> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* M�todos de acesso */
    public Endereco getEndereco()
    {
        return getObjeto();
    }

    public void setEndereco(Endereco pEndereco)
    {
        setObjeto(pEndereco);
    }

}
