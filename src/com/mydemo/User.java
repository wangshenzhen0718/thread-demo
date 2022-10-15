package com.mydemo;

import java.util.concurrent.atomic.AtomicReference;

public class User {//CAS案例
    String userName;
    int age;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
class AtomicReferenceDemo {
    public static void main(String[] args) {
       /* User z3 = new User( "z3",22);
        User li4 = new User("li4" ,25);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(z3);
        System.out.println(userAtomicReference.compareAndSet(z3,li4)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(li4,z3)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(z3,li4)+"\t"+userAtomicReference.get().toString());*/
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User zs = new User("zs", 15);
        User ls = new User("ls", 20);
        atomicReference.set(zs);
        boolean b = atomicReference.compareAndSet(zs, ls);
        boolean c = atomicReference.compareAndSet(ls, zs);
        boolean d = atomicReference.compareAndSet(zs, ls);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
