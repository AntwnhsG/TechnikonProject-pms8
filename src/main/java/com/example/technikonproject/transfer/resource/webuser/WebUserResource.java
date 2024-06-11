package com.example.technikonproject.transfer.resource.webuser;

import com.example.technikonproject.transfer.resource.BaseResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WebUserResource extends BaseResource {

    private Long tin;

    private String firstName;

    private String surname;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;

    private String role;

}
