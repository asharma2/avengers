package com.avengers.dsa.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private int vertices;
	private List<Integer> adj[];

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		adj = new LinkedList[this.vertices];
		for (int i = 0; i < this.vertices; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void dfs(int v) {
		boolean visited[] = new boolean[vertices];
		dfs(v, visited);
	}

	public void dfs(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				dfs(n, visited);
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.dfs(2);
	}
}
