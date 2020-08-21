package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(2);
        jar.add(3);
        System.out.println(jar.remove());

        Jar<String> strJar = new Jar<>();
        strJar.add("one");
        strJar.add("two");
        strJar.add("three");
        System.out.println(strJar.remove());
    }
}
