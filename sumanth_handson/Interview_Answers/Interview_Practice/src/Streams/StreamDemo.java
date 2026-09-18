package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo
{
    public static void main(String[] args)
    {
        List<String> stringList = new ArrayList<>();
        stringList.add("Sam");
        stringList.add("altman");
        stringList.add("hide");
        stringList.add("seek");

        List<String> finallist = stringList.stream()
                .filter(name -> name.length() >3)
                .map(String::toUpperCase).sorted().toList();

        System.out.println("Result: " + finallist);
    }
}
