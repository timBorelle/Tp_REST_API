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
        Client cExemple = new Client();
        cExemple.setId(getLastId()+1);
        cExemple.setNom("nom exemple");
        cExemple.setPrenom("prenom exemple");
        this.inventaire.add(cExemple);
    }

    public void ajouterClientdansListe(Client c) {
        this.inventaire.add(c);
    }

    public void modifierClient(Client c, String nom, String prenom) {
        c.setId(0);
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
