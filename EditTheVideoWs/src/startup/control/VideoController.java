package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.VideoDAO;
import startup.dto.VideoDTO;
import startup.model.Video;

public class VideoController {
	// M�todo para criar um Video
    public static VideoDTO cadastrar(Video pVideo)
    {
        if (pVideo == null)
            return new VideoDTO(false, "Tentativa de inserir um Video nulo");

        // Chamando a camada de persist�ncia
        VideoDAO tDao = DaoFactory.getVideoDAO();
        Video tVideo = tDao.create(pVideo);

        // Verificando se houve erro de cria��o
        if (tVideo == null)
            return new VideoDTO(false, "Problemas na grava��o do Video");

        // Retornando o indicativo de sucesso com o objeto criado
        return new VideoDTO(true, "Video gravado com sucesso", tVideo);
    }

    // M�todo para recuperar um Video
    public static VideoDTO recuperar(int pId)
    {
        // Lendo o objeto
        VideoDAO tDao = DaoFactory.getVideoDAO();
        Video tVideo = tDao.recovery(pId);

        // Verificando se houve erro de recupera��o
        if (tVideo == null)
            return new VideoDTO(false, "Video n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new VideoDTO(true, "Video lido com sucesso", tVideo);
    }

    // M�todo para atualizar um Video
    public static VideoDTO atualizar(Video pVideo)
    {
        if (pVideo == null)
            return new VideoDTO(false, "Tentativa de atualizar um Video nulo");

        // Chamando a camada de persist�ncia
        VideoDAO tDao = DaoFactory.getVideoDAO();
        Video tVideo = tDao.update(pVideo);

        // Verificando se houve erro de atualiza��o
        if (tVideo == null)
            return new VideoDTO(false, "Video n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new VideoDTO(true, "Video regravado com sucesso", tVideo);
    }

    // M�todo para deletar um Video
    public static VideoDTO remover(int pId)
    {
        // Removendo o Video e verificando se houve erro de remo��o
        VideoDAO tDao = DaoFactory.getVideoDAO();
        if (! tDao.delete(pId))
            return new VideoDTO(false, "Video n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new VideoDTO(true, "Video removido com sucesso");
    }

    // M�todo para pesquisar todos os Videos
    public static VideoDTO pesquisar()
    {
        // Obtendo a lista de Videos
        VideoDAO tDao = DaoFactory.getVideoDAO();
        List<Video> tLista = tDao.search();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new VideoDTO(false, "Lista de Videos vazia");

        // Retornando a lista obtida
        return new VideoDTO(true, "Lista de Videos recuperada", tLista);
    }

}
