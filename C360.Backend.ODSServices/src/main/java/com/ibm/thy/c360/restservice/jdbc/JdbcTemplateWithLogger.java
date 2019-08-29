package com.ibm.thy.c360.restservice.jdbc;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ibm.thy.c360.restservice.domain.common.Cons;
import com.ibm.thy.c360.restservice.util.Stopwatch;
import com.ibm.thy.graylog.GrayLogger;
import com.ibm.thy.graylog.LogAttributeHolder;

public class JdbcTemplateWithLogger extends JdbcTemplate {

	private static final Logger logger = GrayLogger.getLogger("log." + JdbcTemplateWithLogger.class.getName());

	
	public JdbcTemplateWithLogger(DataSource dataSource) {
		super(dataSource);
	}

	public int update(LogAttributeHolder lah,String sql, Object... args) throws DataAccessException {
		
		Stopwatch sw = new Stopwatch();
		GrayLogger.logPurgeParams();
		
		try {
			
			if(logger.isDebugEnabled()){
				String[] p = new String[]{Arrays.toString(args)};
				lah.setAction(Cons.JDBC_PRE);
				lah.setElapsedTime(sw.elapsedTimeMiliSecondString());
				GrayLogger.logPreSql(lah, sql, p);
				logger.debug(lah.getInterfase() + " " + lah.getOperation() + " statement started for : " + lah.getPurpose());
			}
			
			int r = update(sql, newArgPreparedStatementSetter(args));
			
			if(logger.isDebugEnabled()){
				String[] p = new String[]{Arrays.toString(args)};
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
				String[] p = new String[]{Arrays.toString(args)};
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
