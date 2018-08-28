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
public class AtributetEPuntoreve {
        private int ID;
        private String emri;
        private String mbiemri;
        private String gjinia;
        private String username;
        
        public AtributetEPuntoreve(int ID,String emri,String mbiemri,String gjinia,String username){
           this.ID=ID;
           this.emri=emri;
           this.mbiemri=mbiemri;
           this.gjinia=gjinia;
           this.username=username;
        }
        
        public int getID(){
            return ID;
        }
        
        public String  getEmri(){
            return emri;
        }
        
        public String getMbiemri(){
            return mbiemri;
        }
        
        public String getGjinia(){
            return gjinia;
        }
        
        public String getUsername(){
            return username;
        }
}
