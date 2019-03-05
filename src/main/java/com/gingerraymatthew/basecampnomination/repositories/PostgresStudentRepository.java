package com.gingerraymatthew.basecampnomination.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gingerraymatthew.basecampnomination.forms.StudentForm;

@Repository
public class PostgresStudentRepository implements com.gingerraymatthew.basecampnomination.repositories.Repository<StudentForm> {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresStudentRepository(JdbcTemplate jdbtemplate) {
        jdbc = jdbtemplate;
    }

    public void save(StudentForm student) {

        jdbc.update("INSERT INTO students (name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", student.name, student.email,
        student.school, student.eligibility, student.age, student.phoneNumber, student.graduation, student.plan, student.aptitude, student.dedication, student.passion, student.basecamp);
    }

    public Optional<StudentForm> findById(Integer id) {
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students where id = ?", this::mapRowToStudent, id));
    }

    public List<StudentForm> findAll() {
        return jdbc.query("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students ORDER BY id ASC", this::mapRowToStudent);
    }

    public List<StudentForm> oldest() {
        return jdbc.query("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students WHERE eligibility = true ORDER BY id ASC", this::mapRowToStudent);
    }

    public List<StudentForm> newest() {
        return jdbc.query("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students WHERE eligibility = true ORDER BY id DESC", this::mapRowToStudent);
    }

    public List<StudentForm> abc() {
        return jdbc.query("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students WHERE eligibility = true ORDER BY name ASC", this::mapRowToStudent);
    }

    public List<StudentForm> ineligible() {
        return jdbc.query("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students WHERE eligibility = false ORDER BY name ASC", this::mapRowToStudent);
    }

    public Boolean check(String email) {
        String sql = "SELECT * FROM students WHERE email = " + email;
        List<StudentForm> table = jdbc.query("SELECT id, name, email, school, eligibility, age, phoneNumber, graduation, plan, aptitude, dedication, passion, basecamp FROM students where email = ?", this::mapRowToStudent, email);
        if (table.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public StudentForm mapRowToStudent(ResultSet row, int rowNum) throws SQLException{
        return new StudentForm(
                row.getInt("id"),
                row.getString("name"),
                row.getString("email"),
                row.getString("school"),
                row.getBoolean("eligibility"),
                row.getInt("age"),
                row.getString("phoneNumber"),
                row.getDate("graduation"),
                row.getString("plan"),
                row.getString("aptitude"),
                row.getString("dedication"),
                row.getString("passion"),
                row.getString("basecamp"));
    }
}


