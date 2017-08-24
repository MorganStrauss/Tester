public class Room
{
    public String roomName;
    public String roomDes;
    public int roomID;
    public String northRoom;
    public String southRoom;
    public String westRoom;
    public String eastRoom;
    public String aboveRoom;
    public String belowRoom;
    
    public Room (String name, String des, int id, String n, String s, String w, String e)
    {
        roomName = name;
        roomDes = des;
        roomID = id;
        northRoom = n;
        southRoom = s;
        westRoom = w;
        eastRoom = e;
    }
    
    public Room (String name, String des, int id, String n, String s, String w, String e, String u, String d)
    {
        roomName = name;
        roomDes = des;
        roomID = id;
        northRoom = n;
        southRoom = s;
        westRoom = w;
        eastRoom = e;
        aboveRoom = u;
        belowRoom = d;
    }
    
    /*public static String getRoomDes(String r)
    {
        return roomDes;
    }
    
    public static int getRoomID(String r)
    {
        return roomID;
    }
    
    public static String getNorthRoom(String r)
    {
        return northRoom;
    }
    
    public static String getSouthRoom(String r)
    {
        return southRoom;
    }
    
    public static String getWestRoom(String r)
    {
        return westRoom;
    }
    
    public static String getEastRoom(String r)
    {
        return eastRoom;
    }
    
    public static String getAboveRoom(String r)
    {
        return aboveRoom;
    }
    
    public static String getBelowRoom(String r)
    {
        return belowRoom;
    }*/
}