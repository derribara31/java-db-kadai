package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;


public class Scores_Chapter10 {
	public static void main(String[] args) {

        Connection con = null;
        Statement statement = null;
    

        try {
            // データベースに接続
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost/challenge_java",
                "root",
                "1236koki"
            );

            System.out.println("データベース接続成功");
            System.out.println("レコード開始を実行します");
        
            
            statement  = con.createStatement();
            String sql = "UPDATE scores SET score_math = 95 , score_english = 80 where id = 5;";
            		
            System.out.println("レコード更新:" + statement.toString() );
            int rowCnt = statement.executeUpdate(sql);
            System.out.println(rowCnt + "件のレコードが更新されました");
            
           
             sql = "SELECT * FROM scores ORDER BY score_math DESC,score_english DESC;";
             System.out.println("データ取得を実行:" + sql);
             ResultSet result = statement.executeQuery(sql);
             
             while(result.next()) {
                 int id = result.getInt("id");
                 String name = result.getString("name");
                 int math = result.getInt("score_math");
                 int english = result.getInt("score_english");
                 System.out.println(result.getRow() + "生徒ID=" + id
                                    + "／氏名=" + name + "／数学=" + math + "/英語=" + english );
             }
         } catch(InputMismatchException e) {
             System.out.println("入力が正しくありません");
         } catch(SQLException e) {
             System.out.println("エラー発生：" + e.getMessage());
         } finally {
            
             
             if( statement != null ) {
                 try { statement.close(); } catch(SQLException ignore) {}
             }
             if( con != null ) {
                 try { con.close(); } catch(SQLException ignore) {}
             }
         }
	}
}

             
             
             
            
            


