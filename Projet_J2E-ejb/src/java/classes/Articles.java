/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

public class Articles {
    public ArrayList<Articles> articles;
    private int ref;
    private String type;
    private double prixUnitaire;
    private int stock;
    private STATUT statutA = STATUT.DISPONIBLE;

    private Articles() {
        this.ref = 0;
        this.type = null;
        this.prixUnitaire = 0;
        this.stock = 0;
    }
    public enum STATUT {
        DISPONIBLE, INDISPONIBLE;
    }

    public Articles(int ref, String type, double prixUnitaire, int stock) {
        this.ref = ref;
        this.type = type;
        this.prixUnitaire = prixUnitaire;
        this.stock = stock;
    }

    public void addArticle(){
        Articles newA = new Articles();
        articles.add(newA);
    }
 
    public void deleteArticles(int ref){
        articles.remove(ref);
    }
    
    public void majproduct(int ref, int stock){
        Articles article = articles.get(ref);
        article.stock = stock;
        articles.set(ref, article);
    }
    
    public void statutBecomeIndispo(int ref){
        Articles article = articles.get(ref);
        if (article.statutA == STATUT.DISPONIBLE){
            article.statutA = STATUT.INDISPONIBLE;
        }
        else{
            article.statutA = STATUT.DISPONIBLE;
        }
        articles.set(ref, article);
    }
    
    
}
