package startup.dao;

import startup.dao.hibernate.EmpresaHibernateDAO;
import startup.dao.hibernate.EnderecoHibernateDAO;
import startup.dao.hibernate.GeneroHibernateDAO;
import startup.dao.hibernate.ProfissionalHibernateDAO;
import startup.dao.hibernate.UsuarioHibernateDAO;
import startup.dao.hibernate.VideoHibernateDAO;

public class DaoFactory
{
    public static UsuarioDAO getUsuarioDAO()
    {
        return new UsuarioHibernateDAO();
    }

    public static ProfissionalDAO getProfissionalDAO()
    {
        return new ProfissionalHibernateDAO();
    }

    public static EmpresaDAO getEmpresaDAO()
    {
        return new EmpresaHibernateDAO();
    }

	public static GeneroDAO getGeneroDAO() {
		
	    return new GeneroHibernateDAO();
	}
	public static VideoDAO getVideoDAO() {
		
	    return new VideoHibernateDAO();
	}

public static EnderecoDAO getEnderecoDAO() {
		
	    return new EnderecoHibernateDAO();
	}

}
