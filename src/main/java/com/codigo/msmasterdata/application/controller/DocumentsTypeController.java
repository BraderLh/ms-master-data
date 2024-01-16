package com.codigo.msmasterdata.application.controller;

import com.codigo.msmasterdata.application.service.DocumentsTypeService;
import com.codigo.msmasterdata.domain.model.DocumentsType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/documents")
@Slf4j
public class DocumentsTypeController {

    private final DocumentsTypeService documentsTypeService;

    public DocumentsTypeController(DocumentsTypeService documentsTypeService) {
        this.documentsTypeService = documentsTypeService;
    }

    @PostMapping()
    public ResponseEntity<DocumentsType> create(@RequestBody DocumentsType documentsType){
        log.info(String.valueOf(documentsType));
        DocumentsType type = documentsTypeService.create(documentsType);
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<DocumentsType> findOne(@PathVariable Long id){
        return documentsTypeService.findOne(id).map(documentsType -> new ResponseEntity<>(documentsType,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping()
    public List<DocumentsType> findAll(){
        return documentsTypeService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentsType> update(@PathVariable Long id, @RequestBody DocumentsType documentsType){
        return documentsTypeService.update(id,documentsType)
                .map(documentsType1 -> new ResponseEntity<>(documentsType1,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DocumentsType> delete(@PathVariable Long id){
        return documentsTypeService.delete(id)
                .map(documentsType1 -> new ResponseEntity<>(documentsType1,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
