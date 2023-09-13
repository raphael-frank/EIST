package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
  	// do not change this
    private final List<Person> persons;

    public PersonService() {
        this.persons = new ArrayList<>();
    }

    public Person savePerson(Person person) {
        var optionalPerson = persons.stream().filter(existingPerson -> existingPerson.getId().equals(person.getId())).findFirst();
        if (optionalPerson.isEmpty()) {
            person.setId(UUID.randomUUID());
            persons.add(person);
            return person;
        } else {
            var existingPerson = optionalPerson.get();
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setBirthday(person.getBirthday());
            return existingPerson;
        }
    }

    public void deletePerson(UUID personId) {
        this.persons.removeIf(person -> person.getId().equals(personId));
    }

    public List<Person> getAllPersons(PersonSortingOptions sortingOptions) {
        // TODO Part 3: Add sorting here
        ArrayList<Person> sortedPersons = new ArrayList<>(this.persons);
        if(sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.ASCENDING)) {
            switch (sortingOptions.getSortField()) {
                case ID -> sortedPersons.sort(Comparator.comparing(Person::getId));
                case FIRST_NAME -> sortedPersons.sort(Comparator.comparing(Person::getFirstName));
                case LAST_NAME -> sortedPersons.sort(Comparator.comparing(Person::getLastName));
                case BIRTHDAY -> sortedPersons.sort(Comparator.comparing(Person::getBirthday));
            }
        }
        else {
            switch (sortingOptions.getSortField()) {
                case ID -> sortedPersons.sort(Comparator.comparing(Person::getId).reversed());
                case FIRST_NAME -> sortedPersons.sort(Comparator.comparing(Person::getFirstName).reversed());
                case LAST_NAME -> sortedPersons.sort(Comparator.comparing(Person::getLastName).reversed());
                case BIRTHDAY -> sortedPersons.sort(Comparator.comparing(Person::getBirthday).reversed());
            }
        }
        return sortedPersons;
    }
}
