package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.SeqRepository;
import boot.model.Seq;

@Service
@Transactional
public class SeqService {
	private final SeqRepository seqRepository;

	public SeqService(SeqRepository seqRepository) {
		super();
		this.seqRepository = seqRepository;
	}

	public List<Seq> findAll() {
		List<Seq> seqs = new ArrayList<Seq>();
		for (Seq seq : seqRepository.findAll()) {
			seqs.add(seq);
		}
		return seqs;
	}
	public void save(Seq seq){
		seqRepository.save(seq);
	}
	public void delete(int id){
		seqRepository.delete(id);
	}
	public Seq findSeq(int id){
		return seqRepository.findOne(id);
	}
}
