/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajdbc;

import DAO.Daobd;
import MODEL.*;


/**
 *
 * @author omar
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GestionArticle A =new GestionArticle();
        
        /*  A.Add(7,"article7",2500);
        A.Add(8,"article8",2500);
        A.Add(9,"article9",2500);
        A.Add(10,"article10",2500);
        A.create(11, "article11", 2500);
        A.all_Articles();
        A.Add(1, "article2", 0);*/
      A.Delete(7);
      A.Delete(8);
      A.Delete(10);
      A.Delete(9);
      A.Delete(11);
      A.update(7,"arc",190);
      A.Rechercher(7);
      A.all_Articles();
        
      
      
        // TODO code application logic here
       // Daobd dao=new Daobd();
     /*   Daobd.setPilote("com.mysql.jdbc.Driver");
        Daobd.setUrl("jdbc:mysql://localhost:3306/bd18_19");
        Daobd.setLogin("root");
        Daobd.setPassword("");
        dao.SeConnecter();*/
     
        
    }
    
}
