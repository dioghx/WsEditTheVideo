package startup.dao.hibernate;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import startup.dao.EmpresaDAO;
import startup.hibernate.HibernateUtil;
import startup.model.Empresa;
import startup.util.ExceptionUtil;

public class EmpresaHibernateDAO implements EmpresaDAO
{
    @Override
    public Empresa create(Empresa pEmpresa)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.save(pEmpresa);
            tSessao.flush();

            return pEmpresa;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Empresa");
        }

        return null;
    }

    @Override
    public Empresa recovery(int pId)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Empresa tEmpresa = (Empresa) tSessao.get(Empresa.class, pId);

            return tEmpresa;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Empresa");
        }
        return null;
    }


    @Override
    public Empresa update(Empresa pEmpresa)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.merge(pEmpresa);
            tSessao.flush();

            return pEmpresa;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Empresa");
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

            tSessao.delete(tSessao.get(Empresa.class, pId));
            tSessao.flush();

            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Empresa");
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Empresa> search()
    {
        List<Empresa> tLista = new ArrayList<>();

        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Query tQuery = tSessao.createQuery("FROM Empresa");

            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Empresas");
        }

        return tLista;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Empresa> searchByNome_Curto(String pNome_Curto)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome_Curto + "%";

        // Criando a tLista de Empresas vazia
        List<Empresa> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Empresa.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Empresas");
        }

        return tLista;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Empresa> searchByEmail(String pEmail)
    {
        // Acertando o critério de pesquisa
        String tEmailPesquisa = "%" + pEmail + "%";

        // Criando a tLista de Empresas vazia
        List<Empresa> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Empresa.class)
                                          .add(Restrictions.like("email", tEmailPesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Empresas");
        }

        return tLista;
    }
}
