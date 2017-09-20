package com.deep.service.common.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by longyuntao on 2014/12/12.
 */
public abstract class DBUtils {

    public static Boolean setAutoCommit(Connection connection, boolean autoCommit) {
        try {
            boolean pre = connection.getAutoCommit();
            connection.setAutoCommit(autoCommit);
            return pre;
        } catch (SQLException ignored) {
        }
        return null;
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException ignored) {
        }
    }

    public static void commit(Connection connection) {
        try {
            connection.commit();
        } catch (SQLException ignored) {
        }
    }

    public static void close(Object object) {
        if (object == null) return;
        if (object instanceof Connection) {
            closeConnection((Connection) object);
        } else if (object instanceof Statement) {
            closeStatement((Statement) object);
        } else if (object instanceof ResultSet) {
            closeResultSet((ResultSet) object);
        }
    }

    private static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ignored) {
        }
    }

    private static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException ignored) {
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException ignored) {
        }
    }
}
