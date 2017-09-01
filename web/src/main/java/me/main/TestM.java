package me.main;

/**
 * Created by lmk39 on 2017/6/18.
 */
public class TestM {
    public static void main(String[] args){
        int num=100;
       // String str=
        int x=1234;
        String str="";
        int sumOf1=0;
        while (x>=1){
            str=(x%2)+str;
            if(x%2==1){
                sumOf1++;
            }
            x=x/2;

        }
        System.out.println(str+"||"+sumOf1);

        char[] ret=Integer.toBinaryString(1234).toCharArray();
        int sum=0;
        for(int i=0;i<ret.length;i++){
            if(ret[i]=='1'){
                sum++;
            }
        }
        System.out.println(sum);
        System.out.println(Integer.bitCount(1234));
    }


//    public char div(int x){
//        if(x%2==0){
//            return '0';
//        }else{
//            return '1';
//        }
//        div(x/2);
//    }
}
