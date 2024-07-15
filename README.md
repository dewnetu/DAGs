# QUESTIONS to be answered WITH the CODING EXERCISE:
## Does the solution work for larger graphs?
Yes, the solution is designed to work for larger graphs as well, provided the graphs fit within the memory constraints of the system and the execution time is acceptable.

## Can you think of any optimizations?
1. Avoid Duplicate Object Creation: Instead of creating new Vertex objects when adding edges, use a map to store and reuse existing vertices.
2. Simplify Topological Sort: The topological sort can be simplified to use a single method to avoid unnecessary complexity.
3. Efficient Use of Data Structures: Using more efficient data structures, such as ArrayDeque instead of Stack and HashMap for dynamic programming, can improve performance.
4. Edge Case Handling: Ensure the solution handles edge cases like an empty graph or a start vertex with no outgoing edges.
## What’s the computational complexity of your solution?
he time complexity of the algorithm is 
𝑂(𝑉+𝐸)
O(V+E), where 
V is the number of vertices and 
E is the number of edges, making it efficient for large DAGs.
## Are there any unusual cases that aren&#39;t handled?
Like an empty graph or a start vertex with no outgoing edges
