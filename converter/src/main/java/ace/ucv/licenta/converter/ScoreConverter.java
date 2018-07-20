package ace.ucv.licenta.converter;

import java.util.ArrayList;
import java.util.List;

import ace.ucv.licenta.converter.business.dto.ScoreKeeperDTO;
import ace.ucv.licenta.converter.core.dto.ScoreKeeper;

public class ScoreConverter {

	public List<ScoreKeeper> converToModel(List<ScoreKeeperDTO> scores) {
		List<ScoreKeeper> newScores = new ArrayList<>();
		for (ScoreKeeperDTO score : scores) {
			ScoreKeeper newScore = new ScoreKeeper();
			newScore.setPath(score.getPath());
			newScore.setAuthor(score.getAuthor());
			newScore.setVsm(score.getVsm());
			newScore.setBigram(score.getBigram());
			newScore.setLanguageAnalyzer(score.getLanguageAnalyzer());
			newScore.setStatus(score.getStatus());
			newScores.add(newScore);
		}
		return newScores;
	}
}
