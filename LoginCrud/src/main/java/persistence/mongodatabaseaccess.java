/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.User;

/**
 *
 * @author blandonm
 */
public class mongodatabaseaccess {
    
    private User databaseUser;

    public User getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(User databaseUser) {
        this.databaseUser = databaseUser;
    }
    
}
