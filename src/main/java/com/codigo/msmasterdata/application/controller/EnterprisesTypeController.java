package com.codigo.msmasterdata.application.controller;

import com.codigo.msmasterdata.application.service.EnterprisesTypeService;
import com.codigo.msmasterdata.domain.model.EnterprisesType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enterprises")
@Slf4j
public class EnterprisesTypeController {
    private final EnterprisesTypeService enterprisesTypeService;

    public EnterprisesTypeController(EnterprisesTypeService enterprisesTypeService) {
        this.enterprisesTypeService = enterprisesTypeService;
    }

    @PostMapping()
    public ResponseEntity<EnterprisesType> create(@RequestBody EnterprisesType enterprisesType){
        log.info(String.valueOf(enterprisesType));
        EnterprisesType type = enterprisesTypeService.create(enterprisesType);
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<EnterprisesType> findOne(@PathVariable Long id){
        return enterprisesTypeService.findOne(id).
                map(enterprisesType -> new ResponseEntity<>(enterprisesType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping()
    public ResponseEntity<List<EnterprisesType>> findAll(){
        if(enterprisesTypeService.findAll().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(enterprisesTypeService.findAll(), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterprisesType> update(@PathVariable Long id, @RequestBody EnterprisesType enterprisesType){
        return enterprisesTypeService.update(id, enterprisesType)
                .map(enterprisesType1 -> new ResponseEntity<>(enterprisesType1, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnterprisesType> delete(@PathVariable Long id){
        return enterprisesTypeService.delete(id)
                .map(enterprisesType -> new ResponseEntity<>(enterprisesType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
