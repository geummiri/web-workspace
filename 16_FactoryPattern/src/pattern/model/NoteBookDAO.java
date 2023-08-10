package pattern.model;

import java.sql.SQLException;

public class NoteBookDAO {
	//싱글톤 패턴 작성
	private static NoteBookDAO dao = new NoteBookDAO();
	
	private NoteBookDAO() {}
	
	public static NoteBookDAO getInstance() {
		return dao;
	}
	
	
	public NoteBook findNoteBook(String model) throws SQLException{
		//디비연결 로직 작성 (작성 완료됐다는 가정하에)
		
		NoteBook notebook = new NoteBook(model, 1000);
		
		
		return notebook;
		
	};
}
