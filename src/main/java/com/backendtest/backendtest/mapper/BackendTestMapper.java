package com.backendtest.backendtest.mapper;

import com.backendtest.backendtest.dto.itemDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

@Mapper
public interface BackendTestMapper {

    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

    void registerItem(HashMap<String, Object> paramMap);

}
