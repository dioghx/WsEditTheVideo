package startup.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import startup.model.Video;

@XmlRootElement(name = "VideoDTO")
public class VideoDTO extends AbstractDTO<Video> {

	  /* Construtores da classe */
    public VideoDTO()
    {
        super();
    }

    public VideoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public VideoDTO(boolean pOk, String pMensagem, Video pVideo)
    {
        super(pOk, pMensagem, pVideo);
    }

    public VideoDTO(boolean pOk, String pMensagem, List<Video> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Video getVideo()
    {
        return getObjeto();
    }

    public void setVideo(Video pVideo)
    {
        setObjeto(pVideo);
    }
}
