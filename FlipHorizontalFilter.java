/**
 * Filter that flips the image horizontally.
 * @author Chloe Kuhar
 * @version 1 Apr 2016
 */
public class FlipHorizontalFilter implements Filter {
    // no instance variables -- no state of objects
  
    /** 
     * filter
     * flips pixel image horizontally around vertical
     * center line
     * @param data The Pixel array object to modify
     */
    public void filter(Pixel[][] data) {
        
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length / 2; col++) {
                // swap values across center line
                Pixel temp = data[row][col];
                data[row][col] = data[row][data[row].length - col - 1];
                data[row][data[row].length - col - 1] = temp;
            }
        }  
    }
}