import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Standardization {
	public static int baris=0;
	public static int kolom=0;
	public static double test[][] = new double[1000][1000];
	
	 public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	        String excelFilePath = "C:\\Users\\Jonatan Morisson\\Desktop\\GLCM MATLAB\\MoveHere\\GLCMfeaturesSEMUA2.xlsx";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	       
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	         int baristrkhr = firstSheet.getLastRowNum();
	         baris = baristrkhr;
	         Row r = firstSheet.getRow(0);
	         int kolomtrkhr = r.getLastCellNum();
	         kolom = kolomtrkhr;
	         
	         double nilai[][] = new double[baristrkhr+1][kolomtrkhr-2];
	         double nilai2[][] = new double[baristrkhr+1][kolomtrkhr-2];
	         double stddev=0;
	         double sum =0;
	         double mean =0;
	         int banyaknilai = (baristrkhr+1) * (kolomtrkhr-2);
	         String nama[] = new String[baristrkhr+1];
	         String jenis[] = new String[baristrkhr+1];
 
	         //masukkin ke array
	         for(int i=0; i<= baristrkhr;i++) {
	        	 for(int j=0; j<=kolomtrkhr-3;j++) {
	        		 Row row = firstSheet.getRow(i);
	        		 Cell cell = row.getCell(j);
	        		 double aa = cell.getNumericCellValue();
	        	  
	        	  nilai[i][j] = aa;
	        	  sum = sum + aa;
	        	 }
	         }
	         
	         for(int i=0; i<= baristrkhr;i++) {
	        	 int j=16;
	        		 Row row = firstSheet.getRow(i);
	        		 Cell cell = row.getCell(j);
	        		 String namaa = cell.getStringCellValue();
	        	 	nama[i] = namaa;
	        	 }
	         
	         for(int i=0; i<= baristrkhr;i++) {
	        	 int j=17;
	        		 Row row = firstSheet.getRow(i);
	        		 Cell cell = row.getCell(j);
	        		 String jeniss = cell.getStringCellValue();
	        	 	jenis[i] = jeniss;
	        	 }
	         
	         
	         database db = new database();
	         ArrayList<Double> feature1 = new ArrayList<>();
	         feature1 = db.selectfeature1(db.getConnection());
	         
	         double f1[] = new double[feature1.size()];
	         for(int i=0;i<feature1.size();i++) {
	        	 f1[i] = feature1.get(i);
	         //System.out.println(f1[i]);
	         }
	         for(int i=538; i<= 692;i++) {
	        	 
	        		 try {
						db.insert(db.getConnection(), nama[i], nilai[i][0], nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5], nilai[i][6], nilai[i][7], nilai[i][8], nilai[i][9], nilai[i][10], nilai[i][11], nilai[i][12], nilai[i][13], nilai[i][14], nilai[i][15], jenis[i]);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	 	
	        	 }
	         
	         
//	         try {
//				db.insertsum(db.getConnection(), sum, banyaknilai);
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	         double sumdb =0;
//	         try {
//				sumdb = db.selectsum(db.getConnection());
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	         //System.out.println(sumdb);
	         
	         int byknilaidb =0;
//	         try {
//				byknilaidb = db.banyaknilai(db.getConnection());
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	         //System.out.println(byknilaidb);
	         
	         mean = sum/banyaknilai;
	         //System.out.println(mean);
	         //hitung std dev dsb
	         for(int i=0; i<= baristrkhr;i++) {
	        	 for(int j=0; j<=kolomtrkhr-3;j++) {
	        		 stddev += Math.pow(nilai[i][j] - mean, 2);
	        	 }
	         }
	         stddev = Math.sqrt(stddev/banyaknilai);
	         //System.out.println(stddev);
	         
	         //nilai yang sudah di standardization
	         for(int i=0; i<= baristrkhr;i++) {
	        	 for(int j=0; j<=kolomtrkhr-3;j++) {
	        		 nilai2[i][j]= (nilai[i][j] - mean) / stddev;
	        		 
	        		 test[i][j] = nilai2[i][j];
	        		 
	        	 	}
	        	 //System.out.println(test[i][0]);
	        	 }
	        
	         
	        workbook.close();
	        inputStream.close();    
	        
	        //tulis();
	        //intelligentkmeans();
	        //test("053529031120177.jpg");
	    }
	 
	 public static void test(String namafile) throws IOException {
		 String excelFilePath = "C:\\Users\\Jonatan Morisson\\Desktop\\GLCM MATLAB\\GLCMwithParameter\\"+namafile+".xlsx";
	     FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	    
	     Workbook workbook = new XSSFWorkbook(inputStream);
	     Sheet firstSheet = workbook.getSheetAt(0);
	     Iterator<Row> iterator = firstSheet.iterator();
	     
	     int baristrkhr2 = firstSheet.getLastRowNum();
	     Row r = firstSheet.getRow(0);
	     int kolomtrkhr2 = r.getLastCellNum();
	     
	     double ftrgambarmasuk[] = new double[kolomtrkhr2];
	     
	     System.out.println("aaaaaaaaaaaaaaa");
	     //masukkin ke array
	     int i=0;
	     	 for(int j=0; j<kolomtrkhr2;j++) {
	    		 Row row = firstSheet.getRow(i);
	    		 Cell cell = row.getCell(j);
	    		 double aa = cell.getNumericCellValue();
	    	  
	    	  ftrgambarmasuk[j] = aa;
	    	 
	     }
	 }
	 
	 public static void intelligentkmeans(String namafile) throws FileNotFoundException, IOException {
		 
		 
		 
		 
		 ArrayList<ArrayList<Double>> centroid = new ArrayList<ArrayList<Double>>();
		 baris=baris+1;
		 double centroids[][] = new double[20][baris];
		  
		 double fitur1[] = new double[baris];
         double fitur2[] = new double[baris];
         double fitur3[] = new double[baris];
         double fitur4[] = new double[baris];
         
         double COM[] = new double[baris];
         double Centroid1[] = new double[baris];
         double Centroid2[] = new double[baris];
         
         double s1 = 0;
         double s2 = 0;
         double s3 = 0;
         double s4 = 0;
    
		 for(int i=0; i<baris;i++) {
        	 fitur1[i] = test[i][1];
        	 fitur2[i] = test[i][5];
        	 fitur3[i] = test[i][9];
        	 fitur4[i] = test[i][13];
         
        	 s1 = s1+fitur1[i];
        	 s2 = s2+fitur2[i];
        	 s3 = s3+fitur3[i];
        	 s4 = s4+fitur4[i];
		 }
		 
		 s1 = s1/(baris);
		 s2 = s2/(baris);
		 s3 = s3/(baris);
		 s4 = s4/(baris);
 
		 double max = 0;
		 int countmax1 = 0;
		 for(int i=0; i<baris;i++) {
		 COM[i] = Math.sqrt(Math.pow((fitur1[i]-s1),2) + Math.pow((fitur2[i]-s2),2) + Math.pow((fitur3[i]-s3),2) + Math.pow((fitur4[i]-s4),2));
		 if(max < COM[i]) {
			 max = COM[i];
			 countmax1 = i; 
		 }
		 }
		 
		 double max2=0;
		 int countmax2=0;
		 for(int i=0; i<baris;i++) {
			 Centroid1[i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[countmax1]),2) + Math.pow((fitur2[i]-fitur2[countmax1]),2) + Math.pow((fitur3[i]-fitur3[countmax1]),2) + Math.pow((fitur4[i]-fitur4[countmax1]),2));
			 if(max2 < Centroid1[i]) {
				 max2 = Centroid1[i];
				 countmax2 = i; 
				 
			 }
		 }
		 for(int i=0; i<baris;i++) {
			 Centroid2[i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[countmax2]),2) + Math.pow((fitur2[i]-fitur2[countmax2]),2) + Math.pow((fitur3[i]-fitur3[countmax2]),2) + Math.pow((fitur4[i]-fitur4[countmax2]),2));
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
				 
				 
				
				 
				 double feature1[] = new double[centroid.size()];
				 double feature2[] = new double[centroid.size()];
				 double feature3[] = new double[centroid.size()];
				 double feature4[] = new double[centroid.size()];
			
				 
				 double centroid1opt[][] = new double[centroid.size()][baris+1];
				 double jrkpstcentroid[][] = new double[centroid.size()][baris+1];
				 
				 double nilainilai[][] = new double[centroid.size()][baris];
				 
				 double mean1[] = new double[centroid.size()];
				 double mean2[] = new double[centroid.size()];
				 double mean3[] = new double[centroid.size()];
				 double mean4[] = new double[centroid.size()];
			
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
						   
					   }else {
						   if (simpan < max_distance) {
						         max_distance = simpan;
						         selected_centroid = j;
						      }
					   }
					   }
					   kelas[i] = selected_centroid;   
				}
				
				 }else {
					 
					 for (int i = 0; i < centroid.size(); i++) {
						 for (int j = 0; j < baris; j++) {
								centroidarray[i][j] = centroids[i][j];
							}
					 }
				 }
	
				 for(int i =0; i<centroid.size();i++) {
					 feature1[i] = 0;
					 feature2[i] = 0;
					 feature3[i] = 0;
					 feature4[i] = 0;
		
					 count[i] = 0;

				 }
				 
				 for(int i =0;i<baris;i++) {
						for(int q=0;q<centroid.size();q++) {
							if(kelas[i]==q) {
								feature1[q] = feature1[q]+fitur1[i];
					        	feature2[q] = feature2[q]+fitur2[i];
					        	feature3[q] = feature3[q]+fitur3[i];
					        	feature4[q] = feature4[q]+fitur4[i];
					
				        	
					        	count[q]=count[q]+1;
							}				
						}
					}
				 
				 for(int q=0;q<centroid.size();q++) {
						mean1[q] = feature1[q]/count[q];
					    mean2[q] = feature2[q]/count[q];
					    mean3[q] = feature3[q]/count[q];
					    mean4[q] = feature4[q]/count[q];
			
				 }
		
				 int smpnkelas[] = new int[baris];

		for (int i = 0; i < baris; i++) {
			   double max_distance = 0;
			   int selected_centroid = 0;
			   double simpan =0;
			   for (int j = 0; j < centroid.size(); j++) {
				   centroid1opt[j][i] = Math.sqrt(Math.pow((fitur1[i]-mean1[j]),2) + Math.pow((fitur2[i]-mean2[j]),2) + Math.pow((fitur3[i]-mean3[j]),2) + Math.pow((fitur4[i]-mean4[j]),2));
				   
				   simpan = centroid1opt[j][i];
				   if(j==0) {max_distance = simpan;
				   
			   }else {
				   if (simpan < max_distance) {
				         max_distance = simpan;
				         selected_centroid = j;
				      }
			   }
			   }
			   smpnkelas[i] = selected_centroid;   
		}
		;
		
		
		if(Arrays.equals(kelas, smpnkelas)) {
			if(centroidarray[0][0] == centroid1opt[0][0]) {
				 System.out.println("benar");
				 flag1=false;
				 for(int i=0;i<baris;i++) {
				 System.out.println(kelas[i]);
				 
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
								jrkpstcentroid[q][i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[ltkcntr[q]]),2) + Math.pow((fitur2[i]-fitur2[ltkcntr[q]]),2) + Math.pow((fitur3[i]-fitur3[ltkcntr[q]]),2) + Math.pow((fitur4[i]-fitur4[ltkcntr[q]]),2));
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
							nilainilai[i][j] = Math.sqrt(Math.pow((fitur1[j]-fitur1[ltkcntr[i]]),2) + Math.pow((fitur2[j]-fitur2[ltkcntr[i]]),2) + Math.pow((fitur3[j]-fitur3[ltkcntr[i]]),2) + Math.pow((fitur4[j]-fitur4[ltkcntr[i]]),2));
						
						}
					}

					 double nextcentroid[][] = new double[centroid.size()][centroid.size()];
					 double meanz[] = new double[centroid.size()];
					 double maxxx = 0;
					 int pstcntroidbaru =0;
					 for(int i=0;i<centroid.size();i++) {
						 for(int j=0;j<centroid.size();j++) {
							 
							 nextcentroid[i][j] = Math.sqrt(Math.pow((fitur1[maxcntroid[i]]-fitur1[ltkcntr[j]]),2) + Math.pow((fitur2[maxcntroid[i]]-fitur2[ltkcntr[j]]),2) + Math.pow((fitur3[maxcntroid[i]]-fitur3[ltkcntr[j]]),2) + Math.pow((fitur4[maxcntroid[i]]-fitur4[ltkcntr[j]]),2));
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
						 smpnhslcentroidbaru[i] = Math.sqrt(Math.pow((fitur1[i]-fitur1[pstcntroidbaru]),2) + Math.pow((fitur2[i]-fitur2[pstcntroidbaru]),2) + Math.pow((fitur3[i]-fitur3[pstcntroidbaru]),2) + Math.pow((fitur4[i]-fitur4[pstcntroidbaru]),2));
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
	 
	 
	 public static void tulis() throws FileNotFoundException, IOException {
		 	XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Sheet1");
	         
	        for(int i=0; i<= baris;i++) {
	        	Row row = sheet.createRow(i);
	        	 for(int j=0; j<=kolom-3;j++) {
	        		 
	        		 Cell cell = row.createCell(j);
	        		 cell.setCellValue(test[i][j]);
	        	 }
	        }
	        
	        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Jonatan Morisson\\Desktop\\JavaBooks.xlsx")) {
	            workbook.write(outputStream);
	        }
	        
	        
}
	 }
