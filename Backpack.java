package GCPU;

// @author Johnson

import java.util.*;
 
public class Backpack 
{
    
    private ArrayList <Artifact> contents = new ArrayList <Artifact> ();
        
    public int size()
    {
        return contents.size();
    }
    public boolean setArtifact(Artifact anyArtifact)
    {
        if(contents.size() < 3 && anyArtifact != null)
        {
            contents.add(anyArtifact);
            return true;
        }
        else if(contents.size() > 2 && anyArtifact != null)
        {
            System.out.println("Unable to take the artifact, your backpack is full");
        }
    return false;
    }

    public Artifact removeArtifact(int index)
    {
        return contents.remove(index);
    }

    public String getInventory()
    {
        String message = "";
        String inventoryOutput = "";

        if(contents.size() > 0)
        {
            for (int index = 0; index < contents.size(); index++)
            {
                    message += "\n" + contents.get(index).name + "\n";
                    inventoryOutput = "You are carrying " + message;
            }
        }
        else if(contents.size() == 0)
        {
            inventoryOutput = "Your Backpack is empty";
        }
    return inventoryOutput;
    }

    public Artifact getArtifact(int i)
    {
        return contents.get(i);
    }

    void erase()
    {
        for(int a = 0; a < contents.size(); a++)
        {
            contents.removeAll(contents);
        }
    }
}

// @author Johnson Ju