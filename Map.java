package GCPU;


// @author Johnson Ju

// Example map of the Great Cal Poly Underground
public class Map 
{
    // Instance variables
    Room rooms[][] = new Room[4][4];
    Artifact sign, coffee, exam, gazebo, panda, picture, lunch, dirt;
    SpecialArtifact robot, car, paper, aloePlant;
    //ArrayList <Artifact> storedArtifact = new ArrayList<>();
    
    // Constructor
    Map()
    {
    		//Local variables       Name, Exits, Description, Artifact
        Room library = new Room("University Library", new String[] {"e","s"}, "Sunlight is streaming in through the glass windows.");
        Room lectureHall = new Room("Lecture Hall", new String[] {"w","e"}, "You see a huge lecture room fit for over 300 students!");
        Room starBucks = new Room("Starbucks", new String[] {"w","s"}, "The smell of freshly made coffee in the air makes you a bit less stressed.");
        Room engineeringLab = new Room("Engineering Lab", new String[] {"sw"}, "This lab looks amazing with all the machines and gadgets in here.");
        Room classRoom = new Room("Class Room", new String[] {"n","e"}, "You see an old table covered with papers near the front of the room.");
        Room roseGarden = new Room("Rose Garden", new String[] {"w","s","e"}, "You are standing in the middle of a beautiful rose garden.");
        Room recreationalArea = new Room("Recreational Area", new String[] {"w","n","ne"}, "It is such a nice day out today. \n The recent contruction of the lake in the middle of campus looks great.");
        Room kelloggMansion = new Room("Kellogg Mansion", new String[] {"e","se"}, "This is the former home of William Kellog.");
        Room losOlivos = new Room("Los Olivos", new String[] {"w","n","e"}, "The aroma of hamburgers and pizza wafts through the air.");
        Room parkingLot = new Room("Parking Lot", new String[] {"w","sw","e"}, "The parking lot is packed! They should really develop a more efficient parking system.");
        Room constructionZone = new Room("Construction Zone ", new String[] {"w"}, "Hmm, I hope they build something useful here.");
        Room boxCanyon = new Room("Box Canyon", new String[] {"n"}, "This looks like the Voorhis Ecological Reserve. \n A cavernous opening in the canyon wall lies just ahead of you.");
        Room scienceLab = new Room("Science Lab", new String[] {"nw","ne"}, "You see a wide variety of odd looking plants in the room. \n I wonder what they're experimenting on.");
        
        sign = new Artifact("Sign", "The sign reads: No food or drink in the library.");
        library.contents = sign;
        
        //Lecture Hall
        
        coffee = new Artifact("Coffee", "It looks like its been sitting there for a while.");
        starBucks.contents = coffee;
        
        robot = new SpecialArtifact("Robot", "The robot looks so real. \n I wonder if I could turn it on", false,
                    "The robot begins to light up and power on slowly.", 
                    "The robot looks around and starts dancing.", 
                    "The robot starts walking back to its original location and slowly powers down.");
        engineeringLab.contents = robot;
       
        
        exam = new Artifact("Exams", "CIS 234 Final Exam... \n The rest appears unreadable due to the lack of pritner toner.");
        classRoom.contents = exam;
        
        gazebo = new Artifact("Gazebo", "The small plague on the structure reads: Enjoy the garden!");
        roseGarden.contents = gazebo;
        
        panda = new Artifact("Panda Express Meal", "It looks like Beef Brocoli with Orange Chicken. \n You're thinking of grabbing it and running away.");
        recreationalArea.contents = panda;
        
        picture = new Artifact("Picture", "The picture bears an inscription that reads W.K. Kellog. \n He appears to be holding a box of Corn Flakes.");
        kelloggMansion.contents = picture;
        
        lunch = new Artifact("Lunch", "The lunch appears to be a hamburger, french fries, and some kind of soda.");
        losOlivos.contents = lunch;
        
        car = new SpecialArtifact("Car", "Oh wow! It looks like a brand new Tesla! \n You feel very jealous.", false,
                    "The Tesla's Falcon Wing doors starts to open.", 
                    "The Tesla's Falcon Wing completely opens and reveals a beautiful interior.", 
                    "The Tesla's Falcon Wing starts to close");
        parkingLot.contents = car;
        
        
        dirt = new Artifact("Dirt", "You see piles and piles of dirt.");
        constructionZone.contents = dirt;
        
        paper = new SpecialArtifact("Paper", "The paper appears blank", false,
                    "The paper begins to glow and you see mysterious writing appear.",
                    "The paper reads: Welcome to the Great Cal Poly Pomona Underground!",
                    "The writing fades.");
        boxCanyon.contents = paper;
        //boxCanyon.specialArtifact = paper;
        
        aloePlant = new SpecialArtifact("Aloe Polyphylla", "Oh wow! this aloe plant looks beautiful! \n I'm going to google more information about this later.", false,
                        "The aloe plant starts to move very very slowly", 
                        "The aloe plant forms into a beautiful perfect spiral shape.",
                        "The aloe plant begins to form back into a regular aloe plant.");
        scienceLab.contents = aloePlant;   
        // Transfer local variable values to instance variables
        rooms[0][0] = library;
        rooms[0][1] = lectureHall;
        rooms[0][2] = starBucks;
        rooms[0][3] = engineeringLab;
        rooms[1][0] = classRoom;
        rooms[1][1] = roseGarden;
        rooms[1][2] = recreationalArea;
        rooms[1][3] = null;
        rooms[2][0] = kelloggMansion;
        rooms[2][1] = losOlivos;
        rooms[2][2] = parkingLot;
        rooms[2][3] = constructionZone;
        rooms[3][0] = boxCanyon;
        rooms[3][1] = scienceLab;
        rooms[3][2] = null;
        rooms[3][3] = null;
    }
    
    void erase()
    {
        for(int a = 0; a <= 3; a++)
        {
            for(int b = 0; b <= 3; b++)
            {
                if(rooms[a][b] != null)
                {
                    rooms[a][b].contents = null;
                }
            }
        }
    }
}

// @author Johnson Ju
