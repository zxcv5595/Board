package com.example.demo.board.mapper;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo.board.domain.Board;
@Mapper
public interface BoardMapper {
	void save(Board board);
	
	List<Board> findAll();
	
	Optional<Board> findById(@Param("id") Long id);
	
	void increaseViewCountById(@Param("id") Long id);
	
	List<Board> findTitleByKeyword(@Param("keyword") String keyword);
}
