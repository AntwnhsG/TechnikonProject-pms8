package com.example.technikonproject.domain;

import com.example.technikonproject.domain.enums.PropertyType;
import com.example.technikonproject.domain.subDomain.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "properties")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_seq", allocationSize = 1)
public class Property extends BaseModel {


    @Column(unique = true)
    private Long e9Number;

    @Column
    private Date yearOfConstruction;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private PropertyType propertyType;

    @ManyToOne()
    private WebUser webUser;

    @Column
    private String picture;

    @Column
    private String location;

}
