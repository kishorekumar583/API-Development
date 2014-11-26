package com.college.admin.dao.data;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

	public static final String COLLEGE_JNDI_NAME = "java:/jdbc/college";

	protected static final String NOT_FOUND = " Not Found";

	protected static final String DATABASE_ERROR = "Unable to perform database operations";

	protected static final String ACTIVE_SWITCH = "Y";
	/*
	 * @Inject private CollegeServierUtil collegeServiceUtil;
	 */

	@Inject
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Inject
	private DataSource dataSource;

	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	protected <T> T fetchObject(String sql, SqlParameterSource params, RowMapper<T> rowMapper) throws EmptyResultDataAccessException {
		return getNamedParameterJdbcTemplate().queryForObject(sql, params, rowMapper);
	}

	protected <T> T fetchObject(String sql, SqlParameterSource params, Class<T> classType) throws EmptyResultDataAccessException {
		return getNamedParameterJdbcTemplate().queryForObject(sql, params, classType);
	}

	protected <T> T fetchObject(String sql, Map params, RowMapper<T> rowMapper) throws EmptyResultDataAccessException {
		return (T) getNamedParameterJdbcTemplate().queryForObject(sql, params, rowMapper);
	}

	protected <T> List<T> fetchObjects(String sql, SqlParameterSource params, RowMapper<T> rowMapper) {
		return getNamedParameterJdbcTemplate().query(sql, params, rowMapper);
	}

	protected <T> List<T> fetchObjects(String sql, Map params, RowMapper<T> rowMapper) {
		return getNamedParameterJdbcTemplate().query(sql, params, rowMapper);
	}

	protected int updateObject(String sql, SqlParameterSource params) {
		return getNamedParameterJdbcTemplate().update(sql, params);
	}

	protected int insertObject(String sql, SqlParameterSource params, KeyHolder generatedKeyHolder, String... keyColumnNames) {
		return getNamedParameterJdbcTemplate().update(sql, params, generatedKeyHolder, keyColumnNames);
	}

	protected int insertObject(String sql, SqlParameterSource params) {
		return getNamedParameterJdbcTemplate().update(sql, params);
	}

}
