package dao;

import java.util.List;

import vo.UserVO;

public interface UserDAO {
	
	/* User 데이터 삽입하기 Create*/
	public int createUser(UserVO user);
	
	/*	User 정보 모두 가져오기 Read All */
	public List<UserVO> selectUser();
	
	/* userIdx로 부터 한명의 User정보 가져오기  Read One*/
	public List<UserVO> selectUser(int userIdx);
	
	/* user 정보 Update */
	public int updateUser(UserVO user);
	
	/* userIdx를 통한 User정보 삭제 */
	public int deleteUser(int userIdx);
	
	
}
