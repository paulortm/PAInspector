package ist.meic.pa.graph;

public class Graph<T> {

	private Node<T> current;

	public Graph() {
		super();
		this.current = null;
	}

	public T getCurrentObject() {
		return this.current.getObj();
	}

	public void add(T obj) {
		Node<T> node = new Node<T>(obj, this.current);
		if (this.current != null)
			this.current.addChildren(node);
		this.current = node;
	}
}
