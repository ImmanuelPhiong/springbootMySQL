package com.impractice.springbootMySQL.entity.offices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="offices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = "offices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Office {
    @Id
    @Column(name = "officeCode")
    private Integer officeCode;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private String phone;
    @Column(name = "addressLine1")
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "territory")
    private String territory;

    //Bidirectional relationship
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "officeCode")
    @JsonIgnore
    private List<Office> offices;
}
