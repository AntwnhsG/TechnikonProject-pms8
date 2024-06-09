package com.example.technikonproject.repository;

import com.example.technikonproject.domain.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    //void deleteByTin(Integer tin);
    WebUser readWebUserByTin(Long tin);

    List<WebUser> readWebUserByFirstName(String name);

    WebUser readWebUserByEmail(String email);

    void deleteByTin(Long tin);

}
