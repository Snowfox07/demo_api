package com.example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.NewDTO;
import com.example.entity.NewEntity;

@Component
public class NewConverter {

	@Autowired
	private final ModelMapper mapper;

	public NewConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = mapper.map(dto, NewEntity.class);
//
//		NewEntity entity = new NewEntity(); entity.setTitle(dto.getTitle());
//		entity.setContent(dto.getContent());
//		entity.setShortDescription(dto.getShortDescription());
//		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = mapper.map(entity, NewDTO.class);
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
//		NewDTO dto = new NewDTO(); if(entity.getId() != null) {
//		dto.setId(entity.getId()); } dto.setTitle(entity.getTitle());
//		dto.setContent(entity.getContent());
//		dto.setShortDescription(entity.getShortDescription());
//		dto.setThumbnail(entity.getThumbnail());
//		dto.setCreatedDate(entity.getCreatedDate());
//		dto.setModifiedDate(entity.getModifiedDate());
//		dto.setCreatedBy(entity.getCreatedBy());
//		dto.setModifiedBy(entity.getModifiedBy());
		
		return dto;
	}
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
	
	
}
