package com.example.service;

import java.util.List;

import com.example.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDto);
	void delete(long[] ids);
	void delete(long id);
	List<NewDTO> findAll();
}
