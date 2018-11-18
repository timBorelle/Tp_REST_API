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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
        
        return "Service REST Bank";
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
        newClient.setNom("Dupont");
        newClient.setPrenom("Michel");
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
        //peupler la liste de clients (sans base de données)
        Client newClient = new Client();
        newClient.setId(this.clients.getLastId()+1);
        newClient.setNom("Dupont");
        newClient.setPrenom("Jacques");
        
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
    @Path("consulterClient/{id}/{nom}/{prenom}")
    @Produces("application/xml")
    public String consulterClient(@PathParam("id") String id,
                                 @PathParam("nom") String nom,
                                 @PathParam("prenom") String prenom) {
        //peupler la liste de clients (sans base de données)
        Client newClient = new Client();
        newClient.setId(this.clients.getLastId()+1);
        newClient.setNom("Dupont");
        newClient.setPrenom("Jacques");
        
        for(Client c : this.clients.consulterListeClient()){
            if (c.getId()==Integer.parseInt(id)) {
               this.clients.consulterClient(c.getId());
                return "Client supprimé avec succès "+'\n'+c.toString();
            }
        }
        return "Le client avec l'id "+id+" est introuvable !";
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
        //peupler la liste de clients (sans base de données)
        Client newClient = new Client();
        newClient.setId(this.clients.getLastId()+1);
        newClient.setNom("Dupont");
        newClient.setPrenom("Jacques");
        this.clients.ajouterClientdansListe(newClient);
        Client newClient2 = new Client();
        newClient2.setId(this.clients.getLastId()+1);
        newClient2.setNom("Nom");
        newClient2.setPrenom("Paul");
        this.clients.ajouterClientdansListe(newClient2);
        
        //return "consulter toutes les infos des Client";
        //return new ListeClient();
        return this.clients.consulterListeClient();
    }
    
    @PUT
    @Path("supprimerClient/{id}/{nom}/{prenom}")
    @Produces("text/plain")
    public String supprimerClient(@PathParam("id") String id,
                                 @PathParam("nom") String nom,
                                 @PathParam("prenom") String prenom) {
        //peupler la liste de clients (sans base de données)
        Client newClient = new Client();
        newClient.setId(this.clients.getLastId()+1);
        newClient.setNom("Dupont");
        newClient.setPrenom("Jacques");
        
        for(Client c : this.clients.consulterListeClient()){
            if (c.getId()==Integer.parseInt(id)) {
               this.clients.supprimerClient(c);
                return "Client supprimé avec succès "+'\n'+c.toString();
            }
        }
        return "Le client avec l'id "+id+" est introuvable !"; 
    }
    
}
