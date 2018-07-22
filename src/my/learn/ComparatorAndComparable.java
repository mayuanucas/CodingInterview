package my.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/22
 */
public class ComparatorAndComparable {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(10);

        list.add(new Person("aa", 19));
        list.add(new Person("A", 9));
        list.add(new Person("b", 11));
        list.add(new Person("BB", 2));
        list.add(new Person("cC", 23));
        list.add(new Person("aA", 54));

        System.out.printf("原始列表顺序为: %s\n", list);

        // 根据 name 进行排序
        Collections.sort(list);
        System.out.printf("排序后列表顺序为: %s\n", list);

        Collections.sort(list, new AscAgeComparator());
        System.out.printf("根据 age 升序排序: %s\n", list);

        Collections.sort(list, new DescAgeComparator());
        System.out.printf("根据 age 降序排序: %s\n", list);

    }

    private static class Person implements Comparable<Person> {

        private int age;
        private String name;

        public Person() {

        }

        public Person(String s, int a) {
            this.age = a;
            this.name = s;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name + "-" + age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (null != obj && (obj instanceof Person)) {
                if (this.age == ((Person) obj).age && this.name == ((Person) obj).name) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }
    }

    private static class AscAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();
        }
    }

    private static class DescAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p2.getAge() - p1.getAge();
        }
    }
}
