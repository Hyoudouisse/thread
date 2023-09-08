class Student implements Runnable{
    public void run()
    {
        for(int iterator=1 ; iterator <=5; iterator++)
        {
            try {
                System.out.println("Student"+iterator);
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
class Number extends Thread{
    public void run()
    {
        for(int iterator=1 ; iterator <=5; iterator++)
        {
            try {
                System.out.println("Number" + iterator);
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args)throws InterruptedException {
        Student student = new Student();
        Number number = new Number();

        Thread studentThread= new Thread(student);
        System.out.println(studentThread.isAlive());
        number.setPriority(10);
        studentThread.setPriority(1);
        studentThread.start();
        number.start();
        studentThread.setName("Student 1");
        System.out.println(studentThread.getName());

        studentThread.join();
        number.join();

        System.out.println("Code execution finishing");
    }
}