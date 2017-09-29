package GCPU;

// @author Johnson

public class Artifact 
{
    // Instance variables
    String name, defaultDescription;
	
    // Constructors
    public Artifact (String name, String description)
    {
	this.name = name;
        this.defaultDescription = description;
    }
       
    String getDescription()
    {
        return defaultDescription;
    }
        
    String getDescription(String touch)
    {
        return getDescription();
    }
        
    //Outputs would be default descriptions if there is no special artifact when user examine
    String examine()
    {
    	return defaultDescription;
    }
    	
    	
    //In case of touching ordinary artifact
    String touch()
    {
    	return "Touching " + name + " doesn't appear to do anything.";
    }

}

// @author Johnson Ju