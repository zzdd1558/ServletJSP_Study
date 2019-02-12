package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utils.DBUtil;
import vo.UserVO;

public class UserDAOImpl implements UserDAO{
	
	@Override
	public int createUser(UserVO user) {
		
		SqlSession session = DBUtil.getSqlSession(true);
		int count = 0;
		
		
		try {
			count = session.insert("sql.user.insertUser", user);
		}catch (Exception e) {
			System.out.println("createUser Error :: " + e.getMessage());
		}finally {
			session.close();
		}
		
		return count;
	}

	@Override
	public List<UserVO> selectUser() {
		
		SqlSession session = DBUtil.getSqlSession(true);
		List<UserVO> selectAll = null;
		
		try {
			selectAll = session.selectList("sql.user.selectAllUser");
		}catch (Exception e) {
			e.printStackTrace();
			session.close();
			// TODO: handle exception
		}
		return selectAll;
	}

	@Override
	public List<UserVO> selectUser(int userIdx) {
		SqlSession session = DBUtil.getSqlSession(true);
		List<UserVO> selectAll = null;
		UserVO user = null;
		
		try {
			selectAll = new ArrayList<UserVO>();
			user = session.selectOne("sql.user.selectOneUser" , userIdx);
			
			if (user != null) {
				selectAll.add(user);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			session.close();
			// TODO: handle exception
		}
		return selectAll;
	}

	@Override
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int userIdx) {
		
		SqlSession session = DBUtil.getSqlSession(true);
		int count = 0;
		
		try {
			count = session.delete("sql.user.deleteUser" , userIdx);
		}catch (Exception e) {
			e.printStackTrace();
			session.close();
			// TODO: handle exception
		}
		
		return count;
	}

	
}
