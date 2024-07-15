import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LongestPathDAGTest {

	@Test
	void test1() {
		Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = Arrays.asList(v1, v2, v3, v4, v5);
        List<Edge> edges = Arrays.asList(
            new Edge(v1, v2),
            new Edge(v1, v3),
            new Edge(v3, v4),
            new Edge(v4, v5),
            new Edge(v2, v5)
        );

        Vertex startVertex = v1;
        LongestPathDAG lpd = new LongestPathDAG();
        int result = lpd.longestPathDAG(vertices, edges, startVertex);
        assertEquals(3, result);
	}

	@Test
	void test2() {
		Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(5);
        Vertex v7 = new Vertex(5);
        Vertex v8 = new Vertex(5);

		List<Vertex> vertices = Arrays.asList(v1, v2, v3, v4, v5);
		List<Edge> edges = Arrays.asList(
				new Edge(v1, v2),
				new Edge(v1, v3),
				new Edge(v3, v4),
				new Edge(v4, v5),
				new Edge(v5, v6),
				new Edge(v6, v7),
				new Edge(v2, v5)
				);
		 Vertex startVertex = v1;
	     LongestPathDAG lpd = new LongestPathDAG();
	     int result = lpd.longestPathDAG(vertices, edges, startVertex);
	     assertEquals(5, result);
	}
	@Test
	void test3() {
		Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = Arrays.asList(v1, v2, v3, v4, v5);
        List<Edge> edges = Arrays.asList(
            new Edge(v1, v2),
            new Edge(v1, v3),
            new Edge(v4, v5)
        );

        Vertex startVertex = v1;
        LongestPathDAG lpd = new LongestPathDAG();
        int result = lpd.longestPathDAG(vertices, edges, startVertex);
        assertEquals(1, result);
		
	}
	@Test
	void test4() {
		Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = Arrays.asList(v1, v2, v3, v4, v5);
        List<Edge> edges = Arrays.asList(
            new Edge(v1, v2),
            new Edge(v1, v3),
            new Edge(v2, v3),
            new Edge(v4, v5)
        );

        Vertex startVertex = v1;
        LongestPathDAG lpd = new LongestPathDAG();
        int result = lpd.longestPathDAG(vertices, edges, startVertex);
        
        assertEquals(2, result);
		
	}
	@Test
	void test5() {

        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
        	vertices.add(new Vertex(i));                                                                                                                                                                                                                                                                                                       
        }
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < 999; i++) {
        	edges.add(new Edge(vertices.get(i), vertices.get(i+1)));                                                                                                                                                                                                                                                                                                       
        }

        Vertex startVertex = vertices.get(0);
        LongestPathDAG lpd = new LongestPathDAG();
        int result = lpd.longestPathDAG(vertices, edges, startVertex);
        
        assertEquals(999, result);
		
	}
	
	
}
