
/*
Given a non-empty array of integers, return the k most frequent elements.

For example,

Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
- You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
- Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


*/
package medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class TopKFrequentElements
{
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
        
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int key=nums[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }else {
                map.put(key, 1);
            }
        }
        
        List<Entry<Integer,Integer>> list=new ArrayList<>();
        for(Entry<Integer,Integer> e:map.entrySet()) 
            list.add(e);
        // sort entry list according to entry's value
        Collections.sort(list, new Comparator<Entry<Integer,Integer>>()
        {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                if(o1.getValue()>o2.getValue())
                    return -1;
                else if(o1.getValue()==o2.getValue())
                    return 0;
                else
                    return 1;
            }
        });
        
        for(int i=0;i<k;i++)
            res.add(list.get(i).getKey());
        
        return res;
    }
}

