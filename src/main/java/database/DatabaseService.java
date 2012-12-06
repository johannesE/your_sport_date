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
   
   
   public static void createUser(UserTable _user, EntityManager _EM){
       
       _EM.getTransaction().begin();
       
       _EM.persist(_user);
       
       _EM.flush();
       _EM.getTransaction().commit();
   }
   
}
