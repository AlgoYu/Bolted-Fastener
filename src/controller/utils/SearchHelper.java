package controller.utils;

import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import modle.bean.Bolt;
import modle.bean.Gasket;
import modle.bean.Nut;

public class SearchHelper extends MyJDBC{
	
	public String SearchBolt(String name){
		String data = "null";
		Bolt bolt = null;
		try {
			ConnectDatabase();
			String SQL = "SELECT * FROM bolt WHERE bolt.`name` = '"+name+"';";
			System.out.println("执行的SQL语句："+SQL);
			resultSet = statement.executeQuery(SQL);
			while(resultSet.next()){
				bolt = new Bolt();
				bolt.setName(resultSet.getString("name"));
				bolt.setP_a(resultSet.getString("p_a"));
				bolt.setB_b(resultSet.getString("b_b"));
				bolt.setB_c(resultSet.getString("b_c"));
				bolt.setB_d(resultSet.getString("b_d"));
				bolt.setC_max(resultSet.getString("c_max"));
				bolt.setD_a_max(resultSet.getString("d_a_max"));
				bolt.setD_s_max(resultSet.getString("d_s_max"));
				bolt.setD_s_min(resultSet.getString("d_s_min"));
				bolt.setD_w_min(resultSet.getString("d_w_min"));
				bolt.setE_min(resultSet.getString("e_min"));
				bolt.setK_nominal(resultSet.getString("k_nominal"));
				bolt.setK_max(resultSet.getString("k_max"));
				bolt.setK_min(resultSet.getString("k_min"));
				bolt.setK_w_e_min(resultSet.getString("k_w_e_min"));
				bolt.setR_min(resultSet.getString("r_min"));
				bolt.setS_nominal_max(resultSet.getString("s_nominal_max"));
				bolt.setS_min(resultSet.getString("s_min"));
				bolt.setLs_lg(resultSet.getString("ls_lg"));
			}
			CloseDatabseConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bolt!=null){
			data = gson.toJson(bolt);
		}
		return data;
	}
	
	public String SearchNut(String name){
		String data = "null";
		Nut nut = null;
		try {
			ConnectDatabase();
			String SQL = "SELECT * FROM nut WHERE nut.`name` = '"+name+"';";
			System.out.println("执行的SQL语句："+SQL);
			resultSet = statement.executeQuery(SQL);
			while(resultSet.next()){
				nut = new Nut();
				nut.setName(resultSet.getString("name"));
				nut.setP_a(resultSet.getString("p_a"));
				nut.setC_max(resultSet.getString("c_max"));
				nut.setC_min(resultSet.getString("c_min"));
				nut.setD_a_max(resultSet.getString("d_a_max"));
				nut.setD_a_min(resultSet.getString("d_a_min"));
				nut.setD_w_min(resultSet.getString("d_w_min"));
				nut.setE_min(resultSet.getString("e_min"));
				nut.setM_max(resultSet.getString("m_max"));
				nut.setM_min(resultSet.getString("m_min"));
				nut.setM_w_min(resultSet.getString("m_w_min"));
				nut.setS_nominal_max(resultSet.getString("s_nominal_max"));
				nut.setS_min(resultSet.getString("s_min"));
			}
			CloseDatabseConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nut!=null){
			data = gson.toJson(nut);
		}
		return data;
	}
	
	public String SearchGasket(String name){
		String data = "null";
		Gasket gasket = null;
		try {
			ConnectDatabase();
			String SQL = "SELECT * FROM gasket WHERE gasket.`name` = '"+name+"';";
			System.out.println("执行的SQL语句："+SQL);
			resultSet = statement.executeQuery(SQL);
			while(resultSet.next()){
				gasket = new Gasket();
				gasket.setName(resultSet.getString("name"));
				gasket.setD1_nominal_min(resultSet.getString("d1_nominal_min"));
				gasket.setD1_max(resultSet.getString("d1_max"));
				gasket.setD2_nominal_max(resultSet.getString("d2_nominal_max"));
				gasket.setD2_min(resultSet.getString("d2_min"));
				gasket.setH_nominal(resultSet.getString("h_nominal"));
				gasket.setH_max(resultSet.getString("h_max"));
				gasket.setH_min(resultSet.getString("h_min"));
			}
			CloseDatabseConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resultSet = null;
			}
		}
		if(gasket!=null){
			data = gson.toJson(gasket);
		}
		return data;
	}
}
