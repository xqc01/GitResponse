package cn.xqc.code_easy;

/**
 * 二分查找：使用递归
 * 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 */
public class BinarySearch {
    public int upper_bound_ (int n, int v, int[] a) {
        if(n == 0)
            return 1;
        return this.binarySearch(a,0,n-1,v);
    }
    public int binarySearch(int[] a, int begin, int end, int v){
        if(begin == end ){
            if(a[begin] >= v)
                return begin+1;
            else return begin + 2;
        }
        int mid = (begin + end) / 2;
        if(a[mid] >= v){
            return this.binarySearch(a,begin,mid,v);
        }else{
            return this.binarySearch(a,mid+1,end,v);
        }
    }
}
