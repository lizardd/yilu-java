package coordinate;

/**
 * Created by lmk39 on 2017/8/25.
 */
public class Solution {
    public static void main(String []args){
//        int numObBulbs=8;
//        int []glowState = {0,1,0,0,1,1,0,0};
//        int []distanceOfBulb={3,5,10,12,13,23,30,38};
        int numObBulbs=7;
        int []glowState = {1,0,1,1,0,1,1};
        int []distanceOfBulb={1,5,6,7,8,9,17};
        System.out.println(minWireLength(numObBulbs,glowState,distanceOfBulb));
    }

    static int minWireLength(int numObBulbs,int []glowState,int []distanceOfBulb){
        int sum=0;
        for(int i=0;i<numObBulbs;i++){
            if(glowState[i]==0){
                sum+=minLengthSingle(distanceOfBulb[i],distanceOfBulb ,i);
            }
        }
        return sum;
    }
    static int minLengthSingle(int distance,int []distanceOfBulb,int index){
        int min=Math.abs(distanceOfBulb[index==distanceOfBulb.length-1?index-1:index+1]-distance);
        for(int i=0;i<distanceOfBulb.length;i++){
            if(Math.abs(distanceOfBulb[i]-distance)<min && index !=i){
                min=Math.abs(distanceOfBulb[i]-distance);
            }
        }
        return min;
    }

}
