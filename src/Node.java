
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
public final class Node {
    
	private Node parent;
	public Node children_yes;
        public Node children_no;
        public boolean isLeaf;
	private ArrayList <Datas> data;
	public double value;
        public String classu;
        public int counter;
        public String attrb;
        



	public Node() {
		this.data = new ArrayList<Datas>();//Datalar gelecek
		setEntropy(0.0);
		setParent(null);
		setChildrenNo(null);
                setChildrenYes(null);
		
	}
        
        public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}

	public void setData(ArrayList<Datas> data) {
		this.data = data;
	}

	public ArrayList getData() {
		return data;
	}

	public void setEntropy(double entropy) {
		this.value = entropy;
	}

	public double getEntropy() {
		return value;
	}

	public void setChildrenYes(Node children) {
		this.children_yes = children;
	}

	public Node getChildren() {
		return children_yes;
	}
        
        public void setChildrenNo(Node children) {
		this.children_no = children;
	}

	public Node getChildrenNo() {
		return children_no;
	}
        
        public String getclassu() {
		return classu;
	}

     
	

}