package ca.mcmaster.se2aa4.mazerunner;

public class StringManipulator{

	//change up a bit

	public String toFactorized(String path)
	{
        int count = 1;
        char prev = path.charAt(0);

        String newPath = "";

        for (int i = 1; i < path.length(); i++) 
        {
            char current = path.charAt(i);
            if (current == prev) 
            {
                count++;
            } 
            else 
            {
                if (count > 1) 
                {
                	newPath = newPath + count + prev + " ";
                } 
                else 
                {
                	newPath = newPath + prev + " ";
                }
                prev = current;
                count = 1;
            }
        }

        if (count > 1) 
        {
        	newPath = newPath + count + prev + " ";
        } 
        else 
        {
        	newPath = newPath + prev + " ";
        }

     

        return newPath;
	}
}