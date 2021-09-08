package com.board.commandObj;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "store")
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class Member {

	
	// member
	private String id;
	private String pw;
	private String name;
	private String email;
	private String nickname;
	private String address;
	private String joinpath;
	
	// board
	private String idx;
	private String memId;
	private String title;
	private String content;
	private String board;

}
