package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.RecommendVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	//@RequestMapping(value='/board/list", method=RequestMethod.GET)
	@GetMapping("/board/list")
	public String boardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		//커뮤니티 리스트를 가져와서 화면에 전송
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		return "/board/insert";
	}
	
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board,
			HttpServletRequest request, MultipartFile[] file) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(boardService.insertBoard(board, user, file)) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		return "message";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model, int boNum, Criteria cri) {
		//조회수 증가
		boardService.updateView(boNum);
		//게시글을 가져옴
		BoardVO board = boardService.getBoard(boNum);
		//첨부파일 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(boNum);
		//화면에 게시글, 첨부파일, 검색정보를 전송
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		model.addAttribute("cri", cri);
		
		return "/board/detail";
	}
	
	@ResponseBody
	@PostMapping("/recommend/check")
	public Map<String, Object> recommendCheck(@RequestBody RecommendVO recommend, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		int res = boardService.recommend(recommend, user);
		map.put("result", res);
		return map;
	}
	
	@ResponseBody
	@PostMapping("/recommend")
	public Map<String, Object> 메서드명(@RequestParam("num") int num, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		//로그인한 회원의 추천 정보
		MemberVO user = (MemberVO) session.getAttribute("user");
		int state = boardService.getUserRecommend(num, user);
		//게시글의 추천/비추천수를 가져옴
		BoardVO board = boardService.getBoard(num);
		map.put("state", state);
		map.put("board", board);
		return map;
	}
}
