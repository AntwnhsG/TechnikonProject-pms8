package com.example.technikonproject.transfer.resource.webuser;

import com.example.technikonproject.transfer.resource.BaseResource;
import lombok.Data;

@Data
public class WebUserMedInfoResource extends BaseResource {

    private String firstName;

    private String surname;

    private Long phoneNumber;

    private String email;
}
