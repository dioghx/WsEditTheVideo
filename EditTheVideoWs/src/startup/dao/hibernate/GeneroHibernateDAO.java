package startup.dao.hibernate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import startup.dao.GeneroDAO;
import startup.hibernate.HibernateUtil;
import startup.model.Genero;
import startup.util.ExceptionUtil;
public class GeneroHibernateDAO implements GeneroDAO 
{

	  @Override
	    public Genero create(Genero pGenero)
	    {
	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            tSessao.save(pGenero);
	            tSessao.flush();

	            return pGenero;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Genero");
	        }

	        return null;
	    }

	    @Override
	    public Genero recovery(int pId)
	    {
	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            Genero tGenero = (Genero) tSessao.get(Genero.class, pId);

	            return tGenero;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Genero");
	        }
	        return null;
	    }


	    @Override
	    public Genero update(Genero pGenero)
	    {
	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            tSessao.merge(pGenero);
	            tSessao.flush();

	            return pGenero;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Genero");
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

	            tSessao.delete(tSessao.get(Genero.class, pId));
	            tSessao.flush();

	            return true;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Genero");
	        }

	        return false;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Genero> search()
	    {
	        List<Genero> tLista = new ArrayList<>();

	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            Query tQuery = tSessao.createQuery("FROM Genero");

	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Generos");
	        }

	        return tLista;
	    }
}
