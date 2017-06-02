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

import startup.control.EmpresaController;
import startup.dto.EmpresaDTO;
import startup.model.Empresa;

@Path("/Empresa")
public class EmpresaWebService
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO cadastrar(Empresa pEmpresa)
    {
        return EmpresaController.cadastrar(pEmpresa);
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO recuperar(@PathParam("id") int pId)
    {
        return  EmpresaController.recuperar(pId);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO atualizar(Empresa pEmpresa)
    {
        return EmpresaController.atualizar(pEmpresa);
    }

    @DELETE
    @Path("/Remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO remover(@PathParam("id") int pId)
    {
        return EmpresaController.remover(pId);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO pesquisar()
    {
        return EmpresaController.pesquisar();
    }

    @GET
    @Path("/PesquisarPorEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO pesquisarPorEmail(@PathParam("email") String pEmail)
    {
        return EmpresaController.pesquisarPorEmail(pEmail);
    }

    @GET
    @Path("/PesquisarPorNome_Curto/{nome_curto}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpresaDTO pesquisarPorNome_Curto(@PathParam("nome_curto") String pNome_Curto)
    {
        return EmpresaController.pesquisarPorNome_Curto(pNome_Curto);
    }
}
