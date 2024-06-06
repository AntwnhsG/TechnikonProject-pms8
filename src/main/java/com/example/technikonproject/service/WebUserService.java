package com.example.technikonproject.service;

import com.example.technikonproject.domain.WebUser;

import java.util.List;


public interface WebUserService extends BaseService<WebUser, Long> {

    WebUser readWebUser(Long tin);

    List<WebUser> readWebUserByFirstName(String name);

    WebUser readWebUserByEmail(String email);

    WebUser update(WebUser webuser);

    void deleteByTin(Long tin);

    WebUser userLogin(String username, String password);
}
