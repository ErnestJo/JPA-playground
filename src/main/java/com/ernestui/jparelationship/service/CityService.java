package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.City;
import com.ernestui.jparelationship.dto.requestDto.CityRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 11:06
 * @project jpa-relationship
 */

@Service
public interface CityService {
    public City addCity(CityRequestDto cityRequestDto);
    public List<City> getCities();
    public City getCity(Long cityId);
    public City deleteCity(Long cityId);
    public City editCity(Long cityId, CityRequestDto cityRequestDto);
}
