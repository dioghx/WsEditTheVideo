package startup.dao;

import java.util.List;

import startup.model.Endereco;

public interface EnderecoDAO
{
    Endereco create(Endereco pEndereco);

    Endereco recovery(int pId);

    Endereco update(Endereco pEndereco);

    boolean delete(int pId);

    List<Endereco> search();

}
