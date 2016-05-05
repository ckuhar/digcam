/**
 * This class is used to demosaic an image.
 * @Chloe Kuhar
 * @version 23 Mar 2016
 */
public class DemosaicFilter implements Filter {
    /** 
     * Demoasics an image.
     */
    public void filter(Pixel[][] data) {
        int greenVal;
        int redVal;
        int blueVal;
        int colorVal;
        
        for(int i = 0; i < 2; i++)
        {
            for (int row = 0; row < data.length; row++) {
                for (int col = 0; col < data[row].length; col++) {
                    colorVal = data[row][col].getDigCamColor();
                    if( colorVal == 3  )
                    {
                        //blue is what we know, green adjacent, red diagonal
                        if( row == 0 && col == 0 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setRed(data[row+1][col+1].getRed());
                        }
                        else if( row == 0 && col == data[row].length - 1 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row+1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setRed(data[row+1][col-1].getRed());
                        }
                        else if( row == data.length - 1 && col == data[row].length - 1 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row-1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setRed(data[row-1][col-1].getRed());
                        }
                        else if( row == data.length - 1 && col == 0 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row-1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            redVal = DemosaicFilter.getAverage(data[row+1][col+1].getRed(), data[row-1][col+1].getRed());
                            data[row][col].setRed(redVal);
                        }
                        else if( row == 0 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            redVal = DemosaicFilter.getAverage(data[row+1][col+1].getRed(), data[row+1][col-1].getRed());
                            data[row][col].setRed(redVal);
                        }
                        else if( col == 0 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row-1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            redVal = DemosaicFilter.getAverage(data[row+1][col+1].getRed(), data[row-1][col+1].getRed());
                            data[row][col].setRed(redVal);
                        }
                        else if( col == data[row].length - 1 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row+1][col].getGreen(), data[row-1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            redVal = DemosaicFilter.getAverage(data[row-1][col-1].getRed(), data[row+1][col-1].getRed());
                            data[row][col].setRed(redVal);
                        }
                        else if( row == data.length - 1 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row-1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            redVal = DemosaicFilter.getAverage(data[row-1][col+1].getRed(), data[row-1][col-1].getRed());
                            data[row][col].setRed(redVal);
                        }
                        else
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row-1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            redVal = DemosaicFilter.getAverage(data[row+1][col+1].getRed(), data[row-1][col+1].getRed(), data[row+1][col-1].getRed(), data[row-1][col-1].getRed());
                            data[row][col].setRed(redVal);
                        }
                    }
                    else if( colorVal == 2 )
                    {
                        //green is what we know
                        if( row == 0 && col == data[row].length - 1 )
                        {
                            //determines red and blue value by taking the average of nearby known values
                            data[row][col].setBlue(data[row][col-1].getBlue());
                            
                            data[row][col].setRed(data[row+1][col].getRed());
                        }
                        else if( row == data.length - 1 && col == 0 )
                        {
                            //determines red and blue value by taking the average of nearby known values
                            data[row][col].setBlue(data[row-1][col].getBlue());
                            
                            data[row][col].setRed(data[row][col+1].getRed());
                        }
                        else if( row == 0 && col == 0 )
                        {
                            //determines red and blue value by taking the average of nearby known values
                            data[row][col].setBlue(data[row][col+1].getBlue());
                            
                            data[row][col].setRed(data[row+1][col].getRed());
                        }
                        else if( col == 0 )
                        {
                            //determines red and blue value by taking the average of nearby known values
                            blueVal = DemosaicFilter.getAverage(data[row+1][col].getBlue(), data[row-1][col].getBlue());
                            data[row][col].setBlue(blueVal);
                            
                            data[row][col].setRed(data[row][col+1].getRed());
                        }
                        else if( row == 0 )
                        {
                            //determines red and blue value by taking the average of nearby known values
                            blueVal = DemosaicFilter.getAverage(data[row][col+1].getBlue(), data[row][col-1].getBlue());
                            data[row][col].setBlue(blueVal);
                            
                            data[row][col].setRed(data[row+1][col].getRed());
                        }
                        else
                        {
                            //determines red and blue value by taking the average of nearby known values
                            if( row % 2 == 0 )
                            {
                                if( row == data.length - 1 && col == data[row].length - 1 )
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    data[row][col].setBlue(data[row-1][col].getBlue());
                            
                                    data[row][col].setRed(data[row][col-1].getRed());
                                }
                                else if( row == data.length - 1 )
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    blueVal = DemosaicFilter.getAverage(data[row][col+1].getBlue(), data[row][col-1].getBlue());
                                    data[row][col].setBlue(blueVal);
                            
                                    data[row][col].setRed(data[row-1][col].getRed());
                                }
                                else if( col == data[row].length - 1 )
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    data[row][col].setBlue(data[row][col-1].getBlue());
                            
                                    redVal = DemosaicFilter.getAverage(data[row+1][col].getRed(), data[row-1][col].getRed());
                                    data[row][col].setRed(redVal);
                                }
                                else
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    blueVal = DemosaicFilter.getAverage(data[row][col+1].getBlue(), data[row][col-1].getBlue());
                                    data[row][col].setBlue(blueVal);
                            
                                    redVal = DemosaicFilter.getAverage(data[row+1][col].getRed(), data[row-1][col].getRed());
                                    data[row][col].setRed(redVal);
                                }
                            }
                            else
                            {
                                if( row == data.length - 1 && col == data[row].length - 1 )
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    data[row][col].setBlue(data[row-1][col].getBlue());
                                
                                    data[row][col].setRed(data[row][col-1].getRed());
                                }
                                else if( row == data.length - 1 )
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    data[row][col].setBlue(data[row-1][col].getBlue());
                                
                                    redVal = DemosaicFilter.getAverage(data[row][col+1].getRed(), data[row][col-1].getRed());
                                    data[row][col].setRed(redVal);
                                }
                                else if( col == data[row].length - 1 )
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    blueVal = DemosaicFilter.getAverage(data[row+1][col].getBlue(), data[row-1][col].getBlue());
                                    data[row][col].setBlue(blueVal);
                                
                                    data[row][col].setRed(data[row][col-1].getRed());
                                }
                                else
                                {
                                    //determines red and blue value by taking the average of nearby known values
                                    blueVal = DemosaicFilter.getAverage(data[row+1][col].getBlue(), data[row-1][col].getBlue());
                                    data[row][col].setBlue(blueVal);
                                
                                    redVal = DemosaicFilter.getAverage(data[row][col+1].getRed(), data[row][col-1].getRed());
                                    data[row][col].setRed(redVal);
                                }
                            }
                        }
                    }
                    else
                    {
                        //red is what we know, blue diagonal, green adjacent
                        if( row == data.length - 1 && col == data[row].length - 1 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col-1].getGreen(), data[row-1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setBlue(data[row-1][col-1].getBlue());
                        }
                        else if( row == 0 && col == 0 )
                        {
                            //determines red and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setBlue(data[row+1][col+1].getBlue());
                        }
                        else if( row == 0 && col == data[row].length - 1 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row+1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setBlue(data[row+1][col-1].getBlue());
                        }
                        else if( row == data.length - 1 && col == 0 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row-1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            data[row][col].setBlue(data[row-1][col+1].getBlue());
                        }
                        else if( row == 0 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            blueVal = DemosaicFilter.getAverage(data[row+1][col+1].getBlue(), data[row+1][col-1].getBlue());
                            data[row][col].setBlue(blueVal);
                        }
                        else if( col == 0 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row-1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            blueVal = DemosaicFilter.getAverage(data[row+1][col+1].getBlue(), data[row-1][col+1].getBlue());
                            data[row][col].setBlue(blueVal);
                        }
                        else if( row == data.length - 1 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row-1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            blueVal = DemosaicFilter.getAverage(data[row-1][col+1].getBlue(), data[row-1][col-1].getBlue());
                            data[row][col].setBlue(blueVal);
                        }
                        else if( col == data[row].length - 1 )
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col-1].getGreen(), data[row+1][col].getGreen(), data[row-1][col].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            blueVal = DemosaicFilter.getAverage(data[row-1][col-1].getBlue(), data[row+1][col-1].getBlue());
                            data[row][col].setBlue(blueVal);
                        }
                        else
                        {
                            //determines blue and green value by taking the average of nearby known values
                            greenVal = DemosaicFilter.getAverage(data[row][col+1].getGreen(), data[row+1][col].getGreen(), data[row-1][col].getGreen(), data[row][col-1].getGreen());
                            data[row][col].setGreen(greenVal);
                            
                            blueVal = DemosaicFilter.getAverage(data[row+1][col+1].getBlue(), data[row-1][col+1].getBlue(), data[row+1][col-1].getBlue(), data[row-1][col-1].getBlue());
                            data[row][col].setBlue(blueVal);
                        }
                    }
                }
            }
        }
    }
    
    /** 
     * average of two numbers.
     */
    public static int getAverage(int one, int two)
    {
        int sum = one + two;
        return sum / 2;
    }
    
    /** 
     * average of three numbers.
     */
    public static int getAverage(int one, int two, int three)
    {
        int sum = one + two + three;
        return sum / 3;
    }
    
    /** 
     * average of four numbers.
     */
    public static int getAverage(int one, int two, int three, int four)
    {
        int sum = one + two + three + four;
        return sum / 4;
    }
}
