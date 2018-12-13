/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.Daobd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */
public class GestionArticle
{
    
    
    private Statement St ;
    private   Daobd dao; 
     private Connection con;
   
    public  GestionArticle()
    {
          dao=new Daobd();
        Daobd.setPilote("com.mysql.jdbc.Driver");
        Daobd.setUrl("jdbc:mysql://localhost:3306/bd18_19");
        Daobd.setLogin("root");
        Daobd.setPassword("");
        dao.SeConnecter();
        con=Daobd.getConnexion(); 
        
     
    }
    
    public void create  ( int code ,String des , float prix)
    {
        String Req;
        Req="insert into article values('"+code+"','"+des+"','"+prix+"');";
        
        
            try {
                if(con!=null)
        {
                St=con.createStatement();
                St.executeUpdate(Req);
                
        }
            }
            catch (SQLException ex) {
                System.err.println("Erreur de la requete  Insert : "+ex.getMessage());
            }
            
        }
    public void all_Articles()
     { 
         String Req ; 
         ResultSet Rs;
                 
        
          try {
                if(con!=null)
                  {
                    St=con.createStatement();
                    Rs=St.executeQuery("select * from article ;");
                
                     while(Rs.next())
                    {
                    System.out.println(Rs.getInt(1)+"  "+Rs.getString("designation")+"  "+Rs.getFloat(3));
                    }
                  }
               } 
          catch (SQLException ex) {
              System.err.println("Erreur de la requete Select "+ex.getMessage());
        }
     }
    
        public ResultSet LesArticles()
            { 
                String Req ; 
                ResultSet Rs = null;


                 try {
                       if(con!=null)
                         {
                           St=con.createStatement();
                           Rs=St.executeQuery("select * from article ;");


                         }
                      } 
                 catch (SQLException ex) {
                     System.err.println("Erreur de la requete Select "+ex.getMessage());
               }
                 return Rs;
             }

    public void Add(int code ,String des , float prix)
       {

            try {
                PreparedStatement Pst = con.prepareStatement("insert into article values (?,?,?)");
                Pst.setInt(1, code);
                Pst.setString(2, des);
                Pst.setFloat(3, prix);
                Pst.executeUpdate();


                }   
            catch (SQLException ex) {
                 System.err.println("Erreur dant la requete  Insert (prepared) "+ex.getMessage());   
                                    }
            
       }
   
    public void Delete (int code )
    {
         
        try { 
            St=con.createStatement();
            
            String req= "delete from article where code='"+code+"'";
             St.executeUpdate(req);
           
        } catch (SQLException ex) {
            System.err.println("Erreur requete delete "+ex.getMessage());
        }
        
        
    }
    // delete avec prepareStatement .. 
    
    
    public void updatePrix(int code, float prix )
    {
        
        PreparedStatement Pst;
        try {
            Pst = con.prepareStatement("update article set prix=? where code=?");
             Pst.setFloat(1, prix);
            Pst.setInt(2,code);
            int nb= Pst.executeUpdate();
            System.out.println("Maj Reussi: nbr de ligne affectes est  "+nb);
            
        } catch (SQLException ex) {
            System.err.println("Maj echoue "+ex.getMessage());
        }
      
        
        
    }
       
    public void update(int code,String  Des , float prix )
    {
        
        PreparedStatement Pst;
        try {
            Pst = con.prepareStatement("update  article set prix=?,designation =? where code=?");
             Pst.setFloat(1, prix);
             Pst.setString(2,Des);
            Pst.setInt(3,code);
            int nb= Pst.executeUpdate();
            System.out.println("Maj Reussi: nbr de ligne affectes est  "+nb);
            
        } catch (SQLException ex) {
            System.err.println("Maj echoue "+ex.getMessage());
        }
      
        
        
    }
    
    
    public void  Rechercher(int code)
    {
        try {
            PreparedStatement Pst = con.prepareStatement("select * from article  where code=?");
             Pst.setInt(1, code);
              ResultSet Rs= Pst.executeQuery();
              while(Rs.next())
              {
                     System.out.println(Rs.getInt(1)+"  "+Rs.getString("designation")+"  "+Rs.getFloat(3));
              }
                
           
    }  
        catch (SQLException ex) {
            Logger.getLogger(GestionArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
            }
}
            
