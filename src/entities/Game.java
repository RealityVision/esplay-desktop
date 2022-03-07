/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Timestamp;


/**
 *
 * @author fadhe
 */

public class Game {

    private static final long serialVersionUID = 1L;
    
    private Integer idGame;
    
    private String title;
    
    private String description;
    
    private int size;

    
    private Double rate;
   
    private int category;
    
    private Timestamp date;
    
    private String image;
    
    private int ratenbr;

    public Game(Integer idGame, String title, String description, int size, Double rate, int category, String image, int ratenbr) {
        this.idGame = idGame;
        this.title = title;
        this.description = description;
        this.size = size;
        this.rate = rate;
        this.category = category;
        this.image = image;
        this.ratenbr = ratenbr;
    }

    public int getRatenbr() {
        return ratenbr;
    }

    public void setRatenbr(int ratenbr) {
        this.ratenbr = ratenbr;
    }

    public Game() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    
    public Game(Integer idGame) {
        this.idGame = idGame;
    }

    public Game(String title, String description, int size, int category,String image) {
        this.title = title;
        this.description = description;
        this.size = size;
        this.category = category;
         this.image = image;

       
    }

    public Game(Integer idGame, String title, String description, int size, Double rate, int category, String image) {
        this.idGame = idGame;
        this.title = title;
        this.description = description;
        this.size = size;
        this.rate = rate;
        this.category = category;
        this.image = image;
    }
    

    public Game(Integer idGame, String title, String description, int size, Double rate, int category) {
        this.idGame = idGame;
        this.title = title;
        this.description = description;
        this.size = size;
        this.rate = rate;
        this.category = category;
    }

    

    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGame != null ? idGame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.idGame == null && other.idGame != null) || (this.idGame != null && !this.idGame.equals(other.idGame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "idGame=" + idGame + ", title=" + title + ", description=" + description + ", size=" + size + ", rate=" + rate + ", category=" + category + ", date=" + date + ", image=" + image + '}';
    }

    
    
    
}
