package com.ernestui.jparelationship.controller;

import com.ernestui.jparelationship.data.City;
import com.ernestui.jparelationship.dto.requestDto.CityRequestDto;
import com.ernestui.jparelationship.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 05/04/2023 - 09:39
 * @project jpa-relationship
 */
@RestController
@RequestMapping("/city")
public class CityController {
    private  final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody final CityRequestDto cityRequestDto){
        City city = cityService.addCity(cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<City> getCity(@PathVariable final Long id){
        City city = cityService.getCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<City>> getCities(){
        List<City> city = cityService.getCities();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable final Long id){
       City city = cityService.deleteCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<City> editCities(@PathVariable final Long id ,@RequestBody final CityRequestDto cityRequestDto){
        City city = cityService.editCity(id, cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

}
