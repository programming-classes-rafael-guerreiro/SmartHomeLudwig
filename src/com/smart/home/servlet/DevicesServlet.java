package com.smart.home.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smart.home.model.UserDevice;

@WebServlet({"/devices", "/"})
public class DevicesServlet extends HttpServlet {

	@Override // GET = Leitura
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Unable to locate mysql driver. " + e.getMessage());
			return;
		}

		UserDevice[] data = new UserDevice[2] ;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartHome", "root", "")) {

			StringBuilder sqlStatement = new StringBuilder();
			sqlStatement.append("select u.user_id, u.name as user_name, d.device_id, d.name as device_name ");
			sqlStatement.append("from users u ");
			sqlStatement.append("join devices d on u.user_id = d.user_id ");

			PreparedStatement sql = connection.prepareStatement(sqlStatement.toString());
			ResultSet result = sql.executeQuery();

			int i = 0;
			while (result.next()) {
				data[i++] = new UserDevice(result.getInt("user_id"), result.getString("user_name"), result.getInt("device_id"), result.getString("device_name"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect to database. " + e.getMessage());
		}

		//String chave = req.getParameter("chave");
		req.setAttribute("chave", data);
		
		//chave = "teste";
		
		// send data to devices.jsp
		req.getRequestDispatcher("WEB-INF/jsp/devices.jsp").forward(req, resp);
	}

	@Override // POST = Criação
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

	@Override // PUT - Alteração
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

	@Override // DELETE - Exclusão
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
}
