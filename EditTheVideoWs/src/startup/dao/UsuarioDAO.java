package startup.dao;

import java.util.List;

import startup.model.Usuario;;

public interface UsuarioDAO
{

    Usuario create(Usuario pUsuario);

    Usuario recovery(int pMatricula);

    Usuario update(Usuario pUsuario);

    boolean delete(int pMatricula);

    List<Usuario> search();

    List<Usuario> searchByNome(String pNome);

    List<Usuario> searchByEmail(String pEmail);

}
