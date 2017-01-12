package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Seq;

public interface SeqRepository extends CrudRepository<Seq, Integer>{

}
