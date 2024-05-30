package com.impractice.springbootMySQL.entity.offices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @PostMapping()
    public String createOffice(@RequestBody Office office){
        officeService.createOffice(office);
        return "Office created successfully";
    }

    @PutMapping()
    public String updateOffice(@RequestBody Office office){
        officeService.updateOffice(office);
        return "Office updated successfully";
    }

    @DeleteMapping("/{officeCode}")
    public String deleteOffice(@PathVariable Integer officeCode){
        officeService.deleteOffice(officeCode);
        return "Office deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<Office>> getAllOffice(){
        return officeService.getAllOffice();
    }

    @GetMapping("/{officeCode}")
    public EntityModel<Office> getOffice(@PathVariable Integer officeCode){
        return officeService.getOffice(officeCode);
    }
}
