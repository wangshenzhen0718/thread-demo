package com.wang;

class  TestLambda{
    public static void main(String[] args) {
        executorService love= a->
            System.out.println(a);
        love.love(20);

    }

}
interface executorService {
    void love(int a);



}