package Book_Work;
public class Node<T> 
{
    private T data; // data held by the node
    private Node<T> nextNode;

    public Node(T d) 
    {
        this.data = d;
    }

    /**
     * Returns the data of the node 
     * @return data
     */
    public T getData() 
    {
        return data;
    }

    /**
     * Setting the data to the node
     * @param dataSet the data to be set to the node's data
     */
    public void setData(T dataSet) 
    {
        data = dataSet;
    }

    /**
     * Returns the next node linked to this node
     * @return nextNode object
     */
    public Node<T> getNextNode() 
    {
        return nextNode;
    }

    public void setNextNode(Node<T> nodeSet) 
    {
        nextNode = nodeSet;
    }
}
