package com.ernestui.jparelationship.controller;

import com.ernestui.jparelationship.data.City;
import com.ernestui.jparelationship.data.Zipcode;
import com.ernestui.jparelationship.dto.requestDto.CityRequestDto;
import com.ernestui.jparelationship.dto.requestDto.ZipcodeRequestDto;
import com.ernestui.jparelationship.service.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 05/04/2023 - 09:55
 * @project jpa-relationship
 */

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {

    private final ZipcodeService zipcodeService;

    @Autowired
    public ZipcodeController(ZipcodeService zipcodeService) {
        this.zipcodeService = zipcodeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Zipcode> addCity(@RequestBody final ZipcodeRequestDto zipcodeRequestDto){
        Zipcode zipcode = zipcodeService.addZipCode(zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Zipcode> getCity(@PathVariable final Long id){
        Zipcode zipcode = zipcodeService.getZipCode(id);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Zipcode>> getCities(){
        List<Zipcode> zipcodes = zipcodeService.getZipCodes();
        return new ResponseEntity<>(zipcodes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Zipcode> deleteZipcode(@PathVariable final Long id){
        Zipcode zipcode = zipcodeService.deleteZipcode(id);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Zipcode> editZipcode(@PathVariable final Long id ,@RequestBody final ZipcodeRequestDto zipcodeRequestDto){
        Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/addCity/{cityId}/toZipcode/{zipCodeId}")
    public ResponseEntity<Zipcode> addCity(@PathVariable final Long cityId ,
                                           @PathVariable final Long zipCodeId){
        Zipcode zipcode = zipcodeService.addCityToZipcode(cityId, zipCodeId);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/deleteCity/{zipCodeId}")
    public ResponseEntity<Zipcode> deleteCity(@PathVariable final Long zipCodeId){
        Zipcode zipcode = zipcodeService.deleteZipcode(zipCodeId);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }
}
