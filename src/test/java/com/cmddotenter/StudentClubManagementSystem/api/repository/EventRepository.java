package com.cmddotenter.StudentClubManagementSystem.api.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class EventRepository {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void EventRepostiry_SaveAll_ReturnSavedEvent(){

    }

}
