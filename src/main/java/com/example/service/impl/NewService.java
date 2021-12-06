package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.converter.NewConverter;
import com.example.dto.NewDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.service.INewService;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;


    // save and update
    @Override
    public NewDTO save(NewDTO newDto) {
        NewEntity newEntity = new NewEntity();
        if (newDto.getId() != null) {
            NewEntity oldNewEntity = newRepository.findOne(newDto.getId());
            newEntity = newConverter.toEntity(newDto, oldNewEntity);
        } else {
            newEntity = newConverter.toEntity(newDto);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDto.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }


    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            newRepository.delete(item);
        }
    }

    @Override
    public void delete(long id) {
        newRepository.delete(id);
    }


    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> results = new ArrayList<NewDTO>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity item : entities) {
            NewDTO newDTO = newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }


//	@Override
//	public NewDTO update(NewDTO newDto) {
//		// TODO Auto-generated method stub
//		NewEntity oldNewEntity = newRepository.findOne(newDto.getId());
//		NewEntity newEntity = newConverter.toEntity(newDto, oldNewEntity);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDto.getCategoryCode());
//		newEntity.setCategory(categoryEntity);
//		newEntity = newRepository.save(newEntity);
//		return newConverter.toDTO(newEntity);
//	}


}
