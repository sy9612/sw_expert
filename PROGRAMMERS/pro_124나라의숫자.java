import java.util.*;
import java.io.*;
class Solution {
    public String solution(int n) {
        String [] numbers = {"4", "1", "2"};
        String answer = "";
           while(n > 0){
              int temp = n % 3;
               n /= 3;
               if(temp == 0){
                   n -= 1;
               }
               answer = numbers[temp] + answer;
           }
            return answer;
        }
}