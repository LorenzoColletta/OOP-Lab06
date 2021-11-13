package it.unibo.oop.lab06.generics1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class UndirectedGraph<N> extends DirectedGraph<N> {


	public UndirectedGraph() {
		super();
	}

	@Override
	public void addEdge(N source, N target) {
		super.addEdge(source, target);
		super.addEdge(target, source);
	}



	

}
