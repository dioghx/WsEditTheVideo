package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.GeneroDAO;
import startup.dto.GeneroDTO;
import startup.model.Genero;

public class GeneroController {

	// M�todo para criar um Genero
    public static GeneroDTO cadastrar(Genero pGenero)
    {
        if (pGenero == null)
            return new GeneroDTO(false, "Tentativa de inserir um Genero nulo");

        // Chamando a camada de persist�ncia
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        Genero tGenero = tDao.create(pGenero);

        // Verificando se houve erro de cria��o
        if (tGenero == null)
            return new GeneroDTO(false, "Problemas na grava��o do Genero");

        // Retornando o indicativo de sucesso com o objeto criado
        return new GeneroDTO(true, "Genero gravado com sucesso", tGenero);
    }

    // M�todo para recuperar um Genero
    public static GeneroDTO recuperar(int pId)
    {
        // Lendo o objeto
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        Genero tGenero = tDao.recovery(pId);

        // Verificando se houve erro de recupera��o
        if (tGenero == null)
            return new GeneroDTO(false, "Genero n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new GeneroDTO(true, "Genero lido com sucesso", tGenero);
    }

    // M�todo para atualizar um Genero
    public static GeneroDTO atualizar(Genero pGenero)
    {
        if (pGenero == null)
            return new GeneroDTO(false, "Tentativa de atualizar um Genero nulo");

        // Chamando a camada de persist�ncia
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        Genero tGenero = tDao.update(pGenero);

        // Verificando se houve erro de atualiza��o
        if (tGenero == null)
            return new GeneroDTO(false, "Genero n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new GeneroDTO(true, "Genero regravado com sucesso", tGenero);
    }

    // M�todo para deletar um Genero
    public static GeneroDTO remover(int pId)
    {
        // Removendo o Genero e verificando se houve erro de remo��o
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        if (! tDao.delete(pId))
            return new GeneroDTO(false, "Genero n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new GeneroDTO(true, "Genero removido com sucesso");
    }

    // M�todo para pesquisar todos os Generos
    public static GeneroDTO pesquisar()
    {
        // Obtendo a lista de Generos
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        List<Genero> tLista = tDao.search();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new GeneroDTO(false, "Lista de Generos vazia");

        // Retornando a lista obtida
        return new GeneroDTO(true, "Lista de Generos recuperada", tLista);
    }
}
