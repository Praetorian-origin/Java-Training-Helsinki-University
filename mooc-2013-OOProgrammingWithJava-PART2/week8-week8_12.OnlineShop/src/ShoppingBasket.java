
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class ShoppingBasket {

    private List<Purchase> purchases;

    public ShoppingBasket() {
        purchases = new ArrayList<Purchase>();
    }

    public void add(String product, int price) {
        Purchase purchase = new Purchase(product, 1, price);
        if (purchases.contains(purchase)) {
            purchases.get(purchases.indexOf(purchase)).increaseAmount();
            return;
        }
        purchases.add(purchase);
    }

    public int price() {
        int price = 0;
        for (Purchase purchase : purchases) {
            price += purchase.price();
        }
        return price;
    }

    public void print() {
        for (Purchase purchase : purchases) {
            System.out.println(purchase.toString());
        }
    }
}
