public class test {
    public static void main(String[] args) {
        int a[][] = {{1,1,2}, {2,3,5}, {5,3,9}};
        if (a[0][0] == a[0][1] && a[0][1] == a[0][2]){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}