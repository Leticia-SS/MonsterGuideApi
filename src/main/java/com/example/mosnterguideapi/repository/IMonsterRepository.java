package com.example.mosnterguideapi.repository;

import com.example.mosnterguideapi.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMonsterRepository extends JpaRepository<Monster, Long> {
}
