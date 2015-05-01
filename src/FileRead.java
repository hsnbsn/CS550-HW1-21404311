
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Scanner;


public class FileRead {
    
    public static ArrayList<Datas> IRIS=new ArrayList<Datas>();
    public static ArrayList<Datas> IRIS_TEST=new ArrayList<Datas>();
    
    //public static ArrayList<Datas> IRIS_MISSING_TRAIN=new ArrayList<Datas>();
    //public static ArrayList<Datas> IRIS_MISSING_TEST=new ArrayList<Datas>();
    
    public static ArrayList <String> realValues =new ArrayList<String>();
   // public static ArrayList <String> missingRealValues =new ArrayList<String>();
    
    public static Double MeanSL;
    public static Double MeanSW;
    public static Double MeanPL;
    public static Double MeanPW;
    
    public static void trainRead(String input) throws FileNotFoundException {
        
      
            File f = new File(input);//dosta
            Scanner sc = new Scanner(f);
          
            int i=0;
            
             while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] details = line.split(",");
                

                Double sepallength = Double.valueOf(details[0]);
                
                Double sepalwidth = Double.valueOf(details[1]);
                
                Double petallength = Double.valueOf(details[2]);
                
                Double petalwidth = Double.valueOf(details[3]);
                
                String sinif = details[4];
                
                Datas d = new Datas(sepallength, sepalwidth, petallength, petalwidth, sinif);
                IRIS.add(d);
                i++;
                
            }
             
         
            
             


    
}

    public static void testRead(String input) throws FileNotFoundException {

    File f = new File(input);//dosta
            Scanner sc = new Scanner(f);

          int j=0;
            
             while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] details = line.split(",");
                

                Double sepallength = Double.valueOf(details[0]);
                Double sepalwidth = Double.valueOf(details[1]);
                Double petallength = Double.valueOf(details[2]);
                Double petalwidth = Double.valueOf(details[3]);
                
                realValues.add(details[4]);
 
                Datas d = new Datas(sepallength, sepalwidth, petallength, petalwidth);
                IRIS_TEST.add(d);
                
               // System.out.println(" --> "+ realValues.get(j) );
                j++;
                
                
                
                
            }
             
             
             
             
    }
    
    public static void missingValuesTrainRead(String input ) throws FileNotFoundException {
        
        


        

    File f = new File(input);//dosta
            Scanner sc = new Scanner(f);
             while(sc.hasNextLine()){
                 
                Double sepallength=0.0;
                Double sepalwidth=0.0;
                Double petallength=0.0;
                Double petalwidth=0.0;
                
                String classu="";
                String line = sc.nextLine();
                String[] details = line.split(",");

                if(!details[0].equals("?"))sepallength=Double.valueOf(details[0]);
                if(!details[1].equals("?"))sepalwidth = Double.valueOf(details[1]);
                if(!details[2].equals("?"))petallength = Double.valueOf(details[2]);
                if(!details[3].equals("?"))petalwidth = Double.valueOf(details[3]);
                classu=details[4];
                
                Datas d = new Datas(sepallength, sepalwidth, petallength, petalwidth,classu);
                IRIS.add(d);

            }
             
    int petalLengthCounter=0;
    int sepalLengthCounter=0;
    int petalWidthCounter=0;
    int sepalWidthCounter=0;
    
    double petalLength=0;
    double sepalLength=0;
    double petalWidth=0;
    double sepalWidth=0;
   
      for (int i=0;i<IRIS.size();i++)
      {
          
          if (IRIS.get(i).getPetalLength()> 0 )
          {
              petalLengthCounter++;
              petalLength = petalLength + IRIS.get(i).getPetalLength();
          }
          
          if (IRIS.get(i).getPetalWidth()> 0 )
          {
              petalWidthCounter++;
              petalWidth = petalWidth + IRIS.get(i).getPetalWidth();
          }
            
          if (IRIS.get(i).getSepalLength()> 0 )
          {
              sepalLengthCounter++;
              sepalLength = sepalLength + IRIS.get(i).getSepalLength();
          }
          
          if (IRIS.get(i).getSepalWidth()> 0 )
          {
              sepalWidthCounter++;
              sepalWidth = sepalWidth + IRIS.get(i).getSepalWidth();
          }

        }
      
    MeanSL=  sepalLength / sepalLengthCounter;
    MeanPL=  petalLength / petalLengthCounter;
    MeanSW=  sepalWidth / sepalWidthCounter;
    MeanPW=  petalWidth / petalWidthCounter;
    

    System.out.println("MEAN of PetalLength " +round(MeanPL,1));
     System.out.println("MEAN of SepalLenth " +round(MeanSL,1));
      System.out.println("MEAN of PetalWidth " +round(MeanPW,1));
       System.out.println("MEAN of SepalWidth " +round(MeanSW,1));
    
    for (int i=0;i<IRIS.size();i++)
      {
          
          if (IRIS.get(i).getPetalLength() == 0 )  IRIS.get(i).setPetalLength(round(MeanPL,1));
          if (IRIS.get(i).getPetalWidth() == 0 )  IRIS.get(i).setPetalWidth(round(MeanPW,1));
          if (IRIS.get(i).getSepalLength()== 0 )  IRIS.get(i).setSepalLength(round(MeanSL,1));
          if (IRIS.get(i).getSepalWidth() == 0 )  IRIS.get(i).setSepalWidth(round(MeanSW,1));
          
        
      }
    
             
    }
    
    public static void missingValuesTestRead(String input) throws FileNotFoundException {


    File f = new File(input);//dosta
            Scanner sc = new Scanner(f);

             while(sc.hasNextLine()){
                 
                  Double sepallength=0.0;
        Double sepalwidth=0.0;
        Double petallength=0.0;
        Double petalwidth=0.0;
                String line = sc.nextLine();
                String[] details = line.split(",");
                
                
                if(details[0].equals("?")) sepallength=MeanSL;
                else sepallength = Double.valueOf(details[0]);
                
                if(details[1].equals("?")) sepalwidth=MeanSW;
                else sepalwidth = Double.valueOf(details[1]);
                
                if(details[2].equals("?"))petallength=MeanPL;
                else petallength = Double.valueOf(details[2]);
                
                if(details[3].equals("?")) petalwidth=MeanPW;
                else petalwidth = Double.valueOf(details[3]);
                
                realValues.add(details[4]);

                Datas d = new Datas(sepallength, sepalwidth, petallength, petalwidth);
                IRIS_TEST.add(d);
                
                
                
                
            }
    }
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}

    
}

   