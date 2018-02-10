import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 

public class database { 


  
 public static Connection getConnection() throws ClassNotFoundException, SQLException { 
  String driver = "org.gjt.mm.mysql.Driver"; 
  String url = "jdbc:mysql://localhost/db_images"; 
  String username = "root"; 
  String password = ""; 
  Class.forName(driver); 
  Connection conn = DriverManager.getConnection(url, username, password); 
  return conn; 
 } 
  
 public static void insert(Connection conn, String nama, double feature1, double feature2, double feature3, double feature4, double feature5, double feature6, double feature7, double feature8, double feature9, double feature10, double feature11, double feature12, double feature13, double feature14, double feature15, double feature16, String jenis) throws SQLException{ 
  String sql = "INSERT INTO feature (namagambar, feature1, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, feature11, feature12, feature13, feature14, feature15, feature16, jenis) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
  PreparedStatement stmt = conn.prepareStatement(sql); 
  stmt.setString(1, nama); 
  stmt.setDouble(2, feature1); 
  stmt.setDouble(3, feature2); 
  stmt.setDouble(4, feature3); 
  stmt.setDouble(5, feature4); 
  stmt.setDouble(6, feature5); 
  stmt.setDouble(7, feature6);
  stmt.setDouble(8, feature7); 
  stmt.setDouble(9, feature8); 
  stmt.setDouble(10, feature9); 
  stmt.setDouble(11, feature10); 
  stmt.setDouble(12, feature11); 
  stmt.setDouble(13, feature12); 
  stmt.setDouble(14, feature13); 
  stmt.setDouble(15, feature14); 
  stmt.setDouble(16, feature15); 
  stmt.setDouble(17, feature16);
  stmt.setString(18, jenis);
  stmt.executeUpdate(); 
 } 
  
 public static void insertsum(Connection conn, double sum, int banyaknilai) throws SQLException{ 
	  String sql = "INSERT INTO stddev (sum, banyaknilai) values (?,?)"; 
	  PreparedStatement stmt = conn.prepareStatement(sql); 
	  stmt.setDouble(1, sum); 
	  stmt.setInt(2, banyaknilai); 
	  stmt.executeUpdate(); 
	 } 
 
 public static int insertpath(Connection conn, String path1,String path2, String path3, String path4, String path5, String path6, String path7, String path8, String path9, String path10, String namagbr) throws SQLException{ 
	  String sql = "UPDATE temukembali SET pathgbr1 = ?, pathgbr2 = ?, pathgbr3 = ?, pathgbr4 = ?, pathgbr5 = ?, pathgbr6 = ?, pathgbr7 = ?, pathgbr8 = ?, pathgbr9 = ?, pathgbr10 = ? WHERE namagambar = ? "; 
	  PreparedStatement stmt = conn.prepareStatement(sql); 
	  stmt.setString(1, path1); 
	  stmt.setString(2, path2); 
	  stmt.setString(3, path3); 
	  stmt.setString(4, path4); 
	  stmt.setString(5, path5); 
	  stmt.setString(6, path6); 
	  stmt.setString(7, path7); 
	  stmt.setString(8, path8); 
	  stmt.setString(9, path9); 
	  stmt.setString(10, path10); 
	  stmt.setString(11, namagbr);
	  stmt.executeUpdate(); 
	  return 1;
	 } 
 
 public static double selectsum(Connection conn) throws SQLException{
	 //String sql = "SELECT sum from stddev"; 
	  Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT sum from stddev");
	  while(rs.next()) {
	  return rs.getDouble(1);
	  }
	  rs.close();
	  conn.close();
	  return 0;
 }
 
 public static int banyaknilai(Connection conn) throws SQLException{
	  Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT banyaknilai from stddev");
	  while(rs.next()) {
	  return rs.getInt(1);
	  }
	  rs.close();
	  conn.close();
	  return 0;
 }
 public static ArrayList<Integer> Fopt(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement();
	 ResultSet rs = stmt.executeQuery("SELECT * from featureopt");
	 ArrayList<Integer> fitur = new ArrayList<>();
	 while(rs.next()) {
		  fitur.add(rs.getInt("feature1"));
		  fitur.add(rs.getInt("feature2"));
		  fitur.add(rs.getInt("feature3"));
		  fitur.add(rs.getInt("feature4"));
		  fitur.add(rs.getInt("feature5"));
		  fitur.add(rs.getInt("feature6"));
		  fitur.add(rs.getInt("feature7"));
		  fitur.add(rs.getInt("feature8"));
		  fitur.add(rs.getInt("feature9"));
		  fitur.add(rs.getInt("feature10"));
		  fitur.add(rs.getInt("feature11"));
		  fitur.add(rs.getInt("feature12"));
		  fitur.add(rs.getInt("feature13"));
		  fitur.add(rs.getInt("feature14"));
		  fitur.add(rs.getInt("feature15"));
		  fitur.add(rs.getInt("feature16"));
	 }
	 rs.close();
	 return fitur;
 }
 
 public static ArrayList<String> selectnamabatik(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT jenis from feature");
	  ArrayList<String> nama = new ArrayList<>();
	  while(rs.next()) {
	  nama.add(rs.getString(1));
	  }
	  rs.close();
	  return nama;
 }

 public static ArrayList<String> selectnamagambar(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT namagambar from feature");
	  ArrayList<String> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getString(1));
	  }
	  rs.close();
	  return features1;
 }
 
 
 public static ArrayList<Double> selectfeature1(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature1 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature2(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature2 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature3(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature3 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature4(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature4 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature5(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature5 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature6(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature6 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature7(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature7 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature8(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature8 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature9(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature9 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature10(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature10 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature11(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature11 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature12(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature12 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature13(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature13 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature14(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature14 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature15(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature15 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
 public static ArrayList<Double> selectfeature16(Connection conn) throws SQLException{
	 Statement stmt = conn.createStatement(); 
	  ResultSet rs = stmt.executeQuery("SELECT feature16 from feature");
	  ArrayList<Double> features1 = new ArrayList<>();
	  while(rs.next()) {
	  features1.add(rs.getDouble(1));
	  }
	  rs.close();
	  return features1;
 }
 
// public static int selectCount(Connection conn) throws SQLException{ 
//  Statement stmt = conn.createStatement(); 
//  ResultSet rs = stmt.executeQuery("SELECT COUNT(*) from tb_globalhistogram"); 
//  while (rs.next()) { 
//   return rs.getInt(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return 0; 
// } 
//  
// public static ArrayList<Integer> selectId(Connection conn) throws SQLException{ 
//  Statement stmt = conn.createStatement(); 
//  ResultSet rs = stmt.executeQuery("SELECT id_karakter FROM tb_globalhistogram"); 
//  ArrayList<Integer> idKarakter = new ArrayList<>();  
//  while (rs.next()) { 
//   idKarakter.add(rs.getInt(1)); 
//  } 
//  rs.close(); 
//  return idKarakter; 
// } 
//  
// public static void selectAll(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT * FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  if(rs.next()){ 
//   latKarakter = rs.getString(1); 
//   latStdHori = rs.getDouble(2); 
//   latMeanHori= rs.getDouble(3); 
//   latStdVert = rs.getDouble(4); 
//   latMeanVert= rs.getDouble(5); 
//   latStdDiag = rs.getDouble(6); 
//   latMeanDiag = rs.getDouble(7); 
//  } 
//  rs.close(); 
//  conn.close(); 
// } 
//  
// public static double selectHoriSD(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT horizontalSD FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  double latHoriSD = 0; 
//  if(rs.next()) { 
//   latHoriSD = rs.getDouble(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return latHoriSD; 
// } 
//  
// public static double selectHoriM(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT horizontalMean FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  double latHoriM = 0; 
//  if(rs.next()) { 
//   latHoriM = rs.getDouble(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return latHoriM; 
// } 
//
// public static double selectVertiSD(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT vertikalSD FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  double latVertiSD = 0; 
//  if(rs.next()) { 
//   latVertiSD = rs.getDouble(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return latVertiSD; 
// } 
//  
// public static double selectVertiM(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT vertikalMean FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  double latVertiM = 0; 
//  if(rs.next()) { 
//   latVertiM = rs.getDouble(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return latVertiM; 
// } 
//  
// public static double selectDiagSD(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT diagonalSD FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  double latDiagSD = 0; 
//  if(rs.next()) { 
//   latDiagSD = rs.getDouble(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return latDiagSD; 
// } 
//  
// public static double selectDiagM(Connection conn, int id) throws SQLException{ 
//  String sql = "SELECT diagonalMean FROM tb_globalhistogram WHERE id_karakter = ?"; 
//  PreparedStatement stmt = conn.prepareStatement(sql); 
//  stmt.setInt(1, id); 
//  ResultSet rs = stmt.executeQuery(); 
//  double latDiagM = 0; 
//  if(rs.next()) { 
//   latDiagM = rs.getDouble(1); 
//  } 
//  rs.close(); 
//  conn.close(); 
//  return latDiagM; 
// } 
//  
// public static void selectIdLeven(Connection conn) throws SQLException{ 
//  Statement stmt = conn.createStatement(); 
//  ResultSet rs = stmt.executeQuery("SELECT id FROM tb_levenshtein"); 
//  while (rs.next()) { 
//   idString.add(rs.getInt(1)); 
//  } 
//  rs.close(); 
// } 
//  
// public static void selectString(Connection conn) throws SQLException{ 
//  Statement stmt = conn.createStatement(); 
//  ResultSet rs = stmt.executeQuery("SELECT stringLatih FROM tb_levenshtein");   
//  while (rs.next()) { 
//   stringLatih.add(rs.getString(1)); 
//  } 
//  rs.close(); 
// } 
}