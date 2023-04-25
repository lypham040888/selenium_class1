package handlecontrol.tesstng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AllAnnotations {
	
  @Test
  public void Testcase1() {
	  // Nội dung của test case 
	  System.out.println("Thực hiên test case 1");
  }
  @Test
  public void Testcase2() {
	// Nội dung của test case 
	  System.out.println("Thực hiên test case 2");
  }
  
  @Test
  public void Testcase3() {
	// Nội dung của test case 
	  System.out.println("Thực hiên test case 3");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	 // Những bước chuẩn bị cho việc chạy test case
	  System.out.println("beforeMethod");
  }
  

  @AfterMethod
  public void afterMethod() {
	  // Những việc thực hiện sau khi thực hiện hết các test case
	  // Ví dụ: Close kết nối databas
	  // selenium: close brower
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  // Thực thi trước khi phương thức thứ nhất trong class được gọi
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  // Thực thi sau khi phương thức thứ nhất trong class được thực hiện
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  // Thực thi trước tất cả các phương thức nào thuộc các lớp được thực hiện
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  // Thực thi sau khi tất cả phương thức thuộc class được thực hiện

	  System.out.println("afterTest");
  }
 // Nâng cao tạm bỏ vì kiến thức khó
  @BeforeSuite
  public void beforeSuite() {
	  // Thiết kế nhiều bộ test suitte
	  // Testsuite 1: Test case 1 và Test case 2
	  // TestSuite 2: Test case 2, test case 3
	  // TestSuite 3: Tất cả test case
	  // Những việc thực hiện trước khi chạy bất kỳ bộ test suite 
	  // Ví dụ: chuẩn bị test data cho từng bộ trong file excel, hoặc txt 
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  // Thực hiện sau khi thực hiện xong tất cả các test suite
	  System.out.println("afterSuite");
  }

}
