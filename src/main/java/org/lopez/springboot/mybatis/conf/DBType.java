package org.lopez.springboot.mybatis.conf;

/**
 * 数据源类型
* 
* @author hugr
*
*/
public enum DBType {
    /** MYSQL **/
    MYSQL("mysql"),
    /** ORACLE **/
    ORACLE("oracle"),
    /** DB2 **/
    DB2("db2"),
    /** MSSQL **/
    MSSQL("mssql");

    DBType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
}
