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
public class AtributetEStokut {    
            private int stokuID;
            private int barkodi;
            private String emriIProduktit;
            private double qmimi;
            private int sasia;
          
            
            public AtributetEStokut(int stokuID,int barkodi,String emriIProduktit,double qmimi,int sasia){
                this.stokuID=stokuID;
                this.barkodi=barkodi;
                this.emriIProduktit=emriIProduktit;
                this.qmimi=qmimi;
                this.sasia=sasia;
                
            }
            
            public int getStokuID(){
                return stokuID;
            }
            
            public int getBarkodi(){
                return barkodi;
            }
            
            public String getEmriIProduktit(){
                return emriIProduktit;
            }
            
            public double getQmimi(){
                return qmimi;
            }
            
            public int getSasia(){
                return sasia;
            }
            
            
    
}
