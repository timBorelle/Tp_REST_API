/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tim-b
 */
@XmlRootElement
public class Client {
    
    private String nom;
    private String prenom;
    
    public Client(String nomC, String prenomC){
        this.nom = nomC;
        this.prenom = prenomC;
    }
    
    public void setNom(String nomC){
        this.nom = nomC;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setPrenom(String prenomC){
        this.prenom = prenomC;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
}
