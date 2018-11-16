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
        this.inventaire.add(new Client("nom 1", "prenom 1"));
        this.inventaire.add(new Client("nom 2", "prenom 2"));
        this.inventaire.add(new Client("nom 3", "prenom 3"));
    }

    public void ajouterClientdansListe(Client c) {
        this.inventaire.add(c);
    }

    public void modifierClient(Client c, String nom, String prenom) {
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

}
