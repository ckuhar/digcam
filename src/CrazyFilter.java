
/**
 * Write a description of class CrazyFilter here.
 * 
 * @author Chloe Kuhar
 * @version 1 Apr 2016
 */
public class CrazyFilter implements Filter
{
    public void filter(Pixel[][] data)
    {
        EdgeFilter f = new EdgeFilter();
        for(int i = 0; i < 100; i++)
        {
            f.filter(data);
        }
    }
}
