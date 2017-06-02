package startup.dao.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import startup.dao.UsuarioDAO;
import startup.hibernate.HibernateUtil;
import startup.model.Usuario;
import startup.util.ExceptionUtil;

public class UsuarioHibernateDAO implements UsuarioDAO
{
    @Override
    public Usuario create(Usuario pUsuario)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.save(pUsuario);
            tSessao.flush();

            return pUsuario;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Usuario");
        }

        return null;
    }

    @Override
    public Usuario recovery(int pId)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Usuario tUsuario = (Usuario) tSessao.get(Usuario.class, pId);

            return tUsuario;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Usuario");
        }
        return null;
    }


    @Override
    public Usuario update(Usuario pUsuario)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.merge(pUsuario);
            tSessao.flush();

            return pUsuario;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
        }
        return null;
    }

    @Override
    public boolean delete(int pId)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.delete(tSessao.get(Usuario.class, pId));
            tSessao.flush();

            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> search()
    {
        List<Usuario> tLista = new ArrayList<>();

        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Query tQuery = tSessao.createQuery("FROM Usuario");

            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
        }

        return tLista;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> searchByNome(String pNome)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Usuarios vazia
        List<Usuario> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Usuario.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
        }

        return tLista;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> searchByEmail(String pEmail)
    {
        // Acertando o critério de pesquisa
        String tEmailPesquisa = "%" + pEmail + "%";

        // Criando a tLista de Usuarios vazia
        List<Usuario> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Usuario.class)
                                          .add(Restrictions.like("email", tEmailPesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
        }

        return tLista;
    }
}
