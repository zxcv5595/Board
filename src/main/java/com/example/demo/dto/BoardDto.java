package com.example.demo.dto;
import java.time.LocalDate;
import com.example.demo.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BoardDto {
	private Long id;
	
	private String writer;
	
	private String title;
	
	private String content;
	
	private LocalDate createdAt;
	
	private Long views;
	
	public static BoardDto from(Board board) {
		return BoardDto.builder().writer(board.getWriter()).id(board.getId()).title(board.getTitle()).content(board.getContent()).createdAt(board.getCreatedAt().toLocalDate()).views(board.getViews()).build();
	}
}
