package com.backendtest.backendtest.service;

import com.backendtest.backendtest.dto.itemDto;
import com.backendtest.backendtest.entity.ItemEntity;
import com.backendtest.backendtest.mapper.BackendTestMapper;
import com.backendtest.backendtest.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
@Slf4j

public class BackendTestService {

    @Autowired
    private BackendTestMapper   backendTestMapper;
    @Autowired
    private ItemRepository itemRepository;


    public boolean registerItem(itemDto item)
    {
        // TODO: DB Insert

//        HashMap<String, Object> paramMap = new HashMap<>();
//
//        paramMap.put("id", item.getId());
//        paramMap.put("name", item.getName());
//
//        backendTestMapper.registerItem(paramMap);
//
//        log.info("service...." + item);


        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(item.getId());
        itemEntity.setName(item.getName());
        itemRepository.save(itemEntity);

        return true;

    }

    public itemDto getItemById(String id)
    {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String, Object> res = backendTestMapper.findById(paramMap);
//
//        itemDto itemDto = new itemDto();
//        itemDto.setId((String)res.get("ID"));
//        itemDto.setId((String)res.get("NAME"));
//        return itemDto;

        ItemEntity itemEntity = itemRepository.findById(id).get();
        itemDto itemDto = new itemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setId(itemEntity.getName());

        return itemDto;
    }
}
