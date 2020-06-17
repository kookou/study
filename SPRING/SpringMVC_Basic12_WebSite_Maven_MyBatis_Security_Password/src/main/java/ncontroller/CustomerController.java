package ncontroller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CustomerService;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	private CustomerService customerservice;
	
	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	
	//글 목록보기
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q , Model model) {
		
		List<Notice> list = customerservice.notices(pg, f, q);
		model.addAttribute("list", list);	
		
		return "customer.notice"; //"notice.jsp";
	}
	
	//글 상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice = customerservice.noticeDetail(seq);
		model.addAttribute("notice", notice);
		
		return "customer.noticeDetail"; //"noticeDetail.jsp";
	}
	
	//글쓰기 view
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
		return  "customer.noticeReg";//"noticeReg.jsp";
	}
	
	//글쓰기 처리
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request, Principal principal) throws IOException, ClassNotFoundException, SQLException {
		return customerservice.noticeReg(n, request, principal); 
	}
	
	//글 삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		return customerservice.noticeDel(seq);
	}
	
	//글 수정하기(화면)
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		Notice notice = customerservice.noticeEdit(seq);	
		model.addAttribute("notice", notice);
		return "customer.noticeEdit";//"noticeEdit.jsp";
	}
	
	//글 수정하기(처리)
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		return customerservice.noticeEdit(n, request);
	}
	
}

