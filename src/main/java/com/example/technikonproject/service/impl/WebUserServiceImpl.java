package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.repository.WebUserRepository;
import com.example.technikonproject.service.WebUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl extends BaseServiceImpl<WebUser> implements WebUserService {
    private final WebUserRepository webUserRepository;

    @Override
    public JpaRepository<WebUser, Long> getRepository() {
        return webUserRepository;
    }

    @Override
    public WebUser readWebUser(Long tin) {
        return webUserRepository.readWebUserByTin(tin);
    }

    public List<WebUser> readWebUserByFirstName(String name) {
        return webUserRepository.readWebUserByFirstName(name);
    }

    @Override
    public WebUser readWebUserByEmail(String email) {
        return webUserRepository.readWebUserByEmail(email);
    }

    @Override
    public WebUser update(WebUser webUser) {

        WebUser webUserOld = webUserRepository.findById(webUser.getId()).orElseThrow();
        webUserOld.setEmail(updateUserEmail(webUser, webUserOld));
        webUserOld.setFirstName(updateUserName(webUser, webUserOld));
        webUserOld.setAddress(webUser.getAddress());
        return webUserRepository.save(webUserOld);
    }

    private String updateUserName(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getFirstName().isEmpty() &&
                !webUserNew.getFirstName().equals(webUserOld.getFirstName())) {
            return webUserNew.getFirstName();
        }
        return webUserOld.getFirstName();
    }

    private String updateUserEmail(WebUser webUserNew, WebUser webUserOld) {
        if (!webUserNew.getEmail().isEmpty() &&
                !webUserNew.getEmail().equals(webUserOld.getEmail())) {
            return webUserNew.getEmail();
        }
        return webUserOld.getEmail();

    }

    public void deleteByTin(Long tin) {
        WebUser webUser = webUserRepository.readWebUserByTin(tin);
        if (checkNullability(webUser)) {
            webUserRepository.deleteByTin(tin);
        }
    }

    private boolean checkNullability(WebUser webUser) {
        if (webUser == null) {
            logger.warn("WebUser does not exist.");
            return true;
        }
        return false;
    }



}
