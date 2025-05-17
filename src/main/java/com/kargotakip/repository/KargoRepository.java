package com.kargotakip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kargotakip.data.model.Kargo;
@Repository
public interface KargoRepository extends JpaRepository<Kargo, Long> {

}
