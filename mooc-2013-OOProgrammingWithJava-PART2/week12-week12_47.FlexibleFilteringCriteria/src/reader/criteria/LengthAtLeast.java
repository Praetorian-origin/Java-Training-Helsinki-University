/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author praetorian
 */
public class LengthAtLeast implements Criterion {

    private int lengthAtLeast;

    public LengthAtLeast(int lengthAtLeast) {
        this.lengthAtLeast = lengthAtLeast;
    }

    @Override
    public boolean complies(String line) {
        if (line.length() >= this.lengthAtLeast) {
            return true;
        }
        return false;
    }

}
