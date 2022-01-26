

package moneycalculator;

import Persistance.FileCurrencyLoader;
import Model.Currency;
import View.MC_Swing;
import java.util.List;


public class MoneyCalculator {


    public static void main(String[] args) {
       FileCurrencyLoader currencyLoader = new FileCurrencyLoader("currencies.txt");
       List<Currency> currencies = currencyLoader.load();
       MC_Swing userInterface = new MC_Swing(currencies);
       userInterface.setVisible(true);
       
       
       
    }
    
}
