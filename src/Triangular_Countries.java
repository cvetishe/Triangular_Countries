import java.util.ArrayList;
import java.util.Scanner;

public class Triangular_Countries {
    private int numberCountries;
    private ArrayList<Integer> suitableCountries = new ArrayList<>();
    private int x_n;
    private int y_n;

    // ввод координат города
    public void inCoordinatesCity() {
        System.out.println("Введите координаты (x y) города через пробел: ");
        Scanner inn = new Scanner(System.in);
        String[] city = inn.nextLine().split(" ");
        x_n = Integer.parseInt(city[0]);
        y_n = Integer.parseInt(city[1]);
    }

    // ввод кол-ва стран
    public void inNumberCountries() {
        System.out.println("Введите количество стран: ");
        Scanner inn = new Scanner(System.in);
        numberCountries = inn.nextInt();
        if (numberCountries < 1 || numberCountries > 1000) {
            System.out.println("Стран не может быть меньше 1 и больше 1000." + "\n"
                    + "Попробуйте снова");
            inNumberCountries();
        }
    }

    //ввод координат стран и вызов подсчета S и попадания города в страну
    public void inCoordinatesTriangularCountries() {
        if (numberCountries > 1) {
            for (int country = 0; country < numberCountries; country++) {
                System.out.println("Введите через пробел координаты (х у) 3х углов " + (country + 1) + " страны: ");
                Scanner inn = new Scanner(System.in);
                String[] s = inn.nextLine().split(" ");
                double area = checkingArea(s);
                if (area <= 0) {
                    System.out.println("Страна имеет нулевую площадь. Введите кооординаты снова");
                    inCoordinatesTriangularCountries();
                }
                if (checingCitiInContry(s)) {
                    suitableCountries.add(country + 1);
                }
            }
        } else {
            System.out.println("Введите через пробел координаты (х у) 3х углов страны: ");  //если страна всего 1
            Scanner inn = new Scanner(System.in);
            String[] s = inn.nextLine().split(" ");
            double area = checkingArea(s);
            if (area <= 0) {
                System.out.println("Страна имеет нулевую площадь. Введите кооординаты снова");
                inCoordinatesTriangularCountries();
            } else {
                if (checingCitiInContry(s)){
                    suitableCountries.add(1);
                } else {
                    System.out.println("город N не вошёл в эти страны");
                }
            }
        }
    }

    private double checkingArea(String[] str) {
        int x_1 = Integer.parseInt(str[0]);
        int y_1 = Integer.parseInt(str[1]);
        int x_2 = Integer.parseInt(str[2]);
        int y_2 = Integer.parseInt(str[3]);
        int x_3 = Integer.parseInt(str[4]);
        int y_3 = Integer.parseInt(str[5]);
        return 0.5 * ((x_1 - x_3) * (y_2 - y_3) - (x_2 - x_3) * (y_1 - y_3));
    }

    private boolean checingCitiInContry(String[] str) {
        int x_1 = Integer.parseInt(str[0]);
        int y_1 = Integer.parseInt(str[1]);
        int x_2 = Integer.parseInt(str[2]);
        int y_2 = Integer.parseInt(str[3]);
        int x_3 = Integer.parseInt(str[4]);
        int y_3 = Integer.parseInt(str[5]);
        int res_1 = (x_1 - x_n) * (y_2 - y_1) - (x_2 - x_1) * (y_1 - y_n);
        int res_2 = (x_2 - x_n) * (y_3 - y_2) - (x_3 - x_2) * (y_2 - y_n);
        int res_3 = (x_3 - x_n) * (y_1 - y_3) - (x_1 - x_3) * (y_3 - y_n);
        if (res_1 > 0 && res_2 > 0 && res_3 > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void info(){
        String res = "";
        for(Integer num : suitableCountries){
            res += num + " ";
        }
        System.out.println(suitableCountries.size() + "\n"
                + res);

    }
}
