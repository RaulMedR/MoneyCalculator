
package Persistance;

import Model.Currency;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyLoader {
    private final String pathNameArchive;
    public FileCurrencyLoader(String pathNameArchive){
        this.pathNameArchive = pathNameArchive;
    }
    public List<Currency> load(){
        List<Currency> currenciesList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.pathNameArchive));
            String line = reader.readLine();
            while(line != null){
                String[] textSplit = line.split(",");
                Currency currency = new Currency(textSplit[0], textSplit[1], textSplit[2]);
                currenciesList.add(currency);
                line = reader.readLine();
            }
            reader.close();
        } catch(FileNotFoundException e){
            System.out.println("ERROR: FileCurrencyLoader (load) " + e.getMessage());
        } catch(IOException e){
            System.out.println("ERROR: FileCurrencyLoader (load) " + e.getMessage());
        }
        return currenciesList;
    }

}
