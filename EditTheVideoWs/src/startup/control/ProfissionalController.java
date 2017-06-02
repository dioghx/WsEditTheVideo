package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.ProfissionalDAO;
import startup.dto.ProfissionalDTO;
import startup.model.Profissional;

public class ProfissionalController
{
    // M�todo para criar um Profissional
    public static ProfissionalDTO cadastrar(Profissional pProfissional)
    {
        if (pProfissional == null)
            return new ProfissionalDTO(false, "Tentativa de inserir um Profissional nulo");

        // Chamando a camada de persist�ncia
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        Profissional tProfissional = tDao.create(pProfissional);

        // Verificando se houve erro de cria��o
        if (tProfissional == null)
            return new ProfissionalDTO(false, "Problemas na grava��o do Profissional");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ProfissionalDTO(true, "Profissional gravado com sucesso", tProfissional);
    }

    // M�todo para recuperar um Profissional
    public static ProfissionalDTO recuperar(int pId)
    {
        // Lendo o objeto
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        Profissional tProfissional = tDao.recovery(pId);

        // Verificando se houve erro de recupera��o
        if (tProfissional == null)
            return new ProfissionalDTO(false, "Profissional n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ProfissionalDTO(true, "Profissional lido com sucesso", tProfissional);
    }

    // M�todo para atualizar um Profissional
    public static ProfissionalDTO atualizar(Profissional pProfissional)
    {
        if (pProfissional == null)
            return new ProfissionalDTO(false, "Tentativa de atualizar um Profissional nulo");

        // Chamando a camada de persist�ncia
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        Profissional tProfissional = tDao.update(pProfissional);

        // Verificando se houve erro de atualiza��o
        if (tProfissional == null)
            return new ProfissionalDTO(false, "Profissional n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ProfissionalDTO(true, "Profissional regravado com sucesso", tProfissional);
    }

    // M�todo para deletar um Profissional
    public static ProfissionalDTO remover(int pId)
    {
        // Removendo o Profissional e verificando se houve erro de remo��o
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        if (! tDao.delete(pId))
            return new ProfissionalDTO(false, "Profissional n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ProfissionalDTO(true, "Profissional removido com sucesso");
    }

    // M�todo para pesquisar todos os Profissionals
    public static ProfissionalDTO pesquisar()
    {
        // Obtendo a lista de Profissionals
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        List<Profissional> tLista = tDao.search();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ProfissionalDTO(false, "Lista de Profissionals vazia");

        // Retornando a lista obtida
        return new ProfissionalDTO(true, "Lista de Profissionals recuperada", tLista);
    }

    // M�todo para pesquisar por nome todos os Profissionals
    public static ProfissionalDTO pesquisarPorNome(String pNome)
    {
        // Caso o nome de pesquisa seja nulo, retorna a lista geral
        if (pNome == null)
            return pesquisar();

        // Obtendo a lista de Profissionals
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        List<Profissional> tLista = tDao.searchByNome(pNome);

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ProfissionalDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

        // Retornando a lista obtida
        return new ProfissionalDTO(true, "Lista de Profissionals recuperada", tLista);
    }

    // M�todo para pesquisar por email todos os Profissionals
    public static ProfissionalDTO pesquisarPorEmail(String pEmail)
    {
        // Caso o email de pesquisa seja nulo, retorna a lista geral
        if (pEmail == null)
            return pesquisar();

        // Obtendo a lista de Profissionals
        ProfissionalDAO tDao = DaoFactory.getProfissionalDAO();
        List<Profissional> tLista = tDao.searchByEmail(pEmail);

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ProfissionalDTO(false, "Nenhum registro encontrado com email '" + pEmail + "'");

        // Retornando a lista obtida
        return new ProfissionalDTO(true, "Lista de Profissionals recuperada", tLista);
    }
}
