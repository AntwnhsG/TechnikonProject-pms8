//package com.example.technikonproject.repository;
//
//import com.example.technikonproject.domain.WebUser;
//import com.example.technikonproject.domain.subDomain.Address;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.apache.tomcat.jni.Buffer.address;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@DataJpaTest
//class WebUserRepositoryTest {
//
//    @Autowired
//    private  WebUserRepository webUserRepository;
//
////    private  final Address address = new Address(
////            "stname",
////            123,
////            12345,
////            8
////    );
////    private final WebUser webUser = new WebUser(
////            1L,
////            "firstName",
////            "Surname",
////            new Address(
////                    "stname",
////                    123,
////                    "12345",
////                    8
////            ),
////            "2105698545",
////            "email@mail.com",
////            "username",
////            "password",
////            false
////    );
//
//    private final WebUser webUser2 = new WebUser(
//            2L,
//            "firstName",
//            "Surname2",
//            new Address(
//                    "stname2",
//                    1223,
//                    "123245",
//                    82),
//            456789789,
//            "email2@mail.com",
//            "username2",
//            "password2",
//            false
//    );
//
//    @Test
//    @DisplayName("Testing if method returns the right user from the database")
//    void itShouldCheckIfWebUserExistsByEmailAndReturnHim() {
//        //given
//        webUserRepository.save(webUser);
//        //when
//        WebUser exists = webUserRepository.readWebUserByEmail(webUser.getEmail());
//        //then
//        assertEquals(exists.getEmail(), webUser.getEmail());
//    }
//
//    @Test
//    @DisplayName("Test if method finds all the user with the same firstname")
//    void seeIfReadWebUserByFirstNameFindsIdenticalNamesInDb(){
//        //given
//        webUserRepository.save(webUser);
//        //WebUser webUser2 = webUser;
//        webUserRepository.save(webUser2);
//        //when
//        List<WebUser> webUsers = webUserRepository.readWebUserByFirstName(webUser.getFirstName());
//        //then
//        assertAll(
//                () -> assertFalse(webUsers.isEmpty()),
//                () -> assertEquals(webUsers.get(0).getFirstName(), webUsers.get(1).getFirstName())
//        );
//
//    }
//
//    @Test
//    @DisplayName("Test if methods finds the right user in the database using tin")
//    void seeIfReadWebUserByTinFindsTheCorrectUserInDb(){
//        webUserRepository.save(webUser);
//        WebUser webUserNew = webUserRepository.readWebUserByTin(1L);
//        assertNotNull(webUserNew);
//    }
//
//    @Test
//    @DisplayName("Test if the right user deleted from the database using tin")
//    void seeIfWebUserIsDeleteByTinInDb(){
//        webUserRepository.deleteByTin(webUser.getTin());
//        assertFalse(webUserRepository.existsById(webUser.getTin()));
//    }
//
//}