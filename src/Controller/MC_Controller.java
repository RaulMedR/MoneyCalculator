package Controller;

import Model.Money;
import Model.WebExchangeRate;
import View.Dialog;
import View.Display;

public class MC_Controller {
    private final Dialog dialog;
    private final Display display;
    private final WebExchangeRate exchangeRateLoader;

    public MC_Controller(Dialog dialog, Display display) {
        this.dialog = dialog;
        this.display = display;
        this.exchangeRateLoader = new WebExchangeRate();
    }
    
    public void execute(){
        display.show(new Money(dialog.getAmount().getAmount() * exchangeRateLoader.getRate(dialog.getCurrencyFrom(), dialog.getCurrencyTo()), dialog.getCurrencyTo()));
    }
    
    
    
    
    

}
