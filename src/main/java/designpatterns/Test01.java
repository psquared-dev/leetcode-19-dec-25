package designpatterns;

class DataSource{
    private volatile static DataSource instance;

    private DataSource(){
    }

    public static DataSource getInstance(){
        if(instance == null){
            synchronized (DataSource.class){
                if(instance == null){
                    instance = new DataSource();
                }
            }
        }

        return instance;
    }
}

public class Test01 {
    public static void main(String[] args) {
        DataSource instance1 = DataSource.getInstance();
        System.out.println(instance1);

        DataSource instance2 = DataSource.getInstance();
        System.out.println(instance2);
    }
}
