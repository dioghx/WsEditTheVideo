package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.VideoDAO;
import startup.dto.VideoDTO;
import startup.model.Video;

public class VideoController {
	// Método para criar um Video
    public static VideoDTO cadastrar(Video pVideo)
    {
        if (pVideo == null)
            return new VideoDTO(false, "Tentativa de inserir um Video nulo");

        // Chamando a camada de persistência
        VideoDAO tDao = DaoFactory.getVideoDAO();
        Video tVideo = tDao.create(pVideo);

        // Verificando se houve erro de criação
        if (tVideo == null)
            return new VideoDTO(false, "Problemas na gravação do Video");

        // Retornando o indicativo de sucesso com o objeto criado
        return new VideoDTO(true, "Video gravado com sucesso", tVideo);
    }

    // Método para recuperar um Video
    public static VideoDTO recuperar(int pId)
    {
        // Lendo o objeto
        VideoDAO tDao = DaoFactory.getVideoDAO();
        Video tVideo = tDao.recovery(pId);

        // Verificando se houve erro de recuperação
        if (tVideo == null)
            return new VideoDTO(false, "Video não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new VideoDTO(true, "Video lido com sucesso", tVideo);
    }

    // Método para atualizar um Video
    public static VideoDTO atualizar(Video pVideo)
    {
        if (pVideo == null)
            return new VideoDTO(false, "Tentativa de atualizar um Video nulo");

        // Chamando a camada de persistência
        VideoDAO tDao = DaoFactory.getVideoDAO();
        Video tVideo = tDao.update(pVideo);

        // Verificando se houve erro de atualização
        if (tVideo == null)
            return new VideoDTO(false, "Video não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new VideoDTO(true, "Video regravado com sucesso", tVideo);
    }

    // Método para deletar um Video
    public static VideoDTO remover(int pId)
    {
        // Removendo o Video e verificando se houve erro de remoção
        VideoDAO tDao = DaoFactory.getVideoDAO();
        if (! tDao.delete(pId))
            return new VideoDTO(false, "Video não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new VideoDTO(true, "Video removido com sucesso");
    }

    // Método para pesquisar todos os Videos
    public static VideoDTO pesquisar()
    {
        // Obtendo a lista de Videos
        VideoDAO tDao = DaoFactory.getVideoDAO();
        List<Video> tLista = tDao.search();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new VideoDTO(false, "Lista de Videos vazia");

        // Retornando a lista obtida
        return new VideoDTO(true, "Lista de Videos recuperada", tLista);
    }

}
