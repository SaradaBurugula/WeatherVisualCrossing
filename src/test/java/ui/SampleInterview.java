package ui;

import org.testng.annotations.Test;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class SampleInterview {
    @Test
    public void stringJava8Plus()
    {
        String s1="sarada";
        String s2="siva";
        StringJoiner s=new StringJoiner(" and ");
        s.add(s1);
        s.add(s2);
        System.out.println(s.toString()+" : "+s.length());
    }

    @Test
    public void stringTokenizer() {
        StringTokenizer st = new StringTokenizer("my name is sarada", " ");
        System.out.println("Count os tokens are : " + st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
    }
}
