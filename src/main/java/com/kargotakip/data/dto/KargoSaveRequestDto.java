package com.kargotakip.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class KargoSaveRequestDto {
	
	@NotBlank(message = "Gönderici adı boş olamaz")
	private String gonderici;
	@NotBlank(message = "Alıcı adı boş olamaz")
	private String alici;
	
	

}
