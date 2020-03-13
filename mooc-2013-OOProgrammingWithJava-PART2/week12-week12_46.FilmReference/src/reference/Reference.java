/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.comparator.FilmComparator;
import reference.comparator.FilmPersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author praetorian
 */
public class Reference {

    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;

    }

//    public Film recommendFilm (Person person) {
//        /*
//        Hint: you need three things to find out the most suitable film.
//        These are at least the class FilmComparator which you created earlier on; the method public Map<Film, List<Rating>> filmRatings() of the class RatingRegister;
//        and a list of the existing films.
//         */
//        Map<Film, List<Rating>> filmRatings = ratingRegister.filmRatings();
//        Set<Film> keySet = filmRatings.keySet();
//        ArrayList<Film> films = new ArrayList<Film>(keySet);
//        Collections.sort(films, new FilmComparator(filmRatings));
//       return films.get(0);
//    }
    public Film recommendFilm(Person person) {

        Map<Film, Rating> ratingsOfPersonParameter = ratingRegister.getPersonalRatings(person);

        // if a person hasn't evaluated any film, we recommend them a film according to film ratings.
//        if (ratingsOfPersonParameter == null) {
//            Map<Film, List<Rating>> filmRatings = ratingRegister.filmRatings();
//            Set<Film> keySet = filmRatings.keySet();
//            ArrayList<Film> films = new ArrayList<Film>(keySet);
//            Collections.sort(films, new FilmComparator(filmRatings));
//            return films.get(0);
//        }
        List<Person> persons = ratingRegister.reviewers();
        persons.remove(person);

        Set<Film> setFilmsOfPersonParameter = new HashSet<Film>();

        for (Map.Entry<Film, Rating> entry : ratingsOfPersonParameter.entrySet()) {
            Film key = entry.getKey();
            setFilmsOfPersonParameter.add(key);

        }

        Map<Person, Integer> similarityScores = new HashMap<Person, Integer>();
        int highestSimilaritySoFar = 0;
        Person mostSimilarPerson = null;

        for (Film film : setFilmsOfPersonParameter) {

            for (Person personReviewer : persons) {
                if (!similarityScores.containsKey(personReviewer)) {
                    similarityScores.put(personReviewer, 0);
                }

                if (!ratingRegister.getRating(personReviewer, film).equals(Rating.NOT_WATCHED)) {
                    if (similarityScores.get(personReviewer) == 0) {
                        similarityScores.put(personReviewer, (ratingsOfPersonParameter.get(film).getValue() * ratingRegister.getRating(personReviewer, film).getValue()));
                    } else {
                        similarityScores.put(personReviewer, similarityScores.get(personReviewer) + (ratingsOfPersonParameter.get(film).getValue() * ratingRegister.getRating(personReviewer, film).getValue()));
                    }

                }

                if (similarityScores.get(personReviewer) > highestSimilaritySoFar) {
                    mostSimilarPerson = personReviewer;
                    highestSimilaritySoFar = similarityScores.get(personReviewer);
                }
            }

        }

        Map<Film, Rating> ratingsOfSimilarPerson = ratingRegister.getPersonalRatings(mostSimilarPerson);

        for (Iterator<Map.Entry<Film, Rating>> iterator = ratingsOfSimilarPerson.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<Film, Rating> next = iterator.next();
            if (next.getValue().getValue() <= 0) {
                iterator.remove();
            }

        }

        ArrayList<Film> filmsWatchedBySimilarPerson = new ArrayList<Film>(ratingsOfSimilarPerson.keySet());
        Collections.sort(filmsWatchedBySimilarPerson, new FilmPersonComparator(ratingsOfSimilarPerson));

        for (Film film : filmsWatchedBySimilarPerson) {
            if (!(setFilmsOfPersonParameter.contains(film)) || ratingsOfPersonParameter.get(film).getValue() == 0) {
                return film;
            }
        }

        Map<Film, List<Rating>> filmRatings = ratingRegister.filmRatings();
        Set<Film> keySet = filmRatings.keySet();
        ArrayList<Film> films = new ArrayList<Film>(keySet);
        Collections.sort(films, new FilmComparator(filmRatings));

        if (ratingsOfPersonParameter.containsKey(films.get(0))) {

            if (ratingsOfPersonParameter.get(films.get(0)).getValue() != 0) {
                return null;
            }
        }
        return films.get(0);

    }

}
