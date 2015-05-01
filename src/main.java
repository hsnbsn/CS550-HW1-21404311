
import java.io.Console;
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
   public static void main(String[] args) throws FileNotFoundException
    
    {
        Node root=new Node();
        

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press 1 for solution of Question-1");
        System.out.println("Press 2 for solution of Question-2");
        int selection = keyboard.nextInt();
        
  if (selection==1)
  {
      FileRead.trainRead("iris_train.txt");FileRead.testRead("iris_test.txt");
  }
  else if (selection ==2 ) 
  {
      FileRead.missingValuesTrainRead("iris_train_2.txt");FileRead.missingValuesTestRead("iris_test_2.txt");
  }
  
  else if (selection >2 ) { System.out.println("Wrong input .. Input must be 1 or 2");exit(0);}
  
  
 System.out.println("_________");
 
 

       // FileRead.missingValuesTrainRead("iris_train_2.txt"); //Read input  as train dataset , 
                                              //This function's result allocates training dataset to FileRead.IRIS arraylist
        
        
        //FileRead.missingValuesTestRead("iris_train_2.txt"); //Read input  as test dataset
                                             //This function's result allocates test dataset to FileRead.IRIS_TEST arraylist
   
  
  
         //FileRead.trainRead("iris_train.txt"); //Read input  as train dataset , 
                                              //This function's result allocates training dataset to FileRead.IRIS arraylist
        
        
        //FileRead.testRead("iris_test.txt"); //Read input  as test dataset
                                             //This function's result allocates test dataset to FileRead.IRIS_TEST arraylist
        
        ArrayList<Datas> train =new ArrayList<Datas>(FileRead.IRIS);
        ArrayList<Datas> test =new ArrayList<Datas>(FileRead.IRIS_TEST);
        
      
    

        Algorithm.threshold=0.7;
        
        
        Algorithm.ID(train,root,1); //Create decision tree with train data set
        System.out.println(Algorithm.results);

        for (int i=0;i<test.size();i++) TestDT.Test(root,test.get(i)); //gets 
        
       
        System.out.println();
        statistics.basicStats();
        statistics.calcstats();

      

    }
    
}
