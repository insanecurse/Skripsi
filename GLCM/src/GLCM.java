import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.print.attribute.Size2DSyntax;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.*;

import matlabcontrol.*;
import net.sf.json.JSONArray;

import com.google.gson.Gson;
import com.mathworks.engine.*;
import com.mathworks.util.async.Status.Future;

public class GLCM 
{	
	public static String namaa;
 public static void main(String[] args) throws Exception, IOException
 { 
	 File file = new File("C:\\xampp\\htdocs\\SkripsiUpload\\TemuKembali\\");

		if(file.isDirectory()){
			Boolean a = true;
			while (a=true) {
			if(file.list().length==0){

				System.out.println("Directory is empty!");

			}else{
				
					String nama[] = file.list();
					String tempnma;
					//System.out.println(nama[0]);
					File file2 = new File("C:\\xampp\\htdocs\\SkripsiUpload\\TemuKembali\\"+nama[0]);
					tempnma = file2.getName();
					//System.out.println(file2.getName());
					namaa = file2.getName();
					System.out.println(namaa);
					file2.renameTo(new File("C:\\xampp\\htdocs\\SkripsiUpload\\FileYangInginDiTemuKembali\\Gambar\\" + file2.getName()));
					extract(file2.getName());
					System.out.println("Data moved");
					intelligentkmeans(file2.getName());
				//break;
			}
			}
		}else{

			System.out.println("This is not a directory");

		}
		
 }
 
 

 
 public static void extract(String namafile) throws Exception, IOException{
	
		  MatlabEngine eng = MatlabEngine.startMatlab();
		  

		  eng.eval("addpath('C:\\xampp\\htdocs\\SkripsiUpload\\FileYangInginDiTemuKembali\\Gambar')");
		  eng.putVariable("nama",namafile);
		  eng.eval("GLCM");
		  
		  eng.disconnect();
		  
		  
 }
 
 public static void intelligentkmeans(String namafile) throws Exception, IOException{
		
	 String excelFilePath = "C:\\xampp\\htdocs\\SkripsiUpload\\FileYangInginDiTemuKembali\\Excel\\"+namafile+".xlsx";
     FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
     Workbook workbook = new XSSFWorkbook(inputStream);
     Sheet firstSheet = workbook.getSheetAt(0);
     Iterator<Row> iterator = firstSheet.iterator();  
     Row r = firstSheet.getRow(0);
     int kolomtrkhr = r.getLastCellNum();
     
     double ftrgambarmasuk[] = new double[kolomtrkhr];
     ArrayList<ArrayList<Double>> semuafitur = new ArrayList<ArrayList<Double>>();
     
     int banyakfiturmasuk =0;
     double jumlahfiturmasuk =0;
     int awal=0;
    	 for(int j=0; j<kolomtrkhr;j++) {
    		 Row row = firstSheet.getRow(awal);
    		 Cell cell = row.getCell(j);
    		 double aa = cell.getNumericCellValue();    	  
    		 ftrgambarmasuk[j] = aa;
    		 jumlahfiturmasuk = jumlahfiturmasuk+aa;
    		 banyakfiturmasuk++;
     }
    	 
      //System.out.println(banyakfiturmasuk);
	  //System.out.println(jumlahfiturmasuk);
      
	  database db = new database();
	  ArrayList<Double> feature1 = new ArrayList<>();
	  ArrayList<Double> feature2 = new ArrayList<>();
	  ArrayList<Double> feature3 = new ArrayList<>();
	  ArrayList<Double> feature4 = new ArrayList<>();
	  ArrayList<Double> feature5 = new ArrayList<>();
	  ArrayList<Double> feature6 = new ArrayList<>();
	  ArrayList<Double> feature7 = new ArrayList<>();
	  ArrayList<Double> feature8 = new ArrayList<>();
	  ArrayList<Double> feature9 = new ArrayList<>();
	  ArrayList<Double> feature10 = new ArrayList<>();
	  ArrayList<Double> feature11 = new ArrayList<>();
	  ArrayList<Double> feature12 = new ArrayList<>();
	  ArrayList<Double> feature13 = new ArrayList<>();
	  ArrayList<Double> feature14 = new ArrayList<>();
	  ArrayList<Double> feature15 = new ArrayList<>();
	  ArrayList<Double> feature16 = new ArrayList<>();
	  ArrayList<String> nama = new ArrayList<>();
	  ArrayList<String> namajpg = new ArrayList<>();
	  
	  feature1 = db.selectfeature1(db.getConnection());
	  feature2 = db.selectfeature2(db.getConnection());
	  feature3 = db.selectfeature3(db.getConnection());
	  feature4 = db.selectfeature4(db.getConnection());
	  feature5 = db.selectfeature5(db.getConnection());
	  feature6 = db.selectfeature6(db.getConnection());
	  feature7 = db.selectfeature7(db.getConnection());
	  feature8 = db.selectfeature8(db.getConnection());
	  feature9 = db.selectfeature9(db.getConnection());
	  feature10 = db.selectfeature10(db.getConnection());
	  feature11 = db.selectfeature11(db.getConnection());
	  feature12 = db.selectfeature12(db.getConnection());
	  feature13 = db.selectfeature13(db.getConnection());
	  feature14 = db.selectfeature14(db.getConnection());
	  feature15 = db.selectfeature15(db.getConnection());
	  feature16 = db.selectfeature16(db.getConnection());
	  nama = db.selectnamabatik(db.getConnection());
	  namajpg = db.selectnamagambar(db.getConnection());
	  
	  feature1.add(ftrgambarmasuk[0]);
	  feature2.add(ftrgambarmasuk[1]);
	  feature3.add(ftrgambarmasuk[2]);
	  feature4.add(ftrgambarmasuk[3]);
	  feature5.add(ftrgambarmasuk[4]);
	  feature6.add(ftrgambarmasuk[5]);
	  feature7.add(ftrgambarmasuk[6]);
	  feature8.add(ftrgambarmasuk[7]);
	  feature9.add(ftrgambarmasuk[8]);
	  feature10.add(ftrgambarmasuk[9]);
	  feature11.add(ftrgambarmasuk[10]);
	  feature12.add(ftrgambarmasuk[11]);
	  feature13.add(ftrgambarmasuk[12]);
	  feature14.add(ftrgambarmasuk[13]);
	  feature15.add(ftrgambarmasuk[14]);
	  feature16.add(ftrgambarmasuk[15]);
	  nama.add("Gambar yang Akan Di-Temu Kembali");
	  namajpg.add("Gambar yang ingin di-Temu Kembali");
	  
	  semuafitur.add(feature1);
	  semuafitur.add(feature2);
	  semuafitur.add(feature3);
	  semuafitur.add(feature4);
	  semuafitur.add(feature5);
	  semuafitur.add(feature6);
	  semuafitur.add(feature7);
	  semuafitur.add(feature8);
	  semuafitur.add(feature9);
	  semuafitur.add(feature10);
	  semuafitur.add(feature11);
	  semuafitur.add(feature12);
	  semuafitur.add(feature13);
	  semuafitur.add(feature14);
	  semuafitur.add(feature15);
	  semuafitur.add(feature16);
	  
	  System.out.println(namaa);
	  
	  String namajenis[] = new String[nama.size()];
	  double arraysemuafitur[][] = new double[semuafitur.size()][semuafitur.get(0).size()];
	  String namagambarjpg[] = new String[namajpg.size()];
	  
	  double jmlhsemuafiturdb = 0;
	  int banyakfiturdb = 0;
	  
	  //System.out.println(semuafitur.size());
	  for (int i=0;i<semuafitur.size();i++) {
		  for(int j=0;j<semuafitur.get(0).size();j++) {
			  arraysemuafitur[i][j] = semuafitur.get(i).get(j);
			  jmlhsemuafiturdb = jmlhsemuafiturdb + arraysemuafitur[i][j];
			  banyakfiturdb++;
		  }
	  }
	  
	  for(int i =0;i<nama.size();i++) {
		  namajenis[i] = nama.get(i);
	  }
	  
	  for(int i=0;i<namajpg.size();i++) {
		  namagambarjpg[i] = namajpg.get(i);
	  }
	  
	  //double jmlhsemuafiturdb = 0;
	  //jmlhsemuafiturdb = db.selectsum(db.getConnection());
	  
	  //int banyakfiturdb = 0;
	  //banyakfiturdb = db.banyaknilai(db.getConnection());
	  
	  double totalsemuafitur =0;
	  totalsemuafitur = jmlhsemuafiturdb+jumlahfiturmasuk;
	  
	  int banyakfitur =0;
	  banyakfitur = banyakfiturdb + banyakfiturmasuk;
	  
	  double mean =0;
	  mean = totalsemuafitur/banyakfitur;
	  
	  double stddev =0;
	  for (int i=0;i<semuafitur.size();i++) {
		  for(int j=0;j<semuafitur.get(0).size();j++) {
			 stddev+=Math.pow(arraysemuafitur[i][j] - mean, 2);
		  }
	  }
	  
	  stddev = Math.sqrt(stddev/banyakfitur);
	  //System.out.println(stddev);
	  double nilaistelahstd[][] = new double[semuafitur.size()][semuafitur.get(0).size()];
	  for (int i=0;i<semuafitur.size();i++) {
		  for(int j=0;j<semuafitur.get(0).size();j++) {
			 nilaistelahstd[i][j] = (arraysemuafitur[i][j] - mean) / stddev;
			 //System.out.println(nilaistelahstd[i][j]);
		  }
	  }
	  
	  
		 ArrayList<ArrayList<Double>> centroid = new ArrayList<ArrayList<Double>>();
		 int baris=semuafitur.get(0).size();
		 
		 double centroids[][] = new double[20][baris];
		 double fitur1[] = new double[baris];
		 double fitur2[] = new double[baris];
		 double fitur3[] = new double[baris];
		 double fitur4[] = new double[baris];
		 double fitur5[] = new double[baris];
		 double fitur6[] = new double[baris];
		 double fitur7[] = new double[baris];
		 double fitur8[] = new double[baris];
		 double fitur9[] = new double[baris];
		 double fitur10[] = new double[baris];
		 double fitur11[] = new double[baris];
		 double fitur12[] = new double[baris];
		 double fitur13[] = new double[baris];
		 double fitur14[] = new double[baris];
		 double fitur15[] = new double[baris];
		 double fitur16[] = new double[baris];
		 double COM[] = new double[baris];
		 double Centroid1[] = new double[baris];
		 double Centroid2[] = new double[baris];
		 double s1 = 0;
		 double s2 = 0;
		 double s3 = 0;
		 double s4 = 0;
		 double s5 = 0;
		 double s6 = 0;
		 double s7 = 0;
		 double s8 = 0;
		 double s9 = 0;
		 double s10 = 0;
		 double s11 = 0;
		 double s12 = 0;
		 double s13 = 0;
		 double s14 = 0;
		 double s15 = 0;
		 double s16 = 0;
		 
		 
		 ArrayList<Integer> featureopt = new ArrayList<>();
		 featureopt = db.Fopt(db.getConnection());
		 Integer arrayfo[] =featureopt.toArray(new Integer[featureopt.size()]);
		 
		 
		 if(arrayfo[0]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur1[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur1[i] = nilaistelahstd[0][i];
			 }
		 }
		 
		 if(arrayfo[1]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur1[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur2[i] = nilaistelahstd[1][i];
			 }
		 }
		 
		 if(arrayfo[2]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur3[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur3[i] = nilaistelahstd[2][i];
			 }
		 }
		 
		 if(arrayfo[3]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur4[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur4[i] = nilaistelahstd[3][i];
			 }
		 }
		 
		 if(arrayfo[4]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur5[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur5[i] = nilaistelahstd[4][i];
			 }
		 }
		 
		 if(arrayfo[5]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur6[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur6[i] = nilaistelahstd[5][i];
			 }
		 }
		 
		 if(arrayfo[6]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur7[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur7[i] = nilaistelahstd[6][i];
			 }
		 }
		 
		 if(arrayfo[7]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur8[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur8[i] = nilaistelahstd[7][i];
			 }
		 }
		 
		 if(arrayfo[8]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur9[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur9[i] = nilaistelahstd[8][i];
			 }
		 }
		 
		 if(arrayfo[9]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur10[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur10[i] = nilaistelahstd[9][i];
			 }
		 }
		 
		 if(arrayfo[10]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur11[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur11[i] = nilaistelahstd[10][i];
			 }
		 }
		 
		 if(arrayfo[11]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur12[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur12[i] = nilaistelahstd[11][i];
			 }
		 }
		 
		 if(arrayfo[12]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur13[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur13[i] = nilaistelahstd[12][i];
			 }
		 }
		 
		 if(arrayfo[13]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur14[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur14[i] = nilaistelahstd[13][i];
			 }
		 }
		 
		 if(arrayfo[14]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur15[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur15[i] = nilaistelahstd[14][i];
			 }
		 }
		 
		 if(arrayfo[15]==0) {
			 for(int i=0;i<baris;i++) {
				 fitur16[i] = 0;
			 }
		 }else {
			 for(int i=0;i<baris;i++) {
				 fitur16[i] = nilaistelahstd[15][i];
			 }
		 }
		 
		 for(int i=0; i<baris;i++) {
      
     	 s1 = s1+fitur1[i];
     	 s2 = s2+fitur2[i];
     	 s3 = s3+fitur3[i];
     	 s4 = s4+fitur4[i];
     	 s5 = s5+fitur5[i];
    	 s6 = s6+fitur6[i];
    	 s7 = s7+fitur7[i];
    	 s8 = s8+fitur8[i];
    	 s9 = s9+fitur9[i];
     	 s10 = s10+fitur10[i];
     	 s11 = s11+fitur11[i];
     	 s12 = s12+fitur12[i];
     	 s13 = s13+fitur13[i];
    	 s14 = s14+fitur14[i];
    	 s15 = s15+fitur15[i];
    	 s16 = s16+fitur16[i];
     	 
		 }
		 
		 s1 = s1/(baris);
		 s2 = s2/(baris);
		 s3 = s3/(baris);
		 s4 = s4/(baris);
		 s5 = s5/(baris);
		 s6 = s6/(baris);
		 s7 = s7/(baris);
		 s8 = s8/(baris);
		 s9 = s9/(baris);
		 s10 = s10/(baris);
		 s11 = s11/(baris);
		 s12 = s12/(baris);
		 s13 = s13/(baris);
		 s14 = s14/(baris);
		 s15 = s15/(baris);
		 s16 = s16/(baris);

		 double max = 0;
		 int countmax1 = 0;
		 
		 for(int i=0; i<baris;i++) {
		 COM[i] = Math.sqrt(Math.pow((fitur1[i]-s1),2) + Math.pow((fitur2[i]-s2),2) + Math.pow((fitur3[i]-s3),2) + Math.pow((fitur4[i]-s4),2) + Math.pow((fitur5[i]-s5),2) + Math.pow((fitur6[i]-s6),2) + Math.pow((fitur7[i]-s7),2) + Math.pow((fitur8[i]-s8),2) + Math.pow((fitur9[i]-s9),2) + Math.pow((fitur10[i]-s10),2) + Math.pow((fitur11[i]-s11),2) + Math.pow((fitur12[i]-s12),2) + Math.pow((fitur13[i]-s13),2) + Math.pow((fitur14[i]-s14),2)+ Math.pow((fitur15[i]-s15),2) + Math.pow((fitur16[i]-s16),2));
		 if(max < COM[i]) {
			 max = COM[i];
			 countmax1 = i; 
		 }
		 }
		 
		 double max2=0;
		 int countmax2=0;
		 
		 for(int i=0; i<baris;i++) {
			 Centroid1[i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[countmax1]),2) + Math.pow((fitur2[i]-fitur2[countmax1]),2) + Math.pow((fitur3[i]-fitur3[countmax1]),2) + Math.pow((fitur4[i]-fitur4[countmax1]),2) + Math.pow((fitur5[i]-fitur5[countmax1]),2) + Math.pow((fitur6[i]-fitur6[countmax1]),2) + Math.pow((fitur7[i]-fitur7[countmax1]),2) + Math.pow((fitur8[i]-fitur8[countmax1]),2) + Math.pow((fitur9[i]-fitur9[countmax1]),2) + Math.pow((fitur10[i]-fitur10[countmax1]),2) + Math.pow((fitur11[i]-fitur11[countmax1]),2) + Math.pow((fitur12[i]-fitur12[countmax1]),2) + Math.pow((fitur13[i]-fitur13[countmax1]),2) + Math.pow((fitur14[i]-fitur14[countmax1]),2) + Math.pow((fitur15[i]-fitur15[countmax1]),2) + Math.pow((fitur16[i]-fitur16[countmax1]),2));
			 if(max2 < Centroid1[i]) {
				 max2 = Centroid1[i];
				 countmax2 = i; 
				 
			 }
		 }
		 
		 for(int i=0; i<baris;i++) {
			 Centroid2[i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[countmax2]),2) + Math.pow((fitur2[i]-fitur2[countmax2]),2) + Math.pow((fitur3[i]-fitur3[countmax2]),2) + Math.pow((fitur4[i]-fitur4[countmax2]),2) + Math.pow((fitur5[i]-fitur5[countmax2]),2) + Math.pow((fitur6[i]-fitur6[countmax2]),2) + Math.pow((fitur7[i]-fitur7[countmax2]),2) + Math.pow((fitur8[i]-fitur8[countmax2]),2) + Math.pow((fitur9[i]-fitur9[countmax2]),2) + Math.pow((fitur10[i]-fitur10[countmax2]),2) + Math.pow((fitur11[i]-fitur11[countmax2]),2) + Math.pow((fitur12[i]-fitur12[countmax2]),2) + Math.pow((fitur13[i]-fitur13[countmax2]),2) + Math.pow((fitur14[i]-fitur14[countmax2]),2) + Math.pow((fitur15[i]-fitur15[countmax2]),2) + Math.pow((fitur16[i]-fitur16[countmax2]),2));
		 }
		 
		 ArrayList<Double> temp = new ArrayList<>();
			 for(int is=0; is<baris;is++) {
				 temp.add((double) Centroid1[is]);
			 }
			 centroid.add(temp);
			
		 ArrayList<Double> temp2 = new ArrayList<>();
			 for(int is=0; is<baris;is++) {
				 temp2.add((double) Centroid2[is]);
			 }
			 centroid.add(temp2);
			 
			 
		 int kelas[] = new int[baris];
			 for(int i=0; i<baris;i++) {
				 if(Centroid1[i]<Centroid2[i]) {
					 kelas[i] = 0;
				 }else {
					 kelas[i] = 1;
				 }
			 }
			 
			 
			 boolean flag1 = true;
			 
			 ArrayList<Integer> ltkcentroid = new ArrayList<>();
			 ltkcentroid.add(countmax1);
			 ltkcentroid.add(countmax2);
			 
			  
			 int test =1;
			 while(flag1 = true) {		
				 
				 int ltkcntr[] = new int[ltkcentroid.size()];
				 for (int i = 0; i < ltkcentroid.size(); i++) {
					 ltkcntr[i] = ltkcentroid.get(i);
				 }
				 
				 
				
				 
				 double f1[] = new double[centroid.size()];
				 double f2[] = new double[centroid.size()];
				 double f3[] = new double[centroid.size()];
				 double f4[] = new double[centroid.size()];
				 double f5[] = new double[centroid.size()];
				 double f6[] = new double[centroid.size()];
				 double f7[] = new double[centroid.size()];
				 double f8[] = new double[centroid.size()];
				 double f9[] = new double[centroid.size()];
				 double f10[] = new double[centroid.size()];
				 double f11[] = new double[centroid.size()];
				 double f12[] = new double[centroid.size()];
				 double f13[] = new double[centroid.size()];
				 double f14[] = new double[centroid.size()];
				 double f15[] = new double[centroid.size()];
				 double f16[] = new double[centroid.size()];
			
				 
				 double centroid1opt[][] = new double[centroid.size()][baris];//baris+1
				 double jrkpstcentroid[][] = new double[centroid.size()][baris];//baris+1
				 
				 double nilainilai[][] = new double[centroid.size()][baris];
				 
				 double mean1[] = new double[centroid.size()];
				 double mean2[] = new double[centroid.size()];
				 double mean3[] = new double[centroid.size()];
				 double mean4[] = new double[centroid.size()];
				 double mean5[] = new double[centroid.size()];
				 double mean6[] = new double[centroid.size()];
				 double mean7[] = new double[centroid.size()];
				 double mean8[] = new double[centroid.size()];
				 double mean9[] = new double[centroid.size()];
				 double mean10[] = new double[centroid.size()];
				 double mean11[] = new double[centroid.size()];
				 double mean12[] = new double[centroid.size()];
				 double mean13[] = new double[centroid.size()];
				 double mean14[] = new double[centroid.size()];
				 double mean15[] = new double[centroid.size()];
				 double mean16[] = new double[centroid.size()];
			
				 
				 int count[] = new int[centroid.size()];
				 double centroidarray[][] = new double[centroid.size()][centroid.get(0).size()];
				 
				 if(test ==1) {
				 for (int i = 0; i < centroid.size(); i++) {
					 for (int j = 0; j < centroid.get(i).size(); j++) {
							centroidarray[i][j] = centroid.get(i).get(j);
						}
				 }
				 
				 for (int i = 0; i < baris; i++) {
					   double max_distance = 0;
					   int selected_centroid = 0;
					   double simpan =0;
					   for (int j = 0; j < centroid.size(); j++) {
						   
						   simpan = centroidarray[j][i];
						   if(j==0) {max_distance = simpan;
						   
						   	}
						   else {
							   if (simpan < max_distance) {
						         max_distance = simpan;
						         selected_centroid = j;
						      }
						   	}
					   	 }
					   kelas[i] = selected_centroid;   
				}
				
				 }
				 else //saat test bukan 1
				 {
					 
					 for (int i = 0; i < centroid.size(); i++) {
						 for (int j = 0; j < baris; j++) {
								centroidarray[i][j] = centroids[i][j];
							}
					 }
				 }
	
				 for(int i =0; i<centroid.size();i++) {
					 f1[i] = 0;
					 f2[i] = 0;
					 f3[i] = 0;
					 f4[i] = 0;
					 f5[i] = 0;
					 f6[i] = 0;
					 f7[i] = 0;
					 f8[i] = 0;
					 f9[i] = 0;
					 f10[i] = 0;
					 f11[i] = 0;
					 f12[i] = 0;
					 f13[i] = 0;
					 f14[i] = 0;
					 f15[i] = 0;
					 f16[i] = 0;
		
					 count[i] = 0;

				 }
				 
				 for(int i =0;i<baris;i++) {
						for(int q=0;q<centroid.size();q++) {
							if(kelas[i]==q) {
								f1[q] = f1[q]+fitur1[i];
					        	f2[q] = f2[q]+fitur2[i];
					        	f3[q] = f3[q]+fitur3[i];
					        	f4[q] = f4[q]+fitur4[i];
					        	f5[q] = f5[q]+fitur5[i];
					        	f6[q] = f6[q]+fitur6[i];
					        	f7[q] = f7[q]+fitur7[i];
					        	f8[q] = f8[q]+fitur8[i];
					        	f9[q] = f9[q]+fitur9[i];
					        	f10[q] = f10[q]+fitur10[i];
					        	f11[q] = f11[q]+fitur11[i];
					        	f12[q] = f12[q]+fitur12[i];
					        	f13[q] = f13[q]+fitur13[i];
					        	f14[q] = f14[q]+fitur14[i];
					        	f15[q] = f15[q]+fitur15[i];
					        	f16[q] = f16[q]+fitur16[i];
					
				        	
					        	count[q]=count[q]+1;
							}				
						}
					}
				 
				 for(int q=0;q<centroid.size();q++) {
						mean1[q] = f1[q]/count[q];
					    mean2[q] = f2[q]/count[q];
					    mean3[q] = f3[q]/count[q];
					    mean4[q] = f4[q]/count[q];
					    mean5[q] = f5[q]/count[q];
					    mean6[q] = f6[q]/count[q];
					    mean7[q] = f7[q]/count[q];
					    mean8[q] = f8[q]/count[q];
					    mean9[q] = f9[q]/count[q];
					    mean10[q] = f10[q]/count[q];
					    mean11[q] = f11[q]/count[q];
					    mean12[q] = f12[q]/count[q];
					    mean13[q] = f13[q]/count[q];
					    mean14[q] = f14[q]/count[q];
					    mean15[q] = f15[q]/count[q];
					    mean16[q] = f16[q]/count[q];
			
				 }
		
			   int smpnkelas[] = new int[baris];

				 for (int i = 0; i < baris; i++) {
					 double max_distance = 0;
					 int selected_centroid = 0;
					 double simpan =0;
					 	for (int j = 0; j < centroid.size(); j++) {
					 		centroid1opt[j][i] = Math.sqrt(Math.pow((fitur1[i]-mean1[j]),2) + Math.pow((fitur2[i]-mean2[j]),2) + Math.pow((fitur3[i]-mean3[j]),2) + Math.pow((fitur4[i]-mean4[j]),2) + Math.pow((fitur5[i]-mean5[j]),2) + Math.pow((fitur6[i]-mean6[j]),2) + Math.pow((fitur7[i]-mean7[j]),2) + Math.pow((fitur8[i]-mean8[j]),2) + Math.pow((fitur9[i]-mean9[j]),2) + Math.pow((fitur10[i]-mean10[j]),2) + Math.pow((fitur11[i]-mean11[j]),2) + Math.pow((fitur12[i]-mean12[j]),2) + Math.pow((fitur13[i]-mean13[j]),2) + Math.pow((fitur14[i]-mean14[j]),2) + Math.pow((fitur15[i]-mean15[j]),2) + Math.pow((fitur16[i]-mean16[j]),2));
					 		simpan = centroid1opt[j][i];
					 			if(j==0) {
					 				max_distance = simpan;
					 					 }
					 			else {
					 				if (simpan < max_distance) {
					 					max_distance = simpan;
					 					selected_centroid = j;
					 				}
					 			}
					 		}
			   smpnkelas[i] = selected_centroid;   
				 	}
		
		
		
		if(Arrays.equals(kelas, smpnkelas)) {
			if(centroidarray[0][0] == centroid1opt[0][0]) {
				 System.out.println("benar");
				 flag1=false;
				 
				 double hasilakhir = 0;
				 double nilaigmbr = centroidarray[kelas[baris-1]][baris-1];		//nilai data yang dicari		 
				 double dstnc[] = new double[centroid.get(kelas[baris-1]).size()];
				 double dstnc2[] = new double[centroid.get(kelas[baris-1]).size()];
				 int leength = baris-centroid.get(kelas[baris-1]).size();
				 double tempz;
				 double silcoef =0;
				 
				 String tempnama;
				 String tempjpg;
				 
				 int hitungan=0;
				 int hitungan2=0;
				 int j=0;
				 int nilaiike;
				 int nilaike[] = new int[centroid.get(kelas[baris-1]).size()];
				 
				 String paths[] = new String[10];
				 double smpndstnc[] = new double[10];
				 double smpndstnc2[] = new double[698];
				 String smpnnmagbr[] = new String[10];
				 String smpnnmajpg[] = new String[10];
				 int indekske[] = new int[10];
				 double asv =0;
				 int hitasv = 1;
				 double bsv =0;
				 int hitbsv=0;
				 
				System.out.println("Jumlah Cluster : "+ centroid.size());
				
				 ArrayList<Integer> clusterutama = new ArrayList<>();
				 ArrayList<Integer> clusterlain = new ArrayList<>();
				 
				 
				 for(int i=0;i<baris;i++) {
					 if(kelas[baris-1] == kelas[i]) {
					 dstnc[i] = Math.abs(nilaigmbr - centroidarray[kelas[baris-1]][i]);
					 nilaike[i] = i;
					 clusterutama.add(i);
				
					 }else {
						 dstnc2[i] = Math.abs(nilaigmbr - centroidarray[kelas[baris-1]][i]);
						 bsv = bsv + dstnc2[i];
						 hitbsv++;
						 clusterlain.add(i);
					 }
				 }
				 
				 double meanasv[] = new double[clusterutama.size()];
				 double means1=0;
				 double simpantotalasv=0;
				 double silcoefsum =0;
				 double simpanA[]=new double[clusterutama.size()];
				 double silzcoef[]=new double[clusterutama.size()];
				 double means2=0;
				 double simpantotalbsv=0;
				 double asd=0;
				 double untukbandingkan=1;
				 //System.out.println("banyak data = " + clusterutama.size());
				 double d1[] = new double[centroid.get(kelas[baris-1]).size()];
				 double ai=0;
				 double tempp;
				 
				 for(int ll=0;ll<clusterutama.size();ll++) {
					 asv=0;
					 means1=0;
					 means2=0;
					 bsv=0;
					 simpantotalasv=0;
					 for(int i=0;i<centroid.get(0).size();i++) {
						 asv = asv + Math.abs((centroidarray[kelas[baris-1]][clusterutama.get(ll)] - centroidarray[kelas[baris-1]][i])); 
					 }
					 
					 means1 = asv/centroid.get(0).size();
	
					 simpantotalbsv=0;
					 bsv=0;
					 untukbandingkan =1;
					 
					 for(int p=0;p<centroid.size();p++) {
						 means2=0;
						 if(kelas[baris-1] != p) {
							
							for(int l=0;l<centroid.get(0).size();l++) {
								 bsv = bsv + Math.abs((centroidarray[p][ll] - centroidarray[p][l]));
							 }
							 
							 means2 = bsv/centroid.get(p).size();
							 
						if(untukbandingkan == 1) {
							untukbandingkan = means2;
						}
							 if(untukbandingkan > means2) {
								untukbandingkan = means2; 
							 }
								
						 }
					 
				 }
					 
					 
				
					 
					 silzcoef[ll] = (untukbandingkan - means1)/Math.max(means1, untukbandingkan);
					 silcoefsum = silcoefsum + silzcoef[ll];
					 untukbandingkan = 1;
				 }
				 
				 silcoef = silcoefsum/clusterutama.size();			 
				 
				 
				 for (int h = 0; h < dstnc.length; h++) 
			        {
			            for (int o = h + 1; o < dstnc.length; o++) 
			            {
			                if (dstnc[h] > dstnc[o]) 
			                {
			                    tempz = dstnc[h];
			                    nilaiike = nilaike[h];
			                    tempnama = namajenis[h];
			                    tempjpg = namagambarjpg[h];
			                    
			                    dstnc[h] = dstnc[o];
			                    nilaike[h] = nilaike[o];
			                    namajenis[h] = namajenis[o];
			                    namagambarjpg[h] = namagambarjpg[o];
			                    
			                    dstnc[o] = tempz;
			                    nilaike[o] = nilaiike;
			                    namajenis[o] = tempnama;
			                    namagambarjpg[o] = tempjpg;
			                }
			            }
			            if(dstnc[h]!=0 && hitungan != 10) {
			            
			            smpndstnc[hitungan] = dstnc[h];
			            smpnnmagbr[hitungan] = namajenis[h].replace(" ", "");
			            smpnnmajpg[hitungan] = namagambarjpg[h];
			            indekske[hitungan] = nilaike[h];
			            paths[hitungan]= smpnnmagbr[hitungan]+"/"+smpnnmajpg[hitungan];
			            hitungan++;
			        }
			        }
				
				 
				 
				 if(db.insertpath(db.getConnection(), paths[0], paths[1], paths[2], paths[3], paths[4], paths[5], paths[6], paths[7], paths[8], paths[9], namaa)==1) {
					 System.out.println("Success");
				 }else{
					 System.out.println("Failed");
				 }
				 System.out.println("Silhouette Coefficient : "+silcoef);
				 System.out.println();
				while(j<10) {
					System.out.println("Rank ke- "+j);
					System.out.println("Dengan Jarak : "+smpndstnc[j]);
					System.out.println("Dengan Jenis : "+smpnnmagbr[j]);
					System.out.println("Dengan Nama File : "+smpnnmajpg[j]);
					System.out.println("Indeks ke-"+indekske[j]);
					//System.out.println("Dengan Jarak ke Pusat Centroid : " + centroidarray[kelas[baris-1]][indekske[j]]);
					System.out.println("");
					j++;
					//System.out.println();
					//System.out.println();
					
					//System.out.println("Jumlah Centroid : " + centroid.size());
					for( int i=0;i<centroid.size();i++) {
						//System.out.println("Centroid Ke : "+i);
						for(int k = 0;k<centroid.get(i).size();k++) {
							//System.out.println(centroidarray[i][k]);
						}
					}
				}
				 break;
			 }else
				 
				 {
				
				 
				 System.out.println("kelas sama tapi beda isi!!!!");
				
					 double maxx[] = new double[centroid.size()];
					 int maxcntroid[] = new int[centroid.size()];
					
					 
					for(int i =0;i<baris;i++) {
						for(int q=0;q<centroid.size();q++) {
							if(kelas[i]==q) {
								jrkpstcentroid[q][i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[ltkcntr[q]]),2) + Math.pow((fitur2[i]-fitur2[ltkcntr[q]]),2) + Math.pow((fitur3[i]-fitur3[ltkcntr[q]]),2) + Math.pow((fitur4[i]-fitur4[ltkcntr[q]]),2) + Math.pow((fitur5[i]-fitur5[ltkcntr[q]]),2) + Math.pow((fitur6[i]-fitur6[ltkcntr[q]]),2) + Math.pow((fitur7[i]-fitur7[ltkcntr[q]]),2) + Math.pow((fitur8[i]-fitur8[ltkcntr[q]]),2) + Math.pow((fitur9[i]-fitur9[ltkcntr[q]]),2) + Math.pow((fitur10[i]-fitur10[ltkcntr[q]]),2) + Math.pow((fitur11[i]-fitur11[ltkcntr[q]]),2) + Math.pow((fitur12[i]-fitur12[ltkcntr[q]]),2) + Math.pow((fitur13[i]-fitur13[ltkcntr[q]]),2) + Math.pow((fitur14[i]-fitur14[ltkcntr[q]]),2) + Math.pow((fitur15[i]-fitur15[ltkcntr[q]]),2) + Math.pow((fitur16[i]-fitur16[ltkcntr[q]]),2));
								if(maxx[q]<jrkpstcentroid[q][i]) {
								maxcntroid[q] =i;
								maxx[q]=jrkpstcentroid[q][i];
								}
							}
							
						}
					}
					for(int q=0;q<centroid.size();q++) {
					}
					for(int i=0;i<centroid.size();i++) {
						for(int j=0;j<baris;j++) {
							nilainilai[i][j] = Math.sqrt(Math.pow((fitur1[j]-fitur1[ltkcntr[i]]),2) + Math.pow((fitur2[j]-fitur2[ltkcntr[i]]),2) + Math.pow((fitur3[j]-fitur3[ltkcntr[i]]),2) + Math.pow((fitur4[j]-fitur4[ltkcntr[i]]),2) + Math.pow((fitur5[j]-fitur5[ltkcntr[i]]),2) + Math.pow((fitur6[j]-fitur6[ltkcntr[i]]),2) + Math.pow((fitur7[j]-fitur7[ltkcntr[i]]),2) + Math.pow((fitur8[j]-fitur8[ltkcntr[i]]),2) + Math.pow((fitur9[j]-fitur9[ltkcntr[i]]),2) + Math.pow((fitur10[j]-fitur10[ltkcntr[i]]),2) + Math.pow((fitur11[j]-fitur11[ltkcntr[i]]),2) + Math.pow((fitur12[j]-fitur12[ltkcntr[i]]),2) + Math.pow((fitur13[j]-fitur13[ltkcntr[i]]),2) + Math.pow((fitur14[j]-fitur14[ltkcntr[i]]),2) + Math.pow((fitur15[j]-fitur15[ltkcntr[i]]),2) + Math.pow((fitur16[j]-fitur16[ltkcntr[i]]),2));
						
						}
					}

					 double nextcentroid[][] = new double[centroid.size()][centroid.size()];
					 double meanz[] = new double[centroid.size()];
					 double maxxx = 0;
					 int pstcntroidbaru =0;
					 for(int i=0;i<centroid.size();i++) {
						 for(int j=0;j<centroid.size();j++) {
							 
							 nextcentroid[i][j] = Math.sqrt(Math.pow((fitur1[maxcntroid[i]]-fitur1[ltkcntr[j]]),2) + Math.pow((fitur2[maxcntroid[i]]-fitur2[ltkcntr[j]]),2) + Math.pow((fitur3[maxcntroid[i]]-fitur3[ltkcntr[j]]),2) + Math.pow((fitur4[maxcntroid[i]]-fitur4[ltkcntr[j]]),2) + Math.pow((fitur5[maxcntroid[i]]-fitur5[ltkcntr[j]]),2) + Math.pow((fitur6[maxcntroid[i]]-fitur6[ltkcntr[j]]),2) + Math.pow((fitur7[maxcntroid[i]]-fitur7[ltkcntr[j]]),2) + Math.pow((fitur8[maxcntroid[i]]-fitur8[ltkcntr[j]]),2) + Math.pow((fitur9[maxcntroid[i]]-fitur9[ltkcntr[j]]),2) + Math.pow((fitur10[maxcntroid[i]]-fitur10[ltkcntr[j]]),2) + Math.pow((fitur11[maxcntroid[i]]-fitur11[ltkcntr[j]]),2) + Math.pow((fitur12[maxcntroid[i]]-fitur12[ltkcntr[j]]),2) + Math.pow((fitur13[maxcntroid[i]]-fitur13[ltkcntr[j]]),2) + Math.pow((fitur14[maxcntroid[i]]-fitur14[ltkcntr[j]]),2) + Math.pow((fitur15[maxcntroid[i]]-fitur15[ltkcntr[j]]),2) + Math.pow((fitur16[maxcntroid[i]]-fitur16[ltkcntr[j]]),2));
						 }
					 }
					 
					 double smpnhslcentroidbaru[] =new double[baris];
					 
					 for(int i=0;i<centroid.size();i++) {
						 double hitung =0;
						 for(int j=0;j<centroid.size();j++) {
							 hitung = hitung +nextcentroid[i][j];
						 }
						 meanz[i] = hitung/2;
						 if(maxxx<meanz[i]) {
							 maxxx=meanz[i];
							 pstcntroidbaru = maxcntroid[i];
							 
						 }
					 }
					 
					 for(int i =0;i<baris;i++) {
						 smpnhslcentroidbaru[i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[pstcntroidbaru]),2) + Math.pow((fitur2[i]-fitur2[pstcntroidbaru]),2) + Math.pow((fitur3[i]-fitur3[pstcntroidbaru]),2) + Math.pow((fitur4[i]-fitur4[pstcntroidbaru]),2) + Math.pow((fitur5[i]-fitur5[pstcntroidbaru]),2) + Math.pow((fitur6[i]-fitur6[pstcntroidbaru]),2) + Math.pow((fitur7[i]-fitur7[pstcntroidbaru]),2) + Math.pow((fitur8[i]-fitur8[pstcntroidbaru]),2) + Math.pow((fitur9[i]-fitur9[pstcntroidbaru]),2) + Math.pow((fitur10[i]-fitur10[pstcntroidbaru]),2) + Math.pow((fitur11[i]-fitur11[pstcntroidbaru]),2) + Math.pow((fitur12[i]-fitur12[pstcntroidbaru]),2) + Math.pow((fitur13[i]-fitur13[pstcntroidbaru]),2) + Math.pow((fitur14[i]-fitur14[pstcntroidbaru]),2) + Math.pow((fitur15[i]-fitur15[pstcntroidbaru]),2) + Math.pow((fitur16[i]-fitur16[pstcntroidbaru]),2));
					 }
					 
					 ArrayList<Double> temp3 = new ArrayList<>();
					 for(int is=0; is<baris;is++) {
						 temp3.add((double) smpnhslcentroidbaru[is]);
					 }
					 centroid.add(temp3);	
					 
					 System.out.println("Jumlah Centroid : "+centroid.size());
					 	ltkcentroid.add(pstcntroidbaru);
					 
					 	 double centroidsemua[][] = new double[centroid.size()][baris+1];
					 	
					 	for (int i = 0; i < centroid.size(); i++) {
							 for (int j = 0; j < centroid.get(i).size(); j++) {
									centroidsemua[i][j] = centroid.get(i).get(j);
								}
						 }
					 	
					 	for (int i = 0; i < baris; i++) {
							   double max_distance2 = 0;
							   int selected_centroid2 = 0;
							   double simpan2 =0;
							   for (int j = 0; j < centroid.size(); j++) {
								   
								   simpan2 = centroidsemua[j][i];
								   if(j==0) {max_distance2 = simpan2;
								   
							   }else {
								   if (simpan2 < max_distance2) {
								         max_distance2 = simpan2;
								         selected_centroid2 = j;
								      }
							   }
							   }
							   kelas[i] = selected_centroid2;   
						}
				 	 	
				 };
			
		}else
		{
			test++;
			System.out.println("beda isi kelasnya");
			
			for(int i=0;i<centroid.size();i++) {
				
				for(int is=0; is<baris;is++) {
				 centroids[i][is] = centroid1opt[i][is];
			}
			}
			System.arraycopy(smpnkelas, 0, kelas, 0, smpnkelas.length);
			
		}
		}
	  
}
}