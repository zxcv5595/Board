package com.example.demo.board.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;
@RestController
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@PostMapping("/post")
	public ResponseEntity<Void> postBoard(@RequestBody BoardDto request) {
		boardService.saveBoard(request);
		return ResponseEntity.ok().build();
	}
}
