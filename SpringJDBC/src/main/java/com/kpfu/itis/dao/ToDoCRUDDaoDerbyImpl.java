package com.kpfu.itis.dao;

import com.kpfu.itis.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository(value = "toDoDao")
public class ToDoCRUDDaoDerbyImpl  implements CRUDDao<ToDo>{
    @Autowired
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<ToDo> getAll() {
        List<ToDo> toDos = new ArrayList<>();
        String sql = "SELECT id,Todo_title,Todo_start,Todo_end from Todo";
        List<Map<String, Object>> rows = template.queryForList(sql);
        for (Map row : rows) {
            ToDo ToDo = new ToDo();
            ToDo.setId((Long) row.get("id"));
            ToDo.setTitle((String) row.get("Todo_title"));
            ToDo.setStart((String) row.get("Todo_start"));
            ToDo.setEnd((String) row.get("Todo_end"));
            toDos.add(ToDo);
        }
        return toDos;
    }

    @Override
    public void save(ToDo obj) {
        String query = "INSERT INTO Todo(Todo_title,Todo_start,Todo_end) values(?,?,?)";
        template.update(query, obj.getTitle(), obj.getStart(), obj.getEnd());
    }

    @Override
    public void update(ToDo obj) {
        String query = "UPDATE Todo SET Todo_title = ?, Todo_end = ? where id = ?";
        template.update(query, obj.getTitle(),obj.getEnd(),obj.getId());
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM Todo where id =?";
        template.update(query, id);
    }

    public ToDo getTodoById(final Long id) {
        String query = "SELECT Todo_title,Todo_start,Todo_end FROM Todo WHERE id = ?";
        return template.queryForObject(query, new ParameterizedRowMapper<ToDo>() {
            @Override
            public ToDo mapRow(ResultSet rs, int rowNum) throws SQLException {
                ToDo toDo = new ToDo();
                toDo.setId(id);
                toDo.setTitle(rs.getString("Todo_title"));
                toDo.setStart(rs.getString("Todo_start"));
                toDo.setEnd(rs.getString("Todo_end"));
                return toDo;
            }
        }, id);
    }

}
