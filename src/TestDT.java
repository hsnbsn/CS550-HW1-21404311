
import java.util.ArrayList;
public class TestDT {
    public static ArrayList<String> predicts=new ArrayList<String>();
   
    public static void Test (Node node, Datas data){
        double value=node.value;
        
        if (node.isLeaf==false)
        {
            if (node.attrb.equals("petallength"))
            {
                if (data.getPetalLength()<= node.value) 
                    Test(node.children_yes,data);
                else 
                    Test(node.children_no,data);
            }
    
             if (node.attrb.equals("sepallength"))
            {
                if (data.getSepalLength()<= node.value) 
                    Test(node.children_yes,data);
                else 
                    Test(node.children_no,data);
            }
            
             if (node.attrb.equals("petalwidth"))
            {
                if (data.getPetalWidth()<= node.value) 
                    Test(node.children_yes,data);
                else 
                    Test(node.children_no,data);
            }
        
             if (node.attrb.equals("sepalwidth"))
            {
                if (data.getSepalWidth()<= node.value) 
                    Test(node.children_yes,data);
                else 
                    Test(node.children_no,data);
            }
        }
        
        else {
        //System.out.println(node.classu);
        predicts.add(node.classu);
        
            }
    
    
    }
    
   
    
    }
    
  
