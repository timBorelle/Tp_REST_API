/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tim-b
 */
public class ListeClient {

    List<Client> inventaire;

    public ListeClient() {
        this.inventaire = new ArrayList<>();
        //peupler la liste de clients (sans base de données)
        Client cExemple = new Client();
        cExemple.setId(getLastId()+1);
        cExemple.setNom("Martin");
        cExemple.setPrenom("Paul");
        this.inventaire.add(cExemple);
        Client newClient = new Client();
        newClient.setId(this.getLastId()+1);
        newClient.setNom("Dupont");
        newClient.setPrenom("Jacques");
        this.inventaire.add(newClient);
    }

    public void ajouterClientdansListe(Client c) {
        this.inventaire.add(c);
    }

    public void modifierClient(Client c, String nom, String prenom) {
        c.setId(c.getId());
        c.setNom(nom);
        c.setPrenom(prenom);
    }

    public Client consulterClient(int id) {
        return this.inventaire.get(id);
    }

    public List<Client> consulterListeClient() {
        return this.inventaire ;
    }

    public void supprimerClient(Client c) {
        this.inventaire.remove(c);
    }
    
    public int getLastId(){
        if (!this.inventaire.isEmpty())
            return this.inventaire.get(this.inventaire.size() - 1).getId();
        return -1;
        
    }

}
