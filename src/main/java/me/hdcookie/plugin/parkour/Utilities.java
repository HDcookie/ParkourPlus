package me.hdcookie.plugin.parkour;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

public class Utilities {

    public static Location getLocation(String name, int checkpoint){
        YamlConfiguration checks = Parkour.getMainInstance().getCheckpointFile();
       String smth = "cources."+name +"."+checkpoint;

       double x = checks.getDouble(smth+".x");
       double y = checks.getDouble(smth+".y");
       double z = checks.getDouble(smth+".z");

       World world = Bukkit.getWorld(checks.getString(smth+".world"));


        Location location = new Location(world, x, y, z);
        return location;
    }

    public boolean atLocation(Location loc){
        for(int i = (int) loc.getX(); i < loc.getX()+0.99; i++){
            return true;
        }
        for(int i = (int) loc.getY(); i < loc.getY()+0.99; i++){
            return true;
        }
        for(int i = (int) loc.getZ(); i < loc.getZ()+0.99; i++){
            return true;
        }
        return false;
    }

}
