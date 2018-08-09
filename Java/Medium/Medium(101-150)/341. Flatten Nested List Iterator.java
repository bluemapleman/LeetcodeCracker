
/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
 public NestedIterator(List<NestedInteger> nestedList) {
            lists = new Stack<>();
            lists.push(nestedList.listIterator());
        }

        public Integer next() {
            hasNext();
            return lists.peek().next().getInteger();
        }

        public boolean hasNext() {
            while (!lists.empty()) {
                if (!lists.peek().hasNext()) {
                    lists.pop();
                } else {
                    NestedInteger x = lists.peek().next();
                    if (x.isInteger())
                        return lists.peek().previous() == x;
                    lists.push(x.getList().listIterator());
                }
            }
            return false;
        }
        
        private Stack<ListIterator<NestedInteger>> lists;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */