/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Johannes Eifert
 */
public class DatabaseService {
    
   private static DatabaseService instance;
   
   protected static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("nasreldin_johannes_calory_book_war_1.0PU");
   protected EntityManager EM = EMF.createEntityManager();
   
   private DatabaseService(){}
   
   public synchronized static DatabaseService getInstance() 
    {
        if (instance == null) 
        {
            instance = new DatabaseService();
        }
        return instance;
    }
   
   public void createUser(UserTable _user){
       
       EM.getTransaction().begin();
       
       EM.persist(_user);
       
       EM.flush();
       EM.getTransaction().commit();
   }
   
   
   //returns false if there exists no such entry, else true
   public boolean isUser(UserTable _user){
       UserTable result = null;
       
       if(_user.getIdUser()!=null){
           try{
                result = (UserTable) EM.createNamedQuery("UserTable.findByIdUser")
                    .setParameter("idUser", _user.getIdUser())
                    .getSingleResult();
           } catch(NoResultException noResultException){
               System.out.println("no results for the id catched");
               return false;
           }
           
       } else if(_user.getSportUsername()!=null){
           try{
                result = (UserTable) EM.createNamedQuery("UserTable.findByNameUser")
                    .setParameter("sportUsername", _user.getSportUsername())
                    .getSingleResult();
           } catch(NoResultException noResultException){
               System.out.println("no results for the name catched");
               return false;
           }
       }
       else {
           
           System.out.println("User was not found. Give it an Id or a username");
           return false;
       }
       if (result!= null){
           return true;
       } else {
           return false;
       }
       
   }
   
   public UserTable getUser(UserTable _user){
       UserTable result = null;
       
       if(_user.getIdUser()!=null){
           try{
                result = (UserTable) EM.createNamedQuery("UserTable.findByIdUser")
                    .setParameter("idUser", _user.getIdUser())
                    .getSingleResult();
           } catch(NoResultException noResultException){
               System.out.println("no results for the id catched");
           }
           
       }
       else if(_user.getSportUsername()!=null){
           try{
                result = (UserTable) EM.createNamedQuery("UserTable.findByNameUser")
                    .setParameter("sportUsername", _user.getSportUsername())
                    .getSingleResult();
           } catch(NoResultException noResultException){
               System.out.println("no results for the name catched");
           }
       }
       else {
           
           System.out.println("User was not found. Give it an Id or a username");
           return null;
       }
       
      return result;
   }
   
}
