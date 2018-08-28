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
public class ProduktetDepo {
            private int barkodi;
            private String emriProduktit;
            private double qmimi;
            private int sasia;
            
            public ProduktetDepo(int barkodi,String emriProduktit,double qmimi,int sasia){
                this.barkodi=barkodi;
                this.emriProduktit=emriProduktit;
                this.qmimi=qmimi;
                this.sasia=sasia;
            }
            
            public int getBarkodi(){
                return barkodi;
            }
            
            public String getEmriProduktit(){
                return emriProduktit;
            }
            
            public double getQmimi(){
                return qmimi;
            }
            
            public int getSasia(){
                return sasia;
            }
}
