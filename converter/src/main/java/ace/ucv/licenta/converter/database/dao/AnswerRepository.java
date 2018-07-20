package ace.ucv.licenta.converter.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	List<Answer> findByQuestion(Question questionEntity);


}
