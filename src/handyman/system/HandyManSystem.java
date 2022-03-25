/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handyman.system;

/**
 *
 * @author JUDITH
 */
public class HandyManSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        dbConnection object1 = new dbConnection();
        object1.getConnection();
    }
    
}
