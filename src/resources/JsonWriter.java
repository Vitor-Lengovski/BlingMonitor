package resources;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriter
{
    @SuppressWarnings("unchecked")
    public static void main(List<String> urls)
    {
        //First Employee

       // JSONObject cameras = new JSONObject();
       // JSONObject camerasContainerObject = new JSONObject();
        JSONArray cameras = new JSONArray();
        for (int counter = 0; counter < urls.size(); counter++) {
            JSONObject cameraUnique = new JSONObject();
            cameraUnique.put("CameraName", "camera"+(counter+1));
            cameraUnique.put("URL", urls.get(counter));
            cameras.add(cameraUnique);
           // camerasContainerObject.put(cameras, "Cameras");

        }




        //Write JSON file
        try (FileWriter file = new FileWriter("camerasIndexed.json")) {

            file.write(cameras.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}