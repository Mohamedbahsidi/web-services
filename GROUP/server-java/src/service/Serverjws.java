package service;


import java.sql.SQLException;

import javax.xml.ws.Endpoint;


public class Serverjws {

	public static void main(String[] args) throws Exception {
				// TODO Auto-generated method stub
		String url="http://localhost:8586/";
		Endpoint.publish(url,new EtudiantService());
		System.out.println(url);
	}

}
