package cn.xqc.data_structure;

/**
 * 使用异或运算：无进位的相加
 * 两个相同的数异或为0，任何数与0异或都不变，一堆数无论怎么异或，结果不变
 */
public class UseXOR {
    /**
     * 得到传入参数在二进制形式下的最后一位1
     *
     * @param value 传入的int值
     * @return 返回二进制
     */
    public int getLastOne(int value) {
        int result = 0;
        result = (~value + 1) & value;
        return result;
    }

    /**
     * 数组中有一个数出现奇数个，其他数出现偶数个，找出奇数个的数
     *
     * @param arr
     * @return
     */
    public int getOddNumber(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    /**
     * 数组中有两个出现奇数次的数，先遍历数组，得到两个数的异或结果；
     * 然后得到异或结果二进制的最后一个1，
     * 再遍历数组，将数组中的数按照是否有那个1分为两部分，异或其中一部分，得到一个奇数次的数
     *
     * @param arr
     * @return
     */
    public int[] getTwoOddNumber(int[] arr) {
        int[] result = new int[2];
        int resultXOR = 0;
        for (int i = 0; i < arr.length; i++) {
            resultXOR = resultXOR ^ arr[i];
        }
        int lastOne = this.getLastOne(resultXOR);
        System.out.println(lastOne);
        int result1 = 0;
        for (int j = 0; j < arr.length; j++) {
            int temp = arr[j];
            int temp_lastOne = lastOne;
            while ((temp_lastOne = temp_lastOne >> 1) != 0) {
                temp = temp >> 1;
            }
            if ((temp % 2) == 0) {
                result1 = result1 ^ arr[j];
            }
        }
        result[0] = result1;
        result[1] = result1 ^ resultXOR;
        return result;
    }
}
