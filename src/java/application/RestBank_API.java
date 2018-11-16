/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 *
 * @author tim-b
 */
@Path("RestBank_API")
public class RestBank_API {
 
    @GET
    @Produces("text/plain")
    public String getText() {
        return "Service REST Bank";
    }
    
    @GET
    @Path("creerListeClients")
    @Produces("text/plain")
    public String creerListeClients() {
        return "Créer liste de clients";
    }
    
    @GET
    @Path("ajouterClient")
    @Produces("text/plain")
    public String ajouterClient() {
        return "Ajouter client";
    }
    
    @GET
    @Path("modifierClient")
    @Produces("text/plain")
    public String modifierClient() {
        return "Modifier client";
    }
    
    @GET
    @Path("consulterClient")
    @Produces("text/plain")
    public String consulterClient() {
        return "consulter Client";
    }
    
    @GET
    @Path("consulterListeClient")
    @Produces("text/plain")
    public String consulterListeClient() {
        return "consulter toutes les infos des Client";
    }
    
    @GET
    @Path("supprimerClient")
    @Produces("text/plain")
    public String supprimerClient() {
        return "supprimer Client !";
    }
    
}
