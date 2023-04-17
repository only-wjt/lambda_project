package com.onlyWjt.model;

public class PersonFilter{

    private Person person;

    PersonFilter(Person p) {
        this.person = p;
    }

    public PersonFilter greaterThan(int weight) {

        person.setWeight(Math.max(weight + 1, person.getWeight()));
        return this;
    }

    public PersonFilter lessThan(int weight) {

        person.setWeight(Math.min(weight - 1, person.getWeight()));
        return this;
    }

    public Person done() {
        return person;
    }
}
