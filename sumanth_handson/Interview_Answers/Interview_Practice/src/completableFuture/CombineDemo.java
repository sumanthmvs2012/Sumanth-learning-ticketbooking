package completableFuture;

import java.util.concurrent.CompletableFuture;

public class CombineDemo
{
    public static void main(String[] args)
    {
        //thenCombine() combines results from two independent CompletableFutures and produces a new result.
        // allOf() coordinates multiple futures and completes when all of them finish,
        // but it returns CompletableFuture<Void>, so the individual results still need to be retrieved
        // from the original futures.

        CompletableFuture<String> firstName =
                CompletableFuture.supplyAsync(() -> "Sammy");

        CompletableFuture<String> role =
                CompletableFuture.supplyAsync(() -> "java Developer");

        CompletableFuture<String> result =
                firstName.thenCombine(role,
                        (name, role1) -> name + "  has this role " + role1);

        CompletableFuture<String> resultallof =
                CompletableFuture.allOf(firstName,role)
                        .thenApply(v -> firstName.join() + " has this role " + role.join());


        System.out.println("Result:-" + result.join());

        System.out.println("resultallOf:-" + resultallof.join());
    }
}
