package com.xforg.enumerated.menu;
import java.util.EnumMap;
import java.util.Map;
import static com.xforg.utils.Print.print;
import static com.xforg.utils.Print.printnb;

/**
 * Created by Administrator on 2016/4/24.
 */
interface Command{
    void action();
}
public class EnumMaps {
    public static void main(String[] args){
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen fire");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                print("Bathroom alert");
            }
        });
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()){
            printnb(e.getKey()+":");
            e.getValue().action();
        }
        try{
            em.get(AlarmPoints.UTILITY).action();
        }catch (Exception e){
            print(e);
        }
    }
}
