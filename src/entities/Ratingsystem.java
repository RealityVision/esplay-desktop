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

public class Ratingsystem  {

    private static final long serialVersionUID = 1L;
    
    private Integer idRate;
    
    private int stars;
    
    private String comments;

    public Ratingsystem() {
    }

    public Ratingsystem(Integer idRate) {
        this.idRate = idRate;
    }

    public Ratingsystem(Integer idRate, int stars, String comments) {
        this.idRate = idRate;
        this.stars = stars;
        this.comments = comments;
    }

    public Integer getIdRate() {
        return idRate;
    }

    public void setIdRate(Integer idRate) {
        this.idRate = idRate;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRate != null ? idRate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratingsystem)) {
            return false;
        }
        Ratingsystem other = (Ratingsystem) object;
        if ((this.idRate == null && other.idRate != null) || (this.idRate != null && !this.idRate.equals(other.idRate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.games.Ratingsystem[ idRate=" + idRate + " ]";
    }
    
}
