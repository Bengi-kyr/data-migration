package org.lopez.springboot.mybatis.conf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.ognl.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class DialectHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DialectHandlerAdapter.class);

    private static final String DATA_SOURCE = "dataSource";

    private static DBType dbType;

    /**
     * 初始化数据源类型
     * 
     * @throws Exception
     */
    private static void initializeDbType() throws Exception {
        ApplicationContext context = ApplicationContextRegister.getApplicationContext();
        Object object = context.getBean(DATA_SOURCE);

        String databaseId = "";
        if (null != object) {
            DataSource dataSource = (DataSource) object;
            try {
                databaseId = dataSource.getConnection().getMetaData().getDatabaseProductName();
            } catch (SQLException e) {
                throw new SQLException(
                    String.format("{0} get databaseid by {1} from spring context failed.",
                        DialectHandlerAdapter.class, org.mybatis.spring.SqlSessionTemplate.class),
                    e);
            }
        } else {
            object = context.getBean(org.mybatis.spring.SqlSessionTemplate.class);
            SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) object;
            databaseId = sqlSessionTemplate.getConfiguration().getDatabaseId();
        }

        if (null == databaseId || "".equals(databaseId)) {
            throw new Exception(String.format("{0} get databaseid from spring context failed.",
                DialectHandlerAdapter.class));
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("mybatis dialect set is " + databaseId);
        }

        DialectHandlerAdapter.dbType = DBType.valueOf(databaseId.toUpperCase());
    }

    /**
             * 获取数据源类型 
             * 方言处理前必须调用此方法
     * 
     * @return
     * @throws Exception
     */
    public static DBType getDialect() throws Exception {
        if (null == dbType) {
            initializeDbType();
        }
        return dbType;
    }

    /**
     * 日期函数替换
     * 
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static String currentDate() throws ParseException, Exception {

        getDialect();

        String result = "";
        switch (dbType) {
        case MYSQL:
            result = "now()";
            break;
        case ORACLE:
            result = "sysdate";
            break;
        default:
            break;
        }
        return result;
    }

    /**
     * 取第一条数据
     * 
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static String firstRow() throws ParseException, Exception {

        getDialect();

        String result = "";
        switch (dbType) {
        case MYSQL:
            result = " limit 1";
            break;
        case ORACLE:
            result = " where rownum = 1";
            break;
        default:
            break;
        }
        return result;
    }

    /**
     * mysql delete 使用别名需要在delete后加上别名
     * 
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static String deleteDialect() throws ParseException, Exception {

        getDialect();

        String result = "";
        switch (dbType) {
        case MYSQL:
            result = " temp ";
            break;
        case ORACLE:
            result = " ";
            break;
        default:
            break;
        }
        return result;
    }

    /**
     *  字符串转日期
     * 
     * @param date
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static String strToDate(String date) throws ParseException, Exception {

        getDialect();

        String result = "";
        switch (dbType) {
        case MYSQL:
            result = " str_to_date('" + date + "', '%Y-%m-%d %H:%i:%S'" + ") ";
            break;
        case ORACLE:
            result = " to_date('" + date + "', 'yyyy-MM-dd HH24:mi:ss'" + ") ";
            break;
        default:
            break;
        }
        return result;
    }

    /**
     * 字符串转日期
     * 
     * @param date
     * @param format
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static String strToDateWithFormat(String date, String format)
        throws ParseException, Exception {

        getDialect();

        String result = "";
        switch (dbType) {
        case MYSQL:
            result = " str_to_date('" + date + "', " + "'" + format + "'" + ") ";
            break;
        case ORACLE:
            result = " to_date('" + date + "', " + "'" + format + "'" + ") ";
            break;
        default:
            break;
        }
        return result;
    }

    /**
     * 字符串转数字
     * 
     * @param number
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static String strToNumber(String number) throws ParseException, Exception {

        getDialect();

        String result = "";
        switch (dbType) {
        case MYSQL:
            result = " convert('" + number + "', double" + ") ";
            break;
        case ORACLE:
            result = " to_number('" + number + "') ";
            break;
        default:
            break;
        }
        return result;
    }
}
