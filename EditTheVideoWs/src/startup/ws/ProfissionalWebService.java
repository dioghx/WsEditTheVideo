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

import startup.control.ProfissionalController;
import startup.dto.ProfissionalDTO;
import startup.model.Profissional;

@Path("/Profissional")
public class ProfissionalWebService
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO cadastrar(Profissional pProfissional)
    {
        return ProfissionalController.cadastrar(pProfissional);
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO recuperar(@PathParam("id") int pId)
    {
        return  ProfissionalController.recuperar(pId);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO atualizar(Profissional pProfissional)
    {
        return ProfissionalController.atualizar(pProfissional);
    }

    @DELETE
    @Path("/Remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO remover(@PathParam("id") int pId)
    {
        return ProfissionalController.remover(pId);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO pesquisar()
    {
        return ProfissionalController.pesquisar();
    }

    @GET
    @Path("/PesquisarPorEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO pesquisarPorEmail(@PathParam("email") String pEmail)
    {
        return ProfissionalController.pesquisarPorEmail(pEmail);
    }

    @GET
    @Path("/PesquisarPorNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfissionalDTO pesquisarPorNome(@PathParam("nome") String pNome)
    {
        return ProfissionalController.pesquisarPorNome(pNome);
    }
}
