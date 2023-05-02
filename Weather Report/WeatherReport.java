import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class WeatherReport {
    public static void main(String[] args) {
        Scanner val =new Scanner(System.in);
        System.out.println("             ");
        System.out.println("Welcome:-)");
        System.out.println("Get all your Weather Reports here:-");
        System.out.println("Enter the name of the city:");
        String cityname =val.next();
        System.out.println("Enter the code of the state in capital letters:");
        String statecode=val.next();
        try {
            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+cityname+","+statecode+",IND&limit=1&appid=71ad361ee6eacda723d4e0b41ce5d81c ");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int rc = con.getResponseCode();
            //System.out.println(rc);
            if (rc != 200) {
                System.out.println("Error in Connection Establishment");
            } else {
                String data = "";
                Scanner sc = new Scanner(url.openStream());

                while (sc.hasNext()) {
                    data += sc.nextLine();
                }
                sc.close();
                //System.out.println(data);
                JSONParser par = new JSONParser();
                JSONArray arr = (JSONArray) par.parse(data);
//              System.out.println(arr);
//              System.out.println(arr.get(0));
                JSONObject obj = null;

                for (int i = 0; i < arr.size(); i++) {
                    obj = (JSONObject) arr.get(i);
                    //System.out.println(obj);
                    //System.out.println(obj.get("lat"));
                    //System.out.println(obj.get("lon"));
                    double lat = (double) obj.get("lat");
                    double lon = (double) obj.get("lon");

                    URL url2 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=71ad361ee6eacda723d4e0b41ce5d81c");
                    HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
                    con2.setRequestMethod("GET");
                    con2.connect();
                    int rc2 = con2.getResponseCode();
                    //System.out.println(rc2);
                    if (rc2 != 200) {
                        System.out.println("Error in Connection Establishment");
                    } else {
                        String data2 = "";
                        Scanner sc2 = new Scanner(url2.openStream());
                        while (sc2.hasNext()) {
                            data2 += sc2.nextLine();
                        }
                        sc2.close();
                        //System.out.println(data2);
                        JSONParser para = new JSONParser();
                        JSONObject obj2 = (JSONObject) para.parse(data2);
                        // System.out.println(obj2);
                        JSONObject main =(JSONObject) obj2.get("main");
                        JSONObject wind = (JSONObject) obj2.get("wind");
                        //JSONObject visibility = (JSONObject) obj2.get("visibility");
                            double a =(double)main.get("temp");
                            float b = (float) (a-273.15);

                        System.out.println("               ");
                        System.out.println("********** Weather Report **********");
                        System.out.println("Current Temp = >> " +(b)+ "°C");
                        System.out.println("Humidity     = >> "+ main.get("humidity") +"%");
                        System.out.println("Wind Speed   = >> " + wind.get("speed")+"Km/h");
                        System.out.println("Visibility   = >> " +obj2.get("visibility")+"m");
                        System.out.println("Pressure     = >> " + main.get("pressure") +"mBar");
                    }
                }
            }
        }
    catch(Exception e){
            }
    }
    }



