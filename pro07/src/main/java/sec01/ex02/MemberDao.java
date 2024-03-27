package sec01.ex02;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String user = "system";
    private static final String pwd = "0000";
    private Connection con;
    private  PreparedStatement pstmt;

    public List<MemberVo> listMembers(){
        List<MemberVo> list = new ArrayList<MemberVo>();
        try{
            connDB();
            String query = "select * from t_member";
            System.out.println("prepareStatement : " + query);
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVo vo = new MemberVo();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    private void connDB(){
        try{
            Class.forName(driver);
            System.out.println("Oracle 드라이버 로딩 성공");
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection 생성 성공");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}