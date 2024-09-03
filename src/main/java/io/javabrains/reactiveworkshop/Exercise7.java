package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux().filter(i -> i > 5).subscribe(System.out::println, err -> System.out.println(err.getMessage()));

        // Print 10 times each value from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux().filter(i -> i > 5).subscribe(i -> {
//            for (int num : IntStream.range(0, 10).toArray()) {
//                System.out.println(i);
//            }
//        }, (err) -> System.out.println("err"), () -> System.out.println("Completed"));

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
//        ReactiveSources.intNumbersFlux().filter(i -> i > 5)
//                .take(3)
//                .map(i -> i * 10)
//                .subscribe(System.out::println,
//                        (err) -> System.out.println(err.getMessage()),
//                        () -> System.out.println("Completed"));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
//        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux()
//                .filter(i -> i > 20)
//                .defaultIfEmpty(-1);
//        integerFlux.subscribe(System.out::println, (err) -> System.out.println(err.getMessage()), () -> System.out.println("Completed"));

        // Switch ints from intNumbersFlux to the right user from userFlux
//        ReactiveSources.intNumbersFlux()
//                .flatMap(i -> ReactiveSources.userFlux().filter(user -> user.getId() == i).take(1))
//                .subscribe((user) -> System.out.println(user.getId() + "::" + user.getFirstName()));

        // Print only distinct numbers from intNumbersFluxWithRepeat
//        ReactiveSources.intNumbersFluxWithRepeat()
//                .distinct()
//                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        int previous = -1;
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
