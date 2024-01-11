
public class JdbcTranscriptDao implements TranscriptDao{
	
	/**
	 * Constructor
	 */
	public JdbcTranscriptDao() {
		super();
	}
	
	/**
	 * the rest of these methods all simply use their matching method in the TranscriptDao, these just run them
	 * @param id
	 * @return
	 */
	public Transcript getTrans(int id) {
		
		return TranscriptDao.getTrans(id);
	}
}
