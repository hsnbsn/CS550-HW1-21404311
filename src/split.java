
import java.util.ArrayList;
import java.util.Collections;

public class split {
   
    
    public static int split(ArrayList<Datas> data){ // devam eden en uzun serinin class değiştirdiği index'i döner
    
    ArrayList<Integer> index=new ArrayList<Integer>(); //Class geçişlerinin indexlerinin tutulduğu array
    ArrayList<Double> entroyCalculated=new ArrayList<Double>();
   // index.add(0);//indexin başına 0 ekle..
  
    
    boolean donus;
   
    
    for (int i=0;i<data.size()-1;i++) //BURAYA DİKKAT sıkıntı olabilir.
    {   
        donus=data.get(i).getsinif().equals(data.get(i+1).getsinif());//bir sonraki class ile karşılaştır.
            if(donus==false)//eğer farklıysa...
            { 
                index.add(i+1); //sınıf değiştiği index'i tut.///ÖNEMLİİİİ
                           
            }
    }
    
    
   //for (int i=0;i<data.size();i++) System.out.print(index.get(i));
    
    
    for (int i=0;i<index.size();i++)
    
    {
        entroyCalculated.add(Calculator.entropy(data,index.get(i)));
    }
    
    int maxIndex=Collections.min(entroyCalculated).intValue();
    
    return index.get(maxIndex); //min entropy sağlayan yer..
    
 
    }
    
}
