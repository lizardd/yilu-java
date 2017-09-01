package me.coordinate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmk39 on 2017/7/14.
 */
public class Main {
    public static void main(String []args){
        List<Coordinate> data=lodingData();
        for (Coordinate c: data){
            System.out.println(c.getX()+" "+ c.getY() +" "+ c.getZ());
        }
        //输出a b c d di
        for (int i=0;i<data.size();i++){
            output(calA(data,i)+" "+calB(data,i)+" "+calC(data,i)+" "+calD(data,i)+" "+calDi(data,i));
        }

    }


    public static Float calA(List<Coordinate> data,int index){
        Long numerator =sum(data,index,"Ex*z")*2 - sum(data,index,"Ex")*sum(data,index,"Ez");
        Long denominator  =sum(data,index,"Ez*z")*2 - sum(data,index,"Ez")*sum(data,index,"Ez");
        return (float)numerator/(float)denominator;
    }
    public static Float calB(List<Coordinate> data,int index){
        Float numerator = sum(data,index,"Ex")-calA(data,index)*sum(data,index,"Ez");
        return numerator/2;
    }
    public static Float calC(List<Coordinate> data,int index){
        Long numerator =sum(data,index,"Ey*z")*2 - sum(data,index,"Ey")*sum(data,index,"Ez");
        Long denominator  =sum(data,index,"Ez*z")*2 - sum(data,index,"Ez")*sum(data,index,"Ez");
        return (float)numerator/(float)denominator;
    }
    public static Float calD(List<Coordinate> data,int index){
        Float numerator = sum(data,index,"Ey")-calC(data,index)*sum(data,index,"Ez");
        return numerator/2;
    }
    public static Double calDi(List<Coordinate> data,int index){
        Double numerator =Math.sqrt(
                Math.pow(-data.get(index).getY()+calC(data,index)*data.get(index).getZ()+calD(data,index),2)+
                Math.pow(data.get(index).getX()-calA(data,index)*data.get(index).getZ()-calB(data,index),2)+
                Math.pow(-calC(data,index)*data.get(index).getX()+calA(data,index)*data.get(index).getY()+
                        calB(data,index)*calC(data,index)-calA(data,index)*calD(data,index),2)
        );
        Double denominator = Math.sqrt(Math.pow(calA(data,index),2)+Math.pow(calB(data,index),2)+1);
        return numerator/denominator;
    }


    public static Long sum(List<Coordinate> data,int endIndex,String direction){
        if(endIndex> data.size()){
            System.out.println("data error");
            return null;
        }
        long sum=0;
        //自定义累加运算符、、
        //[Ex Ey Ex Ex*z Ey*z Ez*z]
        for(int i=0;i<=endIndex;i++){
            switch (direction){
                case "Ex":
                    sum+=data.get(i).getX();
                    break;
                case "Ey":
                    sum+=data.get(i).getY();
                    break;
                case "Ez":
                    sum+=data.get(i).getZ();
                    break;
                case "Ex*z":
                    sum+=data.get(i).getX()*data.get(i).getZ();
                    break;
                case "Ey*z":
                    sum+=data.get(i).getY()*data.get(i).getZ();
                    break;
                case "Ez*z":
                    sum+=data.get(i).getZ()*data.get(i).getZ();
                    break;
            }

        }
//        System.out.println(direction+"["+endIndex+"]=>"+sum);
        return sum;
    }


    public static List<Coordinate> lodingData() {
        String rootPath= Main.class.getResource("/").getFile().toString();
        File file = new File(rootPath+"/data/input.txt");
        List<Coordinate> data=new ArrayList();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;
            while ((tempString = reader.readLine()) != null) {
                System.out.println("line " + line + ": " + tempString);
                String [] array=tempString.split(" ");
                Coordinate coordinate=new Coordinate();
                coordinate.setX(Long.parseLong(array[0]));
                coordinate.setY(Long.parseLong(array[1]));
                coordinate.setZ(Long.parseLong(array[2]));
                data.add(coordinate);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            return data;
        }
    }

    public static void output(String content) {
        System.out.println(">>");
        String rootPath= Main.class.getResource("/").getFile().toString();
        FileWriter fw = null;
        try {
            File f=new File(rootPath+"/output.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
//        pw.append(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
