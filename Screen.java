 public class Screen {
    //Static variables for all lines on the Screen (Made so an object would not have to be created to print the screen)
    public static String line1 = "---COMPUTERROOM---";
    public static String line2 = "Welcome to Jork!!";
    public static String line3 = "Type \"help\" for Commands!!";
    public static String line4 = "You are in a room that has recently been used";
    public static String line5 = "A game is open on the computer with the name \"Zork\"";
    public static String line6 = "Here on an old shelf, a pair of dirty glasses rest";
    public static String line7 = "A note sticks to the top left of the computer screen";
    public static String line8 = "In the corner of the room, a dusty guitar leans on the wall";
    public static String line9 = "To the West, a closed closet door";
    public static String line10 = "To the North, an ajar door";
    
    //Constructors
    public Screen() {} //Makes a screen object
    
    //Methods
    public static void setScreen(int x) //Method to change Screen
    {    
        switch(x)
        {
            case 0: //Nothing
                line1 = "";
                line2 = ""; 
                line3 = "";
                line4 = "";
                line5 = "";
                line6 = "";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
            case 1: //Main Room
                line1 = "---COMPUTERROOM---";
                line2 = "You are in a room that has recently been used"; 
                line3 = "A game is open on the computer with the name \"Zork\"";
                line4 = "Here on an old shelf, a pair of dirty glasses rest";
                line5 = "A note sticks to the top left of the computer screen";
                line6 = "In the corner of the room, a dusty guitar leans on the wall";
                line7 = "To the West, a closed closet door";
                line8 = "To the North, an ajar door";
                line9 = "";
                line10 = "";
                break;
            case 2: //Hallway
                line1 = "---SOUTH HALLWAY---";
                line2 = "You find yourself in a dimly lit, wooden floored hallway"; 
                line3 = "A painting hangs crooked from the west wall";
                line4 = "You see a door east that seem to lead to the bathroom";
                line5 = "Strait north appears to open into a larger, more lit room";
                line6 = "Behind you, south, leads back to the bedroom";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
                case 3: //Bathroom
                line1 = "---BATHROOM---";
                line2 = "You find yourself in a smelly decrepit old bathroom"; 
                line3 = "There is a decaying yellow cabinet to your left,";
                line4 = "with rotting rat carcus resting on its surface";
                line5 = "Hidden behind the crumbling holes in the wall are glazed";
                line6 = "over dead eyes of a forgotten cat";
                line7 = "Behind you, west, leads back to the South Hallway";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
                case 4: //Top of Staircase
                line1 = "---STAIRCASE---";
                line2 = "You walk up the creaking, rugged staircase"; 
                line3 = "Hearing a splash beside you, you look up, noticing a leak";
                line4 = "caused from the ever dilapidated state of the tattered household";
                line5 = "Strait north appears to open into a larger, more lit hall";
                line6 = "Behind you, south, leads back to the South Hallway";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
                case 5: //Closet (WIP)
                if (!Location.compClosetDoor) //if the closet door is locked
                {
                    Location.roomTile = 1; //set user back to computerroom
                    UserInt.compAnswer = "The door is locked shut and won't budge";
                    break;
                }
                line1 = "---COMPUTER CLOSET---";
                line2 = "Opening the door, you find a dark, dust ridden closet"; 
                line3 = "trash and clothing lays about haphazardly";
                line4 = "noticing something in the corner, you move empty boxes away";
                line5 = "to reveal a partially cylindrical device labeled “portal gun” on the side";
                line6 = "Behind you, east, leads back to the main room";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
                case 6: //North Hallway
                line1 = "---NORTH HALLWAY---";
                line2 = "Walking into the room, you look around to notice a wide, open hall"; 
                line3 = "The walls are decorated with elden, mystic looking lanterns";
                line4 = "A large embellished door towers in front of you";
                line5 = "To the West, a door lays open, revealing a dusty old office space";
                line6 = "Looking south, there is the top of a deteriorating staircase";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
            case 21: //help
                line1 = "---HELP---";
                line2 = "Directions: N, E, S, W, NE, NW, SE, SW, Down, Up"; 
                line3 = "Actions: Take, Drop, Info, Quit, Inventory(i), ";
                line4 = "Prepositions: at, ";
                line5 = "";
                line6 = "";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                break;
            case 22: //Inventory
                line1 = "---INVENTORY---";
                line2 = "";
                line3 = "";
                line4 = "";
                line5 = "";
                line6 = "";
                line7 = "";
                line8 = "";
                line9 = "";
                line10 = "";
                //if (inv.glasses)
                //    line2 = line2 + " Glasses";
                //if (Inv.compNote)
                //    line2 = line2 + " Computer Note";    
                break;
            default:
                line1 = "ERROR"; 
                line2 = "ERROR";
                line3 = "ERROR";
                line4 = "ERROR";
                line5 = "ERROR";
                line6 = "ERROR";
                line7 = "ERROR";
                line8 = "ERROR";
                line9 = "ERROR";
                line10 = "ERROR";
                break;
        }
    }
}