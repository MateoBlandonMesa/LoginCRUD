/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.User;
import java.util.List;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author blandonm
 */
public class MongoDatabaseAccess {
    
    private List<User> databaseUsers;
    
    private MongoDatabase dataBase;
    
    private MongoCollection<Document> usersCollection;

    public MongoDatabaseAccess() {
        var client = MongoClients.create("mongodb+srv://mateoblandon:mongodb123@cluster0.el3zz.mongodb.net/");
        this.dataBase = client.getDatabase("LoginCrudDb");
        this.usersCollection = dataBase.getCollection("UsersCollection");
        this.databaseUsers = null;
    }
    
    

    public List<User> getDatabaseUsers() {
        FindIterable<Document> documents = usersCollection.find();
        this.databaseUsers = new ArrayList<>();

        for (Document doc : documents) {    
            databaseUsers.add(User.fromDocumentToUser(doc));
        }
        
        return databaseUsers;
    }

    public void setDatabaseUsers(List<User> databaseUsers) {
        this.databaseUsers = databaseUsers;
    }
    
    public User getDatabaseUser(String username) {
        Document doc = usersCollection.find(Filters.eq("username", username)).first();
        
        if (doc != null){         
            return User.fromDocumentToUser(doc);
        }
        else{
            return null;
        }
    }
    
    
    public void updateUser(String fullName, String username, String email, String password) {
        usersCollection.updateOne(Filters.eq("username", username),
                combine(set("fullName", fullName), set("username", username), set("email", email), set("password", password)));
        System.out.println("User updated: "+ username);
    }
    
    
    public void addUser(User user) {
        usersCollection.insertOne(user.toDocument());
        System.out.println("User added: " + user.getUsername());
    }
    
    public Boolean ValidateUsernameExists(String username){
         Boolean usernameExists;
         
         User user = getDatabaseUser(username);
         
         if(user != null){
             usernameExists = true;
             System.out.println("User does exists: " + user.getUsername());
         }
         else{
             usernameExists = false;
             System.out.println("User does not exists: " + username);
         }
         
         return usernameExists;
    }
    
    public Boolean ValidatePasswordIsCorrect(String username, String password){
        Boolean passwordIsCorrect;
        
        User user = getDatabaseUser(username);
        
        if(password.equals(user.getPassword())){
            passwordIsCorrect = true;
            System.out.println("Password is correct");
        }
        else{
            passwordIsCorrect = false;
            System.out.println("Password is not correct");
        }
        
        return passwordIsCorrect;
    }
}
