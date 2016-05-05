
/**
 * Filter that darkens the image. Will eventually turn the photo black if used repeatably.
 * 
 * @author Chloe Kuhar
 * @version 1 Apr 2016
 */
public class DarkenFilter implements Filter
{
    /**
     * A filter that darkens the photo by a noticeable amount.
     */
    public void filter(Pixel[][] data)
    {
        //store RGB values
        int red;        
        int green;
        int blue;
        
        //iterate through image and darken colors
        for(int row = 0; row < data.length; row++) 
        {
            for(int col = 0; col < data[row].length; col++) 
            {
                // darken colors
                red = data[row][col].getRed() - 20;
                green = data[row][col].getGreen() - 20;
                blue = data[row][col].getBlue() - 20;
                
                if( red < 0 )
                {
                    red = 0;
                }
                if( green < 0 )
                {
                    green = 0;
                }
                if( blue < 0 )
                {
                    blue = 0;
                }

                data[row][col].setAllColors(red, green, blue);
            }
        }  
    }
}
