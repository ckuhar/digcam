
/**
 * Write a description of class EdgeFilter here.
 * 
 * @author Chloe Kuhar
 * @version 1 Apr 2016
 */
public class EdgeFilter implements Filter
{
    /**
    *identifies an edge and then changes edges to black and non edges to white.
    */
    public void filter(Pixel[][] data)
    {
        
        double brightness;
        double diff;
        boolean[][] isEdge = new boolean[data.length][data[0].length]; 
        
        //identifying brightnesses
        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data[row].length; col++)
            {
                brightness = (data[row][col].getRed() + data[row][col].getGreen() + data[row][col].getBlue()) / 3.0;
                for(int r = -1; r < 2; r++)
                {
                    for(int c = -1; c < 2; c++)
                    {
                        if( row + r >= 0 && row + r < data.length - 1 && col + c >= 0 && col + c < data[row].length - 1 )
                        {
                            diff = brightness - ((data[row+r][col+c].getRed() + data[row+r][col+c].getGreen() + data[row+r][col+c].getBlue()) / 3.0);
                            if( diff > 35.0 )
                            {
                                isEdge[row][col] = true;
                            }
                        }
                    }
                }
            }
        }
        
        //changes the values to black and white
        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data[row].length; col++)
            {
                if( isEdge[row][col] )
                {
                    data[row][col].setAllColors(0,0,0);
                }
                else
                {
                    data[row][col].setAllColors(255,255,255);
                }
            }
        }
    }
}
