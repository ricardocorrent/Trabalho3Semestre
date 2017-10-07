/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


/**
 *
 * @author rcorrent
 */
public class WebServices {
    private static final String URL_WEBSERVICE = "https://maps.googleapis.com/maps/api/directions/json?";
    
    public String getWebServices(String urlWebServices) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlWebServices);
            connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();
            return byteToString(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }

    public String byteToString(InputStream is) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }
    
    public static void main(String[] args) {
        WebServices w = new WebServices();
        StringBuffer url = new StringBuffer();
        url.append("https://maps.googleapis.com/maps/api/directions/json?");
        url.append("origin=rua+europDDFvel,Pr");
        url.append("&destination=Cascavel,Pr");
        url.append("&key=AIzaSyDLH74ZQxjUjpnNWhz8i9loKCGwOdCIoo4");
        
        System.out.println(w.getWebServices(url.toString()));        
        
        JSONObject json = new JSONObject(w.getWebServices(url.toString()));
        
        //Getting routes
        JSONArray result = json.getJSONArray("routes");
        
        JSONArray jLegs = null;
        JSONObject jDistance = null;
        String distancia = null;
        JSONObject jDuration = null;
        String duracao = null;
        
        for(int i = 0; i < result.length(); i++){
            //System.out.println(result.get(i));
            
            //Getting legs
            jLegs = ( (JSONObject)result.get(i)).getJSONArray("legs");
            for(int j=0;j<jLegs.length();j++){
                
                // Getting distancia e duracao
                jDistance = ((JSONObject) jLegs.get(j)).getJSONObject("distance");
                distancia = jDistance.getString("text");
                jDuration = ((JSONObject) jLegs.get(j)).getJSONObject("duration");
                duracao = jDuration.getString("text");
            }
        }
        System.out.println(distancia);
        System.out.println(duracao);
        System.out.println("Status: " + json.getString("status"));
    }

    
    /** //Receives a JSONObject and returns a list of lists containing latitude and longitude
    public List<List<HashMap<String,String>>> parse(JSONObject jObject){
 
        List<List<HashMap<String, String>>> routes = new ArrayList<List<HashMap<String,String>>>() ;
        JSONArray jRoutes = null;
        JSONArray jLegs = null;
        JSONArray jSteps = null;
        JSONObject jDistance = null;
        JSONObject jDuration = null;
 
        try {
 
            jRoutes = jObject.getJSONArray("routes");
 
            // Traversing all routes
            for(int i=0;i<jRoutes.length();i++){
                jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
 
                List<HashMap<String, String>> path = new ArrayList<HashMap<String, String>>();
 
                // Traversing all legs 
                for(int j=0;j<jLegs.length();j++){
 
                    /** Getting distance from the json data 
                    jDistance = ((JSONObject) jLegs.get(j)).getJSONObject("distance");
                    HashMap<String, String> hmDistance = new HashMap<String, String>();
                    hmDistance.put("distance", jDistance.getString("text"));
 
                    // Getting duration from the json data 
                    jDuration = ((JSONObject) jLegs.get(j)).getJSONObject("duration");
                    HashMap<String, String> hmDuration = new HashMap<String, String>();
                    hmDuration.put("duration", jDuration.getString("text"));
 
                    // Adding distance object to the path 
                    path.add(hmDistance);
 
                    // Adding duration object to the path 
                    path.add(hmDuration);
 
                    jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps"); 
                    
                    
                }
                routes.add(path);
                
            }
        } catch (JSONException e) {
           e.printStackTrace();
        }catch (Exception e){
        }
        return routes;
    }*/
    
    
}
