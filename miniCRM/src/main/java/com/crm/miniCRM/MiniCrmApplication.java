package com.crm.miniCRM;

//https://spring.io/guides/gs/accessing-data-jpa/

import com.crm.miniCRM.model.*;
import com.crm.miniCRM.model.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class MiniCrmApplication {

    private static final Logger log = LoggerFactory.getLogger(MiniCrmApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MiniCrmApplication.class);
    }

    @Bean
    public CommandLineRunner demoMiniCRM(PersonRepository personRepository,
                                         AddressRepository addressRepository,
                                         PersonAddressRepository personAddressRepository,
                                         CommunityRepository communityRepository,
                                         MemberRepository memberRepository,
                                         EventRepository eventRepository
    ) {
        return (args) -> {

//Person
            extractPersons(personRepository);
//Address
            extractAddresses(addressRepository);
//Community
            extractCommunities(communityRepository);
//Event
            extractEvents(eventRepository);
//Member
            extractMembers(memberRepository);
//PersonAddress
            extractPersonAddresses(personAddressRepository);
        };
    }

    private static void extractPersonAddresses(PersonAddressRepository personAddressRepository) {
        personAddressRepository.save(new PersonAddress(new PersonAddressID(1L, 1L), "a@b.com", "12343456", "34567789", 'P'));
        personAddressRepository.save(new PersonAddress(new PersonAddressID(2L, 1L), "b@c.com", "23434567", "34567789", 'P'));
        personAddressRepository.save(new PersonAddress(new PersonAddressID(3L, 2L), "d@e.com", "34345678", "34567789", 'P'));
        personAddressRepository.save(new PersonAddress(new PersonAddressID(4L, 3L), "f@g.com", "43456789", "34567789", 'P'));

        // fetch all Persons
        log.info("PersonAddress found with findAll():");
        log.info("-------------------------------");
        for (PersonAddress personAddress : personAddressRepository.findAll()) {
            log.info(personAddress.toString());
        }
        log.info("");

        // fetch addresses from an individual Person by ID

        log.info("Addresses found with findById(new PersonAddressID()):");
        log.info("--------------------------------");
        Optional<PersonAddress> personAddress = personAddressRepository.findById(new PersonAddressID(1L, 1L));
        log.info(personAddress.toString());

        log.info("");

    }

    private static void extractEvents(EventRepository eventRepository) {
        eventRepository.save(new Event("kerstkaartjes 2020", LocalDate.of(2020, 12, 16)));
        eventRepository.save(new Event("BBQ 2020", LocalDate.of(2020, 7, 21)));
        eventRepository.save(new Event("doopfeest 2021", LocalDate.of(2021, 5, 31)));
        // fetch all Persons
        log.info("Event found with findAll():");
        log.info("-------------------------------");
        for (Event event : eventRepository.findAll()) {
            log.info(event.toString());
        }
        log.info("");

        // fetch an individual Person by ID
        Event event = eventRepository.findById(1L);
        log.info("Event found with findById(1L):");
        log.info("--------------------------------");
        log.info(event.toString());
        log.info("");

        // fetch Persons by last name
        log.info("Event found with findByDescriptionStreat('BBQ 2020'):");
        log.info("--------------------------------------------");
        eventRepository.findByDescription("BBQ 2020").forEach(bbq -> {
            log.info(bbq.toString());
        });
    }

    private static void extractCommunities(CommunityRepository communityRepository) {
        communityRepository.save(new Community("Jaarlijkse kerstkaartjes"));
        communityRepository.save(new Community("Jaarlijkse BBQ"));
        communityRepository.save(new Community("eenmalig doopfeest"));
        // fetch all Persons
        log.info("Community found with findAll():");
        log.info("-------------------------------");
        for (Community community : communityRepository.findAll()) {
            log.info(community.toString());
        }
        log.info("");

        // fetch an individual Person by ID
        Community community = communityRepository.findById(1L);
        log.info("Community found with findById(1L):");
        log.info("--------------------------------");
        log.info(community.toString());
        log.info("");

        // fetch Persons by last name
        log.info("Community found with findByStreat('BBQ'):");
        log.info("--------------------------------------------");
        communityRepository.findByDescription("Jaarlijkse BBQ").forEach(bbq -> {
            log.info(bbq.toString());
        });

        log.info("");
    }

    private static void extractAddresses(AddressRepository addressRepository) {
        addressRepository.save(new Address("Tessenstraat", "7", "2", "3000", "Leuven", "België", "PRIV"));
        addressRepository.save(new Address("Brusselsetraat", "73", "2", "3000", "Leuven", "België", "PROF"));
        addressRepository.save(new Address("Tiensestraat", "76A", "", "3000", "Leuven", "België", "PRIV"));
        // fetch all Persons
        log.info("Address found with findAll():");
        log.info("-------------------------------");
        for (Address address : addressRepository.findAll()) {
            log.info(address.toString());
        }
        log.info("");

        // fetch an individual Person by ID
        Address address = addressRepository.findById(1L);
        log.info("Address found with findById(1L):");
        log.info("--------------------------------");
        log.info(address.toString());
        log.info("");

        // fetch Persons by last name
        log.info("Address found with findByStreat('Brusselsestraat'):");
        log.info("--------------------------------------------");
        addressRepository.findByStreet("Brusselsestraat").forEach(street -> {
            log.info(street.toString());
        });

        log.info("");
    }

    private static void extractPersons(PersonRepository personRepository) {
        personRepository.save(new Person("Jack", "Bauer", LocalDate.of(1963, 6, 29)));
        personRepository.save(new Person("Kim", "Bauer", LocalDate.of(1973, 4, 29)));
        personRepository.save(new Person("David", "Palmer", LocalDate.of(1983, 10, 24)));
        personRepository.save(new Person("Michelle", "Dessler", LocalDate.of(1993, 7, 29)));

        // fetch all Persons
        log.info("Persons found with findAll():");
        log.info("-------------------------------");
        for (Person person : personRepository.findAll()) {
            log.info(person.toString());
        }
        log.info("");

        // fetch an individual Person by ID
        Person person = personRepository.findById(1L);
        log.info("Person found with findById(1L):");
        log.info("--------------------------------");
        log.info(person.toString());
        log.info("");

        // fetch Persons by last name
        log.info("Person found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        personRepository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
    }

    //Members
    private void extractMembers(MemberRepository memberRepository) {
        memberRepository.save(new Member(new MemberID(1L, 1L), LocalDate.of(2003, 02, 01)));
        memberRepository.save(new Member(new MemberID(1L, 2L), LocalDate.of(2003, 02, 01)));
        memberRepository.save(new Member(new MemberID(1L, 3L), LocalDate.of(2003, 02, 01)));
        memberRepository.save(new Member(new MemberID(1L, 4L), LocalDate.of(1999, 8, 01)));

        memberRepository.save(new Member(new MemberID(2L, 1L), LocalDate.of(2013, 02, 01)));
        memberRepository.save(new Member(new MemberID(2L, 3L), LocalDate.of(2000, 02, 01)));
        memberRepository.save(new Member(new MemberID(2L, 4L), LocalDate.of(1999, 8, 01)));

        memberRepository.save(new Member(new MemberID(3L, 2L), LocalDate.of(2012, 02, 01)));
        memberRepository.save(new Member(new MemberID(3L, 3L), LocalDate.of(2005, 03, 01)));
        memberRepository.save(new Member(new MemberID(3L, 4L), LocalDate.of(1990, 8, 01)));

        // fetch all Member
        log.info("Member found with findAll():");
        log.info("-------------------------------");
        for (Member member : memberRepository.findAll()) {
            log.info(member.toString());
        }
        log.info("");
// fetch an individual Person by ID
        Optional<Member> member = memberRepository.findById(new MemberID(1L, 3L));
        log.info("Member found with findById(1L):");
        log.info("--------------------------------");
        log.info(member.toString());
        log.info("");
    }


}