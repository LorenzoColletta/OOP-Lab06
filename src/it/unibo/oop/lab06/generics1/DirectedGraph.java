package it.unibo.oop.lab06.generics1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Assert;

public class DirectedGraph<N> implements Graph<N> {

private Map<N,Set<N>> graph;
	
	public DirectedGraph() {
		// TODO Auto-generated constructor stub
		graph = new TreeMap<>();
	}

	@Override
	public void addNode(N node) {
		// TODO Auto-generated method stub
		if(!graph.containsKey(node)) {
			Set<N> linkedNodes = new TreeSet<N>();
			graph.put(node, linkedNodes);
			System.out.println("["+ node + "] -> " + graph.get(node));
		}
	}

	@Override
	public void addEdge(N source, N target) {
		// TODO Auto-generated method stub
		if(source != null && target != null) {
			this.addNode(source);
			Set<N> linkedNodes = graph.get(source);
			if(linkedNodes != null) {
				linkedNodes.add(target);				
			}
			System.out.println("["+ source + "] -> " + graph.get(source));
		}
	}

	@Override
	public Set<N> nodeSet() {
		// TODO Auto-generated method stub		
		return Set.copyOf(graph.keySet());
	}

	@Override
	public Set<N> linkedNodes(N node) {
		// TODO Auto-generated method stub
		return Set.copyOf(graph.get(node));
	}

	@Override
	public List<N> getPath(N source, N target) {
		
		List<N> path = new ArrayList<>();
		N temp = target;
		Map<N,N> tree = this.breadthFirstSearch(source);
		
		if(!tree.containsKey(temp)) {
			return Collections.emptyList();
		}
		
		while(temp != source ) {
			path.add(temp);
			temp = tree.get(temp);
		}
		
		path.add(temp);
		Collections.reverse(path);
		return path;
			
	}
	
	public Map<N,N> breadthFirstSearch(N source){
		
		var nodesQueue = new ArrayDeque<N>();
		Map<N,N> tree = new TreeMap<>();
		
		nodesQueue.add(source);
		tree.put(source,source);

		while (!nodesQueue.isEmpty()) {
			final var node = nodesQueue.pollFirst();
			for(N target : this.linkedNodes(node)) {
				if(!tree.containsKey(target)) {
					tree.put(target,node);
					nodesQueue.add(target);
				}	
			}
		}
		return tree;
	}
	
	
}
