package startup.dao.hibernate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import startup.dao.VideoDAO;
import startup.hibernate.HibernateUtil;
import startup.model.Video;
import startup.util.ExceptionUtil;

public class VideoHibernateDAO implements VideoDAO {
	  @Override
	    public Video create(Video pVideo)
	    {
	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            tSessao.save(pVideo);
	            tSessao.flush();

	            return pVideo;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Video");
	        }

	        return null;
	    }

	    @Override
	    public Video recovery(int pId)
	    {
	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            Video tVideo = (Video) tSessao.get(Video.class, pId);

	            return tVideo;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Video");
	        }
	        return null;
	    }


	    @Override
	    public Video update(Video pVideo)
	    {
	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            tSessao.merge(pVideo);
	            tSessao.flush();

	            return pVideo;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Video");
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

	            tSessao.delete(tSessao.get(Video.class, pId));
	            tSessao.flush();

	            return true;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Video");
	        }

	        return false;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Video> search()
	    {
	        List<Video> tLista = new ArrayList<>();

	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            Query tQuery = tSessao.createQuery("FROM Video");

	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Videos");
	        }

	        return tLista;
	    }

}
