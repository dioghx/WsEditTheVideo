package startup.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import startup.control.GeneroController;
import startup.dto.GeneroDTO;
import startup.model.Genero;

@Path("/Genero")
public class GeneroWebService {
	 @POST
	    @Path("/Cadastrar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public GeneroDTO cadastrar(Genero pGenero)
	    {
	        return GeneroController.cadastrar(pGenero);
	    }

	    @GET
	    @Path("/Recuperar/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public GeneroDTO recuperar(@PathParam("id") int pId)
	    {
	        return  GeneroController.recuperar(pId);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public GeneroDTO atualizar(Genero pGenero)
	    {
	        return GeneroController.atualizar(pGenero);
	    }

	    @DELETE
	    @Path("/Remover/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public GeneroDTO remover(@PathParam("id") int pId)
	    {
	        return GeneroController.remover(pId);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public GeneroDTO pesquisar()
	    {
	        return GeneroController.pesquisar();
	    }

}
