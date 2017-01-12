package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Seq;
import boot.service.SeqService;

@Controller
public class SeqController {
	@Autowired
	private SeqService seqService;
	
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-seqs")
	public String allSeqs(HttpServletRequest request){
		request.setAttribute("seqs",seqService.findAll());
		request.setAttribute("mode","MODE_SEQS");
		return "seq";
	}
	
	@GetMapping("/new-seq")
	public String newSeq(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "seq";
	}
	@PostMapping("/save-seq")
	public String saveSeq(@ModelAttribute Seq seq,BindingResult bindingResult, HttpServletRequest request){
		seqService.save(seq);
		request.setAttribute("seqs",seqService.findAll());
		request.setAttribute("mode","MODE_SEQS");
		return "seq";
	}
	
	
	@GetMapping("/update-seq")
	public String updateSeq(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("seq",seqService.findSeq(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "seq";
	}
	@GetMapping("/delete-seq")
	public String deleteSeq(@RequestParam int id,HttpServletRequest request){
		seqService.delete(id);
		request.setAttribute("seqs",seqService.findAll());
		request.setAttribute("mode","MODE_SEQS");
		return "seq";
	}
}
