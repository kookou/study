package kr.or.bit.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Boarddao;

import kr.or.bit.dto.Board;


public class BoardList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		String ps = request.getParameter("ps"); //pagesize
		String cp = request.getParameter("cp"); //current page
		
		//List 페이지 처음 호출 ...
		if(ps == null || ps.trim().equals("")){
			//default 값 설정
			ps = "10"; //5개씩 
		}
	
		if(cp == null || cp.trim().equals("")){
			//default 값 설정
			cp = "1"; // 1번째 페이지 보겠다 
		}
		
		int pagesize = Integer.parseInt(ps);
		int cpage = Integer.parseInt(cp);
		int pagecount=0;
		
		try {
			 Boarddao dao = new Boarddao();
			 List<Board> boardlist = dao.getBoardList(cpage, pagesize);
			 request.setAttribute("boardlist", boardlist);
			
			 int totalboardcount = dao.getTotalBoardCount();
				
			 if(totalboardcount % pagesize == 0){
				pagecount = totalboardcount / pagesize; //  20 << 100/5
			 }else{
				pagecount = (totalboardcount / pagesize) + 1; 
			 }
			 request.setAttribute("pagesize", pagesize);
			 request.setAttribute("cpage", cpage);
			 request.setAttribute("pagecount", pagecount);
			 request.setAttribute("totalboardcount", totalboardcount);
			 
			 forward = new ActionForward();
			 forward.setRedirect(false); //forward
			 forward.setPath("/WEB-INF/views/board/BoardList.jsp");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}

}
