
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Convert {
    public static String s;
    String Areatype;
    String Size;
    String Area;
    String NOBath;
    String NOBalcony;
    String City;
    Convert(String Areatype, String Size, String Area, String NOBath, String NOBalcony, String City){
        this.Areatype = Areatype;
        this.Size = Size;
        this.Area = Area;
        this.NOBath = NOBath;
        this.NOBalcony = NOBalcony;
        this.City = City;
    }
    String predict() throws IOException {

        // String pathPython = "HP_pred.py";
        String pathPython = "C:/Users/91703/OneDrive/Desktop/OPPS CP/HP_pred.py";
        // String pathPython = "C:/dev/java/House price app/java.py";

        String [] cmd = new String[8];
        cmd[0] = "python";
        cmd[1] = pathPython;
        cmd[2] = this.Areatype;
        cmd[3] = this.Size;
        cmd[4] = this.Area;
        cmd[5] = this.NOBath;
        cmd[6] = this.NOBalcony;
        cmd[7] = this.City;

        Runtime r = Runtime.getRuntime();
        r.exec(cmd);
        String data = null;
        try {
            File Obj = new File("predict.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                data = Reader.nextLine();
                System.out.println(data); 
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return data;

    }
}