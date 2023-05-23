import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class question2 {

    public static LinkedList<Integer> birlestir(List<LinkedList<Integer>> listeler) {
        LinkedList<Integer> birlestirilmis = new LinkedList<>();//Linked list oluşturdum.

        for (LinkedList<Integer> liste : listeler) {//Listelerin hepsini birleştirilmiş linked liste ekledim.
            birlestirilmis.addAll(liste);
        }

        Collections.sort(birlestirilmis); //Listeyi sıralama işlemi yaptım.

        return birlestirilmis;
    }

    public static void questiontwo() {
        List<LinkedList<Integer>> listeler = new LinkedList<>();//Linked list oluşturdum.

        listeler.add(new LinkedList<>(List.of(1, 2, 4))); //Listeler tek seferde oluşturulup ekleniyor.
        listeler.add(new LinkedList<>(List.of(2, 3, 5)));
        listeler.add(new LinkedList<>(List.of(3, 6)));

        LinkedList<Integer> birlestirilmis = birlestir(listeler);//Birleştir fonksiyonunu kullanarak tüm listeleri birleştirilmiş linked liste ekliyorum.
        System.out.println("Output: " + birlestirilmis);
    }
}
