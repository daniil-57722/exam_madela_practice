package com.dfilippov.practice.service;

import com.dfilippov.practice.dto.CountryResponse;
import com.dfilippov.practice.exception.CustomException;
import com.dfilippov.practice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<CountryResponse> getCountries() throws CustomException {
        try{
            return ObjectMapper.mapAll(countryRepository.findAll(), CountryResponse.class);
        } catch (Exception e) {
            throw new CustomException("Произошла ошибка");
        }
    }
}
