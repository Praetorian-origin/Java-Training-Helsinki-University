/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class AtLeastOne implements Criterion {

    private List<Criterion> criterions;

    public AtLeastOne(Criterion... criterion) {
        criterions = new ArrayList<Criterion>();
        for (int i = 0; i < criterion.length; i++) {
            criterions.add(criterion[i]);

        }
    }

    @Override
    public boolean complies(String line) {
        for (Criterion criterion : criterions) {
            if (criterion.complies(line)) {
                return true;
            }
        }
        return false;
    }

}
