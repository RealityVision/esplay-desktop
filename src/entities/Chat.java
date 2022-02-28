/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Timestamp;
import java.util.Objects;
/**
 *
 * @author khaled
 */
public class Chat {
    private int id_message,id_user;
    private String message,username,picture,file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Chat{" + "id_message=" + id_message + ", id_user=" + id_user + ", message=" + message + ", username=" + username + ", picture=" + picture + ", file=" + file + ", date_message=" + date_message + '}';
    }

    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    private Timestamp date_message;
    
        public Chat() {
            }

    public Chat(int id_user, String message) {
        this.id_user = id_user;
        this.message = message;
       
    }
    public Chat(int id_user,String file,String message ) {
        this.id_user = id_user;
        this.message=null;
        this.file=file;
      
    }

    

    
    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getDate_message() {
        return date_message;
    }

    public void setDate_message(Timestamp date_message) {
        this.date_message = date_message;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chat other = (Chat) obj;
        if (this.id_message != other.id_message) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.picture, other.picture)) {
            return false;
        }
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        if (!Objects.equals(this.date_message, other.date_message)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
}
