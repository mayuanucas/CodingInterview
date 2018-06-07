import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int lengthOfArray = Integer.parseInt(temp[0]);
        int numberOfArray = Integer.parseInt(temp[1]);

        MyString[] strArray = new MyString[numberOfArray];
        for (int i = 0; i < numberOfArray; i++) {
            strArray[i] = new MyString(bufferedReader.readLine().trim());
        }

        Arrays.sort(strArray, new MyStringComparator());

        for (MyString myString : strArray) {
            bufferedWriter.write(myString.getStr() + "\n");
            bufferedWriter.flush();
        }
    }


}

class MyString {
    private Integer degree;
    private String str;

    public MyString() {
    }

    public MyString(String originalStr) {
        this.str = originalStr;
        this.degree = getDegree(str);
    }

    public static int getDegree(String charArray) {
        int degree = 0;
        for (int i = 0; i < charArray.length(); i++) {
            for (int j = i + 1; j < charArray.length(); j++) {
                if (charArray.charAt(i) > charArray.charAt(j)) {
                    degree++;
                }
            }
        }
        return degree;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}

class MyStringComparator implements Comparator<MyString> {

    @Override
    public int compare(MyString o1, MyString o2) {
        return o1.getDegree() - o2.getDegree();
    }
}