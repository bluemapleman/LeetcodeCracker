
/*
YEquations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


*/
class Solution {
    // typical BFS/DFS
    // BFS way
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans=new double[queries.length];
        // by default
        for(int i=0;i<ans.length;i++)
            ans[i]=-1.0;
        
        for(int i=0;i<queries.length;i++) {
            Map<String, String> precedingMap=new HashMap<>();
            String[] query=queries[i];
            String from=query[0],to=query[1];
            
            if(BFS(from, to, equations,precedingMap)) {
                if(from.equals(to)) {
                    ans[i]=1.0;
                    continue;
                }
                ans[i]=calDivision(equations, values, from, to, precedingMap);
            }
        }
    
        return ans;
    }
    
    public boolean BFS(String from,String to,String[][] equations,Map<String, String> precedingMap) {
        ArrayDeque<String> open=new ArrayDeque<>();
        Set<String> closed=new HashSet<>();
        
        open.add(from);
        while(!open.isEmpty()) {
            String currentNode=open.poll();
            for(String[] equation:equations) {
                if(equation[0].equals(currentNode)) {
                    if(!closed.contains(equation[1])) {
                        precedingMap.put(equation[1],currentNode);
                        open.add(equation[1]);
                    }
                    if(equation[1].equals(to)) {
                        return true;
                    }
                }else if(equation[1].equals(currentNode)) {
                    if(!closed.contains(equation[0])) {
                        precedingMap.put(equation[0],currentNode);
                        open.add(equation[0]);
                    }
                    if(equation[0].equals(to)) {
                        return true;
                    }
                }
            }
            closed.add(currentNode);
        }
        return false;
    }
    
    public double calDivision(String[][] equations,double[] values,String from,String to,Map<String, String> precedingMap){
        double res=1.0;
        String last=precedingMap.get(to);
        while(true) {
            for(int j=0;j<equations.length;j++) {
                String[] equation=equations[j];
                if(last.equals(equation[0]) && to.equals(equation[1])){
                    res*=values[j];
                }else if(to.equals(equation[0]) && last.equals(equation[1])){
                    res*=1.0/values[j];
                }
            }
            to=last;
            last=precedingMap.get(to);
            // back trace to from
            if(last==null)
                break;
        }
        return res;
    }
}


