package com.kargotakip.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KargoDurumEnum {
	TESLIM_ALINDI(0,"Şubeye Kabul Edildi"),
	TASIMADA(1,"Kargodan havale edildi"),
	VARIS_SUBESINDE(2,"Varış şubesine kabul edildi"),
	DAGITIMDA(3,"Dağıtımda"),
	TESLIM_EDILDI(4,"Teslim edildi");
	
	private int id;
	private String aciklama;
	
	
	public static KargoDurumEnum fromId(int id) {
		for (KargoDurumEnum durum : values()) {
			if(durum.getId()==id) {
				return durum;
			}
			
		}
		
		throw new IllegalArgumentException("Geçersiz Kargo Durum ID'si: "+id);
		
	}

}
