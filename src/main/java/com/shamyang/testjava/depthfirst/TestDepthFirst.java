package com.shamyang.testjava.depthfirst;

/**
 * Created by shamyang on 2017/7/10.
 * 深度优先算法，用来计算数据的全排列
 * 本代码依赖的场景是：将扑克放入盒子的例子，思路来源是<<啊哈算法>>
 */
public class TestDepthFirst {


    /**
     * 全排列的数字总数
     */
    private static final int n=2;
    /**
     * 盒子
     */
    private static int[] a=new int[n];

    /**
     * 扑克是否在手上的标记
     */
    private static int[] book=new int[n];

    private static int sum=0;

    public static void dfs(int step){

        if(step==a.length){
            sum++;
            System.out.print("sum="+sum+"--->>");
            for(int i:a){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<a.length;i++){
            //如果扑克还在手上
            if(book[i]==0){
                //将扑克放入盒子中
                a[step]=i;
                //标记扑克已经放入
                book[i]=1;
                //通过递归,进行其他盒子的放入
                dfs(step+1);
                //取出放入的扑克
                book[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0);
    }
}
