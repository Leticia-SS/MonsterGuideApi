package com.example.mosnterguideapi.controller;

import com.example.mosnterguideapi.model.Monster;
import com.example.mosnterguideapi.service.MonsterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public ResponseEntity<List<Monster>> listAllMonsters(){
        List<Monster> monsters = monsterService.getAllMonsters();
        return ResponseEntity.ok(monsters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listMonster(@PathVariable Long id) {
        Optional<Monster> monster = monsterService.getMonsterById(id);
        if (monster.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: monstro não encontrado");
        }
        return ResponseEntity.ok(monster.get());
    }

    @PostMapping
    public String addMonster(@RequestBody Monster monster){
        monsterService.addMonster(monster);
        return "Monstro criado com sucesso";
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMonster(@PathVariable Long id, @RequestBody Monster newMonster) {
        Optional<Monster> monsterDb = monsterService.getMonsterById(id);
        if (monsterDb.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: monstro não encontrado");
        }
        monsterService.updateMonster(id,newMonster);
        return new ResponseEntity<>(newMonster, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonster(@PathVariable Long id) {
        Optional<Monster> monster = monsterService.getMonsterById(id);
        if (monster.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: monstro não encontrado");
        }
        monsterService.deleteMonster(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/levelup")
    public ResponseEntity<?> levelUp(@PathVariable Long id) {
        Optional<Monster> monster = monsterService.getMonsterById(id);
        if (monster.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: monstro não encontrado");
        }
        Monster updatedMonster = monsterService.levelUp(id);
        return ResponseEntity.ok(updatedMonster);
    }
}
