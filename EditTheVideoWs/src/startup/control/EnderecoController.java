package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.EnderecoDAO;
import startup.dto.EnderecoDTO;
import startup.model.Endereco;

public class EnderecoController {
	// M�todo para criar um Endereco
    public static EnderecoDTO cadastrar(Endereco pEndereco)
    {
        if (pEndereco == null)
            return new EnderecoDTO(false, "Tentativa de inserir um Endereco nulo");

        // Chamando a camada de persist�ncia
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        Endereco tEndereco = tDao.create(pEndereco);

        // Verificando se houve erro de cria��o
        if (tEndereco == null)
            return new EnderecoDTO(false, "Problemas na grava��o do Endereco");

        // Retornando o indicativo de sucesso com o objeto criado
        return new EnderecoDTO(true, "Endereco gravado com sucesso", tEndereco);
    }

    // M�todo para recuperar um Endereco
    public static EnderecoDTO recuperar(int pId)
    {
        // Lendo o objeto
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        Endereco tEndereco = tDao.recovery(pId);

        // Verificando se houve erro de recupera��o
        if (tEndereco == null)
            return new EnderecoDTO(false, "Endereco n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new EnderecoDTO(true, "Endereco lido com sucesso", tEndereco);
    }

    // M�todo para atualizar um Endereco
    public static EnderecoDTO atualizar(Endereco pEndereco)
    {
        if (pEndereco == null)
            return new EnderecoDTO(false, "Tentativa de atualizar um Endereco nulo");

        // Chamando a camada de persist�ncia
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        Endereco tEndereco = tDao.update(pEndereco);

        // Verificando se houve erro de atualiza��o
        if (tEndereco == null)
            return new EnderecoDTO(false, "Endereco n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new EnderecoDTO(true, "Endereco regravado com sucesso", tEndereco);
    }

    // M�todo para deletar um Endereco
    public static EnderecoDTO remover(int pId)
    {
        // Removendo o Endereco e verificando se houve erro de remo��o
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        if (! tDao.delete(pId))
            return new EnderecoDTO(false, "Endereco n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new EnderecoDTO(true, "Endereco removido com sucesso");
    }

    // M�todo para pesquisar todos os Enderecos
    public static EnderecoDTO pesquisar()
    {
        // Obtendo a lista de Enderecos
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        List<Endereco> tLista = tDao.search();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new EnderecoDTO(false, "Lista de Enderecos vazia");

        // Retornando a lista obtida
        return new EnderecoDTO(true, "Lista de Enderecos recuperada", tLista);
    }
}
