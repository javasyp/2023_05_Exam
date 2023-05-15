package com.KoreaIT.syp.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.KoreaIT.syp.demo.vo.Member;

@Mapper
public interface MemberRepository {
	
	@Insert("""
				INSERT INTO `member`
				SET regDate = NOW(),
				loginId = #{loginId},
				loginPw = #{loginPw},
				`name` = #{name},
				nickname = #{nickname},
				cellphoneNum = #{cellphoneNum},
				email = #{email}
			""")
	void join(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email);
	
	@Select("""
				SELECT *
				FROM `member`
				WHERE id = #{id}
			""")
	Member getMemberById(int id);
	
	@Select("SELECT LAST_INSERT_ID()")
	int getLastInsertId();
	
	// 아이디 중복 체크
	@Select("""
				SELECT *
				FROM `member`
				WHERE loginId = #{loginId}
			""")
	Member getMemberByLoginId(String loginId);
	
	// 이름 + 이메일 중복 체크
	@Select("""
				SELECT *
				FROM `member`
				WHERE name = #{name}
				AND email = #{email}
			""")
	Member getMemberByNameAndEmail(String name, String email);
	
	// 이메일 중복 체크
	@Select("""
				SELECT *
				FROM `member`
				WHERE email = #{email}
			""")
	Member getMemberByEmail(String email);
	
}
