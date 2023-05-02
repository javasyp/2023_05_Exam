package com.KoreaIT.syp.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.KoreaIT.syp.demo.vo.Reply;

@Mapper
public interface ReplyRepository {
	
	// 댓글 작성
	@Insert("""
			<script>
				INSERT INTO reply
				SET regDate = NOW(),
				updateDate = NOW(),
				memberId = #{actorId},
				relTypeCode = #{relTypeCode},
				relId =#{relId},
				`body`= #{body}
			</script>
			""")
	void writeReply(int actorId, String relTypeCode, int relId, String body);
	
	// 댓글 개수
	@Select("""
			<script>
				SELECT LAST_INSERT_ID()
			</script>
			""")
	int getLastInsertId();
	
	// 댓글 목록
	@Select("""
			SELECT R.*, M.nickname AS extra_writer
			FROM reply AS R
			LEFT JOIN `member` AS M
			ON R.memberId = M.id
			WHERE R.relTypeCode = #{relTypeCode}
			AND R.relId = #{relId}
			ORDER BY R.id DESC
			""")
	List<Reply> getForPrintReplies(int actorId, String relTypeCode, int relId);

}