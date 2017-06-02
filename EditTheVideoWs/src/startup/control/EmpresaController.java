package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.EmpresaDAO;
import startup.dto.EmpresaDTO;
import startup.model.Empresa;

public class EmpresaController
{
    // M�todo para criar um Empresa
    public static EmpresaDTO cadastrar(Empresa pEmpresa)
    {
        if (pEmpresa == null)
            return new EmpresaDTO(false, "Tentativa de inserir um Empresa nulo");

        // Chamando a camada de persist�ncia
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        Empresa tEmpresa = tDao.create(pEmpresa);

        // Verificando se houve erro de cria��o
        if (tEmpresa == null)
            return new EmpresaDTO(false, "Problemas na grava��o do Empresa");

        // Retornando o indicativo de sucesso com o objeto criado
        return new EmpresaDTO(true, "Empresa gravado com sucesso", tEmpresa);
    }

    // M�todo para recuperar um Empresa
    public static EmpresaDTO recuperar(int pId)
    {
        // Lendo o objeto
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        Empresa tEmpresa = tDao.recovery(pId);

        // Verificando se houve erro de recupera��o
        if (tEmpresa == null)
            return new EmpresaDTO(false, "Empresa n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new EmpresaDTO(true, "Empresa lido com sucesso", tEmpresa);
    }

    // M�todo para atualizar um Empresa
    public static EmpresaDTO atualizar(Empresa pEmpresa)
    {
        if (pEmpresa == null)
            return new EmpresaDTO(false, "Tentativa de atualizar um Empresa nulo");

        // Chamando a camada de persist�ncia
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        Empresa tEmpresa = tDao.update(pEmpresa);

        // Verificando se houve erro de atualiza��o
        if (tEmpresa == null)
            return new EmpresaDTO(false, "Empresa n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new EmpresaDTO(true, "Empresa regravado com sucesso", tEmpresa);
    }

    // M�todo para deletar um Empresa
    public static EmpresaDTO remover(int pId)
    {
        // Removendo o Empresa e verificando se houve erro de remo��o
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        if (! tDao.delete(pId))
            return new EmpresaDTO(false, "Empresa n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new EmpresaDTO(true, "Empresa removido com sucesso");
    }

    // M�todo para pesquisar todos os Empresas
    public static EmpresaDTO pesquisar()
    {
        // Obtendo a lista de Empresas
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        List<Empresa> tLista = tDao.search();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new EmpresaDTO(false, "Lista de Empresas vazia");

        // Retornando a lista obtida
        return new EmpresaDTO(true, "Lista de Empresas recuperada", tLista);
    }

    // M�todo para pesquisar por nome todos os Empresas
    public static EmpresaDTO pesquisarPorNome_Curto(String pNome_Curto)
    {
        // Caso o nome de pesquisa seja nulo, retorna a lista geral
        if (pNome_Curto == null)
            return pesquisar();

        // Obtendo a lista de Empresas
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        List<Empresa> tLista = tDao.searchByNome_Curto(pNome_Curto);

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new EmpresaDTO(false, "Nenhum registro encontrado com nome '" + pNome_Curto + "'");

        // Retornando a lista obtida
        return new EmpresaDTO(true, "Lista de Empresas recuperada", tLista);
    }

    // M�todo para pesquisar por email todos os Empresas
    public static EmpresaDTO pesquisarPorEmail(String pEmail)
    {
        // Caso o email de pesquisa seja nulo, retorna a lista geral
        if (pEmail == null)
            return pesquisar();

        // Obtendo a lista de Empresas
        EmpresaDAO tDao = DaoFactory.getEmpresaDAO();
        List<Empresa> tLista = tDao.searchByEmail(pEmail);

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new EmpresaDTO(false, "Nenhum registro encontrado com email '" + pEmail + "'");

        // Retornando a lista obtida
        return new EmpresaDTO(true, "Lista de Empresas recuperada", tLista);
    }
}
