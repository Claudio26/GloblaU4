package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
