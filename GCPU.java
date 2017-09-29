package GCPU;

// @author Johnson Ju
import java.util.*;
import java.io.*;

public class GCPU 
{
    public static void main(String[] args) throws IOException 
    {
        // Initialize variables
        int row = 3;
        int col = 0;
        Map map = new Map();
        Scanner scan = new Scanner(System.in);
        Scanner saveRestoreScanner = new Scanner(System.in);
        Backpack backPack = new Backpack();
        String savedFileName = null;
                     
        // Greeting message
        System.out.println("Welcome to the Great Cal Poly Underground!");
        System.out.println("Your Journey Begins Here!");
        System.out.println("Input \"help\" for a list of commands");
        System.out.println("");
        System.out.println("You have entered " + map.rooms[row][col].name);
        System.out.println(map.rooms[row][col].descriptions);
        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
        
        // Begin user dialog
        String input = "";
        while (!input.equals("quit")) 
        {
            System.out.println();

            System.out.print("> ");
            input = scan.nextLine().toLowerCase();

            switch (input) 
            {
                case "n":
                    if (map.rooms[row][col].isValidExit("n"))
                    {
                        row--;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    }
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "s":
                    if (map.rooms[row][col].isValidExit("s"))
                    {
                        row++;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    }
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "e":
                    if (map.rooms[row][col].isValidExit("e"))
                    {
                        col++;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    }
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "w":
                    if (map.rooms[row][col].isValidExit("w"))
                    {
                        col--;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    }
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "ne":
                    if (map.rooms[row][col].isValidExit("ne"))
                    {
                        row--;
                        col++;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    }
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "nw":
                    if (map.rooms[row][col].isValidExit("nw"))
                    {
                        row--;
                        col--;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    }
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "sw":
                    if (map.rooms[row][col].isValidExit("sw"))
                    {
                        row++;
                        col--;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    } 
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "se":
                    if (map.rooms[row][col].isValidExit("se"))
                    {
                        row++;
                        col++;
                        System.out.println("You have entered " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                    } 
                    else
                    {
                        System.out.println("You can't go that way.");
                    }
                    break;
                case "look":
                    if (map.rooms[row][col].contents != null)
                    {
                        System.out.println("You are currently at the " + map.rooms[row][col].name);
                        System.out.println(map.rooms[row][col].descriptions);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                        System.out.println("You see a " + map.rooms[row][col].contents.name);
                    } 
                    else
                    {
                        System.out.println("You are currently at the " + map.rooms[row][col].name);
                        System.out.println("You see an opening to the " + map.rooms[row][col].getExits());
                        System.out.println("The room appears to be empty.");

                    }
                    break;
                case "examine":
                    if(map.rooms[row][col].contents==null)
                    {
                    	System.out.println("There is nothing to be examined.");
                        
                    }
                   else
                    {
                        System.out.println(map.rooms[row][col].contents.examine());
                    }
                    break; 
                case "touch":
                	if(map.rooms[row][col].contents == null)
                        {
                            System.out.println("There is nothing to be touched");
                	} 
                        else if (map.rooms[row][col].contents != null)
                        {
                            System.out.println(map.rooms[row][col].contents.touch());
                	} 
                        else 
                        {
                            System.out.println("There is nothing to be touched");
                	}
                    break;
                case "take":
                    if(input.equals("take"))
                    {
                        boolean exists = backPack.setArtifact(map.rooms[row][col].contents);
                        
                        if(exists == true && map.rooms[row][col].contents != null)
                        {
                            System.out.println("You have taken the " + map.rooms[row][col].contents.name);
                            map.rooms[row][col].contents = null;
                        }
                        else if(map.rooms[row][col].contents == null)
                        {
                            System.out.println("There is nothing to be taken here");
                        }
                    }
                    break;
                case "drop":
                    if(input.equals("drop"))
                    {
                        if(map.rooms[row][col].contents == null && backPack.size() != 0)
                        {
                            System.out.println("You have dropped " + backPack.getArtifact(0).name);
                            map.rooms[row][col].contents = backPack.removeArtifact(0);
                        }
                        
                        else if(map.rooms[row][col].contents != null && backPack.size() != 0)
                        {
                            Artifact temp;
                            //put artifact from room into temp
                            temp = map.rooms[row][col].contents;
                            map.rooms[row][col].contents = null;
                            //put artifact from backpack into room
                            map.rooms[row][col].contents = backPack.removeArtifact(0);
                            //put temp(the artifact from the room) into backpack
                            backPack.setArtifact(temp);
                            System.out.println("You have dropped the " + map.rooms[row][col].contents.name);
                            System.out.println("You have picked up the " + temp.name);
                        }
                        else if(backPack.size() == 0)
                        {
                            System.out.println("There is nothing in your backpack to drop");
                        }
                        
                    }
                    break;
                case "inventory":
                    if(input.equals("inventory"))
                    {
                        System.out.println(backPack.getInventory());
                    }
                    break;
                case "save":
                    if(input.equals("save"))
                    {
                        System.out.println("What would you like to name your saved file? ");
                        savedFileName = saveRestoreScanner.nextLine();
                        
                        while (!savedFileName.matches("[a-zA-Z0-9]+")) 
                        {
                        System.out.print("Invalid File name, Please enter a File Name consisting of only numbers and or letters: \n> ");
                        savedFileName = saveRestoreScanner.nextLine();
                        }
                        
                        String fileName = "C:\\Users\\Johnson\\OneDrive\\CPP\\Winter 2017\\CIS 234\\Project 3\\" + savedFileName + ".txt";
                        
                        //File(Creates file) 
                        File file = new File(fileName);
                        boolean overWrite = false;
                        
                        if(file.exists())
                        {
                            System.out.println("File name already Exists, Do you want to Overwrite it? (Y/N)");

                            String saveInput = saveRestoreScanner.nextLine();
                            if(saveInput.equalsIgnoreCase("Y"))
                            {
                                overWrite = true;
                            }
                            else if (saveInput.equalsIgnoreCase("N"))
                            {
                                overWrite = false;
                            }
                        }
                        if(!file.exists())
                        {
                            overWrite = true;
                        }
                        if(overWrite == true)
                        {
                        //FileWriter(Writes to file) 
                            FileWriter fw = new FileWriter(file);
                        //BufferedWriter(Extends FileWriter to write to file more efficiently) 
                            BufferedWriter buffer = new BufferedWriter(fw);
                        //PrintWriter(Extends FileWriter and allows you to format by using println or printf)
                            PrintWriter pw = new PrintWriter(buffer);
                        //Saved Start Location
                            pw.println("StartLocation" + "=" + row + "," + col);

                        //Saved Room Artifacts (Prints Artifact Locations to file)
                            for(int a = 0; a <= 3; a++)
                                {
                                for(int b = 0; b <= 3; b++)
                                {
                                    if(map.rooms[a][b] != null)
                                    {
                                        if (map.rooms[a][b].contents != null)
                                        {
                                            pw.println("Artifact" + "=" + map.rooms[a][b].contents.name + "," + a + "," + b);
                                        }
                                    }
                                }
                            }
                        // Save contents of backpack
                            for(int i = 0; i < backPack.size(); i++)
                            {
                                if(backPack.getArtifact(i) instanceof SpecialArtifact)
                                {
                                    SpecialArtifact temp = (SpecialArtifact)backPack.getArtifact(i);
                                    pw.println("Inventory" + "=" + backPack.getArtifact(i).name);
                                    pw.println("Special Artifact State" + "=" + temp.name + "," + temp.state);
                                    pw.println("");
                                }
                                else if(backPack.getArtifact(i) instanceof SpecialArtifact != true)
                                {
                                    pw.println("Inventory" + "=" + backPack.getArtifact(i).name);
                                }
                            }
                        // Save states of special artifacts
                            for(int a = 0; a <= 3; a++)
                            {
                                for(int b = 0; b <= 3; b++) 
                                {
                                    if(map.rooms[a][b] != null)
                                    {
                                        if(map.rooms[a][b].contents != null)
                                        {
                                            if(map.rooms[a][b].contents instanceof SpecialArtifact == true)
                                            {
                                                SpecialArtifact temp = (SpecialArtifact)map.rooms[a][b].contents;
                                                if(temp.state == true)
                                                {
                                                    String state = "on";
                                                pw.println("Special Artifact State" + "=" + temp.name + "," + state);
                                                }
                                                else if(temp.state == false)
                                                {
                                                    String state = "off";
                                                pw.println("Special Artifact State" + "=" + temp.name + "," + state);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            // Close buffer and display confirmation message
                            buffer.close();      			
                            System.out.println("Adventure saved!"); 
                        }
                        else
                        {
                            System.out.println("File was not Saved");
                        }
                    }
                    break;
                case "restore":
                    if (input.equals("restore"))
                    {
                        System.out.println("What is the file name of the saved Adventure to restore?");
                        savedFileName = saveRestoreScanner.nextLine();
                        //Saved File Directory
                        String fileName = "C:\\Users\\Johnson\\OneDrive\\CPP\\Winter 2017\\CIS 234\\Project 3\\" + savedFileName + ".txt";
                        
                        File file = new File(fileName);
                        while(!file.exists())
                        {
                            System.out.println("The file entered does not exists. Please enter a valid saved File or \"exit\" to exit restore");
                            savedFileName = saveRestoreScanner.nextLine(); 
                            fileName = "C:\\Users\\Johnson\\OneDrive\\CPP\\Winter 2017\\CIS 234\\Project 3\\" + savedFileName + ".txt";
                            file = new File(fileName);
                            
                            if(savedFileName.equalsIgnoreCase("exit"))
                            {
                                break;
                            }
                        }
                        if(savedFileName.equalsIgnoreCase("exit"))
                        {
                            System.out.println("You have exited restore, no file restored");
                            System.out.println("");
                            System.out.println("You are currently at the " + map.rooms[row][col].name);
                            break;
                        }
                        FileReader reader = new FileReader(file);
                        
                        BufferedReader buffer = new BufferedReader(reader);
                        //Erase Artifacts from the Map
                        map.erase();
                        
                        //Erase Artifacts from BackPack 
                        backPack.erase();


                        //Reads Saved File
                        String fileInput = buffer.readLine();
                        while(fileInput != null)
                        {
                            String[] data = fileInput.split("=|,");
                            String key = data[0];
                            if(key.equals("StartLocation"))
                            {
                                row = Integer.parseInt(data[1]);
                                col = Integer.parseInt(data[2]);
                            }
                            else if(key.equals("Artifact"))
                            {
                                //Restores Artifact Locations
                                String name = data[1].toLowerCase();
                                int artifactRow = Integer.parseInt(data[2]);
                                int artifactCol = Integer.parseInt(data[3]);

                                if(name.equals("sign"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.sign;
                                }
                                else if(name.equals("coffee"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.coffee;
                                }
                                else if(name.equals("exam"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.exam;
                                }
                                else if(name.equals("gazebo"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.gazebo;
                                }
                                else if(name.equals("Panda Express Meal"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.panda;
                                }
                                else if(name.equals("picture"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.picture;
                                }
                                else if(name.equals("lunch"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.lunch;
                                }
                                else if(name.equals("dirt"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.dirt;
                                }
                                else if(name.equals("paper"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.paper;
                                }
                                else if(name.equals("robot"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.robot;
                                }
                                else if(name.equals("car"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.car;
                                }
                                else if(name.equals("Aloe Polyphylla"))
                                {
                                    map.rooms[artifactRow][artifactCol].contents = map.aloePlant;
                                }
                            }
                            else if(key.equals("Inventory"))
                            {
                                //Restore Backpack contents
                                String name = data[1].toLowerCase();
                                if(name.equals("sign"))
                                {
                                    backPack.setArtifact(map.sign);
                                }
                                if(name.equals("coffee"))
                                {
                                    backPack.setArtifact(map.coffee);
                                }
                                if(name.equals("robot"))
                                {
                                    backPack.setArtifact(map.robot);
                                }
                                if(name.equals("exams"))
                                {
                                    backPack.setArtifact(map.exam);
                                }
                                if(name.equals("gazebo"))
                                {
                                    backPack.setArtifact(map.gazebo);
                                }
                                if(name.equals("Panda Express Meal"))
                                {
                                    backPack.setArtifact(map.panda);
                                }
                                if(name.equals("picture"))
                                {
                                    backPack.setArtifact(map.picture);
                                }
                                if(name.equals("lunch"))
                                {
                                    backPack.setArtifact(map.lunch);
                                }
                                if(name.equals("car"))
                                {
                                    backPack.setArtifact(map.car);
                                }
                                if(name.equals("dirt"))
                                {
                                    backPack.setArtifact(map.dirt);
                                }
                                if(name.equals("Aloe Polyphylla"))
                                {
                                    backPack.setArtifact(map.aloePlant);
                                }
                                if(name.equals("paper"))
                                {
                                    backPack.setArtifact(map.paper);
                                }
                            }
                            else if(key.equals("Special Artifact State"))
                            {
                                //Restore states of special artifacts
                               String name = data[1].toLowerCase();

                                if(name.equals("robot"))
                                {
                                    if(data[2].equals("on"))
                                    {
                                        map.robot.state = true;
                                    }
                                    else
                                    {
                                        map.robot.state = false;
                                    }
                                }
                                if(name.equals("car"))
                                {
                                    if(data[2].equals("on"))
                                    {
                                        map.car.state = true;
                                    }
                                    else
                                    {
                                        map.car.state = false;
                                    }
                                }
                                if(name.equals("paper"))
                                {
                                    if(data[2].equals("on"))
                                    {
                                        map.paper.state = true;
                                    }
                                    else
                                    {
                                        map.paper.state = false;
                                    }
                                }
                                if(name.equals("Aloe Polyphylla"))
                                {
                                    if(data[2].equals("on"))
                                    {
                                        map.aloePlant.state = true;
                                    }
                                    else
                                    {
                                        map.aloePlant.state = false;
                                    }
                                }
                            }
                            fileInput = buffer.readLine();
                        }
                        buffer.close();
                        reader.close();

                        System.out.println("Restore Successful!");
                        System.out.println("Welcome back Adventurer!");
                    }
                    break;
                case "help":
                    System.out.println("Here is a list of available Commands");
                    System.out.println("Direction Inputs: ");
                    System.out.printf("\t \"N\" for North, \"S\" for South, \"W\" for West, \"E\" for East \n");
                    System.out.printf("\t \"NW\" for NorthWest, \"NE\" for NorthEast, \"SW\" for SouthWest, \"SE\" for SouthEast \n");
                    System.out.println("*Look*: Display current location, Location description, Exits, and Artifacts present");
                    System.out.println("*Examine*: Displays the current details of the present Artifact");
                    System.out.println("*Touch*: If the Artifact touched is special, it will change states");
                    System.out.println("*Take*: Takes the Artifact in the room and puts it into your backpack. "
                                        + "\n \t Note: Maximum Backpack Capacity is 3 items");
                    System.out.println("*Drop*: Drops the first item from your backpack into the current room. "
                                        + "\n \t If the room already has an Artifact, a swap of the first item"
                                        + "\n \t in your backpack and the artifact in the room will occur");
                    System.out.println("*Inventory*: Displays current Artifacts in your backpack");
                    System.out.println("*Save*: Saves your Adventure");
                    System.out.println("*Restore*: Restores a previously saved Adventure "
                                        + "\n \t after inputting a valid saved file name");
                    System.out.println("*Quit*: Quits the Great Cal Poly Underground Adventure");
                    break;
                case "quit":
                    System.out.print("Do you wish to leave the Undergound? (Y/N)? > ");
                    input = scan.nextLine().toLowerCase();
                    if(input.equals("y"))
                    {
                        input = "quit";
                        break;
                    }
                    else if(input.equals("n"))
                    {
                        System.out.println("You are currently at the " + map.rooms[row][col].name);
                      break;  
                    }
                
                default:
                    System.out.println("I don't understand the word \"" + input + "\"");
                    break;
                case "test":
                System.out.println(map.rooms[row][col].contents instanceof SpecialArtifact);
                System.out.println(backPack.getArtifact(0).name);
            }
        }

        // Display goodbye message and close resources
        System.out.println("Thank you for visiting the Underground.");
        
        scan.close();
        saveRestoreScanner.close();
    }
}

// @author Johnson Ju
