package anne.knn_2;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.StringTokenizer;

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
        int k,n, j, l;
        int t=0;
        
        int es =0;
        double ppd=100000;
        double distance;
        float longS[]=new float[500]; 
        float largS[]=new float[500];
        float longP[]=new float[500];
        float largP[]=new float[500];
        String esp[]=new String[500]; 
        
        File source = new File("iris.txt");
        
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
        
        for (k=1;k<=i-1;k++){ //choix du k
        
            for(j=0;j<=k-1;j++) { 
                for (l=k;l<=i;l++){
                    distance = (longS[l]-longS[j])*(longS[l]-longS[j])+(largS[l]-largS[j])*(largS[l]-largS[j])+(longP[l]-longP[j])*(longP[l]-longP[j])+(largP[l]-largP[j])*(largP[l]-largP[j]);
                    distance = Math.sqrt(distance);
                    if (distance<ppd ) {
                        ppd=distance;
                        es=l;
                        
                    }
                }
            if (esp[es].equals(esp[j])){
            t=t+1;
            }
             
            ppd=100000;
            }
            
            
        System.out.println("Pour k="+k+":"+t+"/"+k); 
        t=0;
        }
      
    }
}
