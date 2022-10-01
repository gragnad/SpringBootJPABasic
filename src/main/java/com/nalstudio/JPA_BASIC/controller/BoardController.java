package com.nalstudio.JPA_BASIC.controller;

import com.nalstudio.JPA_BASIC.domain.Board;
import com.nalstudio.JPA_BASIC.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("/boards")
public class BoardController {
    private String TAG = getClass().getName();
    @Autowired
    BoardRepository boardRepository;

    @GetMapping
    public List<Board> getListBoarData() {
        return boardRepository.findAll();
    }

    @PostMapping
    public void registerBoarder(@RequestParam Board board) {
        log.info("registerBoarder==");
        log.info(board.toString());
        boardRepository.save(board);
    }
}
