package com.example.technikonproject.controller;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.mapper.BaseMapper;
import com.example.technikonproject.mapper.WebUserMapper;
import com.example.technikonproject.service.BaseService;
import com.example.technikonproject.service.WebUserService;
import com.example.technikonproject.transfer.ApiResponse;
import com.example.technikonproject.transfer.resource.webuser.WebUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class WebUserController extends BaseController<WebUser, WebUserResource> {

    private final WebUserService webUserService;

    private final WebUserMapper webUserMapper;

    @Override
    public BaseService<WebUser, Long> getBaseService() {
        return webUserService;
    }

    @Override
    protected BaseMapper<WebUser, WebUserResource> getMapper() {
        return webUserMapper;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<WebUserResource>> read(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(
                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(getBaseService().read(id))).build());
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<WebUserResource>> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(
                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(webUserService.readWebUserByEmail(email)))
                        .build());
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<ApiResponse<WebUserResource>> findByTin(@RequestParam Long tin) {
        return ResponseEntity.ok(
                ApiResponse.<WebUserResource>builder().data(getMapper().toResource(webUserService.readWebUser(tin)))
                        .build());
    }

    @GetMapping(params = {"firstName"})
    public ResponseEntity<ApiResponse<List<WebUserResource>>> findByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(
                ApiResponse.<List<WebUserResource>>builder().data(getMapper().toResources(webUserService.readWebUserByFirstName(firstName)))
                        .build());

    }

    @GetMapping("count")
    public ResponseEntity<ApiResponse<Long>> countAllUsers() {
        return ResponseEntity.ok(
                ApiResponse.<Long>builder().data((webUserService.count()))
                        .build());
    }

    @PostMapping("checkNewUser")
    public ResponseEntity<ApiResponse<WebUserResource>> checkNewUser(@RequestBody WebUserResource webUser){
        WebUser newUserAdded = new WebUser();
        newUserAdded = webUserService.readWebUser(webUser.getTin());
        if (newUserAdded == null){
            return new ResponseEntity<>(
                    ApiResponse.<WebUserResource>builder().data(
                            getMapper().toResource(
                                    getBaseService().create(getMapper().toDomain(webUser))
                            )
                    ).build(),
                    HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(
                    ApiResponse.<WebUserResource>builder().data(
                            getMapper().toResource(newUserAdded)).build(),
                    HttpStatus.CREATED);
        }
    }

}
