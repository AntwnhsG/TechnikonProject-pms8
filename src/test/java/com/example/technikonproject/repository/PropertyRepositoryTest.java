//package com.example.technikonproject.repository;
//
//import com.example.technikonproject.domain.Property;
//import com.example.technikonproject.domain.WebUser;
//import com.example.technikonproject.domain.enums.PropertyType;
//import com.example.technikonproject.domain.subDomain.Address;
//import com.example.technikonproject.service.impl.WebUserServiceImpl;
//import lombok.Data;
//import org.aspectj.lang.annotation.Before;
//import org.checkerframework.checker.units.qual.A;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Date;
//import java.util.List;
//
//import static java.time.temporal.TemporalQueries.localDate;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class PropertyRepositoryTest {
//
//    @Autowired
//    private PropertyRepository propertyRepository;
//
//    @Autowired
//    private WebUserRepository webUserRepository;
//
//    private final WebUser webUser = new WebUser(
//            1L,
//            "name",
//            "surname",
//            new Address(
//                    "property street name",
//                    212,
//                    23462,
//                    6
//            ),
//            500466,
//            "mymail@mail.com",
//            "username",
//            "password",
//            false
//    );
//
//    private final Property property = new Property(
//            1L,
//            new Date(2020-10-12),
//            new Address(
//                    "property street name",
//                    21223,
//                    2345622,
//                    622
//            ),
//            PropertyType.APARTMENT_BUILDING,
//            webUser,
//            "pic",
//            "location"
//    );
//
//    private final Property property2 = new Property(
//            2L,
//            new Date(2020-11-12),
//            new Address(
//                    "property street name3",
//                    333,
//                    2343256,
//                    63
//            ),
//            PropertyType.APARTMENT_BUILDING,
//            webUser,
//            "pic",
//            "location"
//    );
//
//
////         webUserRepository.save(webUser);
////         webUserRepository.save(webUser2);
//
//    private static boolean setUpDone = false;
//    @BeforeEach
//    void setUp(){
//        if(!setUpDone) {
//            webUserRepository.save(webUser);
//            propertyRepository.save(property);
//            propertyRepository.save(property2);
//        }
//        setUpDone = true;
//    }
//
//    @Test
//    @DisplayName("Test if the right property is found from the database using E9")
//    void seeIfFindPropertyByE9NumberReturnsTheRightProperty(){
//        //webUserRepository.save(webUser);
//        //propertyRepository.save(property);
//        Property exists = propertyRepository.findPropertyByE9Number(property.getE9Number());
//        assertEquals(exists.getE9Number(), property.getE9Number());
//    }
//
//    @Test
//    @DisplayName("Test if method finds the properties of a specific webUser using his tin")
//    void findByWebUserTin(){
//        //webUserRepository.save(webUser);
//        //propertyRepository.save(property);
//        //propertyRepository.save(property2);
//        List<Property> properties = propertyRepository.findByWebUserTin(property.getWebUser().getTin());
//        assertAll(
//                () -> assertFalse(properties.isEmpty()),
//                ()-> assertEquals(properties.get(0).getWebUser().getTin(), properties.get(1).getWebUser().getTin())
//        );
//    }
//}
