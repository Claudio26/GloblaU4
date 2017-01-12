package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Ticket;
import boot.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-tickets")
	public String allTickets(HttpServletRequest request){
		request.setAttribute("tickets",ticketService.findAll());
		request.setAttribute("mode","MODE_TICKETS");
		return "ticket";
	}
	
	@GetMapping("/new-ticket")
	public String newTicket(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "ticket";
	}
	@PostMapping("/save-ticket")
	public String saveTicket(@ModelAttribute Ticket ticket,BindingResult bindingResult, HttpServletRequest request){
		ticketService.save(ticket);
		request.setAttribute("tickets",ticketService.findAll());
		request.setAttribute("mode","MODE_TICKETS");
		return "ticket";
	}
	
	
	@GetMapping("/update-ticket")
	public String updateTicket(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("ticket",ticketService.findTicket(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "ticket";
	}
	@GetMapping("/delete-ticket")
	public String deleteTicket(@RequestParam int id,HttpServletRequest request){
		ticketService.delete(id);
		request.setAttribute("tickets",ticketService.findAll());
		request.setAttribute("mode","MODE_TICKETS");
		return "ticket";
	}
}
