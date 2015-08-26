package com.sssystem.edu.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.QnaService;
import com.sssystem.edu.vo.QnaBoardVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;


@Controller
public class QnaController {

	@Autowired
	QnaService qnaService;
	
	@RequestMapping("qna/list")
	public String qnaList(@RequestParam(value="board_gb")int board_gb,
			@RequestParam(value="searchWord",required=false)String searchWord,
			@RequestParam(value="page",required=false)String page,
			Model model){
		SearchBoardVO searchVO = new SearchBoardVO();
		searchVO.setSearchWord(searchWord);
		String pn = page;
		
		int page_no = 1;
	    ValidateParamChk chk = new ValidateParamChk();
	    if (!chk.isEmpty(pn)) if (chk.isNumeric(pn)) page_no = chk.toInteger(pn);
	    if (page_no > 0) searchVO.setPage_no(page_no);
	    
	    searchVO.setBoard_gb(board_gb);
	    if(searchWord != null && searchWord.equals("")){
	    	searchVO.setSearchWord(searchWord);
	    }
	    
	    int total = qnaService.cntSelect(searchVO);
	    searchVO.setTotal(total);
	    
	    List<QnaBoardVO> list = qnaService.qnaBoardListSelectAll(searchVO,page_no);
	    
	    model.addAttribute("list",list);
	    model.addAttribute("searchVO",searchVO);
		return "qna/list";
	}
	
	@RequestMapping("qna/view")
	public String qnaView(HttpSession session,Model model,
			@RequestParam(value="no")int no,
			@RequestParam(value="board_gb")int board_gb){
		int qna_no = no;
		QnaBoardVO qnaVO = qnaService.qnaBoardView(qna_no,board_gb);
		qnaVO.setA_user_nm(qnaService.answerNmSelect(qnaVO.getA_user_no()));
		qnaService.hitsUpdate(no);
		
		model.addAttribute("qnaVO",qnaVO);
		return "qna/view";
	}
	
	@RequestMapping("qna/write")
	public String qnaWrite(HttpSession session,Model model,
			@RequestParam(value="edu_no",required=false)int edu_no,
			@RequestParam(value="board_gb")String board_gb,
			@RequestParam(value="title")String title,
			@RequestParam(value="q_contents",required=false)String q_contents,
			@RequestParam(value="a_contents",required=false)String a_contents,
			@RequestParam(value="qna_no",required=false)String qna_no
			){
		
		QnaBoardVO qnaVO = new QnaBoardVO();
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		qnaVO.setEdu_no(15);
		qnaVO.setBoard_gb(board_gb);
		qnaVO.setSecret_yn(0);
		qnaVO.setTitle(title);
		qnaVO.setQ_user_no(sessionVO.getUser_no());
		qnaVO.setQ_contents(q_contents);
		qnaVO.setA_user_no(sessionVO.getUser_no());
		qnaVO.setA_contents(a_contents);
		qnaVO.setVisit_no(0);
		if(!qna_no.isEmpty()){
			qnaVO.setQna_no(Integer.parseInt(qna_no));
		}
		
		if(board_gb.equals("60")){
			if(!(q_contents==null)){
				if(qnaService.qnaBoardInsert(qnaVO)){
					return "60";
				}
			}else if(q_contents==null){
				if(qnaService.qnaBoardUpdate(qnaVO)){
					return "60";
				}
			}
		}else if(board_gb.equals("50")){
			if(qna_no.isEmpty()){
				if(qnaService.qnaBoardUpdate(qnaVO)){
					return "50";
				}
			}else{
				if(qnaService.qnaBoardInsert(qnaVO)){
					return"50";
				}
			}
		}else if(board_gb.equals("40")){
			if(!(q_contents==null)){
				if(qnaService.qnaBoardInsert(qnaVO)){
					return "40";
				}
			}else if(q_contents==null){
				if(qnaService.qnaBoardUpdate(qnaVO)){
					return "40";
				}
			}
		}
		
		return "qna/write";
	}
	
	@RequestMapping("qna/delete")
	public String qnaDelete(Model model,
			@RequestParam(value="no")int no,
			@RequestParam(value="board_gb")int board_gb){
		
		if(board_gb==40){
			qnaService.qnaBoardDelete(no);
			return "40";
		}else if(board_gb==50){
			qnaService.qnaBoardDelete(no);
			return "50";
		}else if(board_gb==60){
			qnaService.qnaBoardDelete(no);
			return "60";
		}
		return "qna/delete";
	}
	
	@RequestMapping("qna/answer")
	public String qnaAnswer(HttpSession session,Model model,
			@RequestParam(value="qna_no")int qna_no,
			@RequestParam(value="a_contents")String a_contents){
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		QnaBoardVO qnaVO = new QnaBoardVO();
		qnaVO.setQna_no(qna_no);
		qnaVO.setA_user_no(sessionVO.getUser_no());
		qnaVO.setA_contents(a_contents);
		
		qnaService.answerUpdate(qnaVO);
		
		return "qna/answer";
		
	}
}
