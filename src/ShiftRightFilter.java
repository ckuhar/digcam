
/**
 * A filter that shifts to the right such that the rightmost column becomes the leftmost column
 * 
 * @author Chloe Kuhar
 * @version 1 Apr 2016
 */
public class ShiftRightFilter implements Filter
{
    /**
     * shifts the image to the right where the rightmost column becomes the leftmost column
     */
    public void filter(Pixel[][] data)
    {
        //array of the same size as data
        Pixel[][] newData = new Pixel[data.length][data[0].length];
        
        //makes the rightmost column the leftmost column
        for(int row = 0; row < data.length; row++)
        {
            newData[row][0] = data[row][data[0].length-1];
        }
        
        //shifts the rest of the pixels to the right
        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data[row].length - 1; col++)
            {
                newData[row][col+1] = data[row][col];
            }
        }
        
        //stores everything in newData into original array
        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data[row].length; col++)
            {
                data[row][col] = newData[row][col];
            }
        }
    }
}
