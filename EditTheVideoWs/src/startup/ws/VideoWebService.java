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

import startup.control.VideoController;
import startup.dto.VideoDTO;
import startup.model.Video;

@Path("/Video")
public class VideoWebService {

	  @POST
	    @Path("/Cadastrar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public VideoDTO cadastrar(Video pVideo)
	    {
	        return VideoController.cadastrar(pVideo);
	    }

	    @GET
	    @Path("/Recuperar/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public VideoDTO recuperar(@PathParam("id") int pId)
	    {
	        return  VideoController.recuperar(pId);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public VideoDTO atualizar(Video pVideo)
	    {
	        return VideoController.atualizar(pVideo);
	    }

	    @DELETE
	    @Path("/Remover/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public VideoDTO remover(@PathParam("id") int pId)
	    {
	        return VideoController.remover(pId);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public VideoDTO pesquisar()
	    {
	        return VideoController.pesquisar();
	    }
}
