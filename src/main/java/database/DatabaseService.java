/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Johannes Eifert
 */
public class DatabaseService {
   protected static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("nasreldin_johannes_calory_book_war_1.0PU");
   protected EntityManager EM = EMF.createEntityManager();
   
   public void createUser(UserTable _user){
       
       EM.getTransaction().begin();
       
       EM.persist(_user);
       
       EM.flush();
       EM.close();
   }
   
}
