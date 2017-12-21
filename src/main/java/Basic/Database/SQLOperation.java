package Basic.Database;

import com.mysql.cj.api.mysqla.result.Resultset;

import java.sql.*;

public class SQLOperation {
    private static String url = "jdbc:mysql://121.42.158.62:3306/Test";
    private static String username = "root";
    private static String pw = "123456";
    private static Connection conn = null;
    public static void main(String[] args){
        //CreateTable();
        //DeleteTable()
        //UpdateValue("user");
        //DeleteValue("user");
        //InsertValue("user");

        ExamplePrepareStatement("linweiyu");
    }

    public static Connection GetDataBaseConnection(){
        if(conn != null){
            return conn;
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pw);
        }catch (ClassNotFoundException ee){
            ee.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    //execute函数： @return <code>true</code> if the first result is a <code>ResultSet</code>
    //              object; <code>false</code> if it is an update count or there are
    //             no results
    public static boolean ExecuteSqlCommon(String sql){
        Connection conn = GetDataBaseConnection();
        boolean result = false;
        Statement statement = null;
        try{
            statement = conn.createStatement();
            result = statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException ee){
                ee.printStackTrace();
            }
        }
        return  result;
    }

    public static ResultSet ExecuteSqlCommonQuery(String sql){
        Connection conn = GetDataBaseConnection();
        ResultSet result = null;
        Statement statement = null;
        try{
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static void CreateTable(){
        String sql = "create table user(name varchar(255), password varchar(255));";
        ExecuteSqlCommon(sql);
    }

    public static void DeleteTable(){
        String sql = "drop table user";
        ExecuteSqlCommon(sql);
    }

    public static void InsertValue(String table){
        String sql = "insert into " + table + " values('weirdo', '123456');";
        ExecuteSqlCommon(sql);
    }

    public static void UpdateValue(String table){
        String sql = "update " + table + " set password='newpassword' where name='linweiyu';";
        ExecuteSqlCommon(sql);
    }

    public static void DeleteValue(String table){
        String sql = "delete from " + table + " where name='linweiyu';";
        ExecuteSqlCommon(sql);
    }

    public static void SelectValue(){
        String sql = "select * from user";
        ResultSet resultSet = ExecuteSqlCommonQuery(sql);
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            while(resultSet.next()){
                for(int i = 1; i <= columns; i++){
                    System.out.print(resultSet.getString(i));
                    System.out.print("\t\t");
                }
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void ExamplePrepareStatement(String username){
        Connection conn = GetDataBaseConnection();
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user where name=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            while(resultSet.next()){
                for(int i = 1; i <= columns; i++){
                    System.out.print(resultSet.getString(i));
                    System.out.print("\t");
                }
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
