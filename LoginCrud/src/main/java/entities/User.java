/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import org.bson.Document;

/**
 *
 * @author blandonm
 */
public class User {
    
    private String fullName;
    
    private String username;
    
    private String email;
    
    private String password;

    public User() {
        this.fullName = null;
        this.username = null;
        this.email = null;
        this.password = null;
    }

    public User(String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    
    
    

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Get the value of fullName
     *
     * @return the value of fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set the value of fullName
     *
     * @param fullName new value of fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public static User fromDocumentToUser(Document doc){
        try{
            User user = new User(
                    doc.getString("fullName"), 
                    doc.getString("username"), 
                    doc.getString("email"), 
                    doc.getString("password"));
                
        return user;
        }
        catch (Exception ex){
            System.out.println("Error converting Documento to User: " + ex);
            return null;
        }
    }
    
    public Document toDocument() {
        try{
            Document doc = new Document("fullName", this.fullName)
                .append("username", this.username)
                .append("email", this.email)
                .append("password", this.password);
            
                
        return doc;
        }
        catch (Exception ex){
            System.out.println("Error converting User to Document: " + ex);
            return null;
        }
    }
}
