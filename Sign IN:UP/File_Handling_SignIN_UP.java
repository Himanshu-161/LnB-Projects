import java.io.FileWriter;
import java.util.Scanner;
import java.io.*;
public class File_Handling_SignIN_UP{
    static void create(){
        File obj = new File("data.txt");
        try
        {
            if (obj.createNewFile()) {

                System.out.println("File created");
            }
            else System.out.println("Already exists");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    static void write_file(String name , String password , String gmail){
        try {
            FileWriter fw = new FileWriter("data.txt", true);
            fw.write(name +" , "+password+" , "+gmail+"\n");
            fw.close();
            System.out.println("Data successfully updated");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static boolean read(String check){
        boolean ans=false;
        try {
            File fr= new File("data.txt");
            Scanner sc = new Scanner(fr);

            while(sc.hasNextLine())
            {  String file_data = sc.nextLine();
                ans= file_data.contains(check);
            }
            sc.close();
        }
        catch(Exception ignored){
        }
        return ans;
    }
    static void delete(){
        File fd = new File("data.txt");
        if(fd.delete()) {
            System.out.println("Database deleted successfully");
        }
        else
        {
            System.out.println("Database not deleted");
        }
    }
}