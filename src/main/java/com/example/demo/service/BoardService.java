package com.example.demo.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;
	
	public String getHelloWorld() {
		return "hello";
	}
	
	@Transactional
	public void saveBoard(BoardDto request) {
		Board board = Board.builder().writer("관리자").title(request.getTitle()).content(request.getContent()).views(0L).build();
		boardMapper.save(board);
	}
	
	@Transactional
	public List<Board> getBoardList() {
		return boardMapper.findAll();
	}
	
	@Transactional
	public Board getBoardDetail(Long id) {
		Board board = boardMapper.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 게시물이 없습니다."));
		boardMapper.increaseViewCountById(id);
		board.increaseViews();
		return board;
	}
	
	@Transactional
	public List<Board> findTitleByKeyword(String keyword) {
		return boardMapper.findTitleByKeyword(keyword);
	}
}
