package service;

import java.util.List;

import org.json.JSONObject;

import dao.UserDAO;
import dao.UserDAOImpl;
import utils.HttpRequestMsg;
import utils.HttpStatusCode;
import vo.UserVO;

public class UserServiceImpl implements UserService {

	@Override
	public JSONObject createUser(UserVO user) {
		JSONObject object = new JSONObject();
		UserDAO dao = new UserDAOImpl();
		
		int count = dao.createUser(user);
		String statusCode = HttpStatusCode.STATUS_NOT_INSERT;
		String data = HttpRequestMsg.INSERT_USER_FAIL;

		if (count > 0) {
			statusCode = HttpStatusCode.STATUS_OK;
			data = HttpRequestMsg.INSERT_USER_OK;
		}

		object.put("statusCode", statusCode);
		object.put("data", data);
		object.put("count", count);

		return object;
	}

	@Override
	public JSONObject selectUser() {

		List<UserVO> result = null;
		JSONObject object = new JSONObject();
		UserDAO dao = new UserDAOImpl();

		result = dao.selectUser();

		object.put("statusCode", HttpStatusCode.STATUS_OK);
		object.put("data", result);

		return object;
	}

	@Override
	public JSONObject selectUser(int userIdx) {

		JSONObject object = new JSONObject();
		List<UserVO> result = null;
		UserDAO dao = new UserDAOImpl();
		
		String statusCode = HttpStatusCode.STATUS_NOT_FOUND;
		result = dao.selectUser(userIdx);

		if (result.size() != 0) {
			statusCode = HttpStatusCode.STATUS_OK;
			object.put("data", result);
		} else {
			object.put("data", HttpRequestMsg.NOT_FOUND_USER);
		}

		object.put("statusCode", statusCode);

		return object;
	}

	@Override
	public JSONObject updateUser(UserVO user) {
		JSONObject object = new JSONObject();

		return object;
	}

	@Override
	public JSONObject deleteUser(int userIdx) {

		JSONObject object = new JSONObject();
		UserDAO dao = new UserDAOImpl();

		int count = dao.deleteUser(userIdx);
		String statusCode = HttpStatusCode.STATUS_NOT_FOUND;
		String date = HttpRequestMsg.NOT_FOUND_USER;
		
		if (count > 0) {
			statusCode =  HttpStatusCode.STATUS_OK;
			date =  HttpRequestMsg.DELETE_USER_OK;
			object.put("count", count);
		} 
		
		object.put("statusCode", statusCode);
		object.put("data", date);
		object.put("count", count);
		
		return object;
	}
}
