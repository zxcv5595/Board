package com.example.demo.dto;
import com.example.demo.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardDto {
	private String title;
	
	private String content;
	
	public static BoardDto from(Board board) {
		return new BoardDto(board.getTitle(), board.getContent());
	}
}
