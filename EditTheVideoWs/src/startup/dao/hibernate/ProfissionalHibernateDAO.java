package startup.dao.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import startup.dao.ProfissionalDAO;
import startup.hibernate.HibernateUtil;
import startup.model.Profissional;
import startup.util.ExceptionUtil;

public class ProfissionalHibernateDAO implements ProfissionalDAO
{
    @Override
    public Profissional create(Profissional pProfissional)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.save(pProfissional);
            tSessao.flush();

            return pProfissional;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Profissional");
        }

        return null;
    }

    @Override
    public Profissional recovery(int pId)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Profissional tProfissional = (Profissional) tSessao.get(Profissional.class, pId);

            return tProfissional;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Profissional");
        }
        return null;
    }


    @Override
    public Profissional update(Profissional pProfissional)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.merge(pProfissional);
            tSessao.flush();

            return pProfissional;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Profissional");
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

            tSessao.delete(tSessao.get(Profissional.class, pId));
            tSessao.flush();

            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Profissional");
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profissional> search()
    {
        List<Profissional> tLista = new ArrayList<>();

        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Query tQuery = tSessao.createQuery("FROM Profissional");

            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Profissionals");
        }

        return tLista;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profissional> searchByNome(String pNome)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Profissionals vazia
        List<Profissional> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Profissional.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Profissionals");
        }

        return tLista;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profissional> searchByEmail(String pEmail)
    {
        // Acertando o critério de pesquisa
        String tEmailPesquisa = "%" + pEmail + "%";

        // Criando a tLista de Profissionals vazia
        List<Profissional> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Profissional.class)
                                          .add(Restrictions.like("email", tEmailPesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Profissionals");
        }

        return tLista;
    }
}
