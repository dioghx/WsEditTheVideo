package startup.dao.hibernate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import startup.dao.EnderecoDAO;
import startup.hibernate.HibernateUtil;
import startup.model.Endereco;
import startup.util.ExceptionUtil;

public class EnderecoHibernateDAO implements EnderecoDAO
{

    @Override
    public Endereco create(Endereco pEndereco)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.save(pEndereco);
            tSessao.flush();

            return pEndereco;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Endereco");
        }

        return null;
    }

    @Override
    public Endereco recovery(int pId)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Endereco tEndereco = (Endereco) tSessao.get(Endereco.class, pId);

            return tEndereco;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Endereco");
        }
        return null;
    }


    @Override
    public Endereco update(Endereco pEndereco)
    {
        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            tSessao.merge(pEndereco);
            tSessao.flush();

            return pEndereco;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Endereco");
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

            tSessao.delete(tSessao.get(Endereco.class, pId));
            tSessao.flush();

            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Endereco");
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Endereco> search()
    {
        List<Endereco> tLista = new ArrayList<>();

        try
        {
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            Query tQuery = tSessao.createQuery("FROM Endereco");

            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Enderecos");
        }

        return tLista;
    }

}
