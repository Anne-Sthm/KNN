package anne.knn_2;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.io.*;

/**
 *
 * @author Anne
 */
public class Comparaison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i=0;
        int k, n, j, l;
        int t=0;
        int es =0;
        double ppd=100000;
        double distance;
        String espece_finale="";
        float longS[]=new float[500]; 
        float largS[]=new float[500];
        float longP[]=new float[500];
        float largP[]=new float[500];
        int cherche[]=new int [3];
        String esp[]=new String[500]; 
        String espt[]=new String[12];
        File source = new File("iris.txt");
        String setosa ="setosa";
        String vesicolor ="vesicolor";
        String virginica ="virginica";
        System.out.println("Quelle est la longeur de ses sepales ?");
        float x1 = Lire.f();
        System.out.println("Quelle est la largeur de ses sepales ?");
        float y1 = Lire.f();
        System.out.println("Quelle est la longeur de ses petales ?");
        float x2=Lire.f();
        System.out.println("Quelle est la largeur de ses petales ?");
        float y2=Lire.f();
        
        try {
        
    
        Scanner sc = new Scanner (new FileInputStream(source));
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer parametre = new StringTokenizer(line, ","); 
            String SlongS = parametre.nextToken();
            String SlargS = parametre.nextToken();
            String SlongP = parametre.nextToken();
            String SlargP = parametre.nextToken();
            String espece = parametre.nextToken();
            longS[i] = Float.parseFloat(SlongS);
            largS[i] = Float.parseFloat(SlargS);
            longP[i] = Float.parseFloat(SlongP);
            largP[i] = Float.parseFloat(SlargP);
            esp[i]=espece;     
            i=i+1;
        
        }
        } catch (IOException e)  {
        System.out.println("Pas de fichier existant");
        }
        
       
        
            for(j=0;j<=11;j++) { 
                for (l=0;l<i;l++){
                    distance = (longS[l]-x1)*(longS[l]-x1)+(largS[l]-y1)*(largS[l]-y1)+(longP[l]-x2)*(longP[l]-x2)+(largP[l]-y2)*(largP[l]-y2);
                    distance = Math.sqrt(distance);
                    if (distance<ppd ) {
                        ppd=distance;
                        es=l;
                        //System.out.println(l);
                    }
                }
            
            espt[j]=esp[es];
            longS[es]=10000;
            largS[es]=10000;
            longP[es]=10000;
            largP[es]=10000;
            ppd=100000;
            }
            
            for (j=0;j<=11;j++) {
                if (espt[j].equals(setosa)==true){
                    cherche[0]=cherche[0]+1;
                } else {
                    if (false!=espt[j].equals(vesicolor)) {
                        cherche[2]=cherche[2]+1;
                    } else {
                        cherche[1]=cherche[1]+1;
                    }
                }
            }
            
            if (cherche[0]>cherche[1]&&cherche[0]>cherche[2]){
                espece_finale="setosa";
            }else{
                if (cherche[1]>cherche[0]&&cherche[1]>cherche[2]) {
                    espece_finale="vesicolor";
                } else {
                    if (cherche[2]>cherche[1]&&cherche[2]>cherche[0]) {
                        espece_finale="virginica";
                    }
                }
                
            }
            
            
             
            
            
            
            
        System.out.println("Pour k="+12+":"+espece_finale);
        
      
    }
}
