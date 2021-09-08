package com.board.app_board.dto;

import java.sql.Timestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "store")
@ToString
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "memId" }, callSuper = false)
public class BoardVo {
	/** 번호 (PK) */
	private Long idx;
	/** 유저 id */
	private String memId; 

	/** 제목 */
	private String title;

	/** 내용 */
	private String content;

	/** 삭제 여부 */
	private String deleteYn;

	/** 등록일 */
	private Timestamp insertTime;

	/** 수정일 */
	private Timestamp updateTime;

	/** 삭제일 */
	private Timestamp deleteTime;
}
