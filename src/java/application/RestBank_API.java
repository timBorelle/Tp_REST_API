/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import clients.Client;
import clients.ListeClient;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tim-b
 */
@Path("rest")
public class RestBank_API {
 
    private ListeClient clients = new ListeClient();
    
    @GET
    @Produces("text/plain")
    public String getText() {
        return "Service REST Bank"+'\n'
                +" /ajouterClient?nom=yourName&prenom=yourFirstName"+'\n'
                +" /modifierClient/id/nom/prenom"+'\n'
                +" /consulterClient/id"+'\n'
                +" /all"+'\n'
                +" /supprimerClient/id";
    }
    
    /*@GET
    @Path("creerListeClients")
    @Produces("text/plain")
    public String creerListeClients() {
        return "Créer liste de clients";
    }*/
    
    @POST
    @Path("ajouterClient")    
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_XML)
    public String ajouterClient(@QueryParam("nom") String nom, 
                                @QueryParam("prenom") String prenom) { 
        
        Client newClient = new Client();
        newClient.setId(this.clients.getLastId()+1);
        newClient.setNom(nom);
        newClient.setPrenom(prenom);
        this.clients.ajouterClientdansListe(newClient);
        return "Ajouter client "+'\n'+"Bienvenue "+ newClient.toString();
    }
    
    @PUT
    @Path("modifierClient/{id}/{nom}/{prenom}")
    //@Produces(MediaType.APPLICATION_XML)
    @Produces("text/plain")
    public String modifierClient(@PathParam("id") String id,
                                 @PathParam("nom") String nom,
                                 @PathParam("prenom") String prenom) {
        
        for(Client c : this.clients.consulterListeClient()){
            if (c.getId()==Integer.parseInt(id)) {
                c.setNom(nom);
                c.setPrenom(prenom);
                return "Client modifié avec succès "+'\n'+c.toString();
            }
        }
        return "Le client avec l'id "+id+" est introuvable !";    
    }
    
    @GET
    @Path("consulterClient/{id}")
    @Produces("application/xml")
    public Client consulterClient(@PathParam("id") String id) {
        

            for(Client c : this.clients.consulterListeClient()){
            if (c.getId()==Integer.parseInt(id)) {
               return this.clients.consulterClient(c.getId());
            }
        }
        
        /*Integer nullInt = null;
        Client nullClient = new Client();
        nullClient.setId(nullInt);
        nullClient.setNom(null);
        nullClient.setPrenom(null);*/
        //return nullClient;
        throw new WebApplicationException("Le client avec l'id "+id+" est introuvable !", 200);
        //return null;
    }
    
    /*
     * consulter Liste Client
    */
    @GET
    @Path("all")
    //@Consumes(MediaType.APPLICATION_XML)
    //@Produces("text/plain")
    @Produces(MediaType.APPLICATION_XML)
    public List<Client> getAll() {
        
        //return "consulter toutes les infos des Client";
        //return new ListeClient();
        return this.clients.consulterListeClient();
    }
    
    @DELETE
    @Path("supprimerClient/{id}")
    @Produces("text/plain")
    public String supprimerClient(@PathParam("id") String id) {
        
        for(Client c : this.clients.consulterListeClient()){
            if (c.getId()==Integer.parseInt(id)) {
                this.clients.supprimerClient(c);
                return "Client supprimé avec succès "+'\n'+c.toString();
            }
        }
        return "Le client avec l'id "+id+" est introuvable !"; 
    }
    
}
