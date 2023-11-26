package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.utility.DBUtility;

// DATABASE OPEARTION


public class StudentDAO {
	public int saveStudent(Student student) throws SQLException {
		// To Load Driver Class // To get Connection
		Connection con = DBUtility.getDBConnection();
		String sql = "insert into student values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		ps.setDouble(3, student.getMarks());

		return ps.executeUpdate();
	}

	public int deleteStudentByID(int id) throws SQLException {

		Connection con = DBUtility.getDBConnection();
		// delete from student where id=?
		String sql = "delete from student where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	public int updateStudent(Student student) throws SQLException {
		Connection con = DBUtility.getDBConnection();
		String sql = "update student set name=? , marks=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student.getName());
		ps.setDouble(2, student.getMarks());
		ps.setInt(3, student.getId());

		return ps.executeUpdate();
	}

	public List<Student> getAllStudents() throws SQLException {
		List<Student> list = new ArrayList<Student>();

		Connection con = DBUtility.getDBConnection();
		String sql = "SELECT * FROM student";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setMarks(rs.getDouble(3));

			list.add(student);
		}

		return list;

	}

	public Student getStudentById(int id) throws SQLException {
		Connection con = DBUtility.getDBConnection();
		String sql = "select * from student where id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		Student student = new Student();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setMarks(rs.getDouble(3));
		}

		return student;

	}


}
