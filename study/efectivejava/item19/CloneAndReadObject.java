package study.efectivejava.item19;

import java.io.*;

/**
 * 126p - Cloneable 과 Serialization 인터페이스는 상속용 설계의 어려움을 한층 더해준다.
 * 둘 중 하나라도 구현한 클래스를 상속할 수 있게 설계하는 것은 일반적으로 좋지 않은 생각이다.
 * 그 클래스를 확장하려는 프로그래머에게 엄ㅊ어난 부담을 지우기 때문이다. 물론 이 인터페이스들을 하위 클래스에서 (원한다면) 구현하도록 하는
 * 특별한 방법도 있다.
 */

public class CloneAndReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CloneAndReadObject test = new CloneAndReadObject();
        test.testDeserializeObj_withDefaultReadObject();
    }

    public void testDeserializeObj_withDefaultReadObject() throws ClassNotFoundException, IOException {
        // Serialization
        FileOutputStream fos = new FileOutputStream("user.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User acutalObject = new User("Sachin", "Kumar");
        oos.writeObject(acutalObject);

        // Deserialization
        User deserializedUser = null;
        FileInputStream fis = new FileInputStream("user.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        deserializedUser = (User)ois.readObject();
    }
}

class User implements Serializable{
    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        this.password = password.substring(3);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        this.password = "xyz" + password;
        oos.defaultWriteObject();
    }
}

class CloneSon implements Cloneable {
    // 재정의 불가 메서드: private, final, static 메서드.

    public static void nonOverridableMethod() {
        System.out.println("hello mot**r f**k");
    }

    public void overridableMethod() {
        System.out.println("hello fat**r f**k");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        nonOverridableMethod(); // ok. not bad.

        overridableMethod(); // 나쁜 예제!! smell code!!

        return super.clone();

    }
}

