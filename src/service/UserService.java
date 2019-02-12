package service;

import org.json.JSONObject;

import vo.UserVO;

public interface UserService {
	
	/* User 데이터 삽입하기 Create*/
	public JSONObject createUser(UserVO user);
	
	/*	User 정보 모두 가져오기 Read All */
	public JSONObject selectUser();
	
	/* userIdx로 부터 한명의 User정보 가져오기  Read One*/
	public JSONObject selectUser(int userIdx);
	
	/* user 정보 Update */
	public JSONObject updateUser(UserVO user);
	
	/* userIdx를 통한 User정보 삭제 */
	public JSONObject deleteUser(int userIdx);
	
	
}
