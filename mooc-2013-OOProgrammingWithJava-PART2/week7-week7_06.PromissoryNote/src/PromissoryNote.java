
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class PromissoryNote {

    private HashMap<String, Double> loans;

    public PromissoryNote() {
        loans = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        loans.put(toWhom, value);

    }

    public double howMuchIsTheDebt(String whose) {
        if (loans.containsKey(whose)) {
            return loans.get(whose);

        }
        return 0;
    }
}
