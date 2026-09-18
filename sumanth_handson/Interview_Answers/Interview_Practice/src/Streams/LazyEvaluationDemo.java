package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationDemo
{
    public static void main(String[] args)
    {
        List<String> stringList = new ArrayList<>();
        stringList.add("Sam");
        stringList.add("altman");
        stringList.add("hide");
        stringList.add("seek");

        Stream<String> filteredStream =
                stringList.stream()
                        .filter(name  -> {System.out.println("Filtering:--> " + name);
                    return name.length()>3;
                });

        System.out.println("Stream created");

        System.out.println("Calling terminal operation");

        System.out.println("Terinal list:--> "+ filteredStream.toList());

        //After:
        //
        //Stream<String> stream = ...
        //
        //nothing was filtered.
        //
        //It started only after:
        //
        //stream.toList();
        //
        //That's lazy evaluation.

    }
}
