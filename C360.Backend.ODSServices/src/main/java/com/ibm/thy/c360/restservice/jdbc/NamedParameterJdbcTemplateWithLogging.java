package com.ibm.thy.c360.restservice.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ibm.thy.c360.restservice.domain.common.Cons;
import com.ibm.thy.c360.restservice.util.Stopwatch;
import com.ibm.thy.graylog.GrayLogger;
import com.ibm.thy.graylog.LogAttributeHolder;

public class NamedParameterJdbcTemplateWithLogging extends NamedParameterJdbcTemplate{
	
	private static final Logger logger = GrayLogger.getLogger("log." + NamedParameterJdbcTemplateWithLogging.class.getName());

	public NamedParameterJdbcTemplateWithLogging(DataSource dataSource) {
		super(dataSource);
	}
	
	public NamedParameterJdbcTemplateWithLogging(JdbcOperations classicJdbcTemplate) {
		super(classicJdbcTemplate);
	}
	
	
	public <T> T queryForObject(LogAttributeHolder lah, String sql, SqlParameterSource paramSource, Class<T> requiredType)
			throws DataAccessException {
		
		Stopwatch sw = new Stopwatch();
		GrayLogger.logPurgeParams();

		try {
			
			if(logger.isDebugEnabled()){
				String [] p = new String[]{((MapSqlParameterSource)paramSource).getValues().toString()}; // new String[]{("X","Y"}
				lah.setAction(Cons.JDBC_PRE);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement started for : " + lah.getPurpose());
			}
			
			T r = queryForObject(sql, paramSource, new SingleColumnRowMapper<T>(requiredType));
			
			if(logger.isDebugEnabled()){
				String [] p = new String[]{((MapSqlParameterSource)paramSource).getValues().toString()}; // new String[]{("X","Y"}
				lah.setAction(Cons.JDBC_POST);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement ended for : " + lah.getPurpose());
				GrayLogger.logPurgeParams();
			}
			
			return r;
			
		} catch (Exception e) {
			e.printStackTrace();
			if(logger.isDebugEnabled()){
				String [] p = new String[]{((MapSqlParameterSource)paramSource).getValues().toString()}; // new String[]{("X","Y"}
				lah.setAction(Cons.JDBC_EXC);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.error(lah.getInterfase() + " " + lah.getOperation() + " statement error for : " + lah.getPurpose(), e);
				GrayLogger.logPurgeParams();
			}
			throw e;
		}
	}
	
	public <T> List<T> query(LogAttributeHolder lah, String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper)
			throws DataAccessException {

		Stopwatch sw = new Stopwatch();
		GrayLogger.logPurgeParams();
		
		try {
			
			if(logger.isDebugEnabled()){
				String [] p = new String[]{((MapSqlParameterSource)paramSource).getValues().toString()}; // new String[]{("X","Y"}
				lah.setAction(Cons.JDBC_PRE);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement started for : " + lah.getPurpose());
			}
			
			List<T> r = getJdbcOperations().query(getPreparedStatementCreator(sql, paramSource), rowMapper);
			
			if(logger.isDebugEnabled()){
				String [] p = new String[]{((MapSqlParameterSource)paramSource).getValues().toString()}; // new String[]{("X","Y"}
				lah.setAction(Cons.JDBC_POST);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement ended for : " + lah.getPurpose());
				GrayLogger.logPurgeParams();
			}
			
			return r ;
		} catch (Exception e) {
			e.printStackTrace();
			if(logger.isDebugEnabled()){
				String [] p = new String[]{((MapSqlParameterSource)paramSource).getValues().toString()}; // new String[]{("X","Y"}
				lah.setAction(Cons.JDBC_EXC);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.error(lah.getInterfase() + " " + lah.getOperation() + " statement error for : " + lah.getPurpose(), e);
				GrayLogger.logPurgeParams();
			}
			throw e;
		}
	}
	
	public <T> List<T> query(LogAttributeHolder lah, String sql, RowMapper<T> rowMapper) throws DataAccessException {

		Stopwatch sw = new Stopwatch();
		GrayLogger.logPurgeParams();
		
		try {
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_PRE);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement started for : " + lah.getPurpose());
			}
			
			List<T> r = getJdbcOperations().query(getPreparedStatementCreator(sql, EmptySqlParameterSource.INSTANCE), rowMapper);
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_POST);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement ended for : " + lah.getPurpose());
				GrayLogger.logPurgeParams();
			}
			
			return r ;
		} catch (Exception e) {
			e.printStackTrace();
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_EXC);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.error(lah.getInterfase() + " " + lah.getOperation() + " statement error for : " + lah.getPurpose(), e);
				GrayLogger.logPurgeParams();
			}
			throw e;
		}
	
	}
	
	public int update(LogAttributeHolder lah, String sql, SqlParameterSource paramSource) throws DataAccessException {
		
		Stopwatch sw = new Stopwatch();
		GrayLogger.logPurgeParams();
		
		
		try {
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_PRE);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement started for : " + lah.getPurpose());
			}
			
			
			int r = getJdbcOperations().update(getPreparedStatementCreator(sql, paramSource));
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_POST);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement ended for : " + lah.getPurpose());
				GrayLogger.logPurgeParams();
			}
			
			
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_EXC);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.error(lah.getInterfase() + " " + lah.getOperation() + " statement error for : " + lah.getPurpose(), e);
				GrayLogger.logPurgeParams();
			}
			
			throw e;
		}
	}
	
	public <T> List<T> query(LogAttributeHolder lah, String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper)
			throws DataAccessException {
		
		Stopwatch sw = new Stopwatch();
		GrayLogger.logPurgeParams();
		
		try {
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_PRE);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement started for : " + lah.getPurpose());
			}
			
			
			List<T> r = query(sql, new MapSqlParameterSource(paramMap), rowMapper);

			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_POST);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement ended for : " + lah.getPurpose());
				GrayLogger.logPurgeParams();
			}
			
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(logger.isDebugEnabled()){
				String [] p = {("")};
				lah.setAction(Cons.JDBC_EXC);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);				
				logger.error(lah.getInterfase() + " " + lah.getOperation() + " statement error for : " + lah.getPurpose(), e);
				GrayLogger.logPurgeParams();
			}
			
			throw e;
		}
	}
	

}
