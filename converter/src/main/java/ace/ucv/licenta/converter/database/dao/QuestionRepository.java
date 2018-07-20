package ace.ucv.licenta.converter.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

	List<Question> findByProfessor(User professor);
	
	Question findByTitle(String title);
}
