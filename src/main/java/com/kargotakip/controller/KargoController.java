package com.kargotakip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kargotakip.data.dto.KargoResponseDto;
import com.kargotakip.data.dto.KargoSaveRequestDto;
import com.kargotakip.data.dto.KargoStatusUpdateDto;
import com.kargotakip.service.KargoService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kargo")
@RequiredArgsConstructor
public class KargoController {
	private final KargoService service;
	
	@PostMapping("/save")
	public ResponseEntity<KargoResponseDto> save(@Valid @RequestBody KargoSaveRequestDto dto) {
		return new ResponseEntity<KargoResponseDto>(service.save(dto),HttpStatus.CREATED);
	}
	
	@PutMapping("/status")
	public ResponseEntity<KargoResponseDto> updateStatus(@Valid @RequestBody KargoStatusUpdateDto dto){
		return new ResponseEntity<KargoResponseDto>(service.durumUpdate(dto.getKargoId(), dto.getEnumId()),HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/Kargo/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
}
