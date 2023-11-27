package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.example.demo.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String writer;
	
	private String title;
	
	private String content;
	
	private Long view;
	/*
	 * USE example;
	 * CREATE TABLE board(
	 * id BIGINT NOT NULL AUTO_INCREMENT,
	 * writer VARCHAR(20) NOT NULL,
	 * title VARCHAR(20) NOT NULL,
	 * content VARCHAR(255) NOT NULL,
	 * view BIGINT NOT NULL DEFUALT 0,
	 * created_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP,
	 * modified_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	 * INDEX (created_at)
	 * PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
	 */
}
