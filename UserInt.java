import java.util.*;
import java.io.*;

import com.opencsv.CSVReader;
public class UserInt { //Main User Interface of Jork
    //Public variable for the machine to awnser the user
    public static String compAnswer = "";

    //Public variables for moves and score
    public static int moves = 0;
    public static int score = 0;

        
    public UserInt() throws IOException {

        // Creating Scanner Object for all User Input
        Scanner user =  new Scanner(System.in);

        Scanner kbReader = new Scanner(System.in);
        String fileName = "JorkItems.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName));
        List<String[]> list = reader.readAll();
        String[][] dataArr = new String[list.size()][];
        dataArr = list.toArray(dataArr);

        int rows = dataArr.length;
        int columns = dataArr[0].length;//how many columns. Not sure why 0 instead of 1)
        int itemCount = rows;

        //System.out.println(itemCount);
        Item items[] = new Item[rows-1];
        for(int i = 0; i<itemCount - 1; i++)
        {
            //35 variable
            items[i] = new Item(dataArr[i+1][0], 
                Integer.parseInt(dataArr[i+1][1]),
                dataArr[i+1][2], Integer.parseInt(dataArr[i+1][3]), Boolean.parseBoolean(dataArr[i+1][4]),
                Boolean.parseBoolean(dataArr[i+1][5]), Integer.parseInt(dataArr[i+1][6]),
                Integer.parseInt(dataArr[i+1][7]), Integer.parseInt(dataArr[i+1][8]));
            //System.out.println(items[i].itemDes());
        }

        String fileName2 = "JorkRooms.csv";
        CSVReader reader2 = new CSVReader(new FileReader(fileName2));
        List<String[]> list2 = reader2.readAll();
        String[][] dataArr2 = new String[list2.size()][];
        dataArr2 = list2.toArray(dataArr2);

        int rows2 = dataArr2.length;
        int columns2 = dataArr2[0].length;//how many columns. Not sure why 0 instead of 1)
        int roomCount = rows2;

        Room rooms[] = new Room[rows2-1];
        for(int i = 0; i<roomCount - 1; i++)
        {
            //35 variable
            rooms[i] = new Room(dataArr2[i+1][0], dataArr2[i+1][1],
                Integer.parseInt(dataArr2[i+1][2]), 
                dataArr2[i+1][3], dataArr2[i+1][4],
                dataArr2[i+1][5], dataArr2[i+1][6], dataArr2[i+1][7], dataArr2[i+1][8]);
            //System.out.println("We are at line: " + i);
        }

        //Creating Inventory
        ArrayList<Item> inv = new ArrayList<>( );

        Item tempItem = null;

        //Variables
        int roomNorth; int roomNorthEast;
        int roomSouth; int roomNorthWest;
        int roomWest; int roomSouthEast;
        int roomEast; int roomSouthWest;

        //Begin Main Game Loop
        while(true){
            //Description of Room
            System.out.printf("%-68s %-10s\n", Screen.line1, "Moves:");
            System.out.printf("%-70s %-10s\n", Screen.line2, moves);
            System.out.printf("%-68s %-10s\n", Screen.line3, "Score:");
            System.out.printf("%-70s %-10s\n", Screen.line4, score);
            System.out.printf("%-10s\n", Screen.line5);
            System.out.printf("%-68s %-10s\n", Screen.line6, "Type");
            System.out.printf("%-68s %-10s\n", Screen.line7, "\"help\"");
            System.out.printf("%-68s %-10s\n", Screen.line8, "for");
            System.out.printf("%-68s %-10s\n", Screen.line9, "Commands");
            System.out.printf("%-10s\n\n", Screen.line10);

            //Awnser from Game
            System.out.println(compAnswer);

            //The User Imput
            System.out.print(">");
            String userInput = user.nextLine();

            //Turn input into array (\\s is a space)
            String words[] = userInput.split("\\s");

            //Take all words minus the first one and put them in a string(used for some text output)
            int wordLength = words.length;
            String allWords = ""; //All words typed by user exept first word
            if (wordLength >= 1)
            {
                for (int i = 1; i < wordLength; i++)
                {   
                    allWords = allWords + " " + words[i];
                }      
            }

            //Switch statement for user input (HUGE CODE)
            switch(words[0])
            {
                //Extra commands
                case "Hello":
                case "hello":
                compAnswer = "Hi";
                break;
                case "Hi":
                case "hi":
                compAnswer = "Hello";
                break;

                //Useful commands
                case "i":
                case "I":
                case "Inv":
                case "inv":
                case "inventory":
                case "Inventory":
                Screen.setScreen(22);
                compAnswer = "";
                break;
                case "help":
                case "Help":
                case "H":
                case "h":
                Screen.setScreen(21);
                compAnswer = "";
                break;
                case "info":
                case "Info":
                Screen.setScreen(Location.roomTile);
                compAnswer = "";
                break;
                case "take":
                case "Take":
                if (wordLength <= 1)
                {    
                    compAnswer = "Take what?";
                    break;
                }
                
                if(words[1] != null) //If statement for anything the player can Take
                {
                    //Finds Item
                    for(int i = 0; i < items.length; i++)
                    {
                        if(items[i].itemDes.compareTo(words[1]) == 0 && items[i].taken == false)
                        {
                            tempItem = items[i];
                            items[i].taken = true;
                        }
                    }
                    //Adds Item to Array
                    if(tempItem != null)
                    {
                        inv.add(tempItem);                        
                        compAnswer = "Taken.";
                    }
                    else
                    {
                        compAnswer = "There are no" + allWords + " here or it has already been taken.";
                    }
                    tempItem = null;
                }
                break;
                
                case "drop":
                case "Drop":
                if (wordLength <= 1)
                {    
                    compAnswer = "Drop what?";
                    break;
                }
                
                if(words[1] != null) //If statement for anything the player can Take
                {
                    //Finds Item
                    for(int i = 0; i < inv.size(); i++)
                    {
                        if(inv.get(i).itemDes.compareTo(words[i]) == 0)
                        {
                            tempItem = inv.get(i);
                        }
                    }
                    //Removes Item from Array
                    if(tempItem != null)
                    {
                        inv.remove(tempItem);                        
                        compAnswer = "Dropped.";
                        for(int i = 0; i < items.length; i++)
                            if(tempItem.itemDes.compareTo(items[i].itemDes) == 0)
                                items[i].taken = false;
                    }
                    else
                    {
                        compAnswer = "There are no" + allWords + " in your inventory.";
                    }
                    tempItem = null;
                }
                break;

                /**Left Off**/
                
                //Directions to move    
                case "N":
                case "n":
                roomNorth = Location.getNorth();
                if (roomNorth != 0)
                {
                    if (compAnswer != "") //Checks to see if the computer said something and if it did it clears it
                        compAnswer = "";
                    Location.roomTile = roomNorth;
                    Screen.setScreen(roomNorth);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "S":
                case "s":
                roomSouth = Location.getSouth();
                if (roomSouth != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomSouth;
                    Screen.setScreen(roomSouth);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "W":
                case "w":
                roomWest = Location.getWest();
                if (roomWest != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomWest;
                    Screen.setScreen(roomWest);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "E":
                case "e":
                roomEast = Location.getEast();
                if (roomEast != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomEast;
                    Screen.setScreen(roomEast);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "NE":
                case "ne":
                case "Ne":
                case "nE":
                roomNorthEast = Location.getNorthEast();
                if (roomNorthEast != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomNorthEast;
                    Screen.setScreen(roomNorthEast);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "NW":
                case "nw":
                case "Nw":
                case "nW":
                roomNorthWest = Location.getNorthWest();
                if (roomNorthWest != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomNorthWest;
                    Screen.setScreen(roomNorthWest);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "SE":
                case "se":
                case "Se":
                case "sE":
                roomSouthEast = Location.getSouthEast();
                if (roomSouthEast != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomSouthEast;
                    Screen.setScreen(roomSouthEast);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                case "SW":
                case "sw":
                case "Sw":
                case "sW":
                roomSouthWest = Location.getSouthWest();
                if (roomSouthWest != 0)
                {
                    if (compAnswer != "")
                        compAnswer = "";
                    Location.roomTile = roomSouthWest;
                    Screen.setScreen(roomSouthWest);
                } else
                {
                    compAnswer = "You can't go that way";
                }
                break;
                default:
                compAnswer = "I do not understand that command";
                break;
            }

            //End Game
            if (words[0].equals("quit") || words[0].equals("Quit")) {
                System.out.print("\u000c");
                break;
            }

            //Test Print
            //System.out.println(Location.roomTile);

            //Add a move on everytime
            moves++;

            //Clear Screen
            System.out.print("\u000c");

        }
    }
}