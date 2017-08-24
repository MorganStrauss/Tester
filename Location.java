public class Location {
    //State Variables
    public static int roomTile = 1;
    public static boolean compClosetDoor = false;
    
    //static String[] room = {"NULL", "BEDROOM", "HALLWAY", "BATHROOM", "LIVINGROOM"};
    //public static String roomTitle = room[roomTile];
    
    //Constructors
    public Location() {}//Creates a Location Object
    
    //Methods
    public static int getNorth()
    {
      switch(roomTile)
      {
          case 1: //Bedroom
            return 2; //Leads to Hallway
          case 2: //Hallway
            return 4; //Living Room
          default:
            return 0;
      }
    }
    public static int getSouth()
    {
      switch(roomTile)
      {
          case 2: //Hallway
            return 1; //Back to Mainroom
          case 4: //Living Room
            return 2;  //Back to Hallway
          default:
            return 0;
      }
    }
    public static int getWest()
    {
      switch(roomTile)
      {
          case 1: //Bedroom
            return 5; //Closet Door West
          case 3: //Bathroom
            return 2;
          default:
            return 0;
      }
    }
    public static int getEast()
    {
      switch(roomTile)
      {
          case 2: //Hallway
            return 3; //Bathroom
          case 5: //Closet
            return 1;
          default:
            return 0;
      }
    }
    
    //Mostly unused directions
    public static int getNorthEast()
    {
      switch(roomTile)
      {
          default:
            return 0;
      }
    }
    public static int getNorthWest()
    {
      switch(roomTile)
      {
          default:
            return 0;
      }
    }
    public static int getSouthEast()
    {
      switch(roomTile)
      {
          default:
            return 0;
      }
    }
    public static int getSouthWest()
    {
      switch(roomTile)
      {
          default:
            return 0;
      }
    }
}