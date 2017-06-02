package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.GeneroDAO;
import startup.dto.GeneroDTO;
import startup.model.Genero;

public class GeneroController {

	// Método para criar um Genero
    public static GeneroDTO cadastrar(Genero pGenero)
    {
        if (pGenero == null)
            return new GeneroDTO(false, "Tentativa de inserir um Genero nulo");

        // Chamando a camada de persistência
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        Genero tGenero = tDao.create(pGenero);

        // Verificando se houve erro de criação
        if (tGenero == null)
            return new GeneroDTO(false, "Problemas na gravação do Genero");

        // Retornando o indicativo de sucesso com o objeto criado
        return new GeneroDTO(true, "Genero gravado com sucesso", tGenero);
    }

    // Método para recuperar um Genero
    public static GeneroDTO recuperar(int pId)
    {
        // Lendo o objeto
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        Genero tGenero = tDao.recovery(pId);

        // Verificando se houve erro de recuperação
        if (tGenero == null)
            return new GeneroDTO(false, "Genero não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new GeneroDTO(true, "Genero lido com sucesso", tGenero);
    }

    // Método para atualizar um Genero
    public static GeneroDTO atualizar(Genero pGenero)
    {
        if (pGenero == null)
            return new GeneroDTO(false, "Tentativa de atualizar um Genero nulo");

        // Chamando a camada de persistência
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        Genero tGenero = tDao.update(pGenero);

        // Verificando se houve erro de atualização
        if (tGenero == null)
            return new GeneroDTO(false, "Genero não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new GeneroDTO(true, "Genero regravado com sucesso", tGenero);
    }

    // Método para deletar um Genero
    public static GeneroDTO remover(int pId)
    {
        // Removendo o Genero e verificando se houve erro de remoção
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        if (! tDao.delete(pId))
            return new GeneroDTO(false, "Genero não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new GeneroDTO(true, "Genero removido com sucesso");
    }

    // Método para pesquisar todos os Generos
    public static GeneroDTO pesquisar()
    {
        // Obtendo a lista de Generos
        GeneroDAO tDao = DaoFactory.getGeneroDAO();
        List<Genero> tLista = tDao.search();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new GeneroDTO(false, "Lista de Generos vazia");

        // Retornando a lista obtida
        return new GeneroDTO(true, "Lista de Generos recuperada", tLista);
    }
}
