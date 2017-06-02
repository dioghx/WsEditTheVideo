package startup.dao;

import java.util.List;

import startup.model.Profissional;;

public interface ProfissionalDAO
{

    Profissional create(Profissional pProfissional);

    Profissional recovery(int pId);

    Profissional update(Profissional pProfissional);

    boolean delete(int pId);

    List<Profissional> search();

    List<Profissional> searchByNome(String pNome);

    List<Profissional> searchByEmail(String pEmail);

}
