package ist.meic.pa;

import ist.meic.pa.graph.Graph;

public class Inspector {
	
	private Graph<Object> graph;

	public Inspector() {
		super();
		this.graph = new Graph<Object>();
	}
	
	public Object obtainCurrentObj() {
		return this.graph.getCurrentObject();
	}
	
	public void modifyCurrentObj(Object obj) {
		this.graph.add(obj);
	}

	public void inspect(Object object) {

	}

}
