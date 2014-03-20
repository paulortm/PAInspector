package ist.meic.pa.graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	private T obj;
	private Node<T> root;
	private List<Node<T>> childrens;
	
	protected Node(T obj, Node<T> root) {
		super();
		this.obj = obj;
		this.root = root;
		this.childrens = new ArrayList<Node<T>>(); 
	}
	
	protected T getObj() {
		return this.obj;
	}
	
	protected void addChildren(Node<T> node) {
		this.childrens.add(node);
	}
}
