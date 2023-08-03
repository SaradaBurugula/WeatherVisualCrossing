package Inteviews.EPAM.Utilities;

import com.sun.jna.StringArray;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class EpamUI {

   @Test
   public void averageAge()
   {
   /*    Keep the below person details in a Map (Person Name as key, Age as value) and then calculate the average age of the persons:
   John    24
       Brian    16
       Steve    18 */

       int age=0;
       HashMap<String, Integer> personDetails=new HashMap<>();
       personDetails.clear();
       personDetails.put("John",24);
       personDetails.put("Brian",16);
       personDetails.put("Steve",18);
       int size=personDetails.size();

       for (Integer value : personDetails.values()) {
           age+=value;
       }
       System.out.println("average age of the person: " +(age/size));
   }

   @Test
   public void sumStringNum() {
//       Calculate the sum of the numbers given in the below string
       String str = "7 9 4 8 6 6 11 9 5";
       int sum=0;
       String[] strArray = str.split(" ");
       for (String s : strArray) {
           sum+=Integer.parseInt(s);
       }
       System.out.println(sum);
//        for(int i=0; i<str.length()-1;i++)
//        {
//            if(str.charAt(i)="")
//        }
   }

   }

//   select
//    case when (column_name=='emp_id' && data_length='' && data_type='') then "true"
//     from schema_colle
//    where table_name='employee'
//
//    select

//public static Response patinetRequestResponse(String practiceId, PatientAccessDetail PatientDeatils)
//
//    return given().body(PatientDeatils).when().post(url).then().
//
//
//}
//
//PatientAccessDetail PatientDeatils=new PatientAccessDetail("sarada","Burugula")
