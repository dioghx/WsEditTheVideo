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

import startup.control.EnderecoController;
import startup.dto.EnderecoDTO;
import startup.model.Endereco;

@Path("/Endereco")
public class EnderecoWebService {

	  @POST
	    @Path("/Cadastrar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public EnderecoDTO cadastrar(Endereco pEndereco)
	    {
	        return EnderecoController.cadastrar(pEndereco);
	    }

	    @GET
	    @Path("/Recuperar/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public EnderecoDTO recuperar(@PathParam("id") int pId)
	    {
	        return  EnderecoController.recuperar(pId);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public EnderecoDTO atualizar(Endereco pEndereco)
	    {
	        return EnderecoController.atualizar(pEndereco);
	    }

	    @DELETE
	    @Path("/Remover/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public EnderecoDTO remover(@PathParam("id") int pId)
	    {
	        return EnderecoController.remover(pId);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public EnderecoDTO pesquisar()
	    {
	        return EnderecoController.pesquisar();
	    }
	
}
