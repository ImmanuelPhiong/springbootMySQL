package com.impractice.springbootMySQL.entity.offices;

import com.impractice.springbootMySQL.entity.employees.Employee;
import com.impractice.springbootMySQL.entity.offices.exception.OfficeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private OfficeModelAssembler officeModelAssembler;

    @Override
    public String createOffice(Office office) {
        officeRepository.save(office);
        return "Success";
    }

    @Override
    public String updateOffice(Office office) {
        officeRepository.save(office);
        return "Success";
    }

    @Override
    public String deleteOffice(Integer officeCode) {
        officeRepository.deleteById(officeCode);
        return "Success";
    }

    @Override
    public EntityModel<Office> getOffice(Integer officeCode) {
        if (officeRepository.findById(officeCode).isEmpty()){
            throw new OfficeNotFoundException("Office with officeCode: " + officeCode + " is not exist");
        }
        Office office = officeRepository.findById(officeCode).get();
        return officeModelAssembler.toModel(office);
    }

    @Override
    public CollectionModel<EntityModel<Office>> getAllOffice() {
        List<EntityModel<Office>> offices = officeRepository.findAll().stream()
                .map(officeModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(offices, linkTo(methodOn(OfficeController.class).getAllOffice()).withSelfRel());

    }
}
