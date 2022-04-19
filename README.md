Backtracking Dynamic Set ADT

In this section i will implement backtracking dynamic set ADT using different underlying
data structures.

My implementations  include all methods of the dynamic set ADT:

● search(S, k)

● insert(S, x)

● delete(S, x)

● minimum(S)

● maximum(S)

● successor(S, x)

● predecessor(S, x)

Also print function implemented;
print(S) – Prints only the values stored in the dynamic set. In array-based implementation the
printed values should be separated by single spaces, and ordered by index from low to high
(the value stored in the cell indexed 0 first, the value stored in the cell indexed 1 second, and
so on), and in a BST-based implementation the printed values should be in pre-order.
Examples follow. 


backtrack(S) – This method should cancel the last insert(S,x) or delete(S,x) performed by the
data structure and return the data-structure to exactly the same state prior to that action.
This means that after backtracking, the data structure should look as if the backtracked action
was never performed. If no insert/delete actions were performed by the data structure, then
the method should not change anything in the data structure
