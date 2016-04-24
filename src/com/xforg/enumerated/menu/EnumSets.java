package com.xforg.enumerated.menu;
import java.util.EnumSet;
import static com.xforg.enumerated.menu.AlarmPoints.*;
import static com.xforg.utils.Print.print;

/**
 * Created by Administrator on 2016/4/24.
 */
public class EnumSets {/*EnumSet的基础是long,一个long的值有64位，而一个enume实例只需要一位bit表示其是否存在。*/
    public static void main(String[] args){
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        print(points);
        points.addAll(EnumSet.of( STAIR1, STAIR2, KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points.removeAll(EnumSet.of(OFFICE1, OFFICE4));
        print(points);
        points = EnumSet.complementOf(points);
        print(points);
    }
}
