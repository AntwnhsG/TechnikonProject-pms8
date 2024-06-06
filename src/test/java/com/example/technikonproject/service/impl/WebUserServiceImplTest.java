package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.repository.WebUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WebUserServiceImplTest {

    @Mock
    private WebUserRepository webUserRepository;

    //private AddressServiceImpl addressServiceImpl;

    private WebUserServiceImpl webUserServiceTest;

//    private final Address address = new Address(
//            1L,
//            "stname",
//            123,
//            12345
//    );
//    private final WebUser webUser = new WebUser(1L,
//            "a",
//            "b",
//            address,
//            203959,
//            "email",
//            "uname",
//            "pass"
//    );

//    @BeforeEach
//    void setUp() {
//        webUserServiceTest = new WebUserServiceImpl(webUserRepository, addressServiceImpl);
//    }


//    @Test
//    void canAddWebUser() {
//        //when
//        webUserServiceTest.addWebUser(webUser);
//        //then
//        ArgumentCaptor<WebUser> webUserArgumentCaptor =
//                ArgumentCaptor.forClass(WebUser.class);
//        verify(webUserRepository).save(webUserArgumentCaptor.capture());
//
//        WebUser capturedWebUser = webUserArgumentCaptor.getValue();
//        assertThat(capturedWebUser).isEqualTo(webUser);
//    }

    @Test
    void canReadWebUser() {
        //when
        webUserServiceTest.readWebUser(1L);
        //then
        verify(webUserRepository).readWebUserByTin(1L);
    }

    @Test
    void canReadWebUserByFirstName() {
        //when
        webUserServiceTest.readWebUserByFirstName("name");
        //then
        verify(webUserRepository).readWebUserByFirstName("name");
    }

    @Test
    void canReadWebUserByEmail() {
        //when
        webUserServiceTest.readWebUserByEmail("email");
        //then
        verify(webUserRepository).readWebUserByEmail("email");
    }

//    @Test
//    void updateUserEmailNew() {
//        //when
//        webUserServiceTest.updateUserEmailNew(1L, "email");
//        //then
//        verify(webUserRepository).findById(1L);
//        verify(webUserRepository).save(webUser);
//    }

    @Test
    void canDeleteWebUser() {
        //when
        webUserServiceTest.deleteByTin(1L);
        //then
        verify(webUserRepository).existsById(1L);
        //verify(webUserRepository).deleteById(1L);
    }
}