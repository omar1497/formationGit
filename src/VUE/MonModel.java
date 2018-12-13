/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;
import  java.util.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */

public class MonModel extends AbstractTableModel {
    
    
    private int  NbLig=0;
    private int NbCol;
    private String [] Titres ;
    private ArrayList<Vector<String>> MesLignes = new ArrayList<Vector<String>>();
    
    public  MonModel(ResultSet  Rs)
    {   
        try {
            
            ResultSetMetaData rsmd = Rs.getMetaData();
            
            NbCol=rsmd.getColumnCount();
            Titres=new String[NbCol];
            for(int i =0 ; i<NbCol;i++)
            Titres[i]=rsmd.getColumnName(i+1);
 
            Vector<String> Ligne; 
            while(Rs.next())
            {
                Ligne=new Vector<String>();
                for( int i = 0 ; i < NbCol ; i++)
                {   
                    
                    Ligne.add(Rs.getObject(i+1).toString());
                    
                
                }
                MesLignes.add(Ligne);
                    this.NbLig++;
                
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        
    }

    @Override
    public String getColumnName(int column) {
        return this.Titres[column]; //To change body of generated methods, choose Tools | Templates.
    }

    
   
    @Override
    public int getRowCount() {
        return this.NbLig;
    }

    @Override
    public int getColumnCount() {
        return this.NbCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.MesLignes.get(rowIndex).get(columnIndex);
    }
}
