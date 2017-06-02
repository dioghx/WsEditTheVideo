package startup.dao;

import java.util.List;

import startup.model.Genero;

public interface GeneroDAO {

	 Genero create(Genero pGenero);

	    Genero recovery(int pId);

	    Genero update(Genero pGenero);

	    boolean delete(int pId);

	    List<Genero> search();
}
