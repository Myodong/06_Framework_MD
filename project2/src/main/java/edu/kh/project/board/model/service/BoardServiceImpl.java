package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.BoardDAO;
import edu.kh.project.board.model.vo.Board;
import edu.kh.project.board.model.vo.Pagination;
import edu.kh.project.common.Util;

/**
 * @author gyehd
 *
 */
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;

	// 게시판 이름 목록 조회
	@Override
	public List<Map<String, Object>> selectBoardType() {
		return dao.selectBoardType();
	}

	// 특정 게시판 목록 조회 + 페이징 처리 계산
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		// 1. 특정 게시판의 전체 게시글 수 조회(단, 삭제 제외)
		int listCount = dao.getListCount(boardCode);
		
		// 2. 전체 게시글 수 + cp(현재 페이지)를 이용해서
		// 	  페이징 처리 객체 생성
		Pagination pagination = new Pagination(listCount, cp);
		
		// 3. 페이징 처리 객체를 이용해서 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(pagination,boardCode);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination",pagination);
		map.put("boardList",boardList);
		
		
		return map;
	}

	// 게시글 상세 조회 + 이미지 목록 조회 + 댓글 목록 조회
	@Override
	public Board selectBoardDetail(int boardNo) {
		return dao.selectBoardDetail(boardNo);
	}

	// 조회 수 증가
	@Override
	public int updateReadCount(int boardNo) {
		return dao.updateReadCount(boardNo);
	}

	// 좋아요 여부 체크 
	@Override
	public int boardLikeCheck(Map<String, Object> map) {
		return dao.boardLikeCheck(map);
	}

	
	// 좋아요 수 증가 (INSERT)
	@Override
	public int boardLikeUp(Map<String, Object> paramMap) {
		return dao.boardLikeUp(paramMap);
	}

	// 좋아요 수 감소(DELETE)
	@Override
//	@Transactional 단인 업데이트 딜리트 등 굳이 사용 안해도 됨
	public int boardLikeDown(Map<String, Object> paramMap) {
		return dao.boardLikeDown(paramMap);
	}

	// 게시글 삭제
	@Override
	public int boardDelete(int boardNo) {
		return dao.boardDelete(boardNo);
	}
	
	// 게시글 삽입
	@Override
	public int boardWrite(Board board, List<MultipartFile> imageList, String webPath, String folderPath) {
		
		// 1. 게시글만 삽입
		// 1) XSS(크로스 사이트 스크립트 공격), 개행문자 처리
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		
		board.setBoardContent(Util.newLineHandling(board.getBoardContent()));

		///2) 게시글 삽입DAO 호출후
		//    결과로 삽입된 게시글 번호 반환 받기
		int boardNo =dao.boardWrite(board);
		
		
		
		return boardNo;
	}
	
}
