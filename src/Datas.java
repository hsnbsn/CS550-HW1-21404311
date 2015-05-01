
import java.util.Comparator;

public class Datas {
 
	private double SepalLength;
	private double SepalWidth;
        private double PetalLength;
        private double PetalWidth;
	private String sinif; //Iris-setosa=1 , Iris-versicolor=2, Iris-virginica=3
 
	public Datas(double SepalLength, double SepalWidth, double PetalLength, double PetalWidth, String sinif) {
		super();
		this.SepalLength = SepalLength;
		this.SepalWidth = SepalWidth;
		this.PetalLength = PetalLength;
                this.PetalWidth = PetalWidth;
                this.sinif=sinif;
	}
        
        public Datas(double SepalLength, double SepalWidth, double PetalLength, double PetalWidth) {
		super();
		this.SepalLength = SepalLength;
		this.SepalWidth = SepalWidth;
		this.PetalLength = PetalLength;
                this.PetalWidth = PetalWidth;
               
	}
 
	public double getSepalLength() {
		return SepalLength;
	}
        
	public void setSepalLength(double SepalLength) {
		this.SepalLength = SepalLength;
	}
        
        public double getSepalWidth() {
		return SepalWidth;
	}
        
	public void setSepalWidth(double SepalWidth) {
		this.SepalWidth = SepalWidth;
	}
        
        public double getPetalLength() {
		return PetalLength;
	}
        
	public void setPetalLength(double PetalLength) {
		this.PetalLength = PetalLength;
	}
        
        public double getPetalWidth() {
		return PetalWidth;
	}
        
	public void setPetalWidth(double PetalWidth) {
		this.PetalWidth = PetalWidth;
	}
        
	public String getsinif() {
		return sinif;
	}
        
	public void setid(String sinif) {
		this.sinif = sinif;
	}
        
        public static Comparator<Datas> PetalwidthCopmp = new Comparator<Datas>() {
        @Override
        public int compare(Datas o1, Datas o2) {
        if (o1.getPetalWidth() < o2.getPetalWidth()) return -1;
        if (o1.getPetalWidth() > o2.getPetalWidth()) return 1;
        return 0;}};
        
        public static Comparator<Datas> SepalwidthCopmp = new Comparator<Datas>() {
        @Override
        public int compare(Datas o1, Datas o2) {
        if (o1.getSepalWidth() < o2.getSepalWidth()) return -1;
        if (o1.getSepalWidth() > o2.getSepalWidth()) return 1;
        return 0;}};
        
        public static Comparator<Datas> PetalLenCopm = new Comparator<Datas>() {
        @Override
        public int compare(Datas o1, Datas o2) {
        if (o1.getPetalLength() < o2.getPetalLength()) return -1;
        if (o1.getPetalLength() > o2.getPetalLength()) return 1;
        return 0;}};
        
        public static Comparator<Datas> SepalLenCopmp = new Comparator<Datas>() {
        @Override
        public int compare(Datas o1, Datas o2) {
        if (o1.getSepalLength()< o2.getSepalLength()) return -1;
        if (o1.getSepalLength() > o2.getSepalLength()) return 1;
        return 0;}};



       
}