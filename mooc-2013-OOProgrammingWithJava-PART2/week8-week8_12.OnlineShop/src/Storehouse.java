
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class Storehouse {

 
    private Map<String, Integer> products;
    private Map<String, Integer> stock_of_products;

    public Storehouse() {
        products = new HashMap<String, Integer>();
        stock_of_products = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stock_of_products.put(product, stock);
    }

    public int price(String product) {
        if (products.containsKey(product)) {
            return products.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (stock_of_products.containsKey(product)) {
            return stock_of_products.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (stock_of_products.containsKey(product) && stock_of_products.get(product) > 0) {
            stock_of_products.replace(product, stock_of_products.get(product) - 1);
            return true;
        }
        return false;
    }
    
    
    public Set<String> products() {
        return products.keySet();
    }
}
