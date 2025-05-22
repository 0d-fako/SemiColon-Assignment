package classtasks;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntStreamSample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);

        Predicate<Integer> filterEvenNumber = number -> number % 2 == 0;

        List <Integer> evenNumber = numbers
                .stream()
                .filter(filterEvenNumber)
                .map(number -> number * 2)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(evenNumber);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@doe.com");
        user.setPassword("password");

        

        List<User> users = List.of(user);

        List <UserDto> stringUser = users.stream()
                .map(UserDto::new)
                .collect(Collectors.toList());

    }

}
