package com.impractice.springbootMySQL.entity.offices;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface OfficeService {
    public String createOffice(Office office);
    public String updateOffice(Office office);
    public String deleteOffice(Integer officeCode);
    public EntityModel<Office> getOffice(Integer officeCode);
    public CollectionModel<EntityModel<Office>> getAllOffice();
}
