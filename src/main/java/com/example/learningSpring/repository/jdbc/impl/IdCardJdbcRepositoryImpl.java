package com.example.learningSpring.repository.jdbc.impl;

import com.example.learningSpring.model.entity.IdCard;
import com.example.learningSpring.repository.jdbc.IdCardJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IdCardJdbcRepositoryImpl implements IdCardJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<IdCard> getAll() {
        String query = "SELECT i.id, i.name, i.surname, i.age, i.fin_code, i.series, i.serial_number FROM vs_learning.id_card i;";

        RowMapper<IdCard> rowMapper = new RowMapper<>() {
            @Override
            public IdCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                return buildIdCard(rs);
            }
        };

        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public IdCard getById(Long id) {
        String query = "SELECT i.id, i.name, i.surname, i.age, i.fin_code, i.series, i.serial_number FROM vs_learning.id_card i WHERE i.id = ?";

        RowMapper<IdCard> rowMapper = new RowMapper<IdCard>() {
            @Override
            public IdCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                return buildIdCard(rs);
            }
        };

        List<IdCard> idCards = jdbcTemplate.query(query, rowMapper, id);

        return idCards.stream()
                .findFirst()
                .orElse(IdCard.builder().build());

//        if (idCards.isEmpty()) {
//            return IdCard.builder() //TODO: json problem verir bu hissede null Integer ile bagli
//                    .build();
//        }
//
//        return idCards.get(0);
    }

    @Override
    public boolean insert(IdCard idCard) {
        String query = "INSERT INTO vs_learning.id_card (name, surname, age, fin_code, series, serial_number) VALUES (?, ?, ?, ?, ?, ?);";

        int res = jdbcTemplate.update(query, idCard.getName(), idCard.getSurname(), idCard.getAge(), idCard.getFinCode(), idCard.getSeries(), idCard.getSerialNumber());

        return res != 0;
    }

    @Override
    public boolean update(IdCard idCard) {
        String query = "UPDATE vs_learning.id_card i SET i.name = ?, i.surname = ?, i.age = ?, i.fin_code = ?, series = ?, i.serial_number = ? WHERE i.id = ?";

        int res = jdbcTemplate.update(query, idCard.getName(), idCard.getSurname(), idCard.getAge(), idCard.getFinCode(), idCard.getSeries(), idCard.getSerialNumber(), idCard.getId());

        return res != 0;
    }

    @Override
    public boolean updateAge(Long id, Integer age) {
        String query = "UPDATE vs_learning.id_card i SET i.age = ? WHERE i.id = ?";

        int res = jdbcTemplate.update(query, age, id);

        return res != 0;
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM vs_learning.id_card i WHERE i.id = ?;";

        int res = jdbcTemplate.update(query, id);

        return res != 0;
    }

    private IdCard buildIdCard(ResultSet rs) throws SQLException {
        return IdCard.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .age(rs.getInt("age"))
                .finCode(rs.getString("fin_code"))
                .series(rs.getString("series"))
                .serialNumber(rs.getString("serial_number"))
                .build();
    }
}
