
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author volka_000
 */
public class Algorithm {
    
    public static ArrayList<Datas> PetalWidthSirali =new ArrayList<Datas>();
    public static ArrayList<Datas> PetalLengthSirali =new ArrayList<Datas>();
    public static ArrayList<Datas> SepalWidthSirali =new ArrayList<Datas>();
    public static ArrayList<Datas> SepalLengthSirali =new ArrayList<Datas>();
    public static double Overall_Entropy;
    public static double threshold;
    public static int main_counter=0;
    public static String results = " ";
    
    public static void ID (ArrayList <Datas> data,Node node, int level) throws FileNotFoundException{

        
        Overall_Entropy=Entropy.calculateEntropy(data);// ilk entropy
        
        Double k=new Double (Overall_Entropy);
        if (k<=threshold){ 
            node.children_no=null;
            node.children_yes=null;
            node.isLeaf=true;
            //System.out.println("Leaf");
            
            if(data.size() > 0)
                node.classu=data.get(0).getsinif();
            results += repeat("\t", level-2) + "@"+node.classu+"@" ; 
            return;
        }
        main_counter++;

        /////////////////////////////////////////////////////////////////////////////////////////////////
        PetalLengthSirali=data;//Gelen Datayı yeni diziye at
        
        Collections.sort(PetalLengthSirali, Datas.PetalLenCopm); // verileri PetalLengh'e göre sırala...
        //for(int i=0;i<data.size();i++) System.out.println(data.get(i).getPetalLength()+ " ");
        //System.out.println("--");
        int donuspl=split.split(PetalLengthSirali);
        ArrayList<Datas> Uzun_SeriPL=new ArrayList<Datas>(PetalLengthSirali.subList(0,donuspl)); //Uzun arrayi yeni dizine at.
        ArrayList<Datas> Kalan_SeriPL=new ArrayList<Datas>(PetalLengthSirali.subList(donuspl,PetalLengthSirali.size())); //Kısa arrayi yeni dizine at.
        double ToplamGainPL=Calculator.entropy(data, donuspl);
        
        PetalWidthSirali=data;
        Collections.sort(PetalWidthSirali, Datas.PetalwidthCopmp); // verileri PetalWidth'e göre sırala...
        //for(int i=0;i<data.size();i++) System.out.println(data.get(i).getPetalWidth()+ " ");System.out.println("--");
        int donuspw=split.split(PetalWidthSirali); // en uzun serinin baslangic ve bitiş indexsi hesapla..donen veri donus[0]=basşlangıc [donus[1]=bitiş
        ArrayList<Datas> Uzun_SeriPW=new ArrayList<Datas>(PetalWidthSirali.subList(0, donuspw));
        ArrayList<Datas> Kalan_SeriPW=new ArrayList<Datas>(PetalWidthSirali.subList(donuspw,PetalWidthSirali.size())); //BURAYA DİKKAT
        double ToplamGainPW=Calculator.entropy(data, donuspw);

        SepalWidthSirali=data;
        Collections.sort(SepalWidthSirali, Datas.SepalwidthCopmp); // verileri PetalWidth'e göre sırala...
        //for(int i=0;i<data.size();i++) System.out.println(data.get(i).getSepalWidth()+ " ");System.out.println("--");
        int donussw=split.split(SepalWidthSirali); // en uzun serinin baslangic ve bitiş indexsi hesapla..donen veri donus[0]=basşlangıc [donus[1]=bitiş
        ArrayList<Datas> Uzun_SeriSW=new ArrayList<Datas>(SepalWidthSirali.subList(0, donussw));
        ArrayList<Datas> Kalan_SeriSW=new ArrayList<Datas>(SepalWidthSirali.subList(donussw,SepalWidthSirali.size())); //BURAYA DİKKAT
        double ToplamGainSW=Calculator.entropy(data, donussw);
        
        SepalLengthSirali=data; 
        Collections.sort(SepalLengthSirali, Datas.SepalLenCopmp); // verileri PetalWidth'e göre sırala...
       // for(int i=0;i<data.size();i++) System.out.println(data.get(i).getSepalLength()+ " ");System.out.println("--");
        int donussl=split.split(SepalLengthSirali); // en uzun serinin baslangic ve bitiş indexsi hesapla..donen veri donus[0]=basşlangıc [donus[1]=bitiş
        ArrayList<Datas> Uzun_SeriSL=new ArrayList<Datas>(SepalLengthSirali.subList(0, donussl));
        ArrayList<Datas> Kalan_SeriSL=new ArrayList<Datas>(SepalLengthSirali.subList(donussl,SepalLengthSirali.size())); //BURAYA DİKKAT
        double ToplamGainSL=Calculator.entropy(data, donussl);
 
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //----------------------------@@@@@@@@@@@@@@@@@@@@@@---------------------------------------------------
        ArrayList<Datas> bolunecek=new ArrayList<Datas> ();
        ArrayList<Datas> diger=new ArrayList<Datas> ();
        ArrayList<Double> infgains=new ArrayList<Double>(); //Bölümlerden elde edilen infgain değerleri..
        infgains.add(ToplamGainSL);
        infgains.add(ToplamGainPW);
        infgains.add(ToplamGainPL);
        infgains.add(ToplamGainSW);
        
        
        
        //for(int i=0;i<infgains.size();i++)System.out.println( " Dongu için --> "+i +infgains.indexOf(Collections.min(infgains))); 
        
        int min=infgains.indexOf(Collections.min(infgains));
        //int max_value=Collections.max(infgains).intValue();
        if (min==0)
            { 
                bolunecek=Uzun_SeriSL; 
                diger=Kalan_SeriSL; 
                //System.out.println("ATRRIBUTE SEPAL LENGTH WILL BE DIVIDED BY " ); 
                double h =bolunecek.get(bolunecek.size()-1).getSepalLength();
                
                results += repeat("\t", level) + "| SEPAL LENGTH: =< " + h + "\n";
                results += repeat("\t", level+1) +"/"+ repeat("\t", level+1)+ "|"+"\n";
                node.attrb="sepallength";
                node.value=h;
                node.isLeaf=false;
            }
        if (min==1)
            { 
                  bolunecek=Uzun_SeriPW; 
                  diger=Kalan_SeriPW; 
           
                  double h= bolunecek.get(bolunecek.size()-1).getPetalWidth();
                  
                  results += repeat("\t", level) +"| PETAL WIDTH: =< " + h + "\n";
                  results += repeat("\t", level) +"/"+ repeat("\t", level+1)+"|"+"\n";
                  node.attrb="petalwidth";
                  node.value=h;
                  node.isLeaf=false;
            }
        if (min==2)
            {
                  bolunecek=Uzun_SeriPL; 
                  diger=Kalan_SeriPL; 
               
                  double h= bolunecek.get(bolunecek.size()-1).getPetalLength();
             
                  results += repeat("\t", level) +"| PETAL LENGTH: =< " + h + "\n";
                  results += repeat("\t", level+1) +"/"+ repeat("\t", level+1) +"|"+ "\n";
                  node.attrb="petallength";
                  node.value=h;
                  node.isLeaf=false;
            }
        if (min==3)
            { 
                bolunecek=Uzun_SeriSW; 
                diger=Kalan_SeriSW; 
                
                double h= bolunecek.get(bolunecek.size()-1).getSepalWidth();
            
                results += repeat("\t", level) +"| SEPAL WIDTH: =< " + h + "\n";
                results += repeat("\t", level+1) +"/"+ repeat("\t", level+1)+"|"+"\n";
                node.attrb="sepalwidth";
                node.value=h;
                node.isLeaf=false;
            
            }

       
        node.children_yes=new Node();
  
        ID(bolunecek, node.children_yes ,level + 1);
        
        node.children_no=new Node();

        ID(diger,node.children_no ,level + 1);  
             
         
       
       
    
}
    public static String repeat(String s, int times) {
       if (times <= 0) return "";
        else return s + repeat(s, times-1);
    }
    
     public static void setThreshold(double s) {
         
           threshold=s;
    }
    
}