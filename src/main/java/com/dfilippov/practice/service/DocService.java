package com.dfilippov.practice.service;

import com.dfilippov.practice.dto.DocResponse;
import com.dfilippov.practice.exception.CustomException;
import com.dfilippov.practice.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocService {
    @Autowired
    DocRepository docRepository;
    public List<DocResponse> getDocs() throws CustomException {
        try{
            return ObjectMapper.mapAll(docRepository.findAll(), DocResponse.class);
        } catch (Exception e) {
            throw new CustomException("Произошла ошибка");
        }
    }
}
