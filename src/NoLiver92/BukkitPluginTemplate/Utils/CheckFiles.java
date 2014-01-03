package NoLiver92.BukkitPluginTemplate.Utils;

/**
 * Created by Nick on 03/01/14.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import NoLiver92.BukkitPluginTemplate.BukkitTemplate;

public class CheckFiles
{

    private final BukkitTemplate plugin;

    public CheckFiles(BukkitTemplate plugin)
    {
        this.plugin = plugin;
    }

    public void checkConfig(String filename)
    {
        if(!checkFile(filename, plugin.getDataFolder()))
        {
            plugin.getLogger().warning("Error creating config!");
        }
    }
    public boolean checkFile(String filename, File directory)
    {
        if(!(new File(directory, filename)).exists())
        {
            if(!extractFile(filename, directory))
            {
                return false;
            }
        }
        return true;
    }
    public boolean extractFile(String filename, File destination)
    {
        File outputFile = new File(destination, filename);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String theDate = dateFormat.format(date);
        File backup = new File(destination, theDate + filename);
        try
        {
            if(outputFile.exists())
            {
                outputFile.renameTo(backup);
            }
            destination.mkdir();
            if(getClass().getResourceAsStream("/" + filename) == null)
            {
                if(backup.exists())
                {
                    backup.renameTo(outputFile);
                }
                System.out.println("File not found in jar: " + filename);
                return false;
            }
            outputFile.createNewFile();
            InputStream is = getClass().getResourceAsStream("/" + filename);
            FileOutputStream fos = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = is.read(buffer)) > 0)
            {
                fos.write(buffer, 0, bytesRead);
            }
            fos.flush();
            fos.close();
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error extracting file: " + filename);
        }
        return true;
    }

}

