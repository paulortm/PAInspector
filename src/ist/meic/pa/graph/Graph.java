package ist.meic.pa.graph;

import java.util.ArrayList;
import java.util.List;

import ist.meic.pa.graph.exception.*;

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

	public List<T> getCurrentChildren() {
		ArrayList<T> children = new ArrayList<T>();

		for (Node<T> node : this.current.getChildrens()) {
			children.add(node.getObj());
		}

		return children;
	}

	public void up() throws EmptyGraphException, RootReachedException {
		if (this.current == null) {
			throw new EmptyGraphException();
		} else if (this.current.getRoot() == null) {
			throw new RootReachedException();
		} else {
			this.current = this.current.getRoot();
		}
	}

	public void down(Integer childIndex) throws EmptyGraphException,
			InvalidChildException {
		if (this.current == null) {
			throw new EmptyGraphException();
		} else {
			try {
				this.current = this.current.getChildrens().get(childIndex);
			} catch (IndexOutOfBoundsException e) {
				throw new InvalidChildException();
			}
		}
	}
}
