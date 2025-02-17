package com.example.reflection.accessprivatefieldstest;

import com.example.reflection.accessprivatefields.FetchPerson;
import com.example.reflection.accessprivatefields.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testRetrieveAge() {
        Person person = new Person(25);
        int retrievedAge = FetchPerson.retrieveAge(person);
        assertEquals(25, retrievedAge);
    }

    @Test
    void testModifyAge() {
        Person person = new Person(25);
        FetchPerson.modifyAge(person, 30);
        int modifiedAge = FetchPerson.retrieveAge(person);
        assertEquals(30, modifiedAge);
    }
}
