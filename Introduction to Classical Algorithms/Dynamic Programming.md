# 动态规划(Dynamic Programming)算法与LC实例的理解

希望通过写下来自己学习历程的方式帮助自己加深对知识的理解，也帮助其他人更好地学习，少走弯路。也欢迎大家来给我的[Github的Leetcode算法项目](https://github.com/bluemapleman/LeetcodeCracker)点star呀~~

[toc]

前言：动态规划（DP）是比较常见的一类算法，不是很容易理解其思想，但掌握后，解决对应问题有奇效。

# DP是什么

## 基本定义

先来看[维基百科的说明]()：

>
动态规划（英语：Dynamic programming，简称DP）是一种在数学、管理科学、计算机科学、经济学和生物信息学中使用的，通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。

>动态规划常常适用于有重叠子问题和最优子结构性质的问题，动态规划方法所耗时间往往远少于朴素解法。

>动态规划背后的基本思想非常简单。大致上，若要解一个给定问题，我们需要解其不同部分（即子问题），再合并子问题的解以得出原问题的解。

>通常许多子问题非常相似，为此动态规划法试图仅仅解决每个子问题一次，从而减少计算量：一旦某个给定子问题的解已经算出，则将其记忆化存储，以便下次需要同一个子问题解之时直接查表。这种做法在重复子问题的数目关于输入的规模呈指数增长时特别有用。

>动态规划在查找有很多重叠子问题的情况的最优解时有效。它将问题重新组合成子问题。为了避免多次解决这些子问题，它们的结果都逐渐被计算并被保存，从简单的问题直到整个问题都被解决。因此，动态规划保存递归时的结果，因而不会在解决同样的问题时花费时间。

>动态规划只能应用于有最优子结构的问题。最优子结构的意思是局部最优解能决定全局最优解（对有些问题这个要求并不能完全满足，故有时需要引入一定的近似）。简单地说，问题能够分解成子问题来解决。

我们首先关注最核心的定义：

>通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。

简练来说，DP的关键在于**分解原本的复杂问题为相对简单的子问题**。

我们结合一点具体的实例来感受一下这句话，比如先来看一下DP最经典的问题之一：硬币问题。

## 帮助理解的经典问题：硬币问题

> 现在假设你手上有1,2,5这三种面额的硬币，给定任意一个正整数n，求凑齐n这个数额最需要的最少的硬币数目为多少。（假设每个面额的硬币都有无数多枚）

现在我们有了目标问题：用最少硬币数拼出指定数目n。而如果我们不思考，想比较暴力地解决这个问题，那当然只能穷举能够拼成n的所有可能的做法，然后找出所有做法中，用到硬币数目最少的那个。

而之所以要有算法这种东西，就是为了尽量避免暴力穷举这种耗时耗力的做法，转而借助一些技巧，让我们能够相对轻松地多的解决问题。

DP的定义在这个问题上就可以给我们一个启示（假设目标拼出数额为n，算法为一个函数f()，问题的解就是f(n)）：

  “如果我知道了拼出数额n-1所需要的最少硬币数目f(n-1)，那么是不是再加1个面额为1的硬币(f(n-1)+1)就是拼出数额n的解(f(n))了呢......诶，不太对，是不是可能f(n-2)的解再加上一个面额为2的硬币的硬币总数会更少呢（f(n-2)+1<f(n-1)+1）......那同理了，f(n-5)+1会不会比f(n-2)+1和f(n-1)+1都小啊？？？那么总结一下是不是这样：对于我手上所有的各类面额的硬币{c1,c2,c3,...cn}，如果我知道了当目标数额为1,2,3,....,n-1时的对应解f(1),f(2),f(3),...,f(n-1)，那么我只需要知道Min{f(n-c1)+1,f(n-c2)+1,f(n-c3)+1,...f(n-cn)+1}就可以了！！！”

当你开始想利用**相似问题的解（拼出小于n的某个面额所需要的最少硬币数）**来帮助解题时，这个思路是很正确的。因为我们发现，乍一看，我们似乎不需要考虑**怎么直接去解决源问题本身，而是有点偷懒地想，但凡类似的子问题有解了，我解决这个问题也就很简单了。**

于是，我们这样不断地把硬币问题往前、往简单的方向分解，就会发现，我们最终会落脚到:n=1时，f(1)=?；n=2时,f(2)=?；n=3时，f(3)=?....类似这样最原始的问题上。而对于这样的子问题，我们就完全可以最开始的时候拍脑袋简单想一想，直接给出解，比如给出n=1,2,3的解：

>f(1)=1,f(2)=1,f(3)=2;

然后，对于n>4的每个情况，我们这样处理：

$$f(n)=MIN\ \{f(n-c_i)+1\}\ \ $$
$$i=1,2,3...,n\ and\  n-c_i\ge0\  and\  c_i\in\{c_1,c_2,c_3,...,c_n\}$$

意思就是对于手上有的所有面额的硬币$c_i$，我们都拿它来试一试$f(n-c_i)+1$，即用它搭配合前面已知的一个最优解得到f(n)的一个可能解时，该可能解是否是最优的（所需硬币数目最少的解）。

这样，我们就不用盲目地去拿手里的硬币瞎拼，也不知道啥时候能拼好了。

给个Java代码：
```
public int coinProblem(int n){
    int[] coins={1,2,5};
    int[] solutions=new int[n+1];
    //为了后续从第一个解开始的初始比较
    Arrays.fill(solutions,Integer.MAX_VALUE);
    //n=0时，一枚硬币都不需要
    solutions[0]=0;
    for(int i=1;i<n;i++){
        if(n-i>=0){
            if(solutions[n-i]+1<solutions[n]){
                solutions[n]=solutions[n-i]+1;
            }
        }
    }
    return solutions[n];
}
```

*当然针对这个问题会有一些边界情况，比如如果硬币面额最小的是3，那么n=1,2时都是没有解的，或者有时候有些n的数额靠仅有的硬币拼不出来，也没有解，这些就依赖于编程时的具体实现，这里我们的核心是DP算法本身，就不过多专注这些细节问题。*




## 第二个经典问题：斐波那契数列

斐波那契数列是头两项为1，后面任意一项均为前两项之和的一个数列。

相应的问题是：如何高效求解斐波那契数列的第n项？

不考虑效率的情况下，最简单直接的做法是递归：f(n)=f(n-1)+f(n-2)。完全不用动脑筋，非常easy。

但是如果你去在OJ上对付斐波那契数列用这种搞法的话，很容易exceeds time limit或者stack overflow，因为这样简单的递归**要进行很多次不必要的重复计算。**

比如说，如果要算f(5)，那么f(5)=f(4)+f(3),而f(4)=f(3)+f(2),f(3)=f(2)+f(1)，f(1)和f(2)已知都等于1，但是f(3)在这个过程已经被计算了两遍。而当n一旦大起来，就可能造成很多个这样的f(i)被多次计算，白白浪费时间。

于是，我们想，我们能不能这样想：递归之所以要进行重复计算，根源问题在于它是倒着推的，即f(n-1)依托于f(n-2)，但f(n-2)也不知道，需要继续往前推。但是如果我们正着推，即在知道f(1)和f(2)后，我们f(3)=f(2)+f(1)，f(4)=f(3)+f(2)这个思路来做，一直求到n，不就完全没有重复的问题了嘛！

其实这个思路就是动态规划的思路，因为我们又把单纯的源问题【求斐波那契数列的第n项】，变成了子问题【知道了斐波那契数列的第n-2和第n-1项，求斐波那契数理的第n项】，那么子问题就是做个加法的事情。而子问题推回到最原始的部分，我们的问题就是求f(3),f(4)了，和之前的硬币问题就很相似了。

同样给个Java代码：

```
public int Fibonacci(int n){
    if(n<=2)
        return 1;
    int[] solutions=new int[n+1];
    solutions[0]=0;
    solutions[1]=1;
    solutions[2]=1;
    for(int i=3;i<n;i++){
        solutions[n]=solutions[n-1]+solutions[n-2];
    }
    return solutions[n];
}
```



# 为什么要用DP

已经看了两个经典例子，大概已经对DP的做法有了一点感觉了，那么接下来，我们就看一下DP以及到底适用什么问题。（此节主要参考了：[什么是动态规划？动态规划的意义是什么？ - 徐凯强 Andy的回答 - 知乎](https://www.zhihu.com/question/23995189/answer/35324479)和[什么是动态规划？动态规划的意义是什么？ - 王勐的回答 - 知乎](https://www.zhihu.com/question/23995189/answer/35429905)）

为什么要用某个算法？当然是因为这一类问题用这个算法解很有效很快捷呀！那么DP到底解什么类型的问题比较合适呢？

其实最开始的维基百科的定义已经给出答案：

>动态规划常常适用于有重叠子问题和最优子结构性质的问题，动态规划方法所耗时间往往远少于朴素解法。

## 重叠子问题

重叠子问题是什么？顾名思义，就是当源问题被分解成子问题时，有的子问题重复了，即有的子问题是同一个问题。

比如在硬币问题中，当我们有1、2两种硬币时，用DP的思路解题的话，我们如果求解n=4时的解，我们就需要用到f(1),f(2),f(3)，而f(3)又会用到f(1)和f(2)，f(2)又会用到f(1)，这里我们就发现，f(1),f(2)都被多次用到（它们本身也是硬币问题，只不过求解过程太过简单，被我们当做理所当然的结果来直接用）。所以这里的f(1)，f(2)就是会被多次用到的重叠子问题。

再比如在斐波那契数列中，f(4)=f(3)+f(2),f(3)=f(2)+f(1)，同理，f(1)和f(2)也是被多次使用的重叠子问题。

## 最优子结构

直接给知乎用户王勐的一句话的定义：

> 每个阶段的最优状态可以从之前某个阶段的某个或某些状态直接得到。

这个性质就叫做最优子结构。

这里的阶段指的就是我们分解出来的子问题，最优状态就是子问题的最优解(f(i))。

在硬币问题中，f(n)只需要f(1),f(2),...f(n-1)的解就可以得到；在斐波那契数列问题中，f(n)只需要f(n-1)和f(n-2)就可以得到。

即我们求解f(n)时，只需要f(i),i<n，而不会需要用到f(n),j>=n。

其实具备最优子结构特性是一个问题能被分解成子问题的基本隐含条件，如果一个问题没有该特性，那么它本身就不是DP可解的，得另辟蹊径。



# 怎么用DP

了解了DP的定义和它适合什么样的问题，我们再来规范化一下DP到底怎么解决一个问题，也即我们做OJ时到底怎么去思考问题。

## 规范化DP的思路：状态定义与状态转移方程

我们这里引入新的名词【状态】和【状态转移方程】，这也是一种比较常见的DP定义方法。

其实【状态】指的其实就是子问题，而【状态转移方程】指的是状态之间的转换关系，即子问题之间是如何关联的，或者说，小子问题的解如何帮助解决大子问题。

同样是斐波那契数列问题，原问题就是f(n),状态/子问题就是f(i)(i<n),而状态转移方程就是f(i)=f(i-1)+f(i-2)，它告诉我们了状态/子问题之间的关系是什么，即我们如何用一些状态去获得其后续的状态。当然，在斐波那契数列里，这个转移方程很简单。

而在硬币问题的例子里，状态转移方程就稍微复杂一点，是f(i)=Min{f(i-c)+1} c in {c1,c2,c3,...,}。

所以，用DP解题的核心就在于：定义状态/子问题并找到状态之间的转移关系，也就是状态转移方程。

而在编程实现时，我们往往需要首先给定最初的状态值，然后实现状态转移方程，去递推得到我们的目标问题的解。


# Leetcode实例


## 最长递增子序列(Longest Increasing Subsequence, LIS)

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,

Given [10, 9, 2, 5, 3, 7, 101, 18],The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

- 思路

1.定义状态：

  假设原数组长度为n，假设f(n)为数组的第n个元素为结尾的最长递增子序列的长度，那么状态就是f(i),i=1,2,3,...,n。而LIS问题的解就是Max{f(i)},i=1,2,3.,,,n。

2.状态转移方程：

对于以第i个元素为结尾的最长递增子序列的长度，我们需要知道f(1),f(2),f(3).,,,f(i-1)，然后：

f(i)=Max{f(i-a)+1} if(arr[i]>arr[i-a]),a={1,2,3,...,i}

即对于i之前的每个数组元素arr[j],0<=j<i，我们看arr[i]是否大于arr[j]：
如果（1）arr[i]>arr[j],且：
【1】如果f(j)+1>f(i)，那么f(i)=f(j)+1
【2】否则，不做处理，继续遍历j。
如果（2）arr[i]<=arr[j]不做处理，继续遍历i。

初始状态f(0)=1。

最后，找出f(i),i=1,2,3,...,n中最大的那个值，即为原问题的解。

- My Answer
```
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */

public class LongestIncreasingSubsequence
{
    // This answer from:https://leetcode.com/problems/longest-increasing-subsequence/discuss/127926/java
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        //新建一个数组T，用来标识nums元素前面有多少个连续小于他的，从1开始加
        //比如nums=[10,15,20,11,9,101] 
        //15前面10比他小，所以为2,20前面有10和15都比他小，所以为3，最后101前面有10,15,20这三个比他小，所以为4
        //那么T=[1,2,3,2,1,4]
        int[] T = new int[nums.length];
        Arrays.fill(T,1);
        
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    T[i] = Math.max(T[i],1+T[j]);
                }
            }
        }
        
        int res = 0;
        for(int i=0;i<T.length;i++){
            res = Math.max(res,T[i]);
        }
        return res;
    }
}
```


# 最大和连续子数组（Maximum Sum Subarray）

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

More practice:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

- 思路

1.状态定义：

  假设f(n)为以第n个元素为结尾的最大和连续子数组的和，那么状态就是f(i),i=1,2,3,...,n

2.状态转移方程：

  因为是连续的最大和数组，所以f(i)也只能和前一个状态f(i-1)发生关联，即对f(i):
```
  if(f(i-1)>0) 
    f(i)=f(i-1)+arr[i];
  else 
    f(i)=arr[i];
```
  遍历完成后，找到f(i)的最大值，即为原问题的解。

- My Answer
```
public static int DPSolution(int[] nums) {
      if(nums.length==0)
          return 0;
      
      int[] solutions=new int[nums.length];
      solutions[0]=nums[0];
      for(int i=1;i<nums.length;i++) {
          if(solutions[i-1]>0) {
              solutions[i]=solutions[i-1]+nums[i];
          }else {
              solutions[i]=nums[i];
          }
      }
      int res=Integer.MIN_VALUE;
      for(int i=0;i<solutions.length;i++)
          res=Math.max(res,solutions[i]);
      
      return res;
}
```









