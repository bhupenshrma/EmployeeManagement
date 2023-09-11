package com.Employee.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.Employee.dto.DapartmentDto;
import com.Employee.entity.Dapartment;

@Component
public class DapartmentConverter {

	// method to convert dto to Department entity
	public Dapartment convertDtoToDeptEntity(DapartmentConverter dDto) {
		Dapartment dept = new Dapartment();

		if (dDto != null) {

			// for all or use BeanUtils
			BeanUtils.copyProperties(dDto, dept);

		}

		return dept;

	}

	// method to convert Department entity to dto

	public DapartmentDto convertDeptEntityToDto(Dapartment dept) {
		DapartmentDto dDto = new DapartmentDto();

		if (dept != null) {
			BeanUtils.copyProperties(dept, dDto);

		}
		return dDto;

	}
}
