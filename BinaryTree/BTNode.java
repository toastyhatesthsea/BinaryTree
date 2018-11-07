package BinaryTree;

public class BTNode <E>
{
    private E data;
    private BTNode left;
    private BTNode right;

    public BTNode(E data, BTNode left, BTNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public BTNode getLeft()
    {
        return left;
    }

    public void setLeft(BTNode left)
    {
        this.left = left;
    }

    public BTNode getRight()
    {
        return right;
    }

    public void setRight(BTNode right)
    {
        this.right = right;
    }

    public boolean isLeaf()
    {
        return left == null && right == null;
    }

    public static int totalNodes(BTNode root)
    {
        if (root.isLeaf())
        {
            return 1;
        }
        else
        {
            int leftTotal = totalNodes(root.getLeft()) + 1;
            int rightTotal = totalNodes(root.getRight()) + 1;
            return leftTotal + rightTotal;
        }

        //TODO Go through left branch until there is no left branches and count the nodes along the way
        //TODO After it hits a node with no left branches, go right and accumulate
        //TODO Then return total nodes back up
    }
}

class BTNodeTesters
{
    public static void main(String[] argsg)
    {
        BTNode root = Guessing.beginningTree();

        int total = BTNode.totalNodes(root);
    }


}

