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
        if (root == null)
        {
            return 0;
        }
        else if (root.isLeaf())
        {
            return 1;
        }
        else
        {
            return totalNodes(root.getLeft()) + totalNodes(root.getRight()) + 1;
        }

        //TODO Go through left branch until there is no left branches and count the nodes along the way
        //TODO After it hits a node with no left branches, go right and accumulate
        //TODO Then return total nodes back up
    }

    /**
     * Calculates the depth of the Tree, which means the furthest branch from the root.
     * A root of only one has no depth
     * @param root BTNode
     * @return int
     */
    public static int depth(BTNode root)
    {
        if (root == null)
        {
            return 0;
        } else if (root.isLeaf())
        {
            return 0;
        }
        else
        {
            int totalLeft = depth(root.getLeft()) + 1;
            int totalRight = depth(root.getRight()) + 1;
            if (totalLeft > totalRight)
            {
                return totalLeft;
            }
            else
            {
                return totalRight;
            }
        }
    }
}

class BTNodeTesters
{
    public static void main(String[] argsg)
    {
        BTNode root = Guessing.beginningTree();

        int total = BTNode.depth(root);
    }


}

