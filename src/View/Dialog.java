
package View;

import Model.Currency;
import Model.Money;

/**
 *
 * @author raulm
 */
public interface Dialog {
    Money getAmount();
    Currency getCurrencyFrom();
    Currency getCurrencyTo();
    
}
