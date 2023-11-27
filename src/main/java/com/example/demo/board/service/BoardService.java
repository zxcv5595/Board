package com.example.demo.board.service;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.domain.Board;
import com.example.demo.board.mapper.BoardMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Transactional
    public void saveBoard(BoardDto request) {
        Board board = new Board(null, "관리자", request.getTitle(), request.getContent(), 0L);
        boardMapper.save(board);
    }

    @Transactional
    public List<Board> getBoardList() {
        return boardMapper.findAll();
    }

    @Transactional
    public Board getBoardDetail(Long id) {
        Board board = boardMapper.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당하는 게시물이 없습니다."));
        boardMapper.increaseViewCountById(id);
        board.increaseViews();
        return board;
    }

    @Transactional
    public List<Board> findTitleByKeyword(String keyword) {
        return boardMapper.findTitleByKeyword(keyword);
    }
}
