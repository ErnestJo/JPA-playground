package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Zipcode;
import com.ernestui.jparelationship.dto.requestDto.ZipcodeRequestDto;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 13:53
 * @project jpa-relationship
 */
public interface ZipcodeService {
    public Zipcode addZipCode(ZipcodeRequestDto zipcodeRequestDto);

    public List<Zipcode> getZipCodes();
    public Zipcode getZipCode(Long zipCodeId);
    public Zipcode deleteZipcode(Long zipCodeId);
    public Zipcode editZipcode(Long zipCodeId, ZipcodeRequestDto zipcodeRequestDto);

    public Zipcode addCityToZipcode(Long zipCodeId, Long cityId);

    public Zipcode removeCityFromZipCode(Long zipCodeId);

}
