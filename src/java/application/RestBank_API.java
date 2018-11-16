/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import clients.ListeClient;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tim-b
 */
@Path("rest")
public class RestBank_API {
 
    @GET
    @Produces("text/plain")
    public String getText() {
        
        return "Service REST Bank";
    }
    
    /*@GET
    @Path("creerListeClients")
    @Produces("text/plain")
    public String creerListeClients() {
        return "Créer liste de clients";
    }*/
    
    @POST
    @Path("ajouterClient")      // /{nom}/{prenom}
    //@Produces("text/plain")
    @Consumes(MediaType.APPLICATION_XML)  //réel
    public String ajouterClient(Client client) { /* @PathParam("nom") String nom, 
                                @PathParam("prenom") String prenom */
        return "Ajouter client "/*+'\n'+"Bienvenue "+nom+" "+prenom*/;
    }
    
    @GET
    @Path("modifierClient")
    @Produces("text/plain")
    public String modifierClient() {
        return "Modifier client";
    }
    
    @GET
    @Path("consulterClient")
    @Produces("application/xml")
    public String consulterClient() {
        return "consulter Client";
    }
    
    /*
     * consulter Liste Client
    */
    @GET
    @Path("all")
    @Consumes(MediaType.APPLICATION_XML)
    public ListeClient getAll() {
        //return "consulter toutes les infos des Client";
        return new ListeClient();
    }
    
    @GET
    @Path("supprimerClient")
    @Produces("text/plain")
    public String supprimerClient() {
        return "supprimer Client !";
    }
    
}
