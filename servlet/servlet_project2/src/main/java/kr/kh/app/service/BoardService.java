package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	boolean insertBoard(BoardVO board, ArrayList<Part> partList);

	ArrayList<CommunityVO> getCommunityList();

	int getTotalCount(Criteria cri);

	boolean updateView(int num);

	BoardVO getBoard(int num);

	boolean deleteBoard(int num, MemberVO user);

	boolean updateBoard(MemberVO user, BoardVO board, String[] nums, ArrayList<Part> partList);

	ArrayList<FileVO> getFileList(int num);

	RecommendVO getRecommend(MemberVO user, int num);

	int recommend(int boNum, int state, String me_id);

	ArrayList<CommentVO> getCommentList(Criteria cri);

	int getTotalCommentCount(Criteria cri);


}
