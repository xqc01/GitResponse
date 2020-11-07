package cn.xqc.code_tree;

/**
 * 折纸条问题：现有一纸条，将纸条折叠一次后，纸条上出现了一条凹折痕，
 * 再折叠一次，凹折痕的上下分别出现凹折痕和凸折痕，要求折叠n次后，打印从上到下的折痕
 *
 * 将其转化为二叉树问题：折叠一次，建立凹折痕的头节点，折叠两次，建立头节点的左右孩子，分别是凹，凸节点
 * 再次折叠，将上一次折叠生成的所有子节点作为头节点，建立其左右孩子，也分别是凹凸节点
 * 打印从上到下的折痕，也就是二叉树的中序遍历
 */
public class OrigamiPaper {
    public void origamiPaper(int n){
        process(n,1,true);
    }

    /**
     *
     * @param n 要求折叠次数
     * @param i 当前二叉树的层数
     * @param isAo 是否是凹节点
     */
    public void process(int n,int i,boolean isAo){
        if (i > n)
            return;
        process(n,i+1,true);
        String str = "凹  ";
        if (isAo == false)
            str = "凸  ";
        System.out.print(str);
        process(n,i+1,false);
    }
}
