package com.board.app_member.dto;

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
public class MemberVo {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String nickname;
	private String address;
	private String joinPath;

}
