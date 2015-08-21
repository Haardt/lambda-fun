package de.iritgo.lambda;

import de.iritgo.lambda.configuration.SystemConfig;
import de.iritgo.lambda.di.User;
import de.iritgo.lambda.di.UserProvider;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static de.iritgo.lambda.AnonymousTypes.with;
import static java.util.Arrays.asList;

public class LambdaFun {

    public static void main(String... args) {

        intersectionInterfaces();

        immutablePojo();

        builder();

        monkeyPatching();

        runtimeConfiguration();

        dependencyInjection();

        curry();
    }

    private static void dependencyInjection() {
        UserProvider userProvider = () -> {
        };
        User user = userProvider.user();
        user.showPrice();
    }

    private static void runtimeConfiguration() {

        SystemConfig systemConfig = Configure.systemConfig(sysConfig ->
        {
            sysConfig.debug = true;
            sysConfig.serverName = "Hallo";
            sysConfig.createdAt = System.currentTimeMillis();

            Properties env = new Properties();
            env.load(new StringReader("curring: curring"));
            sysConfig.env = env;
        });

        System.out.println("Config created at: " + systemConfig.createdAt);
        System.out.println("Env:" + systemConfig.env.getProperty("curring"));
    }

    private static void monkeyPatching() {

        Monkey<String> monkey = new Monkey<>(() -> "Default");

        System.out.println("Monkey: " + monkey.action());

        monkey.action(() -> "Patched");
        System.out.println("Monkey: " + monkey.action());
    }

    private static void builder() {

        Person person = Person.build().firstName("Andreas").lastName("Haardt").company("TELCAT MULTICOM GmbH");
        System.out.println("Person: " + person.getFirstName());
    }

    private static void immutablePojo() {


        Volume volume = Volume.volume(50);
        System.out.println(volume.volume());
        volume = volume.turnUp();
        System.out.println(volume.volume());
        volume = volume.turnUp();
        System.out.println(volume.volume());
    }

    private static void intersectionInterfaces() {

        List<String> stringList = asList("1", "2");

        with((ForwardingList<String> & Mappable<String>) () -> stringList, list -> {
            List<String> strings = list.map(String::toUpperCase);
            strings.forEach(System.out::println);
        });
    }

    public static void curry ()
    {
        IntBinaryOperator simpleAdd = (a, b) -> a + b;
        IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;

        // Simple add:
        System.out.println(simpleAdd.applyAsInt(4, 5));

        // Curried add:
        System.out.println(curriedAdd.apply(4).applyAsInt(5));

        // Curried version lets you perform partial application:
        IntUnaryOperator adder5 = curriedAdd.apply(5);
        System.out.println(adder5.applyAsInt(4));
        System.out.println(adder5.applyAsInt(6));
    }
}