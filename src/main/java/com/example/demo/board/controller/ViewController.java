package com.example.demo.board.controller;

import com.example.demo.board.domain.Board;
import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final BoardService boardService;

    public ViewController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/post")
    public String viewPostPage() {
        return "post";
    }


    @GetMapping("/")
    public String viewBoardListPage(@PageableDefault(size = 5) Pageable pageable, Model model) {
        List<Board> boardList = boardService.getBoardList();
        Page<Board> boardPage = createPage(boardList, pageable);
        List<BoardDto> boardListDto = boardPage.getContent().stream().map(BoardDto::from)
            .collect(Collectors.toList());
        model.addAttribute("posts", boardListDto);
        model.addAttribute("page", boardPage);
        return "index";
    }

    @GetMapping("/boards/{id}")
    public String viewBoardDetail(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardDetail(id);
        model.addAttribute("post", BoardDto.from(board));
        return "details";
    }

    @GetMapping("/boards")
    public String viewBoardPageByTitle(@PageableDefault(size = 5) Pageable pageable, Model model,
        @RequestParam String keyword) {
        List<Board> boardList = boardService.findTitleByKeyword(keyword);
        Page<Board> boardPage = createPage(boardList, pageable);
        List<BoardDto> boardListDto = boardPage.getContent().stream().map(BoardDto::from)
            .collect(Collectors.toList());
        model.addAttribute("posts", boardListDto);
        model.addAttribute("page", boardPage);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    private Page<Board> createPage(List<Board> boardList, Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), boardList.size());
        return new PageImpl<>(boardList.subList(start, end), pageRequest, boardList.size());
    }
}
