/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


/**
 *
 * @author fadhe
 */

public class Game {

    private static final long serialVersionUID = 1L;
    
    private Integer idGame;
    
    private String title;
    
    private String description;
    
    private float size;
    
    private String rate;
   
    private String category;

    public Game() {
    }

    public Game(Integer idGame) {
        this.idGame = idGame;
    }

    public Game(Integer idGame, String title, String description, float size, String rate, String category) {
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return "Game{" + "idGame=" + idGame + ", title=" + title + ", description=" + description + ", size=" + size + ", rate=" + rate + ", category= " + category + '}';
    }

    
    
}
