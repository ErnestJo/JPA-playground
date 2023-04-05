package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.City;
import com.ernestui.jparelationship.data.Zipcode;
import com.ernestui.jparelationship.dto.requestDto.ZipcodeRequestDto;
import com.ernestui.jparelationship.repository.CityRepository;
import com.ernestui.jparelationship.repository.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 14:00
 * @project jpa-relationship
 */
@Service
public class ZipcodeServiceImpl implements ZipcodeService {
    private final ZipcodeRepository zipcodeRepository;
    private  final CityService cityService;

    @Autowired
    public ZipcodeServiceImpl(ZipcodeRepository zipcodeRepository, CityRepository cityRepository, CityService cityService) {
        this.zipcodeRepository = zipcodeRepository;
        this.cityService = cityService;
    }

    @Transactional
    @Override
    public Zipcode addZipCode(ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcode = new Zipcode();
        zipcode.setName(zipcodeRequestDto.getName());
        if(zipcodeRequestDto.getCityId() == null){
            return zipcodeRepository.save(zipcode);
        }
        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcode.setCity(city);

        return zipcodeRepository.save(zipcode);
    }

    @Override
    public List<Zipcode> getZipCodes() {
        return StreamSupport
                .stream(zipcodeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Zipcode getZipCode(Long zipCodeId) {
        return  zipcodeRepository.findById(zipCodeId).orElseThrow(() ->
                new IllegalArgumentException("city with cityId: " + zipCodeId + " could not be found"));
    }

    @Override
    public Zipcode deleteZipcode(Long zipCodeId) {
        Zipcode zipcode = getZipCode(zipCodeId);
        zipcodeRepository.delete(zipcode);
        return zipcode;
    }

    @Override
    public Zipcode editZipcode(Long zipCodeId, ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToEdit = getZipCode(zipCodeId);
        zipcodeToEdit.setName(zipcodeRequestDto.getName());
        if(zipcodeRequestDto.getCityId() == null){
            return zipcodeRepository.save(zipcodeToEdit);
        }
        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcodeToEdit.setCity(city);
        return zipcodeToEdit;
    }

    @Transactional
    @Override
    public Zipcode addCityToZipcode(Long zipCodeId, Long cityId) {
        Zipcode zipcode  = getZipCode(zipCodeId);
        City city = cityService.getCity(cityId);
        if(Objects.nonNull(zipcode.getCity())){
            throw  new IllegalArgumentException("zipcode has already has a city");
        }
        zipcode.setCity(city);
        return zipcode;
    }

    @Transactional
    @Override
    public Zipcode removeCityFromZipCode(Long zipCodeId) {
        Zipcode zipcode  = getZipCode(zipCodeId);
        if(!(Objects.nonNull(zipcode.getCity()))){
            throw  new IllegalArgumentException("zipcode does not have a city");
        }
        zipcode.setCity(null);
        return null;
    }
}
