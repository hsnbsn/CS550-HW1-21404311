
public class statistics {
    
    public static void calcstats()
    
    { 
        int iris_setosaReal=0;
        int iris_versicolorReal=0;
        int iris_virginicaReal=0;
        
        int iris_setosaCalc=0;
        int iris_versicolorCalc=0;
        int iris_virginicaCalc=0;
        
        
        
        int [][]confmatrix=new int[3][3];
        String [][]confmatrixTitle=new String[3][3];
       
        
        confmatrixTitle[0][0]="Iris-setosa";
        confmatrixTitle[0][1]="Iris-versicolor";
        confmatrixTitle[0][2]="Iris-virginica";

        confmatrixTitle[1][0]="Iris-versicolor";
        confmatrixTitle[2][0]="Iris-virginica";
                
        for(int i = 0; i < FileRead.realValues.size();i++) 
                {	
                 if (FileRead.realValues.get(i).equals("Iris-setosa")) iris_setosaReal++;
                 if (FileRead.realValues.get(i).equals("Iris-versicolor")) iris_versicolorReal++;
                 if (FileRead.realValues.get(i).equals("Iris-virginica")) iris_virginicaReal++;
                 
                 if (TestDT.predicts.get(i).equals("Iris-setosa")) iris_setosaCalc++;
                 if (TestDT.predicts.get(i).equals("Iris-versicolor")) iris_versicolorCalc++;
                 if (TestDT.predicts.get(i).equals("Iris-virginica")) iris_virginicaCalc++;
                }
        
        confmatrix[0][0]= iris_setosaReal;
        confmatrix[1][1]= iris_versicolorReal;
        confmatrix[2][2]= iris_virginicaReal;
        
        //System.out.println("Instance Nu.    Real Value        Calculated Value");
        //System.out.println( "----------     ----------        ----------------");
        int stat=0;
        String error;
        for (int i =0 ; i< FileRead.realValues.size();i++)   
        {
            error="error";
            String a=(FileRead.realValues.get(i));
            String b=(TestDT.predicts.get(i));
            
            
            if (a.equals(b)) 
            {
                stat++; error="";
            }
            
            else 
            {
                if (FileRead.realValues.get(i).equals("Iris-setosa"))
                {
                    if (TestDT.predicts.get(i).equals("Iris-versicolor")) {confmatrix[1][0]++;confmatrix[0][0]--;}
                    if (TestDT.predicts.get(i).equals("Iris-virginica"))  {confmatrix[2][0]++;confmatrix[0][0]--;}
                }
                
                  if (FileRead.realValues.get(i).equals("Iris-versicolor"))
                {
                    if (TestDT.predicts.get(i).equals("Iris-setosa")) {confmatrix[0][1]++;confmatrix[1][1]--;}
                    if (TestDT.predicts.get(i).equals("Iris-virginica"))  {confmatrix[2][1]++;confmatrix[1][1]--;}
                }
                  
                     if (FileRead.realValues.get(i).equals("Iris-virginica"))
                {
                    if (TestDT.predicts.get(i).equals("Iris-setosa")) {confmatrix[0][2]++;confmatrix[2][2]--;}
                    if (TestDT.predicts.get(i).equals("Iris-versicolor"))  {confmatrix[1][2]++;confmatrix[2][2]--;}
                }
                
                
            }

            //System.out.println( i+ "             " +a + "         " + b +"  "+ error);
            
            
        }
        double size=TestDT.predicts.size();
        double result=stat/size*100;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("DATASET EVALUATION SCORE  : %"+result);
        System.out.println();
                System.out.println();
                
        System.out.println("------------CONFUSION MATRIX-------------");    
        System.out.println("--------------COMPUTED VALUES------------|");
        System.out.println("        |     1    |     2    |    3     |") ;
        System.out.println("-----------------------------------------|");
        
        
        for (int k=0; k<3;k++)
            {   
              //if (k==0)System.out.println( "            "+k+ " ");
              System.out.println("");
                
           
                
                for (int l=0;l<3;l++)
                {   
                    if (l==0)
                     System.out.print(k+1+"_REAL  |   "+confmatrix [l][k]+ "    ");
                    
                    else 
                        System.out.print("  |    "+confmatrix [l][k]+ "    ");
                        
                }
         
            }
        
         System.out.println();
         System.out.println();
         System.out.println();
        System.out.println(" 1 : Iris-setosa ");
        System.out.println(" 2 : Iris-versicolor ");
        System.out.println(" 3 : Iris-virginica ");
        
        //
        
    }
    

    
    public static void basicStats()
    {
        int error=0;
        double size=TestDT.predicts.size();
        
        
        for (int i=0;i< TestDT.predicts.size() ;i++)
        {
            if (!TestDT.predicts.get(i).equals(FileRead.realValues.get(i))) error++;
            
        }
        
        System.out.println("THRESHOLD VALUE "+Algorithm.threshold +" -->  SUCCESS  %"+(100-(error/size*100)));
        System.out.println("DATASET SIZE " + size + "  MISCLASSIFIED : " + error);
        
    } 
    
    
}
