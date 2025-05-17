package com.kargotakip.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KargoStatusUpdateDto {
	@NotNull(message = "Kargo ID boş olamaz")
	private Long kargoId;
	@NotNull(message = "Durum ID boş olamaz")
	private Integer enumId;

}
