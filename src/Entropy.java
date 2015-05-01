import java.util.ArrayList;
import java.util.List;

public class Entropy {	
    
         
                
	public static double calculateEntropy(List<Datas> data) {
		double entropy = 0;
                double probability_iris_setosa;
                double probability_iris_versicolor;
                double probability_iris_virginica;
                double size=data.size();
                
		
		if(data.size() == 0) { //Gelen array boşşa yapma...
		// nothing to do 
			return 0;
		}
		
                int iris_setosa = 0;
                int iris_versicolor = 0;
                int iris_virginica = 0;

		for(int i = 0; i < data.size();i++) 
                
                {
			
                 if (data.get(i).getsinif().equals("Iris-setosa")) iris_setosa++;
                 if (data.get(i).getsinif().equals("Iris-versicolor")) iris_versicolor++;
                 if (data.get(i).getsinif().equals("Iris-virginica")) iris_virginica++;
                 
                }

                        probability_iris_setosa = iris_setosa / size;
                        probability_iris_versicolor = iris_versicolor / size;
                        probability_iris_virginica = iris_virginica / size;
                        
                           if (probability_iris_setosa==0)probability_iris_setosa=1;
                            if (probability_iris_versicolor==0)probability_iris_versicolor=1;
                            if (probability_iris_virginica==0)probability_iris_virginica=1;
                        
              
                          
                                entropy =  -(probability_iris_setosa * Math.log(probability_iris_setosa) / Math.log(2))
                                           -(probability_iris_versicolor * Math.log(probability_iris_versicolor) / Math.log(2))
                                           -(probability_iris_virginica * Math.log(probability_iris_virginica) / Math.log(2))  ;
                        
                          
    
		
		return entropy;
	}
	


}