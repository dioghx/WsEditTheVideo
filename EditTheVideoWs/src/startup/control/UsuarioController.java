package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.UsuarioDAO;
import startup.dto.UsuarioDTO;
import startup.model.Usuario;

public class UsuarioController
{
    // Método para criar um Usuario
    public static UsuarioDTO cadastrar(Usuario pUsuario)
    {
        if (pUsuario == null)
            return new UsuarioDTO(false, "Tentativa de inserir um Usuario nulo");

        // Chamando a camada de persistência
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        Usuario tUsuario = tDao.create(pUsuario);

        // Verificando se houve erro de criação
        if (tUsuario == null)
            return new UsuarioDTO(false, "Problemas na gravação do Usuario");

        // Retornando o indicativo de sucesso com o objeto criado
        return new UsuarioDTO(true, "Usuario gravado com sucesso", tUsuario);
    }

    // Método para recuperar um Usuario
    public static UsuarioDTO recuperar(int pId)
    {
        // Lendo o objeto
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        Usuario tUsuario = tDao.recovery(pId);

        // Verificando se houve erro de recuperação
        if (tUsuario == null)
            return new UsuarioDTO(false, "Usuario não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new UsuarioDTO(true, "Usuario lido com sucesso", tUsuario);
    }

    // Método para atualizar um Usuario
    public static UsuarioDTO atualizar(Usuario pUsuario)
    {
        if (pUsuario == null)
            return new UsuarioDTO(false, "Tentativa de atualizar um Usuario nulo");

        // Chamando a camada de persistência
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        Usuario tUsuario = tDao.update(pUsuario);

        // Verificando se houve erro de atualização
        if (tUsuario == null)
            return new UsuarioDTO(false, "Usuario não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new UsuarioDTO(true, "Usuario regravado com sucesso", tUsuario);
    }

    // Método para deletar um Usuario
    public static UsuarioDTO remover(int pId)
    {
        // Removendo o Usuario e verificando se houve erro de remoção
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        if (! tDao.delete(pId))
            return new UsuarioDTO(false, "Usuario não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new UsuarioDTO(true, "Usuario removido com sucesso");
    }

    // Método para pesquisar todos os Usuarios
    public static UsuarioDTO pesquisar()
    {
        // Obtendo a lista de Usuarios
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        List<Usuario> tLista = tDao.search();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new UsuarioDTO(false, "Lista de Usuarios vazia");

        // Retornando a lista obtida
        return new UsuarioDTO(true, "Lista de Usuarios recuperada", tLista);
    }

    // Método para pesquisar por nome todos os Usuarios
    public static UsuarioDTO pesquisarPorNome(String pNome)
    {
        // Caso o nome de pesquisa seja nulo, retorna a lista geral
        if (pNome == null)
            return pesquisar();

        // Obtendo a lista de Usuarios
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        List<Usuario> tLista = tDao.searchByNome(pNome);

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new UsuarioDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

        // Retornando a lista obtida
        return new UsuarioDTO(true, "Lista de Usuarios recuperada", tLista);
    }

    // Método para pesquisar por email todos os Usuarios
    public static UsuarioDTO pesquisarPorEmail(String pEmail)
    {
        // Caso o email de pesquisa seja nulo, retorna a lista geral
        if (pEmail == null)
            return pesquisar();

        // Obtendo a lista de Usuarios
        UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
        List<Usuario> tLista = tDao.searchByEmail(pEmail);

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new UsuarioDTO(false, "Nenhum registro encontrado com email '" + pEmail + "'");

        // Retornando a lista obtida
        return new UsuarioDTO(true, "Lista de Usuarios recuperada", tLista);
    }
}
