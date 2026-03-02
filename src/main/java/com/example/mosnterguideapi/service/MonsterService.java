package com.example.mosnterguideapi.service;

import com.example.mosnterguideapi.model.Monster;
import com.example.mosnterguideapi.repository.IMonsterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {
    private final IMonsterRepository monsterRepository;

    public MonsterService(IMonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    public Optional<Monster> getMonsterById(Long id) {
        return monsterRepository.findById(id);
    }

    public void addMonster(Monster monster){
        monster.setLevel(1);
        monsterRepository.save(monster);
    }

    public void updateMonster(Long id, Monster newMonster){
        Optional<Monster> monster = monsterRepository.findById(id);
        if (monster.isPresent()){
            newMonster.setId(id);
            monsterRepository.save(newMonster.get());
        }
    }

    public void deleteMonster(Long id) {
        monsterRepository.deleteById(id);
    }

    public Monster levelUp(Long id){
        Monster monster = monsterRepository.findById(id).orElseThrow(()->new RuntimeException("Monstro não encontrado"));
        monster.setLevel(monster.getLevel() + 1);
        return monsterRepository.save(monster);
    }

}
