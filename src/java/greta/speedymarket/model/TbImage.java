package greta.speedymarket.model;
// Generated 19 sept. 2016 16:55:44 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TbImage generated by hbm2java
 */
public class TbImage  implements java.io.Serializable {


     private String urlImage;
     private String INom;
     private String ILibelle;
     private Set tbArticles = new HashSet(0);
     private Set tbCategories = new HashSet(0);

    public TbImage() {
    }

	
    public TbImage(String urlImage, String INom) {
        this.urlImage = urlImage;
        this.INom = INom;
    }
    public TbImage(String urlImage, String INom, String ILibelle, Set tbArticles, Set tbCategories) {
       this.urlImage = urlImage;
       this.INom = INom;
       this.ILibelle = ILibelle;
       this.tbArticles = tbArticles;
       this.tbCategories = tbCategories;
    }
   
    public String getUrlImage() {
        return this.urlImage;
    }
    
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    public String getINom() {
        return this.INom;
    }
    
    public void setINom(String INom) {
        this.INom = INom;
    }
    public String getILibelle() {
        return this.ILibelle;
    }
    
    public void setILibelle(String ILibelle) {
        this.ILibelle = ILibelle;
    }
    public Set getTbArticles() {
        return this.tbArticles;
    }
    
    public void setTbArticles(Set tbArticles) {
        this.tbArticles = tbArticles;
    }
    public Set getTbCategories() {
        return this.tbCategories;
    }
    
    public void setTbCategories(Set tbCategories) {
        this.tbCategories = tbCategories;
    }




}

