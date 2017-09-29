package GCPU;

// @author Johnson


public class SpecialArtifact extends Artifact
{
    String specialArtifact;
    String onDescription;
    String touchOnDescription;
    String touchOffDesciption;
    boolean state;
    
    SpecialArtifact(String name, String defaultDescription, boolean valid, String touchOnDescription, String onDescription, String touchOffDescription)
    {
        super(name, defaultDescription); 
        this.touchOnDescription = touchOnDescription;
        this.touchOffDesciption = touchOffDescription;
        this.onDescription = onDescription;
        state = valid;
    }
    
    @Override
    String examine()
    {
        if(state == false)
        {
            return defaultDescription;
        } 
        else 
        {
            return onDescription;
        }
    }
	
    @Override
    String touch()
    {
        if(state == false)
        {
            state = true;
            return touchOnDescription;
        }
        else
        {
            state = false;
            return touchOffDesciption;
        }
    }
}

// @author Johnson Ju