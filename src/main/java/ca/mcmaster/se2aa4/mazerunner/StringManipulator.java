package ca.mcmaster.se2aa4.mazerunner;

public class StringManipulator{

    public String cannonicalToFactorized(String path)
    {
        int num = 1;
        path = path.trim();
        char previous = path.charAt(0);
        String newPath = "";

        //loop through path starting at second character
        for (int i = 1; i < path.length(); i++) 
        {
            char currentDirection = path.charAt(i);
            
            //increment if multiple same directions in a row
            if (currentDirection == previous) 
            {
                num++;
            } 
            //when direction changes
            else 
            {
                if (num > 1) 
                {
                    newPath = newPath + num + previous + " ";
                } 
                else 
                {
                    newPath = newPath + previous + " ";
                }
                previous = currentDirection;
                num = 1;
            }
        }
        //handle laste sequence of directions
        if (num > 1) 
        {
            newPath = newPath + num + previous + " ";
        } 
        else 
        {
            newPath = newPath + previous + " ";
        }
        return newPath.trim();
    }

    public String factorizedToCanonical(String factoredPath) {

        StringBuilder canonicalPath = new StringBuilder();
        int length = factoredPath.length();
        
        for (int i = 0; i < length; i++) 
        {
            char character = factoredPath.charAt(i);

            //check if the character is a digit
            if (Character.isDigit(character)) 
            {   
                //convert the character to an integer
                int count = Character.getNumericValue(character);

                //get next character which should be a direction
                if (i + 1 < length) 
                {
                    char direction = factoredPath.charAt(i + 1);

                    for (int j = 0; j < count; j++) 
                    {
                        canonicalPath.append(direction);
                    }

                    //skip direction character
                    i++;
                }
            }    
            else 
            {
                canonicalPath.append(character);
            }
        }
        return canonicalPath.toString().trim();
    }

    public String spacedCannonical(String path)
    {
        String spacedPath = "";

        for (int i = 0; i<path.length(); i++)
        {
            char direction = path.charAt(i);
            spacedPath += Character.toString(direction);

            //checks if current direction and next direction are different
            if ((i+1 < path.length() - 1) && (!(path.charAt(i + 1) == direction)))
            {
                spacedPath += " ";
            }
        }
        return spacedPath;
    }

    public boolean checkFacotrized(String path)
    {
        for (int i = 0; i < path.length(); i++) 
        {
            char character = path.charAt(i);

            // if digit followed by direction character
            if (Character.isDigit(character)) 
            {
                //factored form
                if (i + 1 < path.length() && (path.charAt(i + 1) == 'F' || path.charAt(i + 1) == 'R' || path.charAt(i + 1) == 'L'))
                {
                    return true; 
                }
            }
        }
        //cannonical form
        return false; 
    }
}