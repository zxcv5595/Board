package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@PostMapping("/post")
	public ResponseEntity<Void> postBoard(@RequestBody BoardDto request) {
		boardService.postBoard(request);
		return ResponseEntity.ok().build();
	}
}
