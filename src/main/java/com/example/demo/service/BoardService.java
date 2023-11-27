package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	
	public String getHelloWorld() {
		return "hello";
	}
	
	public Board postBoard(BoardDto request) {
		Board board = Board.builder().writer("관리자").title(request.getTitle()).content(request.getContent()).view(0L).build();
		return boardRepository.save(board);
	}
}
