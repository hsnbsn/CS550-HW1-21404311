
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author volka_000
 */
public class Calculator {
    
    public static double entropy (ArrayList <Datas> data, int k)
    {
        ArrayList<Datas> leftArray =new ArrayList(data.subList(0,k));
        ArrayList<Datas> rightArray =new ArrayList(data.subList(k,data.size()));
        
        double size=data.size();
        double entropy = 0;
        double entropyForLeft=0;
        double entropyForRight=0;
        
        double probabilityIrisSetosaLeft=0;
        double probabilityIrisVersicolorLeft=0;
        double probabilityIrisVirginicaLeft=0;
        
        double probabilityIrisSetosaRight=0;
        double probabilityIrisVersicolorRight=0;
        double probabilityIrisVirginicaRight=0;
        
        int irisSetosaLeft = 0;
        int irisVersicolorLeft  = 0;
        int irisVirginicaLeft  = 0;
        
        int irisSetosaRight = 0;
        int irisVersicolorRight  = 0;
        int irisVirginicaRight  = 0;
        
        
        for (int i=0;i<leftArray.size();i++)
            
        {
            if (leftArray.get(i).getsinif().equals("Iris-setosa")) irisSetosaLeft++;
            if (leftArray.get(i).getsinif().equals("Iris-versicolor")) irisVersicolorLeft++;
            if (leftArray.get(i).getsinif().equals("Iris-virginica")) irisVirginicaLeft++;
        }
        
        double leftArraySize=leftArray.size();
        
        probabilityIrisSetosaLeft=irisSetosaLeft/leftArraySize;
        probabilityIrisVersicolorLeft=irisVersicolorLeft/leftArraySize;
        probabilityIrisVirginicaLeft=irisVirginicaLeft/leftArraySize;
        
       
        
        if (probabilityIrisSetosaLeft==0)probabilityIrisSetosaLeft=1;
        if (probabilityIrisVersicolorLeft==0)probabilityIrisVersicolorLeft=1;
        if (probabilityIrisVirginicaLeft==0)probabilityIrisVirginicaLeft=1;
        
        entropyForLeft=
                -(probabilityIrisSetosaLeft * Math.log(probabilityIrisSetosaLeft) / Math.log(2))
                -(probabilityIrisVersicolorLeft * Math.log(probabilityIrisVersicolorLeft) / Math.log(2))
                -(probabilityIrisVirginicaLeft * Math.log(probabilityIrisVirginicaLeft) / Math.log(2))  ;
        
        
        for (int i=0;i<rightArray.size();i++)
            
        {
            if (rightArray.get(i).getsinif().equals("Iris-setosa")) irisSetosaRight++;
            if (rightArray.get(i).getsinif().equals("Iris-versicolor")) irisVersicolorRight++;
            if (rightArray.get(i).getsinif().equals("Iris-virginica")) irisVirginicaRight++;
        }
        
        
         double rightArraySize=rightArray.size();
        
        probabilityIrisSetosaRight=irisSetosaRight/rightArraySize;
        probabilityIrisVersicolorRight=irisVersicolorRight/rightArraySize;
        probabilityIrisVirginicaRight=irisVirginicaRight/rightArraySize;
        
        if (probabilityIrisSetosaRight==0)probabilityIrisSetosaRight=1;
        if (probabilityIrisVersicolorRight==0)probabilityIrisVersicolorRight=1;
        if (probabilityIrisVirginicaRight==0)probabilityIrisVirginicaRight=1;
        
        
        entropyForRight=
                -(probabilityIrisSetosaRight * Math.log(probabilityIrisSetosaRight) / Math.log(2))
                -(probabilityIrisVersicolorRight * Math.log(probabilityIrisVersicolorRight) / Math.log(2))
                -(probabilityIrisVirginicaRight * Math.log(probabilityIrisVirginicaRight) / Math.log(2))  ;
        
        
        entropy =  ((leftArraySize/size)*entropyForLeft)+((rightArraySize/size)*entropyForRight);
        
     
        
        return entropy;
    
    }
    
}
