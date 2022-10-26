package CustomerService;

import Entity.CurrenCyExample;
import Entity.Customer;
import Entity.Database;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CustomerService {

    public static Customer getCustomerByChatid(String chatId) {
       return Database.customers.stream()
                .filter(customer -> customer.getChatId().equals(chatId))
                .findFirst().orElse(null);
    }

    public static Double checkDollar() {

            Gson gson=new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            try {
                URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
                URLConnection urlConnection = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                CurrenCyExample[] currenCyExamples = gson.fromJson(reader, CurrenCyExample[].class);

                for (CurrenCyExample currenCyExample : currenCyExamples) {
                    if(currenCyExample.getCcyNmUZ().equals("AQSH dollari")){
                        Double rate = Double.valueOf(currenCyExample.getRate());
                        return rate;

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0.0;
    }
    public static Double checkYevro () {

        Gson gson=new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            CurrenCyExample[] currenCyExamples = gson.fromJson(reader, CurrenCyExample[].class);

            for (CurrenCyExample currenCyExample : currenCyExamples) {
                if(currenCyExample.getCcyNmUZ().equals("EVRO")){
                    Double rate = Double.valueOf(currenCyExample.getRate());
                    return rate;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public static Double checkRubl () {

        Gson gson=new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            CurrenCyExample[] currenCyExamples = gson.fromJson(reader, CurrenCyExample[].class);

            for (CurrenCyExample currenCyExample : currenCyExamples) {
                if(currenCyExample.getCcyNmUZ().equals("Rossiya rubli") ){
                    Double rate = Double.valueOf(currenCyExample.getRate());
                    return rate;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}
