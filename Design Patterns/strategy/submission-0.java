class Person {
    private String lastName;
    private int age;
    private boolean isMarried;

    public Person(String lastName, int age, boolean isMarried) {
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }
}

interface PersonFilter {
    boolean apply(Person person);
}

class AdultFilter implements PersonFilter {

    public boolean apply(Person person) {
        if (person.getAge() >= 18) {
            return true;
        }
        return false;
    }
}

class SeniorFilter implements PersonFilter {

    public boolean apply(Person person) {
        if (person.getAge() >= 65) {
            return true;
        }
        return false;
    }
}

class MarriedFilter implements PersonFilter {

    public boolean apply(Person person) {
        return person.isMarried();
    }
}

class PeopleCounter {
    private PersonFilter filter;

    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }

    public int count(List<Person> people) {
        Integer count = 0;
        for (Person person : people) {
            if (filter.apply(person)) count++;
        }
        return count;
    }
}
