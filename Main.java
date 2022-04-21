import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.io.FileReader;
import java.util.HashMap;

public class Main {

    public static HashMap<BigInteger, String> map = new HashMap<BigInteger, String>();
    public static JSONArray jsonArr = new JSONArray();


    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        int size = Integer.parseInt(args[1]);

        //String ID = "";
        try {
            //BufferedReader reader = new BufferedReader(new FileReader("example_input_data_1.data"));
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            ArrayList<BigInteger> scores = new ArrayList<BigInteger>();
            String currentLine = reader.readLine();
            while(currentLine != null){
                String[] details = currentLine.split(":",2);
                String[] getID = details[1].split(",", 2);
                String score = details[0];

                String ID = getID[0].substring(7);


                BigInteger toInt = new BigInteger(score);
                scores.add(toInt);
                size++;
                map.put(toInt, ID);
                currentLine = reader.readLine();
            }

            Collections.sort(scores);
            Collections.reverse(scores);
            for (int i = 0; i < size; i++) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("score: ", scores.get(i));
                jsonObj.put("id:", map.get(scores.get(i)));
                jsonArr.add(jsonObj);
                //System.out.println(scores.get(i));
                //System.out.println(map.get(scores.get(i)).toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(jsonArr.toJSONString());
    }
}
