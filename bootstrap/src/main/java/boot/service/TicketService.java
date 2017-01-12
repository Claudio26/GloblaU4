package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.TicketRepository;
import boot.model.Ticket;

@Service
@Transactional
public class TicketService {
	private final TicketRepository ticketRepository;

	public TicketService(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	public List<Ticket> findAll() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		for (Ticket ticket : ticketRepository.findAll()) {
			tickets.add(ticket);
		}
		return tickets;
	}
	public void save(Ticket ticket){
		ticketRepository.save(ticket);
	}
	public void delete(int id){
		ticketRepository.delete(id);
	}
	public Ticket findTicket(int id){
		return ticketRepository.findOne(id);
	}
}
