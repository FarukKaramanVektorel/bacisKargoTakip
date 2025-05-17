package com.kargotakip.service;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.kargotakip.data.dto.KargoResponseDto;
import com.kargotakip.data.dto.KargoSaveRequestDto;
import com.kargotakip.data.enums.KargoDurumEnum;
import com.kargotakip.data.model.Kargo;
import com.kargotakip.repository.KargoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KargoService {	
	private final KargoRepository repository;
	private final ModelMapper mapper;
	
	public KargoResponseDto save(KargoSaveRequestDto dto) {
		Kargo kargo=mapper.map(dto, Kargo.class);	
		kargo.setTakipNo(takipNoUret());
		kargo.setDurum(KargoDurumEnum.TESLIM_ALINDI.getAciklama());
		
		Kargo addKargo=repository.save(kargo);
		
		return mapper.map(addKargo, KargoResponseDto.class);
	}
	
	public KargoResponseDto durumUpdate(Long kargoId,Integer id) {
		Kargo kargo=null;
		if(repository.existsById(kargoId)) {
			kargo=repository.findById(kargoId).orElse(null);
		}else {
			throw new IllegalArgumentException("Geçersiz Kargo ID'si: "+kargoId);
		}
		kargo.setDurum(KargoDurumEnum.fromId(id).getAciklama());
		return mapper.map(repository.save(kargo), KargoResponseDto.class);
	}
	
	
	
	private String takipNoUret() {
		String takipNo="KR";
		char[] harfler= {'0','1','2','3','4','5','6','7','8','9'};
		Random rnd=new Random();
		for (int i = 0; i < 16; i++) {
			char rakam=harfler[rnd.nextInt(harfler.length)];
			takipNo+=rakam;
			
		}
		
		return takipNo;
	}
	
	public String delete(Long id) {
		repository.delete(repository.findById(id).orElse(null));
		return "Silme işlemi başarılı";
	}

}
