import java.util.List;
import java.util.ArrayList;

public class ipAddress {
    List<String> list;
    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        //if string length is greater than 12 and smaller than 12 i can't make a valid ip addres....think!
        if(s.length() < 4 || s.length() > 12){
            return list;
        }

        restoreIP(s, "" , 0);
        return list;
    }
    // idx shows the number of sections of ip we have covered like 123.22. now idx will be 2 cze we have used 2 dots
    // and atmost we can use 3
    void restoreIP(String s, String sub, int idx){

        if(s.length() == 0 || idx == 4){
            if(s.length() == 0 && idx == 4){
                //removing the last dot and then adding, because while making call we putted .
                // we do not need to check validity of string before adding because, while making call we have checked                 // all scenerio
                list.add(sub.substring(0, sub.length()-1));
            }
            return;
        }
        //1st chcek with string size of 1 i.e, 1. , 2.  etc.
        restoreIP(s.substring(1), sub + s.substring(0,1) + "." , idx+1);

        //2nd check for 2 length string
        if(s.length() >= 2 && s.charAt(0) != '0')
            restoreIP(s.substring(2), sub + s.substring(0,2) + ".", idx + 1);

        //3rd check for 3 length string and if string value is greater than 255 it's not valid..according to the question.
        if(s.length() >= 3 && s.charAt(0) != '0' && Integer.valueOf(s.substring(0,3)) <= 255)
            restoreIP(s.substring(3), sub + s.substring(0,3) + "." , idx + 1);
    }

    public static void main(String[] args) {
        ipAddress ip = new ipAddress();
        String address = "25525511135";
        System.out.println(ip.restoreIpAddresses(address));
    }
}
