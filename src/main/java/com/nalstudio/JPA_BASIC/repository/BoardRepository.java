package com.nalstudio.JPA_BASIC.repository;

import com.nalstudio.JPA_BASIC.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(originPatterns = {"http://localhost:8081", "http://localhost:3000"})
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
