//package com.example.technikonproject.controller;
//
//import com.example.technikonproject.domain.WebUser;
//import com.example.technikonproject.mapper.BaseMapper;
//
//import com.example.technikonproject.mapper.WebUserMapper;
//import com.example.technikonproject.service.BaseService;
//import com.example.technikonproject.service.WebUserService;
//import com.example.technikonproject.transfer.ApiResponse;
//
//import com.example.technikonproject.transfer.resource.webuser.WebUserResource;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/login")
//public class LoginController extends BaseController<WebUser,WebUserResource>{
//
//    private final WebUserService webUserService;
//
//    private final WebUserMapper webUserMapper;
//
//    @Override
//    public BaseService<WebUser, Long> getBaseService() {
//        return webUserService;
//    }
//
//    @Override
//    protected BaseMapper<WebUser, WebUserResource> getMapper() {
//        return webUserMapper;
//    }
//
//    @GetMapping(params = {"username"})
//    public ResponseEntity<ApiResponse<WebUserResource>> userLogin(@RequestParam String username) {
//        return ResponseEntity.ok(
//                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(webUserService.userLogin(username))).build());
//    }
//}
