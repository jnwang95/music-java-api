package com.music.service;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface BaseService {

    ResponseEntity<String> getMusicData(HttpServletRequest request);
}
