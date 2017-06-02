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

import startup.control.UsuarioController;
import startup.dto.UsuarioDTO;
import startup.model.Usuario;

@Path("/Usuario")
public class UsuarioWebService
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO cadastrar(Usuario pUsuario)
    {
        return UsuarioController.cadastrar(pUsuario);
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO recuperar(@PathParam("id") int pId)
    {
        return  UsuarioController.recuperar(pId);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO atualizar(Usuario pUsuario)
    {
        return UsuarioController.atualizar(pUsuario);
    }

    @DELETE
    @Path("/Remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO remover(@PathParam("id") int pId)
    {
        return UsuarioController.remover(pId);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO pesquisar()
    {
        return UsuarioController.pesquisar();
    }

    @GET
    @Path("/PesquisarPorEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO pesquisarPorEmail(@PathParam("email") String pEmail)
    {
        return UsuarioController.pesquisarPorEmail(pEmail);
    }

    @GET
    @Path("/PesquisarPorNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO pesquisarPorNome(@PathParam("nome") String pNome)
    {
        return UsuarioController.pesquisarPorNome(pNome);
    }
}
