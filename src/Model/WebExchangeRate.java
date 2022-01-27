package Model;

import Model.Currency;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebExchangeRate {
    private URL url;
    
    public double getRate(Currency currencyFrom, Currency currencyTo){
        double exchangeRate = 0;
        try{
            this.url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + 
                    currencyFrom.getCode().toLowerCase() + "/" + currencyTo.getCode().toLowerCase() + ".json");
        } catch(MalformedURLException e){
            System.out.println("ERROR: WebExchangeRate (getRate) " + e.getMessage());
        }
        
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            
            String line = reader.readLine();
            while(line != null && !line.contains(currencyTo.getCode().toLowerCase())){
                line = reader.readLine();
            }
            reader.close();
            exchangeRate = Double.parseDouble(line.split(": ")[1]);
        } catch(IOException e){
            System.out.println("ERROR: WebExchangeRate (getRate) " + e.getMessage());
        }
        
        return exchangeRate;
    }
    

}
