package ITzy.OTT.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ITzy.OTT.dto.BbsComment;
import ITzy.OTT.dto.BbsDto;
import ITzy.OTT.dto.BbsParam;
import ITzy.OTT.service.BbsService;
import ITzy.OTT.util.BbsUtil;

@Controller
public class BbsController {

	@Autowired
	BbsService service;

	@GetMapping(value = "bbslist.do")
	public String bbslist(BbsParam param, Model model) {

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20

		param.setStart(start);
		param.setEnd(end);

		List<BbsDto> list = service.bbslist(param);
		int len = service.getAllBbs(param);

		int pageBbs = len / 10; // 25 / 10 -> 2
		if ((len % 10) > 0) {
			pageBbs = pageBbs + 1;
		}

		if (param.getChoice() == null || param.getChoice().equals("") || param.getSearch() == null || param.getSearch().equals("")) {
			param.setChoice("검색");
			param.setSearch("");
		}

		model.addAttribute("bbslist", list); // 게시판 리스트
		model.addAttribute("pageBbs", pageBbs); // 총 페이지수
		model.addAttribute("pageNumber", param.getPageNumber()); // 현재 페이지
		model.addAttribute("choice", param.getChoice()); // 검색 카테고리
		model.addAttribute("search", param.getSearch()); // 검색어

		return "bbslist";
	}

	@GetMapping(value = "bbswrite.do")
	public String bbswrite() {
		return "bbswrite";
	}

	@PostMapping(value = "bbswriteAf.do")
	public String bbswriteAf(Model model, BbsDto dto, 
			@RequestParam(value = "fileload", required = false) MultipartFile fileload, 
			HttpServletRequest req) {

		// 파일업로드
		// filename 취득
		String filename = fileload.getOriginalFilename(); // 원본의 파일명

		dto.setFilename(filename); // 원본 파일명(DB)

		// upload의 경로 설정
		// server
		String fupload = req.getServletContext().getRealPath("/upload");

		// 폴더
		// String fupload = "c:\\temp";

		System.out.println("fupload:" + fupload);

		// 파일명을 충돌되지 않는 명칭(Date)으로 변경
		String newfilename = BbsUtil.getNewFileName(filename);

		dto.setNewfilename(newfilename); // 변경된 파일명

		File file = new File(fupload + "/" + newfilename);

		try {
			// 실제로 파일 생성 + 기입 = 업로드
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());

			// db에 저장
			service.writeBbs(dto);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// return "message";
		return "redirect:/bbslist.do";

	}

	@GetMapping(value = "bbsdetail.do")
	public String bbsdetail(Model model, int seq) {
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("bbsdto", dto);

		return "bbsdetail";
	}

	@GetMapping(value = "bbsupdate.do")
	public String bbsupdate(Model model, int seq) {
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);

		return "bbsupdate";
	}

	/*
	 * @GetMapping(value = "bbsdelete.do") public String bbsdelete(Model model, int
	 * seq) { BbsDto dto = service.getBbs(seq); model.addAttribute("dto", dto);
	 * 
	 * return "bbsdelete"; }
	 */
	@GetMapping(value = "bbsdeleteAf.do")
	public String bbsdelete(Model model, int seq) {
		BbsDto dto = service.deleteBbs(seq);
		model.addAttribute("dto", dto);

		return "redirect:/bbslist.do";
	}

	@GetMapping(value = "bbsupdateAf.do")
	public String bbsupdateAf(Model model, BbsDto dto) {
		System.out.println(dto.toString());
		boolean isS = service.updateBbs(dto);

		String bbsupdate = "BBS_UPDATE_OK";
		if (!isS) {
			bbsupdate = "BBS_UPDATE_NG";
		}
		model.addAttribute("bbsupdate", bbsupdate);
		model.addAttribute("seq", dto.getSeq());

		return "message";
	}

	@GetMapping(value = "bbsanswer.do")
	public String answer(Model model, int seq) {
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);

		return "bbsanswer";
	}

	@PostMapping(value = "answerAf.do")
	public String answerAf(Model model, int seq, BbsDto dto) {
		dto.setSeq(seq);
		boolean isS = service.answerBbs(dto);
		String answer = "BBS_ANSWER_OK";
		if (isS == false) {
			answer = "BBS_ANSWER_NG";
		}
		model.addAttribute("answer", answer);

		return "message";
	}

	// 댓글
	@PostMapping(value = "commentWriteAf.do")
	public String commentWriteAf(BbsComment bbs) {
		boolean isS = service.commentWrite(bbs);
		if (isS) {
			System.out.println("댓글작성에 성공했습니다");
		} else {
			System.out.println("댓글작성에 실패했습니다");
		}

		return "redirect:/bbsdetail.do?seq=" + bbs.getSeq();
	}

	@ResponseBody
	@GetMapping(value = "commentList.do")
	public List<BbsComment> commentList(int seq) {
		List<BbsComment> list = service.commentList(seq);
		return list;
	}
}
