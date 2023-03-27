package com.xhite.peoplistmonolithic.controller;

import com.xhite.peoplistmonolithic.dto.ApiResponse;
import com.xhite.peoplistmonolithic.dto.request.CandidateRequestDto;

import com.xhite.peoplistmonolithic.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.xhite.peoplistmonolithic.constant.Paths.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(CANDIDATE)
public class CandidateController {
    private final CandidateService candidateService;
    private final ApiResponse apiResponse;


    @GetMapping
    public ResponseEntity<ApiResponse> findAll() {
        return apiResponse.createOkResponse(candidateService.findAll());
    }


    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CandidateRequestDto candidateRequestDto) {
        return apiResponse.createOkResponse(candidateService.create(candidateRequestDto));
    }

    @GetMapping(STATUS)
    public ResponseEntity<ApiResponse> findAllByStatus(@PathVariable String status) {
        return apiResponse.createOkResponse(candidateService.findAllByStatus(status));
    }

    @GetMapping(ID)
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return apiResponse.createOkResponse(candidateService.findById(id));
    }


    @PutMapping(ID)
    public ResponseEntity<ApiResponse> update( @PathVariable Long id, @RequestBody CandidateRequestDto candidateRequestDto) {
        return apiResponse.createOkResponse(candidateService.update(candidateRequestDto, id));
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable Long id) {
        candidateService.delete(id);
    }
}
