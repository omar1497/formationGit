/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */
public class Daobd {
    private static String Pilote; 
    private static String Url;
    private static String Login;
    private  static  String  Password ; 
    private static  Connection Connexion;
    public void SeConnecter() 
    {
       
            
            try {
                System.out.println("Chargmenet de Pilote");
                Class.forName(Pilote);
                System.out.println("Chargement dee Pilote reussi .....");
                Connexion=DriverManager.getConnection(Url, Login, Password);
                System.out.println("Connexion etablie ");
            } catch (ClassNotFoundException ex) {
                System.err.println("Chargment de Pilote Echoue "+ex.getMessage());
            } catch (SQLException ex) {
           System.err.println("Connnextion  Echoue "+ex.getMessage());
        }
        
    }

    public static String getPilote() {
        return Pilote;
    }

    public static void setPilote(String Pilote) {
        Daobd.Pilote = Pilote;
    }

    public static String getUrl() {
        return Url;
    }

    public static void setUrl(String Url) {
        Daobd.Url = Url;
    }

    public static String getLogin() {
        return Login;
    }

    public static void setLogin(String Login) {
        Daobd.Login = Login;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        Daobd.Password = Password;
    }

    public static Connection getConnexion() {
        return Connexion;
    }

    public static void setConnexion(Connection Connexion) {
        Daobd.Connexion = Connexion;
    }
}
