package com.backendtest.backendtest.controller;

import com.backendtest.backendtest.dto.ResponseDto;
import com.backendtest.backendtest.dto.itemDto;
import com.backendtest.backendtest.service.BackendTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class BackendTestController {

    @Autowired
    private BackendTestService backendTestService;

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "{dummy}";
    }


    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "{dummy2}";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo
    , @RequestParam("year") int year) {

        log.info("empNo: {}" + empNo);
        log.info("empNo: {}" + year);
        return "ok";
    }


    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}" + id);
        return "ok";
    }


    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody itemDto item) {
        log.info("item: {}" + item);

        boolean b  = backendTestService.registerItem(item);

        if ( b == true )
        {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("success");
            return responseDto;
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;


    }

    @GetMapping("/item")
    public itemDto getItem(@RequestParam("id") String id) {
        itemDto res = backendTestService.getItemById(id);
        return res;
    }



}
