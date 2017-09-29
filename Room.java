package GCPU;

// @author Johnson

// Example of a room in the Underground
public class Room 
{
	// Instance variables
    String name;
    String [] exits;
    String descriptions;
    Artifact contents;

    // Constructors
    Room(String name, String[] exits, String descriptions)
    {
        this.name = name;
    	this.exits = exits;
        this.descriptions= descriptions;
    }
    
    String getExits()
    {
        String response = "";
            for(String exit : exits)
            {
                switch(exit)
                {
                case "n":
                    exit = "North";
                    break;
                case "s":
                    exit = "South";
                    break;    
                case "e":
                    exit = "East";
                    break;    
                case "w":
                    exit = "West";
                    break;    
                case "ne":
                    exit = "NorthEast";
                    break;    
                case "nw":
                    exit = "NorthWest";
                    break;    
                case "sw":
                    exit = "SouthWest";
                    break;    
                case "se":
                    exit = "SouthEast";
                    break;
                }
                response = response + exit + " " ;
            } 
            String[] exitSplit = response.split(" ");
            
            if(exitSplit.length == 2)
                {
                    response = exitSplit[0] + " and " + exitSplit[1];
                }
                else if(exitSplit.length == 3)
                {
                    response = exitSplit[0] + " and " + exitSplit[1] + " and " + exitSplit[2];
                }
        return response;
    }  

    // Instance methods
    boolean isValidExit(String requestedExit)
    {
    	boolean result = false;
    	int index = 0;
    	while (index < exits.length && result == false)
    	{
            if (exits[index].equals(requestedExit))
            {
    		result = true;
            }
            else
            {
                index++;
            }
    	}
    	return result;
    }
}

// @author Johnson Ju

