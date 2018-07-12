/*
#  Count Primes

Description:

Count the number of prime numbers less than a non-negative number, n.

- My Answer
*/
package easy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月25日
 */
public class CountPrimes
{
    public static void main(String[] args)
    {
        System.out.println(countPrimes(499979));
    }
    
    // First of all, starting from 2, hypothesizing that all numbers are prime, then:
    //   Using [Prime Filtering Method] to pre-remove known composite:
    //   "If number i is a prime, then for any integer k>0, i*k must be a composite"
    //   Make use of above law, every time we find a new prime, we could pre-remove great amounts of composite and save time for judging prime. 
    public static int countPrimes(int n) {
        if(n==0 || n==1)
            return 0;
        boolean[] compositeArr=new boolean[n];
        List<Integer> primeList=new ArrayList<Integer>();
        for(int i=2;i<n;i++) {
            if(compositeArr[i]==true)
                continue;
            else {
                primeList.add(i);
                for(int k=2;i*k<n;k++)
                    compositeArr[i*k]=true;
            }
        }
        return primeList.size();
    }
}


