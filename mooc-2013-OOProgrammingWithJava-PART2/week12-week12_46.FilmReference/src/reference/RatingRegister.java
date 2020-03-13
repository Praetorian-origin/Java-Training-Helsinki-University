/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author praetorian
 */
public class RatingRegister {

    private Map<Film, List<Rating>> filmsRatings;
    private Map<Person, Map<Film, Rating>> personRatings;

    public RatingRegister() {
        filmsRatings = new HashMap<Film, List<Rating>>();
        personRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {

        if (!this.filmsRatings.containsKey(film)) {
            this.filmsRatings.put(film, new ArrayList<Rating>());

        }
        this.filmsRatings.get(film).add(rating);

    }

    public List<Rating> getRatings(Film film) {

        List<Rating> ratings = new ArrayList<Rating>();

        for (Map.Entry<Film, List<Rating>> entry : filmsRatings.entrySet()) {
            Film key = entry.getKey();

            if (key.equals(film)) {

                ratings.addAll(entry.getValue());
            }

        }
        return ratings;
    }

    public Map<Film, List<Rating>> filmRatings() {
        return this.filmsRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {

        if (!personRatings.containsKey(person)) {

            personRatings.put(person, new HashMap<Film, Rating>());
        } else if (personRatings.get(person).get(film) != null) {
            return;
        }
        personRatings.get(person).put(film, rating);
        addRating(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        Rating rating = personRatings.get(person).get(film);
        return rating == null ? Rating.NOT_WATCHED : rating;
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        Map<Film, Rating> personRating;
        if (personRatings.get(person) == null) {
            personRating = new HashMap<Film, Rating>();
        } else {
            personRating = new HashMap<Film, Rating>(personRatings.get(person));
        }

        Set<Film> keySet = filmsRatings.keySet();
        for (Film film : keySet) {

            if (personRating.get(film) == null) {
                //personRating.put(film, Rating.NOT_WATCHED);
            }

        }
      
        return personRating;
    }

    public List<Person> reviewers() {
        List<Person> persons;
        persons = new ArrayList<Person>(personRatings.keySet());
        return persons;
    }

    public int getSumRatingFilm(Film film) {
        int sumRating = 0;
        List<Rating> ratings = filmsRatings.get(film);
        for (Rating rating : ratings) {
            sumRating += rating.getValue();
        }
        return sumRating;
    }
}
