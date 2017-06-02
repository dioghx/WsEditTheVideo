package startup.control;

import java.util.List;

import startup.dao.DaoFactory;
import startup.dao.EnderecoDAO;
import startup.dto.EnderecoDTO;
import startup.model.Endereco;

public class EnderecoController {
	// Método para criar um Endereco
    public static EnderecoDTO cadastrar(Endereco pEndereco)
    {
        if (pEndereco == null)
            return new EnderecoDTO(false, "Tentativa de inserir um Endereco nulo");

        // Chamando a camada de persistência
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        Endereco tEndereco = tDao.create(pEndereco);

        // Verificando se houve erro de criação
        if (tEndereco == null)
            return new EnderecoDTO(false, "Problemas na gravação do Endereco");

        // Retornando o indicativo de sucesso com o objeto criado
        return new EnderecoDTO(true, "Endereco gravado com sucesso", tEndereco);
    }

    // Método para recuperar um Endereco
    public static EnderecoDTO recuperar(int pId)
    {
        // Lendo o objeto
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        Endereco tEndereco = tDao.recovery(pId);

        // Verificando se houve erro de recuperação
        if (tEndereco == null)
            return new EnderecoDTO(false, "Endereco não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new EnderecoDTO(true, "Endereco lido com sucesso", tEndereco);
    }

    // Método para atualizar um Endereco
    public static EnderecoDTO atualizar(Endereco pEndereco)
    {
        if (pEndereco == null)
            return new EnderecoDTO(false, "Tentativa de atualizar um Endereco nulo");

        // Chamando a camada de persistência
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        Endereco tEndereco = tDao.update(pEndereco);

        // Verificando se houve erro de atualização
        if (tEndereco == null)
            return new EnderecoDTO(false, "Endereco não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new EnderecoDTO(true, "Endereco regravado com sucesso", tEndereco);
    }

    // Método para deletar um Endereco
    public static EnderecoDTO remover(int pId)
    {
        // Removendo o Endereco e verificando se houve erro de remoção
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        if (! tDao.delete(pId))
            return new EnderecoDTO(false, "Endereco não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new EnderecoDTO(true, "Endereco removido com sucesso");
    }

    // Método para pesquisar todos os Enderecos
    public static EnderecoDTO pesquisar()
    {
        // Obtendo a lista de Enderecos
        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
        List<Endereco> tLista = tDao.search();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new EnderecoDTO(false, "Lista de Enderecos vazia");

        // Retornando a lista obtida
        return new EnderecoDTO(true, "Lista de Enderecos recuperada", tLista);
    }
}
