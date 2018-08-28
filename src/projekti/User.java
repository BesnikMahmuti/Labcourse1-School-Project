/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

/**
 *
 * @author Besnik
 */
public class User {
                private final int ID;
                private final String username;
                private final String password;
                private final String roli;
                
                public User(int ID,String username,String password,String roli){
                    this.ID=ID;
                    this.username=username;
                    this.password=password;  
                    this.roli=roli;
                }
                
                public int getID(){
                    return ID;
                }
                
                public String getUsername(){
                    return username;
                }
                
                public String getPassword(){
                    return password;
                }
                
                public String getRoli(){
                    return roli;
                }
                
}
