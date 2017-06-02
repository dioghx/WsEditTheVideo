package startup.dao;

import java.util.List;

import startup.model.Empresa;;

public interface EmpresaDAO
{

    Empresa create(Empresa pEmpresa);

    Empresa recovery(int pId);

    Empresa update(Empresa pEmpresa);

    boolean delete(int pId);

    List<Empresa> search();

    List<Empresa> searchByNome_Curto(String pNome_Curto);

    List<Empresa> searchByEmail(String pEmail);

}
