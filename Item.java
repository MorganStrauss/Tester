public class Item
{
    public String itemDes;
    public int itemID;
    public String roomName;
    public int roomID;
    public boolean taken;
    public boolean takeable;
    public int weight;
    public int value;
    public int damage;
    
    public Item (String des, int id, String room, int rid, boolean t, boolean ta, int w, int v, int d)
    {
        itemDes = des;
        itemID = id;
        roomName = room;
        roomID = rid;
        taken = t;
        takeable = ta;
        weight = w;
        value = v;
        damage = d;
    }
    
    /*public static String getName()
    {
        return itemDes;
    }
    
    public static int getItemID()
    {
        return itemID;
    }*/
    
    
}