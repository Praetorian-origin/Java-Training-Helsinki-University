/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author praetorian
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    public int avgRatings(Film film) {
        List<Rating> ratings = new ArrayList<Rating>();
        ratings.addAll(this.ratings.get(film));
        int sum = 0;
        int elements = 0;
        for (Rating rating : ratings) {
            sum += rating.getValue();
            elements++;
        }
        return sum / elements;

    }

    @Override
    public int compare(Film t, Film t1) {
       return avgRatings(t1) - avgRatings(t);
    }

}
