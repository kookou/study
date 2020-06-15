package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;

import kr.or.bit.dto.Emp;
import net.sf.json.JSONArray;


public class EmpListAjax implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		String ps = request.getParameter("ps"); //pagesize
		String cp = request.getParameter("cp"); //current page
		
		//List 페이지 처음 호출 ...
		if(ps == null || ps.trim().equals("")){
			//default 값 설정
			ps = "5"; //5개씩 
		}
	
		if(cp == null || cp.trim().equals("")){
			//default 값 설정
			cp = "1"; // 1번째 페이지 보겠다 
		}
		System.out.println(ps);
		System.out.println(cp);
		int pagesize = Integer.parseInt(ps);
		int cpage = Integer.parseInt(cp);
		int pagecount=0;
		
		try {
			 Empdao dao = new Empdao();
			 List<Emp> emplist = dao.getEmpList(cpage, pagesize);
			 //request.setAttribute("emplist", emplist);
			 
			
			 int totalempcount = dao.getEmpCount();
				
				//23건  % 5
				if(totalempcount % pagesize == 0){
					pagecount = totalempcount / pagesize; //  20 << 100/5
				}else{
					pagecount = (totalempcount / pagesize) + 1; 
				}
				//request.setAttribute("pagesize", pagesize);
				//request.setAttribute("cpage", cpage);
				//request.setAttribute("pagecount", pagecount);
				//request.setAttribute("totalempcount", totalempcount);
				
				 JSONArray jsonArr = JSONArray.fromObject(emplist);
				 request.setAttribute("jsonArr", jsonArr);
				 /* response.setContentType("application/x-json; charset=UTF-8");
				 * response.getWriter().print(jsonArr);
				 */
			 forward = new ActionForward();
			 forward.setRedirect(false); //forward
			 forward.setPath("/WEB-INF/views/EmpListAjax.jsp");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
		
	}
}
