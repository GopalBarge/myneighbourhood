package com.bs.myneighbourhood.mapper;

import com.bs.myneighbourhood.dto.Society;
import com.bs.myneighbourhood.entity.SocietyDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") //Creates a Spring Bean automatically
public interface SocietyMapper {

    SocietyDocument toEntity(Society dto);

    Society toDto(SocietyDocument entity);
}
