package com.kargotakip.data.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KargoResponseDto {
	private Long id;	
	private String takipNo;
	private String gonderici;
	private String alici;
	private String durum;

}
