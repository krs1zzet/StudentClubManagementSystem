package com.cmddotenter.StudentClubManagementSystem.api.repository;

import com.cmddotenter.StudentClubManagementSystem.entity.Event;
import com.cmddotenter.StudentClubManagementSystem.repo.EventRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EventRepositoryTests {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void EventRepository_SaveAll_ReturnSavedEvent(){
        //arrange
        Event event = Event.builder()
                .name("Test Event")
                .description("Test Description")
                .build();
        //act
        Event savedEvent = eventRepository.save(event);
        //assert
        Assertions.assertThat(savedEvent).isNotNull();
    }

    @Test
    public void EventRepository_FindById_ReturnEvent(){
        //arrange
        Event event = Event.builder()
                .name("Test Event")
                .description("Test Description")
                .build();
        Event savedEvent = eventRepository.save(event);
        //act
        Event foundEvent = eventRepository.findById(savedEvent.getId()).orElse(null);
        //assert
        Assertions.assertThat(foundEvent).isNotNull();
        Assertions.assertThat(foundEvent.getId()).isEqualTo(savedEvent.getId());
    }

    @Test
    public void EventRepository_DeleteEvent_ReturnNull(){
        //arrange
        Event event = Event.builder()
                .name("Test Event")
                .description("Test Description")
                .build();
        Event savedEvent = eventRepository.save(event);
        //act
        eventRepository.deleteById(savedEvent.getId());
        Event foundEvent = eventRepository.findById(savedEvent.getId()).orElse(null);
        //assert
        Assertions.assertThat(foundEvent).isNull();
    }

    @Test
    public void EventRepository_FindAll_ReturnAllEvents(){
        //arrange
        Event event1 = Event.builder()
                .name("Test Event 1")
                .description("Test Description 1")
                .build();
        Event event2 = Event.builder()
                .name("Test Event 2")
                .description("Test Description 2")
                .build();
        eventRepository.save(event1);
        eventRepository.save(event2);
        //act
        Iterable<Event> events = eventRepository.findAll();
        //assert
        Assertions.assertThat(events).isNotNull();
        Assertions.assertThat(events).hasSizeGreaterThan(1);
    }
}
