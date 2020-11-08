package cn.xqc.code_tree;

/**
 * 二叉树递归问题
 * 利用递归序，二叉树可以得到左右子树的任何信息
 */
public class RecursionQuestion {
    /**
     * 判断二叉树是否为平衡二叉树
     *
     * @param head
     * @return
     */
    public boolean isBalanced(TreeNode head) {
        IsBalancedInfo isBalancedInfo = processIsBalanced(head);
        return isBalancedInfo.maxHeight - isBalancedInfo.minHeight <= 1;
    }

    public IsBalancedInfo processIsBalanced(TreeNode head) {
        if (head == null)
            return null;
        IsBalancedInfo isBalancedInfo = processIsBalanced(head.left);
        IsBalancedInfo isBalancedInfo1 = processIsBalanced(head.right);

        int minHeight = 1;
        int maxHeight = 1;

        int leftMinHeight = isBalancedInfo == null ? 0 : isBalancedInfo.minHeight;
        int rightMinHeight = isBalancedInfo1 == null ? 0 : isBalancedInfo1.minHeight;
        minHeight = Math.min(leftMinHeight, rightMinHeight) + 1;

        int leftMaxHeight = isBalancedInfo == null ? 0 : isBalancedInfo.maxHeight;
        int rightMaxHeight = isBalancedInfo1 == null ? 0 : isBalancedInfo1.maxHeight;
        maxHeight = Math.max(leftMaxHeight, rightMaxHeight) + 1;

        return new IsBalancedInfo(minHeight, maxHeight);
    }

    /**
     * 返回二叉树的最大距离
     *
     * @param head
     * @return
     */
    public int findMaxDistance(TreeNode head) {
        DistanceInfo distanceInfo = distanceProcess(head);
        int distance = distanceInfo.distance;
        return distance;
    }

    public DistanceInfo distanceProcess(TreeNode head) {
        if (head == null)
            return new DistanceInfo(0, 0);
        DistanceInfo distanceInfo = distanceProcess(head.left);
        DistanceInfo distanceInfo1 = distanceProcess(head.right);

        int height = 1;
        int distance = 1;
        height = Math.max(distanceInfo.height, distanceInfo1.height) + 1;
        distance = Math.max(distanceInfo.distance, distanceInfo1.distance);
        if ((distanceInfo.height + distanceInfo1.height + 2) > distance)
            distance = distanceInfo.height + distanceInfo1.height + 2;

        return new DistanceInfo(height, distance);
    }

    /**
     * 返回最大的搜索二叉树的头节点
     *
     * @param head
     * @return
     */
    public TreeNode findMaxSearchTree(TreeNode head) {
        FindSearchInfo findSearchInfo = process2(head);
        return findSearchInfo.head;
    }

    public FindSearchInfo process2(TreeNode head) {
        if (head == null)
            return new FindSearchInfo(0, head, null, null);
        FindSearchInfo findSearchInfo = process2(head.left);
        FindSearchInfo findSearchInfo1 = process2(head.right);

        //二叉搜索树的头节点
        int size = Math.max(findSearchInfo.size, findSearchInfo1.size);
        TreeNode node = findSearchInfo1.head;
        if (findSearchInfo.size > findSearchInfo1.size) {
            node = findSearchInfo.head;
        }
        //满足这些条件，该头节点为二叉树最大搜索二叉树节点
        if ((findSearchInfo.max == null || head.value > findSearchInfo.max) &&
                (findSearchInfo1.min == null || head.value < findSearchInfo1.min) &&
                head.left == findSearchInfo.head && head.right == findSearchInfo1.head) {
            node = head;
            size = findSearchInfo.size + findSearchInfo1.size + 1;
        }
        int min = Math.min(findSearchInfo.min, head.value);
        int max = Math.max(findSearchInfo1.max, head.value);

        return new FindSearchInfo(size, node, min, max);
    }
}

/**
 * 判断二叉树是否平衡，子树返回的信息
 */
class IsBalancedInfo {
    //树的最大和最小高度
    public int minHeight;
    public int maxHeight;

    public IsBalancedInfo() {
    }

    public IsBalancedInfo(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
}

/**
 * 判断二叉树最大距离，返回的信息
 */
class DistanceInfo {
    //树的高度和最大距离
    public int height;
    public int distance;

    public DistanceInfo() {
    }

    public DistanceInfo(int height, int distance) {
        this.height = height;
        this.distance = distance;
    }
}

/**
 * 寻找最大搜索二叉树头节点，返回信息
 */
class FindSearchInfo {
    public int size;
    public TreeNode head;
    public Integer min;
    public Integer max;

    public FindSearchInfo() {
    }

    public FindSearchInfo(int size, TreeNode head, Integer min, Integer max) {
        this.size = size;
        this.head = head;
        this.min = min;
        this.max = max;
    }
}