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
            
    public ListeClient(){
        this.inventaire = new ArrayList<>();
    }
    
    public void ajouterClientdansListe(String nom, String prenom){
        Client c1 = new Client(nom, prenom);
        this.inventaire.add(c1);
    }
    
    public void modifierClient(){
        
    }
    
    public Client consulterClient(){
        Client c = null;
        
        return c;
    }
    
    public List<Client> consulterListeClient(){
        List<Client> lc = null;
        
        return lc;
    }
    
    public void supprimerClient(){
        
    }
            
}
